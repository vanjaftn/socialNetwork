package daos

import dtos.PostDTO
import models.Post

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date



class PostDAO @Inject()(
                         protected val dbConfigProvider: DatabaseConfigProvider
                       )(
                         implicit executionContext: ExecutionContext
                       ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Posts = TableQuery[PostsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def add(postDTO: PostDTO): Future[Option[Post]] = {
    db.run(((Posts returning Posts.map(_.postId)) += postDTO)
      .map(newId => Some(Post.postDTOToPost(postDTO).copy(postId = newId))))
  }

  def updatePost(postDTO: PostDTO): Future[Post] = {
    db.run(Posts.filter(_.postId === postDTO.postId).map(post => (post.content, post.timeOfCreation)).update((postDTO.content, Post.postDTOToPost(postDTO).timeOfCreation)))
      .map(res => Post.postDTOToPost(postDTO))
  }

  def get(id: Option[Long]): Future[Post] = {
    db.run(Posts.filter(_.postId === id).result.head)
  }

  def listAll: Future[Seq[Post]] = {
    db.run(Posts.sortBy(_.timeOfCreation).result)
  }

  def listUsersPosts(userId : Long): Future[Seq[Post]] = {
    db.run(Posts.filter(_.userId === userId).result)
  }

    class PostsTable(tag: Tag) extends Table[Post](tag, "posts") {

    def postId = column[Option[Long]]("POSTID", O.PrimaryKey, O.AutoInc)

    def userId = column[Long]("USERID")

    def content = column[String]("CONTENT")

    def timeOfCreation = column[Date]("TIMEOFCREATION")


    def * = (postId, userId, content, timeOfCreation) <> ((Post.apply _).tupled, Post.unapply)
  }

}
