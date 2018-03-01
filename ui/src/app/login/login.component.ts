import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient, HttpHeaders} from "@angular/common/http";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})



export class LoginComponent implements OnInit {

   email: string;
   password: string;

   private loginedUserIsAdmin: Boolean;

  headers = new HttpHeaders(
    {'Content-Type':'application/json; charset=utf-8'});

  constructor(private routes: Router, private http: HttpClient) {
    this.loginedUserIsAdmin = false;
  }

  ngOnInit() {
  }


  submit(){

    var user ={"email": this.email, "password": this.password };
    this.checkUser(user);

    if(this.loginedUserIsAdmin){
      this.routes.navigate(['/admin'])
    }
    else{
      this.http.post('api/login',user,{headers:this.headers})
        .subscribe(
          data =>{
            if(data != null){
              this.routes.navigate(['/home']);
            }
          }
        )
    }
  }

  private checkUser(user: any){
    this.http.post('api/isAdmin',user, {headers: this.headers}).subscribe(
      data =>{
          if(data == true)
            this.loginedUserIsAdmin = true;
      }
    )
  }

}
