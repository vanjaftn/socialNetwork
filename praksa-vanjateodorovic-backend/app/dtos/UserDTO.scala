package models

import play.api.libs.json.{Format, Json}

case class UserDTO(

                 userId : Option[Long],
                 email : String,
                 firstName : String,
                 lastName : String,
                 photoURL : String
               )
object UserDTO{
  implicit def userToUserDto(user : User): UserDTO = UserDTO(user.userId, user.email, user.firstName, user.lastName, user.photoURL)

  implicit val format: Format[UserDTO] = Json.format[UserDTO]
}