import { Component, OnInit } from '@angular/core';
import {UserService} from "./user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

   email: string;
   password: string;



  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  submit(){

    var user ={"email": this.email, "password": this.password };

    this.userService.storeUser(user)
      .subscribe(
        (response) => console.log(response),
        (error) => console.log(error)
      );
  }

}
