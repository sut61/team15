import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatDatepickerModule, MatNativeDateModule, MatRadioModule } from '@angular/material';

import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FinishComponent } from './finish/finish.component';
import { ReserveQueueComponent } from './reserveQueue/reserveQueue.component';
import { QueueTableComponent } from './queueTable/queueTable.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';

import {MatCheckboxModule} from '@angular/material';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';

import {Controller} from './controller/controller';
import { MenuComponent } from './menu/menu.component';
import { TabComponent } from './tab/tab.component';

import {MatTabsModule} from '@angular/material/tabs';
import {MatChipsModule} from '@angular/material/chips';

import { PaymentComponent } from './payment/payment.component';
import { ReciptComponent } from './recipt/recipt.component';
import {MatTableModule} from '@angular/material/table';

import { RegistercusComponent } from './registercus/registercus.component';
import { LastpageComponent } from './lastpage/lastpage.component';

import { FileworkComponent } from './filework/filework.component';

const appRoutes: Routes = [
{ path: 'login', component:LoginComponent },
{ path: 'register',component: RegisterComponent },
{ path: 'finish', component:FinishComponent },
{ path: 'menu',component: MenuComponent },
{ path: 'tab',component: TabComponent },
{path : 'Payment', component:PaymentComponent},
{path : 'Recipt', component:ReciptComponent},
{ path: 'registercus',component: RegistercusComponent },
{ path: 'lastpage', component:LastpageComponent },
{ path: 'filework',component:FileworkComponent },
{ path: 'reserveQueue' ,component:ReserveQueueComponent },
{ path: 'queueTable' ,component:QueueTableComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    FinishComponent,
    MenuComponent,
    MenuComponent,
    TabComponent,
    PaymentComponent,
    ReciptComponent,
    RegistercusComponent,
    LastpageComponent,
    FileworkComponent,
    ReserveQueueComponent,
    QueueTableComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatRadioModule,
    MatFormFieldModule,
    MatTabsModule,
    MatChipsModule,
    MatTableModule
  ],
  providers: [Controller],
  bootstrap: [AppComponent]
})
export class AppModule { }
