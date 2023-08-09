package dtos

import models.Post
import play.api.libs.json.{Format, Json}

case class PostDTO(
                  postId: Option[Long],
                   userId: Long,
                   content: String,
                  )

object PostDTO {
  implicit val format: Format[PostDTO] = Json.format[PostDTO]

  implicit def postToPostDTO(post : Post) : PostDTO = PostDTO(post.postId, post.userId, post.content)

  //  implicit val timeFormat: Format[Timestamp] = Json.format[Timestamp]

}
