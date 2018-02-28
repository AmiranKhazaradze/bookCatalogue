import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Book} from "../share/entity/book";

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {

  books: Book[] = [];

  private static readonly GET_FAVORITE_URL = 'api/getFavorites';
  private static readonly DELETE_FAVORITE_URL = 'api/deleteFavorite';
  headers = new HttpHeaders(
    {'Content-Type':'application/json; charset=utf-8'});
  constructor(private http: HttpClient) {
    this.http.get<any>(FavoriteComponent.GET_FAVORITE_URL,{headers: this.headers})
      .subscribe(
        data => {
          this.books = data;
        }
      )
  }

  ngOnInit() {
  }

  deleteFavorite(book: Book){
    this.http.post(FavoriteComponent.DELETE_FAVORITE_URL,book,{headers: this.headers})
      .subscribe(
        data =>{
          var index = this.books.indexOf(book, 0);
          if (index > -1) {
            this.books.splice(index, 1);
          }
        }
      )
  }
}
