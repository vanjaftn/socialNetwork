import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { RegisterUser } from '../model/register-user';
import { User } from '../model/user';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }

  create(user: RegisterUser): Observable<any> {
    console.log(user);
    return this.http.post(this.apiServerUrl + '/user', user, {headers: this.headers, responseType: 'text'});
  }

  getLoggedUserInfo(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/getLoggedUserInfo', {headers: this.headers2, responseType: 'text'});
  }

  getUserInfo(userId: number): Observable<any> {
    return this.http.post(this.apiServerUrl + '/getUserInfo', userId, {headers: this.headers2, responseType: 'text'});
  }

  getAllFriendsPosts(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/getAllFriendsPosts', {headers: this.headers2, responseType: 'text'});
  }

  getAllUsers(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/user', {headers: this.headers2, responseType: 'text'});
  }

  searchUser(user: string): Observable<any> {
    let userJSON = JSON.stringify(user)
    return this.http.post(this.apiServerUrl + '/searchUser', userJSON, {headers: this.headers2, responseType: 'text'});
  }

  updateUser(user: User): Observable<any> {
    return this.http.post(this.apiServerUrl + '/updateUser', user, {headers: this.headers2, responseType: 'text'});
  }

  changePhoto(file: FormData): Observable<any> {
    return this.http.post(this.apiServerUrl + '/changePhoto', file, {headers: this.headers3, responseType: 'text'});
  }

}