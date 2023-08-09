// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLikeController LikeController = new controllers.ReverseLikeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseFriendshipController FriendshipController = new controllers.ReverseFriendshipController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePostController PostController = new controllers.ReversePostController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLikeController LikeController = new controllers.javascript.ReverseLikeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseFriendshipController FriendshipController = new controllers.javascript.ReverseFriendshipController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePostController PostController = new controllers.javascript.ReversePostController(RoutesPrefix.byNamePrefix());
  }

}
