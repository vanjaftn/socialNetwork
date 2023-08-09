package daos

import models.{Like}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class LikeDAO @Inject()(
                         protected val dbConfigProvider: DatabaseConfigProvider
                       )(
                         implicit executionContext: ExecutionContext
                       ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Likes = TableQuery[LikesTable]


  def get(id: Long): Future[Like] = {
    db.run(Likes.filter(_.likeId === id).result.head)
  }
  def add(like : Like): Future[Option[Like]] = {
    db.run(((Likes returning Likes.map(like => like.likeId)) += like).map(newId =>
      Some(like.copy
      (likeId = newId))))
  }

  def delete(id: Long): Future[Int] = {
    db.run(Likes.filter(_.likeId === id).delete)
  }

  def getPostLikes(postId: Long): Future[Seq[Like]] = {
    db.run(Likes.filter(like => like.postId === postId).result)
  }

  def likeExists(postId: Long, userId: Long): Future[Like] = {
    db.run(Likes.filter(like => like.postId === postId &&
      like.userId === userId).result.head)
  }


  def listAll: Future[Seq[Like]] = {
    db.run(Likes.result)
  }

    class LikesTable(tag: Tag) extends Table[Like](tag, "likes") {
    def likeId = column[Option[Long]]("LIKEID", O.PrimaryKey, O.AutoInc)

    def userId = column[Long]("USERID")

    def postId = column[Long]("POSTID")

    def * = (likeId, userId, postId) <> ((Like.apply _).tupled, Like.unapply)
  }

}
