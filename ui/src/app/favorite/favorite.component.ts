import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {HomeComponent} from "../home/home.component";
import {Book} from "../share/entity/book";

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {

  books: Book[] = [];

  private static readonly URL = 'http://localhost:8080/getFavorites';
  headers = new HttpHeaders(
    {'Content-Type':'application/json; charset=utf-8'});
  constructor(private http: HttpClient) {
    this.http.get<any>(FavoriteComponent.URL,{headers: this.headers})
      .subscribe(
        data => {
          console.log(data);
          this.books = data;
        }
      )
  }

  ngOnInit() {
  }

}
