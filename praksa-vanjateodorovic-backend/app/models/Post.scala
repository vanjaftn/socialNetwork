package models

import dtos.{PostDTO}
import play.api.libs.json.{Format, Json}

import java.time.Instant
import java.util.{Date}

case class Post(
                postId : Option[Long],
                userId : Long,
                content : String,
                timeOfCreation : Date
               )

object Post {
  implicit val format: Format[Post] = Json.format[Post]

  implicit def postDTOToPost(postDTO : PostDTO) : Post = Post(postDTO.postId, postDTO.userId, postDTO.content, new Date())

  //  implicit val timeFormat: Format[Timestamp] = Json.format[Timestamp]

}