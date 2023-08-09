import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post';
import { User } from '../model/user';
import { PostService } from '../services/post.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  editorOpened = false
  postForEditing = 0
  newPost : String = ''
  updatedPost : String = ''
  user : User = new User()
  post : Post = new Post()
  constructor(private userService : UserService, private postService : PostService) { }

  ngOnInit(): void {
    this.userService.getLoggedUserInfo().subscribe(res=>{
      this.user = JSON.parse(res)
      console.log(this.user)
    })
  }

  addPost() {
    console.log(this.newPost)

    this.post.content = this.newPost
    this.postService.addPost(this.post).subscribe(res=>{
      this.post = JSON.parse(res)
      console.log(this.post)
    })
    window.location.reload()
  }

  updatePost() {
    console.log(this.postForEditing)
    console.log(this.updatedPost)

    this.post.content = this.updatedPost
    this.post.postId = this.postForEditing
    this.postService.updatePost(this.post).subscribe(res=>{
      this.post = JSON.parse(res)
      console.log(this.post)
    })
    window.location.reload()
  }

  cancelUpdate() {
    this.editorOpened = false
  }

  opedEditorForPost(postId: number, content: String) {
    this.editorOpened = true
    this.postForEditing = postId
    this.updatedPost = content
  }

  updateProfile() {
    window.location.href = '/updateProfile'
  }

  myFriends() {
    window.location.href = '/friendsPage'
  }

}
