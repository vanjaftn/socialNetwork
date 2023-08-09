import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { Friendship } from '../model/friendship';
import { MyFriend } from '../model/my-friend';
import { FriendshipService } from '../services/friendship.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-users-page',
  templateUrl: './users-page.component.html',
  styleUrls: ['./users-page.component.css']
})
export class UsersPageComponent implements OnInit {

  users : Array<MyFriend> = new Array
  friendship : Friendship = new Friendship()
  friend: MyFriend = new MyFriend()
  searchUser: string = ''
  searchedUsers: Array<MyFriend> = new Array

  constructor(private userService: UserService, private friendshipService: FriendshipService, private router: Router) { }

  ngOnInit(): void {
    
    this.allUsers()
    
  }

  allUsers() {
    this.userService.getAllUsers().subscribe(res=>{
      this.users = JSON.parse(res)
      this.users.map(
        user =>
        this.friendshipService.doesFriendshipExist(user.userId).subscribe(res => {
          if(res == "true"){
          user.isMyFriend = true
          }
          else if(res == "false")
          {
            user.isMyFriend = false
          }
        })
        )

    })
  }

  friendProfile(userId: number) {
    this.userService.getUserInfo(userId).subscribe(res=>{
      this.friend = JSON.parse(res)
      console.log(this.friend)
      this.friendshipService.doesFriendshipExist(userId).subscribe(res => {
        if(res == "true"){
          
          this.friendshipService.friendshipExists(userId).subscribe(res => {
            this.friendship = JSON.parse(res)
            console.log(this.friendship)

            localStorage.setItem('friendship', JSON.stringify(this.friendship))

            this.friend.isMyFriend = true
            localStorage.setItem('user', JSON.stringify(this.friend))
            console.log(localStorage.getItem('user'))
            window.location.reload()
          })
            

        }
        else if(res == "false")
        {
          this.friend.isMyFriend = false
          localStorage.setItem('user', JSON.stringify(this.friend))
          console.log(localStorage.getItem('user'))
          window.location.reload()
        }
      })
      
      this.router.navigate(['friendProfilePage']);
    })
  }

  search() {
    console.log(this.searchUser)
    this.userService.searchUser(this.searchUser).subscribe(res=>{
      this.users = JSON.parse(res)
      console.log(this.users)
    })
  }
}
