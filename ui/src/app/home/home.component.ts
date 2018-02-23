import { Component, OnInit } from '@angular/core';
import {LoginComponent} from "../login/login.component";
import {Book} from "../share/entity/book";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [LoginComponent]
})
export class HomeComponent implements OnInit {

  books: Book[] = [];
  constructor(private loginComponent: LoginComponent) {
    this.books = loginComponent.books;
    console.log(this.books);
  }

  ngOnInit() {

  }

}
