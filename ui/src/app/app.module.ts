import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';

import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {FavoriteComponent} from './favorite/favorite.component';
import {LoginComponent} from './login/login.component';
import {HttpClientModule } from "@angular/common/http";
import {BookService} from "./share/entity/book.service";
import { AdminComponent } from './admin/admin.component';


const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'favorite', component: FavoriteComponent },
  { path: 'admin', component: AdminComponent },
  ];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FavoriteComponent,
    LoginComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
