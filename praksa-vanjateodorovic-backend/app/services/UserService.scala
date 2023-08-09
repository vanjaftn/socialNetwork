package services

import daos.UserDAO
import dtos.{CreateUserDTO, LoggedUserDTO, ProfilePageDTO}
import models.{Friendship, User, UserDTO}
import org.mindrot.jbcrypt.BCrypt

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class UserService @Inject()(userDAO: UserDAO
                           )(implicit ec : ExecutionContext) {
  def addUser(user: CreateUserDTO): Future[String] = {
    userDAO.emailExists(user.email).flatMap {
      case None => userDAO.add(user)
      case Some(_) => throw new Exception("Email already exists")
    }
  }

  def emailExists(email: String): Future[Option[User]] = {
    userDAO.emailExists(email)
  }

  def deleteUser(id: Long): Future[Int] = {
    userDAO.delete(id)
  }

  def getUser(id: Long): Future[UserDTO] = {
    userDAO.get(id)
  }

  def getAllUsers: Future[Seq[UserDTO]] = {
    userDAO.listAll
  }

  def getAllUsersWithPass: Future[Seq[User]] = {
    userDAO.listAllWithPass
  }

  def searchByName(name: String): Future[Seq[UserDTO]] = {
    userDAO.searchByName(name)
  }

  def updateUser(userDTO: UserDTO): Future[UserDTO] = {
    userDAO.update(userDTO)
  }

  def loginUser(loggedUser: LoggedUserDTO): Future[String] = {
    userDAO.emailExists(loggedUser.email).flatMap {
      case None => throw new Exception("Email doesn't exist")
      case Some(userObj) =>
        if (BCrypt.checkpw(loggedUser.password, userObj.password)) {
          userDAO.loginUser(loggedUser)
        } else
          throw new Exception("Wrong password")
    }
  }

  def changePhoto(userId: Option[Long], photoUrl: String): Future[String] = {
    userDAO.changePhoto(userId, photoUrl)

  }

//  def getUserNonFriends(userId: Long) = {
//    for {
//      allUsers <- getAllUsers
//      friendsAndPendingIds <- friendshipService.getFriendsAndPendingIds(userId)
//
//    } yield {
//      val friend = friendsAndPendingIds.map{friendId => allUsers.filter(user => user.userId.get != friendId
//        && user.userId.get != userId)}
//      friend
//
//      friendsAndPendingIds.map(friendId => allUsers.find(user => user.userId.head != friendId))
//    }
//  }




}
