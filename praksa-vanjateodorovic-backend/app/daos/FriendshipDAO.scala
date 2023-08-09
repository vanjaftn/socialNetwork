package daos

import dtos.FriendshipDTO
import models.{Friendship}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
class FriendshipDAO @Inject()(
                               protected val dbConfigProvider: DatabaseConfigProvider
                             )(
                               implicit executionContext: ExecutionContext
                             ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Friendships = TableQuery[FriendshipsTable]

  def acceptRequest(friendshipId: Long): Future[String] = {
    db.run((Friendships.filter(friendship => friendship.status === "PENDING" && friendship.friendshipId === friendshipId).map(_.status).update("ACCEPTED")))
      .map(res => "Request successfully accepted").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }
//  def acceptRequest(friendshipId: Long): Future[String] = {
//    db.run(Friendships.filter(friendship => friendship.status === "PENDING" && friendship.friendshipId === friendshipId)
//      .map(_.status)
//      .update("ACCEPTED"))
//      .map {
//        case 1 => "Request successfully accepted"
//        case 0 => throw new Exception("Couldn't update friendship status")
//      }
//  }

  def rejectRequest(friendshipId: Long):  Future[String] = {
    db.run(Friendships.filter(friendship => friendship.status === "PENDING" && friendship.friendshipId === friendshipId).delete)
      .map(res => "Request successfully rejected").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def friendshipExists(user1: Long, user2: Long) : Future[Option[Friendship]] = {
    db.run(Friendships.filter(friendship => (friendship.targetUserId === user1 && friendship.sourceUserId === user2)
      ||friendship.targetUserId === user2 && friendship.sourceUserId === user1)
      .result.headOption)
  }

  def getUserFriendships(userId: Long): Future[Seq[Friendship]] ={
    db.run(Friendships.filter(friendship => (friendship.sourceUserId === userId || friendship.targetUserId === userId) && friendship.status === "ACCEPTED").result)
  }

  def getUserFriendshipsAndPending(userId: Long): Future[Seq[Friendship]] = {
    db.run(Friendships.filter(friendship => (friendship.sourceUserId === userId || friendship.targetUserId === userId)
      && (friendship.status === "ACCEPTED" || friendship.status === "PENDING")).result)
  }

  def getSourceUserFriendships(loggedUserId: Long): Future[Seq[Friendship]] = {
    db.run(Friendships.filter(friendship => friendship.sourceUserId === loggedUserId && friendship.status === "ACCEPTED").result)
  }

  def getSourceUserFriends(userId: Long): Future[Seq[Long]] = {
    getSourceUserFriendships(userId).map(_.map(_.targetUserId))
  }

  def getTargetUserFriendships(loggedUserId: Long): Future[Seq[Friendship]] = {
    db.run(Friendships.filter(friendship => friendship.targetUserId === loggedUserId && friendship.status === "ACCEPTED").result)
  }
//
//  def getTargetUserNonFriends(userId: Long): Future[Seq[Long]] = {
//    getTargetUserFriendships(userId).map(_.map(_.sourceUserId))
//    listAll.filter(_.map(friendship => friendship.sourceUserId))
//  }
//
//  def getSourceUserNonFriends(userId: Long): Future[Seq[Long]] = {
//    getSourceUserFriendships(userId).map(_.map(_.sourceUserId))
//  }

  def getTargetUserFriends(userId: Long): Future[Seq[Long]] = {
    getTargetUserFriendships(userId).map(_.map(_.sourceUserId))
  }
//
//  def getUserNonFriends(loggedInUser: Long, userId: Long) = {
//    userDAO.listAll.map(_.filter(user => user.userId != userId))
//  }

  def sendRequest(friendship: FriendshipDTO) : Future[Friendship] = {
    db.run(((Friendships returning Friendships
      .map(_.friendshipId)) += friendship)
      .map(newId => friendship.copy(friendshipId = newId)))
  }

  def get(id: Long): Future[Option[Friendship]] = {
    db.run(Friendships.filter(_.friendshipId === id).result.headOption)
  }
  def listAll: Future[Seq[Friendship]] = {
    db.run(Friendships.result)
  }

//  def sendRequest(friendshipDTO: FriendshipDTO): Future[String] = {
//    db.run(listAllFriendshipDTOs.map(seq => seq.:+(friendshipDTO)).map(_.map(_.friendshipId).map(newId => friendshipDTO.copy(friendshipId = newId)))
//      .map(_.map(newFriendshipDTO => Friendship.friendshipDTOToFriendship(newFriendshipDTO))))
//      .map(res => "Request successfully sent").recover {
//      case ex: Exception => ex.getCause.getMessage
//    }
//  }

  def listAllFriendshipDTOs = {
    Friendships.result.map(_.map(friendship => FriendshipDTO.friendshipToFriendshipDTO(friendship)))
  }

    class FriendshipsTable(tag: Tag) extends Table[Friendship](tag, "friendships") {
    def friendshipId = column[Option[Long]]("FRIENDSHIPID", O.PrimaryKey, O.AutoInc)

    def targetUserId = column[Long]("TARGETUSERID")

    def sourceUserId = column[Long]("SOURCEUSERID")

    def status = column[String]("STATUS")


    def * = (friendshipId, targetUserId, sourceUserId, status) <> ((Friendship.apply _).tupled, Friendship.unapply)
  }

}
