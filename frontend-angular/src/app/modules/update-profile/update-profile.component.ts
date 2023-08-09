import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { User } from '../model/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  user : User = new User()
  newName: String = ''
  newLastName: String =''
  selectedFile!: File;
  isClicked = false


  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getLoggedUserInfo().subscribe(res=>{
      this.user = JSON.parse(res)

      this.newName = this.user.firstName
      this.newLastName = this.user.lastName
      console.log(JSON.parse(res))
    })
  }

  updateProfile() {

    console.log(this.newName)
    console.log(this.newLastName)

    this.user.firstName = this.newName
    this.user.lastName = this.newLastName

    this.userService.updateUser(this.user).subscribe(res=>{
      this.user = JSON.parse(res)
      console.log(this.user)

      window.location.reload()

    })
  }

  changePhoto(event: any) {
    // console.log(this.file)

    console.log(event)

    this.selectedFile = <File>event.target.files[0]
    this.isClicked = true

  }

  submit() {
    const formData = new FormData();
    formData.append('image', this.selectedFile, this.selectedFile.name)

    console.log(this.selectedFile) 

    this.userService.changePhoto(formData).subscribe(res=>{
      console.log(this.user)
      window.location.reload()
    })
  }
}
 