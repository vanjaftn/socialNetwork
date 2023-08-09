package models

import play.api.libs.json.{Format, Json}

case class Like(
                  likeId: Option[Long],
                  userId: Long,
                  postId: Long,
               )
object Like {

  implicit val format: Format[Like] = Json.format[Like]

}
