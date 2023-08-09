package daos

import auth.JwtUtil
import dtos.{CreateUserDTO, LoggedUserDTO}
import models.{Friendship, User, UserDTO}

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile


class UserDAO @Inject()(
                        protected val dbConfigProvider: DatabaseConfigProvider
                      )(
                        implicit executionContext: ExecutionContext
                      ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Users = TableQuery[UsersTable]

  def add(user: CreateUserDTO): Future[String] = {
    db.run(((Users returning Users.map(_.userId)) += user).map(newId => user.copy(userId = newId))).map(user => User.CreateUserDtoToUser(user))
      .map(res => "User successfully registered").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def update(userDTO: UserDTO): Future[UserDTO] = {
    db.run(Users.filter(_.userId === userDTO.userId).map(post => (post.firstName, post.lastName)).update((userDTO.firstName, userDTO.lastName)))
      .map(res => userDTO)
  }
  def emailExists(email: String): Future[Option[User]] = {
    db.run(Users.filter(_.email === email).result.headOption)
  }
  def delete(id: Long): Future[Int] = {
    db.run(Users.filter(_.userId === id).delete)
  }
  def get(id: Long): Future[UserDTO] = {
    db.run(Users.filter(_.userId === id).result.head.map(user => UserDTO.userToUserDto(user)))
  }

  def getIdFromEmail(email: String): Future[Long] = {
    val user = emailExists(email)
    user.map(_.map(_.userId.head).head)

  }

  def listAll: Future[Seq[UserDTO]] = {
    db.run(Users.result.map(_.map(user => UserDTO.userToUserDto(user))))
  }

  def listAllWithPass: Future[Seq[User]] = {
    db.run(Users.result)
  }

  def searchByName(name: String): Future[Seq[UserDTO]] = {
    db.run(Users.filter(user => user.firstName.like(s"%${name}%") || user.lastName.like(s"%${name}%")).result.map(_.map(user => UserDTO.userToUserDto(user))))
  }

  def loginUser(loggedUser : LoggedUserDTO): Future[String] = {
    val jwt = JwtUtil.createToken(loggedUser)

    db.run(Users.result.head.map(res => jwt)).recover {
      case ex: Exception => "Wrong password"
    }
  }

  def changePhoto(userId: Option[Long], photoUrl: String): Future[String] = {
    db.run((Users.filter(user => user.userId === userId).map(_.photoURL).update(photoUrl)))
      .map(res => "Photo successfully updated").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def getUserFromFriendship(friendship: Friendship): Future[Seq[UserDTO]] = {
    db.run(Users.filter(user => user.userId === friendship.sourceUserId || user.userId === friendship.targetUserId ).result).map(_.map(user => UserDTO.userToUserDto(user)))
  }

  def getLoggedUserFromFriendship(loggedUserId: Long, friendship: Friendship): Future[Seq[UserDTO]] = {
    db.run(Users.filter(user => (user.userId === friendship.sourceUserId || user.userId === friendship.targetUserId) && user.userId =!=loggedUserId).result).map(_.map(user => UserDTO.userToUserDto(user)))
  }

      class UsersTable(tag: Tag) extends Table[User](tag, "users") {
      def userId = column[Option[Long]]("USERID", O.PrimaryKey, O.AutoInc)

      def email = column[String]("EMAIL")

      def password = column[String]("PASSWORD")

      def firstName = column[String]("FIRSTNAME")

      def lastName = column[String]("LASTNAME")

      def photoURL = column[String]("PHOTOURL")

      def * = (userId, email, password, firstName, lastName, photoURL) <> ((User.apply _).tupled, User.unapply)
    }
}
