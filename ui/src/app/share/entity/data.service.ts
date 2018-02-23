import {Injectable} from "@angular/core";
import {Book} from "./book";
import {BehaviorSubject} from "rxjs/BehaviorSubject";


@Injectable()
export class DataService{

  private defoultBook =new Book('0','name','author','year','isbn');
  private book = new BehaviorSubject<Book>(this.defoultBook);
  currentBooks = this.book.asObservable();


  constructor(books: Book) {
    this.book.next(books);
  }
}
