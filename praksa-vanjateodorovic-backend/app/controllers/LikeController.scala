package controllers

import auth.AuthAction
import models.Like
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import services.LikeService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class LikeController @Inject()(
                                likeService : LikeService,
                                controllerComponents: ControllerComponents,
                                authAction: AuthAction
                              )(
                                implicit executionContext: ExecutionContext
                              ) extends AbstractController(controllerComponents) {

  def addLike = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val newLike = request.body.validate[Like]
    newLike match {
      case JsSuccess(likeObj, _) =>
        likeService.addLike(likeObj.copy(userId = loggedInUser.userId.head)).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

    def likeExists = authAction.async(parse.json) { implicit request =>
      val loggedInUser = request.user
      val postId = request.body.validate[Long]
      postId match {
        case JsSuccess(idPost, _) =>
          likeService.likeExists(idPost, loggedInUser.userId.head).map(res =>
            Ok(Json.toJson(res))
          )
        case JsError(errors) => Future.successful(BadRequest(errors.toString))
      }
    }


  def dislike = authAction.async(parse.json) { implicit request =>
//    val loggedInUser = request.user
//    likeService.dislike(id).map(res =>
//      Ok(Json.toJson(res))
//    )

    val loggedInUser = request.user
    val likeId = request.body.validate[Long]
    likeId match {
      case JsSuccess(id, _) =>
        likeService.dislike(id).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def getAllLikes = authAction.async { implicit request =>
    val loggedInUser = request.user
    likeService.listAll.map(res =>
      Ok(Json.toJson(res))
    )
  }
}