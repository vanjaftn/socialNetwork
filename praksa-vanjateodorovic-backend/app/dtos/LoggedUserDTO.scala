package dtos

import models.User
import play.api.libs.json.{Format, Json}

case class LoggedUserDTO(
                         email: String,
                         password : String,
                        )

object LoggedUserDTO {
  implicit def userToLoggedUserDTO(user: User): LoggedUserDTO = LoggedUserDTO(user.email, user.password)

  implicit val format: Format[LoggedUserDTO] = Json.format[LoggedUserDTO]
}
