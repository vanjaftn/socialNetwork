// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:58
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:58
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:50
  class ReverseLikeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:50
    def addLike: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "like")
    }
  
    // @LINE:52
    def dislike: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "dislike")
    }
  
    // @LINE:53
    def getAllLikes: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "like")
    }
  
    // @LINE:55
    def likeExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "likeExists")
    }
  
  }

  // @LINE:9
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def changePhoto: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "changePhoto")
    }
  
    // @LINE:19
    def updateUser: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateUser")
    }
  
    // @LINE:9
    def loginUser: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:17
    def addUser: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:15
    def getUser(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:12
    def getAllUsersWithPass: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "userWithPassword")
    }
  
    // @LINE:14
    def searchUser: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "searchUser")
    }
  
    // @LINE:23
    def deleteUser(id:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteUser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:11
    def getAllUsers: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user")
    }
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:29
  class ReverseFriendshipController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def doesFriendshipExist: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "doesFriendshipExist")
    }
  
    // @LINE:29
    def sendRequest: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendRequest")
    }
  
    // @LINE:32
    def acceptRequest: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "acceptRequest")
    }
  
    // @LINE:35
    def getFriendsIds: Call = {
    
      () match {
      
        // @LINE:35
        case ()  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "getFriendsIds")
      
      }
    
    }
  
    // @LINE:30
    def getAllFriendships: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "friendship")
    }
  
    // @LINE:39
    def friendshipExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "friendshipExists")
    }
  
    // @LINE:34
    def rejectRequest: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "rejectRequest")
    }
  
  }

  // @LINE:24
  class ReversePostController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def addPost: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "post")
    }
  
    // @LINE:26
    def getUserInfo: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getUserInfo")
    }
  
    // @LINE:46
    def getAllPosts: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "post")
    }
  
    // @LINE:24
    def getLoggedUserInfo: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getLoggedUserInfo")
    }
  
    // @LINE:45
    def updatePost: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatePost")
    }
  
    // @LINE:47
    def getAllFriendsPosts: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAllFriendsPosts")
    }
  
  }


}
