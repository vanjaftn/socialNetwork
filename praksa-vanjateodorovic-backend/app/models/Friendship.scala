package models

import dtos.FriendshipDTO
import play.api.http.Status
import play.api.libs.json.{Format, Json}

case class Friendship(
                        friendshipId: Option[Long],
                        targetUserId: Long,
                        sourceUserId: Long,
                        status: String = "PENDING"
                     )

object Friendship {
  implicit val format: Format[Friendship] = Json.format[Friendship]

  implicit def friendshipDTOToFriendship(friendshipDTO: FriendshipDTO): Friendship = Friendship(friendshipDTO.friendshipId, friendshipDTO.targetUserId, friendshipDTO.sourceUserId, "PENDING")

}