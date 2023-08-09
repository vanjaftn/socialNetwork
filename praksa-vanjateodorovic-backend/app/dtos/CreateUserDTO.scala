package dtos

import models.{User, UserDTO}
import org.mindrot.jbcrypt.BCrypt
import play.api.libs.json.{Format, Json}

case class CreateUserDTO(

                 userId : Option[Long],
                 email : String,
                 password : String,
                 firstname : String,
                 lastname : String
               )
object CreateUserDTO {
  implicit val format: Format[CreateUserDTO] = Json.format[CreateUserDTO]

  implicit def hashPassword(password: String) = BCrypt.hashpw(password, "")

  //    implicit def checkPassword = BCrypt.checkpw(password, hash)
}

