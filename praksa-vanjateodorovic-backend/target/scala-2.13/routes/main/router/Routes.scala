// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_5: controllers.HomeController,
  // @LINE:9
  UserController_2: controllers.UserController,
  // @LINE:24
  PostController_0: controllers.PostController,
  // @LINE:29
  FriendshipController_1: controllers.FriendshipController,
  // @LINE:50
  LikeController_4: controllers.LikeController,
  // @LINE:58
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_5: controllers.HomeController,
    // @LINE:9
    UserController_2: controllers.UserController,
    // @LINE:24
    PostController_0: controllers.PostController,
    // @LINE:29
    FriendshipController_1: controllers.FriendshipController,
    // @LINE:50
    LikeController_4: controllers.LikeController,
    // @LINE:58
    Assets_3: controllers.Assets
  ) = this(errorHandler, HomeController_5, UserController_2, PostController_0, FriendshipController_1, LikeController_4, Assets_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_5, UserController_2, PostController_0, FriendshipController_1, LikeController_4, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UserController.loginUser"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.UserController.getAllUsers"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userWithPassword""", """controllers.UserController.getAllUsersWithPass"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchUser""", """controllers.UserController.searchUser"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserController.getUser(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.UserController.addUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateUser""", """controllers.UserController.updateUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """changePhoto""", """controllers.UserController.changePhoto"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteUser/""" + "$" + """id<[^/]+>""", """controllers.UserController.deleteUser(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLoggedUserInfo""", """controllers.PostController.getLoggedUserInfo"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getUserInfo""", """controllers.PostController.getUserInfo"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendRequest""", """controllers.FriendshipController.sendRequest"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """friendship""", """controllers.FriendshipController.getAllFriendships"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """acceptRequest""", """controllers.FriendshipController.acceptRequest"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rejectRequest""", """controllers.FriendshipController.rejectRequest"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getFriendsIds""", """controllers.FriendshipController.getFriendsIds"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """doesFriendshipExist""", """controllers.FriendshipController.doesFriendshipExist"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """friendshipExists""", """controllers.FriendshipController.friendshipExists"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getFriendsIds""", """controllers.FriendshipController.getFriendsIds"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post""", """controllers.PostController.addPost"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatePost""", """controllers.PostController.updatePost"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post""", """controllers.PostController.getAllPosts"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllFriendsPosts""", """controllers.PostController.getAllFriendsPosts"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """like""", """controllers.LikeController.addLike"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dislike""", """controllers.LikeController.dislike"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """like""", """controllers.LikeController.getAllLikes"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """likeExists""", """controllers.LikeController.likeExists"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_5.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UserController_loginUser1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UserController_loginUser1_invoker = createInvoker(
    UserController_2.loginUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "loginUser",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserController_getAllUsers2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_UserController_getAllUsers2_invoker = createInvoker(
    UserController_2.getAllUsers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getAllUsers",
      Nil,
      "GET",
      this.prefix + """user""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_getAllUsersWithPass3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userWithPassword")))
  )
  private[this] lazy val controllers_UserController_getAllUsersWithPass3_invoker = createInvoker(
    UserController_2.getAllUsersWithPass,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getAllUsersWithPass",
      Nil,
      "GET",
      this.prefix + """userWithPassword""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UserController_searchUser4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchUser")))
  )
  private[this] lazy val controllers_UserController_searchUser4_invoker = createInvoker(
    UserController_2.searchUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "searchUser",
      Nil,
      "POST",
      this.prefix + """searchUser""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:15
  private[this] lazy val controllers_UserController_getUser5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUser5_invoker = createInvoker(
    UserController_2.getUser(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUser",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_UserController_addUser6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_UserController_addUser6_invoker = createInvoker(
    UserController_2.addUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "addUser",
      Nil,
      "POST",
      this.prefix + """user""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:19
  private[this] lazy val controllers_UserController_updateUser7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateUser")))
  )
  private[this] lazy val controllers_UserController_updateUser7_invoker = createInvoker(
    UserController_2.updateUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateUser",
      Nil,
      "POST",
      this.prefix + """updateUser""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:21
  private[this] lazy val controllers_UserController_changePhoto8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("changePhoto")))
  )
  private[this] lazy val controllers_UserController_changePhoto8_invoker = createInvoker(
    UserController_2.changePhoto,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "changePhoto",
      Nil,
      "POST",
      this.prefix + """changePhoto""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:23
  private[this] lazy val controllers_UserController_deleteUser9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteUser/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_deleteUser9_invoker = createInvoker(
    UserController_2.deleteUser(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "deleteUser",
      Seq(classOf[Long]),
      "POST",
      this.prefix + """deleteUser/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:24
  private[this] lazy val controllers_PostController_getLoggedUserInfo10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLoggedUserInfo")))
  )
  private[this] lazy val controllers_PostController_getLoggedUserInfo10_invoker = createInvoker(
    PostController_0.getLoggedUserInfo,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "getLoggedUserInfo",
      Nil,
      "GET",
      this.prefix + """getLoggedUserInfo""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_PostController_getUserInfo11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getUserInfo")))
  )
  private[this] lazy val controllers_PostController_getUserInfo11_invoker = createInvoker(
    PostController_0.getUserInfo,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "getUserInfo",
      Nil,
      "POST",
      this.prefix + """getUserInfo""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:29
  private[this] lazy val controllers_FriendshipController_sendRequest12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendRequest")))
  )
  private[this] lazy val controllers_FriendshipController_sendRequest12_invoker = createInvoker(
    FriendshipController_1.sendRequest,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendshipController",
      "sendRequest",
      Nil,
      "POST",
      this.prefix + """sendRequest""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:30
  private[this] lazy val controllers_FriendshipController_getAllFriendships13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("friendship")))
  )
  private[this] lazy val controllers_FriendshipController_getAllFriendships13_invoker = createInvoker(
    FriendshipController_1.getAllFriendships,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendshipController",
      "getAllFriendships",
      Nil,
      "GET",
      this.prefix + """friendship""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_FriendshipController_acceptRequest14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("acceptRequest")))
  )
  private[this] lazy val controllers_FriendshipController_acceptRequest14_invoker = createInvoker(
    FriendshipController_1.acceptRequest,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendshipController",
      "acceptRequest",
      Nil,
      "POST",
      this.prefix + """acceptRequest""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:34
  private[this] lazy val controllers_FriendshipController_rejectRequest15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rejectRequest")))
  )
  private[this] lazy val controllers_FriendshipController_rejectRequest15_invoker = createInvoker(
    FriendshipController_1.rejectRequest,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendshipController",
      "rejectRequest",
      Nil,
      "POST",
      this.prefix + """rejectRequest""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:35
  private[this] lazy val controllers_FriendshipController_getFriendsIds16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getFriendsIds")))
  )
  private[this] lazy val controllers_FriendshipController_getFriendsIds16_invoker = createInvoker(
    FriendshipController_1.getFriendsIds,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendshipController",
      "getFriendsIds",
      Nil,
      "GET",
      this.prefix + """getFriendsIds""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_FriendshipController_doesFriendshipExist17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("doesFriendshipExist")))
  )
  private[this] lazy val controllers_FriendshipController_doesFriendshipExist17_invoker = createInvoker(
    FriendshipController_1.doesFriendshipExist,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendshipController",
      "doesFriendshipExist",
      Nil,
      "POST",
      this.prefix + """doesFriendshipExist""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:39
  private[this] lazy val controllers_FriendshipController_friendshipExists18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("friendshipExists")))
  )
  private[this] lazy val controllers_FriendshipController_friendshipExists18_invoker = createInvoker(
    FriendshipController_1.friendshipExists,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendshipController",
      "friendshipExists",
      Nil,
      "POST",
      this.prefix + """friendshipExists""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:40
  private[this] lazy val controllers_FriendshipController_getFriendsIds19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getFriendsIds")))
  )
  private[this] lazy val controllers_FriendshipController_getFriendsIds19_invoker = createInvoker(
    FriendshipController_1.getFriendsIds,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FriendshipController",
      "getFriendsIds",
      Nil,
      "GET",
      this.prefix + """getFriendsIds""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_PostController_addPost20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post")))
  )
  private[this] lazy val controllers_PostController_addPost20_invoker = createInvoker(
    PostController_0.addPost,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "addPost",
      Nil,
      "POST",
      this.prefix + """post""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:45
  private[this] lazy val controllers_PostController_updatePost21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatePost")))
  )
  private[this] lazy val controllers_PostController_updatePost21_invoker = createInvoker(
    PostController_0.updatePost,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "updatePost",
      Nil,
      "POST",
      this.prefix + """updatePost""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:46
  private[this] lazy val controllers_PostController_getAllPosts22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post")))
  )
  private[this] lazy val controllers_PostController_getAllPosts22_invoker = createInvoker(
    PostController_0.getAllPosts,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "getAllPosts",
      Nil,
      "GET",
      this.prefix + """post""",
      """""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_PostController_getAllFriendsPosts23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllFriendsPosts")))
  )
  private[this] lazy val controllers_PostController_getAllFriendsPosts23_invoker = createInvoker(
    PostController_0.getAllFriendsPosts,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "getAllFriendsPosts",
      Nil,
      "GET",
      this.prefix + """getAllFriendsPosts""",
      """""",
      Seq()
    )
  )

  // @LINE:50
  private[this] lazy val controllers_LikeController_addLike24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("like")))
  )
  private[this] lazy val controllers_LikeController_addLike24_invoker = createInvoker(
    LikeController_4.addLike,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LikeController",
      "addLike",
      Nil,
      "POST",
      this.prefix + """like""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:52
  private[this] lazy val controllers_LikeController_dislike25_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dislike")))
  )
  private[this] lazy val controllers_LikeController_dislike25_invoker = createInvoker(
    LikeController_4.dislike,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LikeController",
      "dislike",
      Nil,
      "POST",
      this.prefix + """dislike""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:53
  private[this] lazy val controllers_LikeController_getAllLikes26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("like")))
  )
  private[this] lazy val controllers_LikeController_getAllLikes26_invoker = createInvoker(
    LikeController_4.getAllLikes,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LikeController",
      "getAllLikes",
      Nil,
      "GET",
      this.prefix + """like""",
      """""",
      Seq()
    )
  )

  // @LINE:55
  private[this] lazy val controllers_LikeController_likeExists27_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("likeExists")))
  )
  private[this] lazy val controllers_LikeController_likeExists27_invoker = createInvoker(
    LikeController_4.likeExists,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LikeController",
      "likeExists",
      Nil,
      "POST",
      this.prefix + """likeExists""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:58
  private[this] lazy val controllers_Assets_versioned28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned28_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_5.index())
      }
  
    // @LINE:9
    case controllers_UserController_loginUser1_route(params@_) =>
      call { 
        controllers_UserController_loginUser1_invoker.call(UserController_2.loginUser)
      }
  
    // @LINE:11
    case controllers_UserController_getAllUsers2_route(params@_) =>
      call { 
        controllers_UserController_getAllUsers2_invoker.call(UserController_2.getAllUsers)
      }
  
    // @LINE:12
    case controllers_UserController_getAllUsersWithPass3_route(params@_) =>
      call { 
        controllers_UserController_getAllUsersWithPass3_invoker.call(UserController_2.getAllUsersWithPass)
      }
  
    // @LINE:14
    case controllers_UserController_searchUser4_route(params@_) =>
      call { 
        controllers_UserController_searchUser4_invoker.call(UserController_2.searchUser)
      }
  
    // @LINE:15
    case controllers_UserController_getUser5_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_getUser5_invoker.call(UserController_2.getUser(id))
      }
  
    // @LINE:17
    case controllers_UserController_addUser6_route(params@_) =>
      call { 
        controllers_UserController_addUser6_invoker.call(UserController_2.addUser)
      }
  
    // @LINE:19
    case controllers_UserController_updateUser7_route(params@_) =>
      call { 
        controllers_UserController_updateUser7_invoker.call(UserController_2.updateUser)
      }
  
    // @LINE:21
    case controllers_UserController_changePhoto8_route(params@_) =>
      call { 
        controllers_UserController_changePhoto8_invoker.call(UserController_2.changePhoto)
      }
  
    // @LINE:23
    case controllers_UserController_deleteUser9_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_deleteUser9_invoker.call(UserController_2.deleteUser(id))
      }
  
    // @LINE:24
    case controllers_PostController_getLoggedUserInfo10_route(params@_) =>
      call { 
        controllers_PostController_getLoggedUserInfo10_invoker.call(PostController_0.getLoggedUserInfo)
      }
  
    // @LINE:26
    case controllers_PostController_getUserInfo11_route(params@_) =>
      call { 
        controllers_PostController_getUserInfo11_invoker.call(PostController_0.getUserInfo)
      }
  
    // @LINE:29
    case controllers_FriendshipController_sendRequest12_route(params@_) =>
      call { 
        controllers_FriendshipController_sendRequest12_invoker.call(FriendshipController_1.sendRequest)
      }
  
    // @LINE:30
    case controllers_FriendshipController_getAllFriendships13_route(params@_) =>
      call { 
        controllers_FriendshipController_getAllFriendships13_invoker.call(FriendshipController_1.getAllFriendships)
      }
  
    // @LINE:32
    case controllers_FriendshipController_acceptRequest14_route(params@_) =>
      call { 
        controllers_FriendshipController_acceptRequest14_invoker.call(FriendshipController_1.acceptRequest)
      }
  
    // @LINE:34
    case controllers_FriendshipController_rejectRequest15_route(params@_) =>
      call { 
        controllers_FriendshipController_rejectRequest15_invoker.call(FriendshipController_1.rejectRequest)
      }
  
    // @LINE:35
    case controllers_FriendshipController_getFriendsIds16_route(params@_) =>
      call { 
        controllers_FriendshipController_getFriendsIds16_invoker.call(FriendshipController_1.getFriendsIds)
      }
  
    // @LINE:37
    case controllers_FriendshipController_doesFriendshipExist17_route(params@_) =>
      call { 
        controllers_FriendshipController_doesFriendshipExist17_invoker.call(FriendshipController_1.doesFriendshipExist)
      }
  
    // @LINE:39
    case controllers_FriendshipController_friendshipExists18_route(params@_) =>
      call { 
        controllers_FriendshipController_friendshipExists18_invoker.call(FriendshipController_1.friendshipExists)
      }
  
    // @LINE:40
    case controllers_FriendshipController_getFriendsIds19_route(params@_) =>
      call { 
        controllers_FriendshipController_getFriendsIds19_invoker.call(FriendshipController_1.getFriendsIds)
      }
  
    // @LINE:43
    case controllers_PostController_addPost20_route(params@_) =>
      call { 
        controllers_PostController_addPost20_invoker.call(PostController_0.addPost)
      }
  
    // @LINE:45
    case controllers_PostController_updatePost21_route(params@_) =>
      call { 
        controllers_PostController_updatePost21_invoker.call(PostController_0.updatePost)
      }
  
    // @LINE:46
    case controllers_PostController_getAllPosts22_route(params@_) =>
      call { 
        controllers_PostController_getAllPosts22_invoker.call(PostController_0.getAllPosts)
      }
  
    // @LINE:47
    case controllers_PostController_getAllFriendsPosts23_route(params@_) =>
      call { 
        controllers_PostController_getAllFriendsPosts23_invoker.call(PostController_0.getAllFriendsPosts)
      }
  
    // @LINE:50
    case controllers_LikeController_addLike24_route(params@_) =>
      call { 
        controllers_LikeController_addLike24_invoker.call(LikeController_4.addLike)
      }
  
    // @LINE:52
    case controllers_LikeController_dislike25_route(params@_) =>
      call { 
        controllers_LikeController_dislike25_invoker.call(LikeController_4.dislike)
      }
  
    // @LINE:53
    case controllers_LikeController_getAllLikes26_route(params@_) =>
      call { 
        controllers_LikeController_getAllLikes26_invoker.call(LikeController_4.getAllLikes)
      }
  
    // @LINE:55
    case controllers_LikeController_likeExists27_route(params@_) =>
      call { 
        controllers_LikeController_likeExists27_invoker.call(LikeController_4.likeExists)
      }
  
    // @LINE:58
    case controllers_Assets_versioned28_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned28_invoker.call(Assets_3.versioned(path, file))
      }
  }
}
