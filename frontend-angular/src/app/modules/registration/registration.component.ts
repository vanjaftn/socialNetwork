import { Component, OnInit } from '@angular/core';
import { RegisterUser } from '../model/register-user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user: RegisterUser = new RegisterUser()
  constructor(private userService : UserService) { }

  ngOnInit(): void {
  }

  userRegister(){

    // if(this.user.phoneNumber.length < 9) {
    //   alert('Phone number must be at least 9 digits long')
    //   return;
    // };

    var regexp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;     
    // Converting the email to lowercase
    if(!regexp.test(String(this.user.email).toLowerCase())) {
      alert('email format is not valid')
      return;
    };

    if (this.user.firstname.trim() == '' || this.user.lastname.trim() == '' || this.user.email.trim() == '' 
    || this.user.password.trim() == '') {
        alert('Please fill in all fields!');
        return;
     };

    // if(this.user.password.trim() != this.user.confirmPassword.trim()){
    //   alert("Passwords don't match")
    //   return;
    // };

    console.log(this.user)
    this.userService.create(this.user).subscribe(data=>{
      alert("Successfully registered")
    },error=>console.log(error.message));
  
  }

}
