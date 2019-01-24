import { NgModule } from '@angular/core';

import { Component } from '@angular/core';
import { Routes , RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FinishComponent } from './finish/finish.component';
import { MenuComponent } from './menu/menu.component';
import { TabComponent } from './tab/tab.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';


const routes: Routes = [
{ path: '', component:LoginComponent },
{ path: 'login', component:LoginComponent },
{ path: 'register',component: RegisterComponent },
{ path: 'finish', component:FinishComponent },
{ path: 'menu',component: MenuComponent },
{ path: 'tab',component: TabComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],

})
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
}
