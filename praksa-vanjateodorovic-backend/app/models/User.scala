package models

import dtos.CreateUserDTO
import play.api.libs.json.{Format, Json}
import org.mindrot.jbcrypt.BCrypt

case class User(

               userId : Option[Long],
               email : String,
               password : String,
               firstName : String,
               lastName : String,
               photoURL : String
            )
  object User {
    implicit val format: Format[User] = Json.format[User]

    implicit def userToUserDto(user : User): UserDTO = UserDTO(user.userId, user.email, user.firstName, user.lastName, user.photoURL)
    implicit def CreateUserDtoToUser(createUserDTO : CreateUserDTO): User = User(createUserDTO.userId, createUserDTO.email,BCrypt.hashpw(createUserDTO.password, BCrypt.gensalt(12)), createUserDTO.firstname, createUserDTO.lastname, "dog.png")

  }
