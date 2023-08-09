import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FriendProfilePageComponent } from './modules/friend-profile-page/friend-profile-page.component';
import { FriendsPageComponent } from './modules/friends-page/friends-page.component';
import { LoginComponent } from './modules/login/login.component';
import { MainPageComponent } from './modules/main-page/main-page.component';
import { ProfilePageComponent } from './modules/profile-page/profile-page.component';
import { RegistrationComponent } from './modules/registration/registration.component';
import { UpdateProfileComponent } from './modules/update-profile/update-profile.component';
import { UsersPageComponent } from './modules/users-page/users-page.component';

const routes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'register', component: RegistrationComponent},
  { path: 'profilePage', component: ProfilePageComponent},
  { path: 'mainPage', component: MainPageComponent},
  { path: 'usersPage', component: UsersPageComponent},
  { path: 'friendProfilePage', component: FriendProfilePageComponent},
  { path: 'updateProfile', component: UpdateProfileComponent},
  { path: 'friendsPage', component: FriendsPageComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
