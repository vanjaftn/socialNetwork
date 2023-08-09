package controllers

import auth.AuthAction
import dtos.PostDTO
import models.{Post, User}
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import services.{PostService, UserService}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class PostController @Inject() (
                                 postService: PostService,
                                 controllerComponents: ControllerComponents,
                                 authAction: AuthAction
                               )(
                                 implicit executionContext: ExecutionContext
                               ) extends AbstractController(controllerComponents) {

  def addPost = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val newPost = request.body.validate[PostDTO]
    newPost match {
      case JsSuccess(postObj, _) =>
        postService.addPost(postObj.copy(userId = loggedInUser.userId.head)).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def updatePost = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val newPost = request.body.validate[PostDTO]

    newPost match {
      case JsSuccess(postObj, _) =>
        postService.updatePost(postObj.copy(userId = loggedInUser.userId.head)).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def getAllPosts = authAction.async { implicit request =>
    val loggedInUser = request.user
    postService.getAllPosts.map(res =>
      Ok(Json.toJson(res))
    )
  }

//  def listLoggedUsersPosts = authAction.async { implicit request =>
//    val loggedInUser = request.user
//    postService.listUsersPosts(loggedInUser.userId.head).map(res =>
//      Ok(Json.toJson(res))
//    )
//  }

  //  def getAllFriendsPosts = authAction.async(parse.json) { implicit request =>
  //    val loggedInUser = request.user
  //
  //    postService.getAllFriendsPosts(loggedInUser.userId.head).map(_.map(_.map(res =>
  //      Ok(Json.toJson(res))
  //    )))
  //  }

  def getAllFriendsPosts = authAction.async { implicit request =>
    val loggedInUser = request.user
    postService.getAllFriendsPosts(request.user.userId.head).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def getLoggedUserInfo = authAction.async { implicit request =>
    val loggedInUser = request.user
    postService.getUserInfo(request.user.userId.head).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def getUserInfo = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val userId = request.body.validate[Long]

    userId match {
      case JsSuccess(idUser, _) =>
        postService.getUserInfo(idUser).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }
}
