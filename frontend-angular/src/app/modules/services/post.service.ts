import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Post } from '../model/post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }

  addPost(post: Post): Observable<any> {
    console.log(this.token)
    return this.http.post(this.apiServerUrl + '/post', post, {headers: this.headers, responseType: 'text'});
  }

  updatePost(post: Post): Observable<any> {
    console.log(this.token)
    return this.http.post(this.apiServerUrl + '/updatePost', post, {headers: this.headers, responseType: 'text'});
  }
}