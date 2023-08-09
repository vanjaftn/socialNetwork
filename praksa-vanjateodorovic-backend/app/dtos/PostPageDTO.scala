package dtos

import models.{UserDTO}
import play.api.libs.json.{Format, Json}

import java.util.Date

case class PostPageDTO(
                        postId: Long,
                        userId: Option[UserDTO],
                        content: String,
                        likeNum: Int,
                        isLiked: Boolean,
                        timeOfCreation: Date
                      )
object PostPageDTO {
  implicit val format: Format[PostPageDTO] = Json.format[PostPageDTO]


  //  implicit val timeFormat: Format[Timestamp] = Json.format[Timestamp]

}