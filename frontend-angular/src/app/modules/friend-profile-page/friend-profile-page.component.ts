import { Component, OnInit } from '@angular/core';
import { Friendship } from '../model/friendship';
import { User } from '../model/user';
import { FriendshipService } from '../services/friendship.service';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router'


@Component({
  selector: 'app-friend-profile-page',
  templateUrl: './friend-profile-page.component.html',
  styleUrls: ['./friend-profile-page.component.css']
})
export class FriendProfilePageComponent implements OnInit {

  user = JSON.parse(localStorage.getItem('user') || '{}')
  friendship = JSON.parse(localStorage.getItem('friendship') || '{}')
  newFriendship : Friendship = new Friendship()
  accepted: Boolean = false
  iSendequest: Boolean = false

  constructor(private userService: UserService, private friendshipService: FriendshipService, private router: Router) { }

  ngOnInit(): void {
    // this.userService.getUserInfo().subscribe(res=>{
    //   this.user = JSON.parse(res)
    //   console.log(this.user)
    // })

    if(this.user.isMyFriend) {
      if(this.friendship.status == "ACCEPTED")
      {
        this.accepted = true
      }
      else if(this.friendship.status == "PENDING")
      {
        if(this.user.userId == this.friendship.sourceUserId)
        {
          this.accepted = false
          this.iSendequest = false
          console.log(this.user)
        }
        else if(this.user.userId == this.friendship.targetUserId)
        {
          this.accepted = false
          this.iSendequest = true
          console.log(this.user)
        }
      }
    }
  }
  

  sendRequest(userId: number) {
    
    this.newFriendship.targetUserId = userId
    
    this.friendshipService.sendRequest(this.newFriendship).subscribe(res=>{
      this.newFriendship = JSON.parse(res)
      console.log(this.newFriendship)
    })
    // window.location.reload()
    this.router.navigate(['usersPage']);
  }

  acceptRequest() {
    
    this.friendshipService.acceptRequest(this.friendship.friendshipId).subscribe(res=>{
      
    })
    this.router.navigate(['usersPage'])
    // window.location.reload()
  }

  rejectRequest() {
    
    console.log(this.friendship.friendshipId)
    this.friendshipService.rejectRequest(this.friendship.friendshipId).subscribe(res=>{
    })
    this.router.navigate(['usersPage'])
    // window.location.reload()
  }


}
