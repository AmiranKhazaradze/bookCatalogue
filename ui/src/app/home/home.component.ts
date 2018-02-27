import {Component, OnInit} from '@angular/core';
import {LoginComponent} from "../login/login.component";
import {Book} from "../share/entity/book";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [LoginComponent]
})
export class HomeComponent implements OnInit {

  books: Book[] = [] ;
  private static readonly Home_URL = 'http://localhost:8080/home';
  private static readonly Favorite_URL = 'http://localhost:8080/addFavorite';
  headers = new HttpHeaders(
    {'Content-Type':'application/json; charset=utf-8'});
  constructor(private http: HttpClient) {

    this.http.get<any>(HomeComponent.Home_URL,{headers: this.headers})
      .subscribe(
      data => {
        this.books = data;
      }
    )
  }
  ngOnInit() {
  }

  addFavorite(book: Book){
    this.http.post(HomeComponent.Favorite_URL,book,{headers: this.headers})
      .subscribe(
        data =>{
        }
      )
  }


}
