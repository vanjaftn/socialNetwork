import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Friendship } from '../model/friendship';

@Injectable({
  providedIn: 'root'
})
export class FriendshipService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }

  sendRequest(friendship: Friendship): Observable<any> {
    return this.http.post(this.apiServerUrl + '/sendRequest', friendship, {headers: this.headers, responseType: 'text'});
  }

  acceptRequest(friendshipId: number): Observable<any> {
    return this.http.post(this.apiServerUrl + '/acceptRequest', friendshipId, {headers: this.headers, responseType: 'text'});
  }

  rejectRequest(friendshipId: number): Observable<any> {
    return this.http.post(this.apiServerUrl + '/rejectRequest', friendshipId, {headers: this.headers, responseType: 'text'});
  }

  getFriendsIds(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/getFriendsIds', {headers: this.headers, responseType: 'text'});
  } 

  doesFriendshipExist(userId: number): Observable<any> {
    return this.http.post(this.apiServerUrl + '/doesFriendshipExist', userId, {headers: this.headers, responseType: 'text'});
  }

  friendshipExists(userId: number): Observable<any> {
    return this.http.post(this.apiServerUrl + '/friendshipExists', userId, {headers: this.headers, responseType: 'text'});
  }
}