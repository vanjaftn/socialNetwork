import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { LoginUser } from '../model/login-user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiServerUrl = 'http://localhost:9000';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});


  constructor(private http: HttpClient) { }

  login(loginUser: LoginUser): Observable<any> {
    console.log(loginUser);
    return this.http.post(this.apiServerUrl + '/login', loginUser, {headers: this.headers, responseType: 'text'});
  }

}