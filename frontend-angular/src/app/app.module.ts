import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './modules/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RegistrationComponent } from './modules/registration/registration.component';
import { ProfilePageComponent } from './modules/profile-page/profile-page.component';
import { MainPageComponent } from './modules/main-page/main-page.component';
import { UsersPageComponent } from './modules/users-page/users-page.component';
import { FriendProfilePageComponent } from './modules/friend-profile-page/friend-profile-page.component';
import { UpdateProfileComponent } from './modules/update-profile/update-profile.component';
import { FriendsPageComponent } from './modules/friends-page/friends-page.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    ProfilePageComponent,
    MainPageComponent,
    UsersPageComponent,
    FriendProfilePageComponent,
    UpdateProfileComponent,
    FriendsPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
