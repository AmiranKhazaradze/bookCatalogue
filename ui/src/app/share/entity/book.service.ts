
import {Book} from "./book";
import {Injectable} from "@angular/core";

export class BookService{
  private books: Book[];


  constructor() {
  }

  setBooks(books: Book[]){
    this.books = books;
  }

  getBooks(){
    return this.books;
  }
}
