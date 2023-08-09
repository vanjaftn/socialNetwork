// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:58
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:58
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:50
  class ReverseLikeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:50
    def addLike: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LikeController.addLike",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "like"})
        }
      """
    )
  
    // @LINE:52
    def dislike: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LikeController.dislike",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "dislike"})
        }
      """
    )
  
    // @LINE:53
    def getAllLikes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LikeController.getAllLikes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "like"})
        }
      """
    )
  
    // @LINE:55
    def likeExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LikeController.likeExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "likeExists"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def changePhoto: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.changePhoto",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "changePhoto"})
        }
      """
    )
  
    // @LINE:19
    def updateUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updateUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateUser"})
        }
      """
    )
  
    // @LINE:9
    def loginUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.loginUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:17
    def addUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.addUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
        }
      """
    )
  
    // @LINE:15
    def getUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUser",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:12
    def getAllUsersWithPass: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getAllUsersWithPass",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userWithPassword"})
        }
      """
    )
  
    // @LINE:14
    def searchUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.searchUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "searchUser"})
        }
      """
    )
  
    // @LINE:23
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.deleteUser",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteUser/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:11
    def getAllUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getAllUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:29
  class ReverseFriendshipController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def doesFriendshipExist: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendshipController.doesFriendshipExist",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "doesFriendshipExist"})
        }
      """
    )
  
    // @LINE:29
    def sendRequest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendshipController.sendRequest",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendRequest"})
        }
      """
    )
  
    // @LINE:32
    def acceptRequest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendshipController.acceptRequest",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "acceptRequest"})
        }
      """
    )
  
    // @LINE:35
    def getFriendsIds: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendshipController.getFriendsIds",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getFriendsIds"})
          }
        
        }
      """
    )
  
    // @LINE:30
    def getAllFriendships: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendshipController.getAllFriendships",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "friendship"})
        }
      """
    )
  
    // @LINE:39
    def friendshipExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendshipController.friendshipExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "friendshipExists"})
        }
      """
    )
  
    // @LINE:34
    def rejectRequest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FriendshipController.rejectRequest",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rejectRequest"})
        }
      """
    )
  
  }

  // @LINE:24
  class ReversePostController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def addPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.addPost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post"})
        }
      """
    )
  
    // @LINE:26
    def getUserInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getUserInfo",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getUserInfo"})
        }
      """
    )
  
    // @LINE:46
    def getAllPosts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getAllPosts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post"})
        }
      """
    )
  
    // @LINE:24
    def getLoggedUserInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getLoggedUserInfo",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getLoggedUserInfo"})
        }
      """
    )
  
    // @LINE:45
    def updatePost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.updatePost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updatePost"})
        }
      """
    )
  
    // @LINE:47
    def getAllFriendsPosts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getAllFriendsPosts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllFriendsPosts"})
        }
      """
    )
  
  }


}
