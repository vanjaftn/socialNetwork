package dtos

import models.Friendship
import play.api.http.Status
import play.api.libs.json.{Format, Json}

case class FriendshipDTO (
                           friendshipId: Option[Long],
                           targetUserId: Long,
                           sourceUserId: Long,
                         )
object FriendshipDTO{
  implicit val format: Format[FriendshipDTO] = Json.format[FriendshipDTO]

  implicit def friendshipToFriendshipDTO(friendship : Friendship): FriendshipDTO = FriendshipDTO(friendship.friendshipId, friendship.targetUserId, friendship.sourceUserId)

}