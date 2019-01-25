import { Component, OnInit } from '@angular/core';
import { AppointmentComponent } from '../appointment/appointment.component';
import { Controller } from 'src/app/controller/controller';
import { PrintService } from 'src/app/Model/PrintService';
import { Appointment } from 'src/app/Model/ModelService';

@Component({
  selector: 'app-print',
  templateUrl: './print.component.html',
  styleUrls: ['./print.component.css']
})
export class PrintComponent implements OnInit {
  ap:AppointmentComponent;
  nameType:String;
  Date:String;
  app:Appointment;
  
  constructor(public con:Controller,private p:PrintService) { 
    this.app = p.App;
  }
  ngOnInit() {
    this.con.getAppointment().subscribe(data=>{
      this.Date = data[0].date;
      console.log(data.customer);
    });
  }

}
