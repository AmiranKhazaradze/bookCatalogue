import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class UserService {

  private static readonly POST_URL = 'http://localhost:8080/login';
  headers = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});
  constructor(private http: HttpClient) {
  }

  storeUser(user: any ) {
    return this.http.post(UserService.POST_URL, user,{headers: this.headers});
  }
}