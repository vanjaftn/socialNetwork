package services

import daos.LikeDAO
import models.{Like}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class LikeService @Inject()(likeDAO : LikeDAO)(implicit ec : ExecutionContext) {

  def getLike(id: Long) = {
    likeDAO.get(id)
  }
  def addLike(like: Like): Future[Option[Like]] = {
    likeDAO.add(like)
  }

  def dislike(id: Long): Future[Int] = {
    likeDAO.delete(id)
  }

  def getPostLikes(postId: Long): Future[Seq[Like]] = {
    likeDAO.getPostLikes(postId)
  }

  def listAll: Future[Seq[Like]] = {
    likeDAO.listAll
  }

  def likeExists(postId: Long, userId: Long) = {
    likeDAO.likeExists(postId, userId)
  }

}
