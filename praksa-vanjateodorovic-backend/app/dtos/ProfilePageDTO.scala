package dtos

import models.{Post, UserDTO}
import play.api.libs.json.{Format, Json}

case class ProfilePageDTO(
                          userId: Long,
                          email: String,
                          firstName: String,
                          lastName: String,
                          photoURL: String,
                          posts: Seq[Post],
                         friends: Seq[UserDTO]
                         )

object ProfilePageDTO {
  implicit val format: Format[ProfilePageDTO] = Json.format[ProfilePageDTO]


  //  implicit val timeFormat: Format[Timestamp] = Json.format[Timestamp]

}
