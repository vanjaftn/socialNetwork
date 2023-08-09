package services

import daos.{FriendshipDAO, UserDAO}
import dtos.FriendshipDTO
import models.Friendship

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class FriendshipService @Inject()(friendshipDAO: FriendshipDAO)(implicit ec : ExecutionContext){

  def sendRequest(friendshipDTO: FriendshipDTO): Future[Friendship] = {
    friendshipDAO.friendshipExists(friendshipDTO.targetUserId, friendshipDTO.sourceUserId).flatMap{
      case None => friendshipDAO.sendRequest(friendshipDTO)
      case Some(_) => throw new Exception("Friendship already exists")
    }
  }

  def acceptRequest(friendshipId: Long): Future[String] = {
    friendshipDAO.acceptRequest(friendshipId)
  }

  def rejectRequest(friendshipId: Long): Future[String] = {
    friendshipDAO.rejectRequest(friendshipId)
  }

  def getAllFriendships(): Future[Seq[Friendship]] = {
    friendshipDAO.listAll
  }

  def getUserFriendships(userId: Long): Future[Seq[Friendship]] = {
    friendshipDAO.getUserFriendships(userId)
  }

  def getSourceUserFriendships(loggedUserId: Long): Future[Seq[Friendship]] = {
    friendshipDAO.getSourceUserFriendships(loggedUserId)
  }

  def getTargetUserFriendships(loggedUserId: Long): Future[Seq[Friendship]] = {
    friendshipDAO.getTargetUserFriendships(loggedUserId)
  }

  def getUserFriends(userId: Long) = {
    getUserFriendships(userId).map(_.map(friendship => userId match {
      case friendship.targetUserId => friendshipDAO.getTargetUserFriends(userId)
      case friendship.sourceUserId => friendshipDAO.getSourceUserFriends(userId)
    }))
  }

//  def getUserNonFriends(userId: Long) = {
//    getAllFriendships.filter(_.map(friendship => friendship.targetUserId != userId))
//  }

  def getFriendsIds(userId: Long): Future[Seq[Long]] = {
    getUserFriendships(userId).map(_.map(friendship => userId match {
      case friendship.targetUserId => friendship.sourceUserId
      case friendship.sourceUserId => friendship.targetUserId
    }))
  }

  def friendshipExists(user1: Long, user2: Long) = {
    friendshipDAO.friendshipExists(user1, user2)
  }

  def doesFriendshipExist(user1: Long, user2: Long) = {
    friendshipDAO.friendshipExists(user1, user2).flatMap {
      case None => Future(false)
      case Some(_) => Future(true)
    }
  }





}
