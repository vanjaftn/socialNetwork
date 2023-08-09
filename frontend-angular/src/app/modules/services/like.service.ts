import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Like } from '../model/like';

@Injectable({
  providedIn: 'root'
})
export class LikeService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }

  addLike(like: Like): Observable<any> {
    return this.http.post(this.apiServerUrl + '/like', like, {headers: this.headers, responseType: 'text'});
  } 
  
  dislike(id: number): Observable<any> {
    return this.http.post(this.apiServerUrl + '/dislike', id, {headers: this.headers, responseType: 'text'});
  }

  likeExists(postId: number): Observable<any> {
    return this.http.post(this.apiServerUrl + '/likeExists', postId, {headers: this.headers, responseType: 'text'});
  }
}