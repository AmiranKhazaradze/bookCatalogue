import {Component, OnInit} from '@angular/core';
import {UserService} from "./user.service";
import {Router} from "@angular/router";
import {Book} from "../share/entity/book";
import {BookService} from "../share/entity/book.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})



export class LoginComponent implements OnInit {

   email: string;
   password: string;
  constructor(private userService: UserService,
              private routes: Router) {}

  ngOnInit() {
  }


  submit(){

    var user ={"email": this.email, "password": this.password };

    this.userService.storeUser(user)
      .subscribe(
        (response) => {
          if(response != null) {
             this.routes.navigate(['/home']);
          }
        },
        (error) => console.log(error)
      );
  }

}
