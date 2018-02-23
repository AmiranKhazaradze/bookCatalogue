import {Component, Input, OnInit} from '@angular/core';
import {UserService} from "./user.service";
import {Router} from "@angular/router";
import {Book} from "../share/entity/book";
import {DataService} from "../share/entity/data.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})



export class LoginComponent implements OnInit {

   email: string;
   password: string;
   @Input() books: Book[] = [];
  constructor(private userService: UserService,
              private routes: Router,
              private data: DataService) {}

  ngOnInit() {
    this.data.currentBooks.subscribe()
  }


  submit(){

    var user ={"email": this.email, "password": this.password };

    this.userService.storeUser(user)
      .subscribe(
        (response) => {
          if(response != null) {
             this.books= response;

            this.routes.navigate(['/home']);
          }
        },
        (error) => console.log(error)
      );
  }

}
