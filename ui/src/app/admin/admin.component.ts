import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BookPopularity} from "../share/entity/book.popularity";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  books: BookPopularity[] = [];

  headers = new HttpHeaders(
    {'Content-Type':'application/json; charset=utf-8'});

  constructor(private http: HttpClient) {
    this.http.get<any>('/api/getBooksPopularity',{headers: this.headers})
      .subscribe(
        data => {
          this.books = data;
        }
      )
  }

  ngOnInit() {
  }


}
