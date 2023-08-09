import { Component, OnInit } from '@angular/core';
import { LoginUser } from '../model/login-user';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: "./login.component.html",
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginUser : LoginUser = new LoginUser();
  public token : string = "";
  public role : string = "";
  public loggedUserId : string = "";

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }

  Login(){
    this.loginService.login(this.loginUser).subscribe((response: any) => {
      this.token = response;
      localStorage.setItem('token',this.token);
      console.log(this.token)

      let decodedJWT = JSON.parse(window.atob(this.token.split('.')[1]));

      alert('Successfully logged in');

      // this.loggedUserId = decodedJWT.id.authority;
      // localStorage.setItem('loggedUserId', this.loggedUserId);
      // console.log(decodedJWT);

      window.location.href = '/profilePage'

    },
    (error) => {
      alert("Invalid email/password");
      console.log(error);

    }
   );
  }

}
