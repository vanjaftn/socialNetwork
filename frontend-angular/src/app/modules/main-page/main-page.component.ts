import { Component, OnInit } from '@angular/core';
import { FriendsPost } from '../model/friends-post';
import { Like } from '../model/like';
import { LikeService } from '../services/like.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  friendsPost : Array<FriendsPost> = new Array()
  like: Like = new Like()
  likeForDislike : Like = new Like()
  
  constructor(private userService: UserService, private likeService: LikeService) { }

  ngOnInit(): void {
    this.userService.getAllFriendsPosts().subscribe(res=>{
      this.friendsPost = JSON.parse(res)
      console.log(this.friendsPost)
    })
  }

  addLike(postId: number){
    this.like.postId = postId
    this.likeService.addLike(this.like).subscribe(res=>{
      this.like = JSON.parse(res)
      console.log(this.like)
    })
    window.location.reload()
  }

  dislike(postId: number) {

    this.likeService.likeExists(postId).subscribe(res=>{
      this.likeForDislike = JSON.parse(res)

      this.likeService.dislike(this.likeForDislike.likeId).subscribe(res=>{
      })
      window.location.reload()
    })

  }
}
