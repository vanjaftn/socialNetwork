package controllers

import auth.AuthAction
import dtos.{CreateUserDTO, LoggedUserDTO}
import play.api.libs.json.{JsError, JsSuccess, Json}
import services.UserService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import play.api.mvc.{AbstractController, ControllerComponents}
import models.{UserDTO}

import java.nio.file.Paths
class UserController @Inject() (
                                 userService: UserService,
                                 controllerComponents: ControllerComponents,
                                 authAction: AuthAction
                               )(
  implicit executionContext: ExecutionContext
  ) extends AbstractController(controllerComponents) {


  def deleteUser(id : Long) = authAction.async { implicit request =>
    val loggedInUser = request.user
    userService.deleteUser(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def getUser(id : Long) = authAction.async { implicit request =>
    val loggedInUser = request.user
    userService.getUser(id).map( res =>
      Ok(Json.toJson(res))
    )
  }

  def getAllUsers = authAction.async { implicit request =>
    val loggedInUser = request.user
    userService.getAllUsers.map(res =>
      Ok(Json.toJson(res))
    )
  }

//  def getUserNonFriends = authAction.async { implicit request =>
//    val loggedInUser = request.user
//    userService.getUserNonFriends(loggedInUser.userId.head).map(res =>
//      Ok(Json.toJson(res))
//    )
//  }

  def getAllUsersWithPass = authAction.async { implicit request =>
    val loggedInUser = request.user
    userService.getAllUsersWithPass.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def searchUser =
    authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val name = request.body.validate[String]
    name match {
      case JsSuccess(userObj, _) =>
        userService.searchByName(userObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def loginUser = Action.async(parse.json) { implicit request =>
    val loggedUser = request.body.validate[LoggedUserDTO]
    loggedUser match {
      case JsSuccess(userObj, _) =>
        userService.loginUser(userObj).map(res =>
          Ok(res)

        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def addUser = Action.async(parse.json) { implicit request =>
    val newUser = request.body.validate[CreateUserDTO]
    newUser match {
      case JsSuccess(userObj, _) =>
        userService.addUser(userObj).map(res =>
          Ok(res)
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def updateUser = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val newUser = request.body.validate[UserDTO]
    newUser match {
      case JsSuccess(userObj, _) =>
        userService.updateUser(userObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def changePhoto
  = authAction(parse.multipartFormData) { request =>
    val loggedInUser = request.user
    request.body.files.map { picture =>
      val filename = Paths.get(picture.filename).getFileName
      picture.ref.copyTo(Paths.get(s"C:/Users/vanja/Desktop/project/socialNetwork/praksa-vanjateodorovic-backend/public/images/$filename"), replace = true)
      picture.ref.copyTo(Paths.get(s"C:/Users/vanja/Desktop/project/socialNetwork/frontend-angular/src/assets/images/$filename"), replace = true)
      userService.changePhoto(loggedInUser.userId, filename.toString)
    }
    Ok("File uploaded")
  }


}
