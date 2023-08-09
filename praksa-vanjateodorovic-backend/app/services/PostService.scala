package services

import daos.PostDAO
import dtos.{PostDTO, PostPageDTO, ProfilePageDTO}
import models.Post

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class PostService @Inject()(postDAO: PostDAO,
                            friendshipService: FriendshipService,
                            userService: UserService,
                            likeService: LikeService
                           )(implicit ec : ExecutionContext){

  def addPost(postDTO: PostDTO): Future[Option[Post]] = {
    postDAO.add(postDTO)
  }

  def getAllPosts(): Future[Seq[Post]] = {
    postDAO.listAll
  }

  def get(postId: Option[Long]): Future[Post] = {
    postDAO.get(postId)
  }
  def updatePost(postDTO : PostDTO) : Future[Post] = {
    postDAO.updatePost(postDTO)
  }

  def listUsersPosts(userId: Long): Future[Seq[Post]] = {
    postDAO.listUsersPosts(userId)
  }

  def getAllFriendsPosts(loggedUserId: Long) = {
    val friendships = friendshipService.getUserFriendships(loggedUserId)
    println(friendships)
    for {
        friends <- friendshipService.getFriendsIds(loggedUserId)
        users <- Future.sequence(friends.map(id => userService.getUser(id)))
        posts <- Future.sequence(users.map(user => listUsersPosts(user.userId.head))).map(_.flatten)
        likes <- Future.sequence(posts.map(post => likeService.getPostLikes(post.postId.head))).map(_.flatten)
    } yield {
      posts.map{post =>
        PostPageDTO(post.postId.head,
          users.find(_.userId.head == post.userId),
          post.content,
          likes.count(_.postId == post.postId.head),
          likes.exists(like => like.postId == post.postId.head && like.userId == loggedUserId),
          post.timeOfCreation)
      }
    }
  }

  def getUserInfo(userId: Long) = {
    for {
        user <- userService.getUser(userId)
      posts <- listUsersPosts(userId)
      friends <- friendshipService.getFriendsIds(userId)
      users <- Future.sequence(friends.map(id => userService.getUser(id)))
    } yield {
     val res =  ProfilePageDTO(userId, user.email, user.firstName, user.lastName, user.photoURL, posts, users)
      res
    }
  }

}
