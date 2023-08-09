package controllers

import auth.AuthAction
import dtos.FriendshipDTO
import models.Friendship
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import services.FriendshipService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class FriendshipController @Inject() (friendshipService : FriendshipService,
                                      controllerComponents: ControllerComponents,
                                      authAction: AuthAction
                                      ) (
                                      implicit executionContext: ExecutionContext
                                      ) extends AbstractController(controllerComponents) {

  def sendRequest = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val newRequest = request.body.validate[FriendshipDTO]
    newRequest match {
      case JsSuccess(friendshipObj, _) =>
        friendshipService.sendRequest(friendshipObj.copy(sourceUserId = loggedInUser.userId.head)).map(res =>
          Ok(Json.toJson(res))
        ).recover{
          case ex => InternalServerError(ex.getMessage)
        }
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def acceptRequest = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val newRequest = request.body.validate[Long]
    newRequest match {
      case JsSuccess(friendshipObj, _) =>
        friendshipService.acceptRequest(friendshipObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def rejectRequest = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val newRequest = request.body.validate[Long]
    newRequest match {
      case JsSuccess(friendshipObj, _) =>
        friendshipService.rejectRequest(friendshipObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def getAllFriendships = authAction.async { implicit request =>
    val loggedInUser = request.user
    friendshipService.getAllFriendships().map(res =>
      Ok(Json.toJson(res))
    )
  }

  def getFriendsIds =
    authAction.async { implicit request =>
//    val userId = request.body.validate[Long]
    val loggedInUser = request.user

//    userId match {
//      case JsSuccess(id, _) =>
        friendshipService.getFriendsIds(loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
//      case JsError(errors) => Future.successful(BadRequest(errors.toString))
//    }

  }

  def friendshipExists = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val userId = request.body.validate[Long]
    userId match {
      case JsSuccess(user2, _) =>
        friendshipService.friendshipExists(loggedInUser.userId.head, user2).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }
  def doesFriendshipExist = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val userId = request.body.validate[Long]
    userId match {
      case JsSuccess(user2, _) =>
        friendshipService.doesFriendshipExist(loggedInUser.userId.head, user2).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

}
