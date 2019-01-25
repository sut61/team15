import { NgModule } from '@angular/core';

import { Component } from '@angular/core';
import { Routes , RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FinishComponent } from './finish/finish.component';
import { MenuComponent } from './menu/menu.component';
import { TabComponent } from './tab/tab.component';

import { PaymentComponent } from './payment/payment.component';
import { ReciptComponent } from './recipt/recipt.component';

import { ReserveQueueComponent } from './reserveQueue/reserveQueue.component';
import { QueueTableComponent } from './queueTable/queueTable.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';

import { LastpageComponent } from './lastpage/lastpage.component';
import { RegistercusComponent } from './registercus/registercus.component';

import { FileworkComponent } from './filework/filework.component';

import { AppointmentComponent } from './appointment/appointment.component';
import { PrintComponent } from './print/print.component';

const routes: Routes = [
{ path: '', component:LoginComponent },
{ path: 'login', component:LoginComponent },
{ path: 'register',component: RegisterComponent },
{ path: 'finish', component:FinishComponent },
{ path: 'menu',component: MenuComponent },
{ path: 'tab',component: TabComponent },
{path : 'Payment', component:PaymentComponent},
{path : 'Recipt', component:ReciptComponent},
{ path: 'registercus',component: RegistercusComponent },
{ path: 'lastpage', component:LastpageComponent },
{ path: 'filework',component: FileworkComponent },
{ path: 'reserveQueue' ,component:ReserveQueueComponent },
{ path: 'queueTable' ,component:QueueTableComponent },
{path:'appointment', component:AppointmentComponent},
{path:'print', component:PrintComponent},
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
