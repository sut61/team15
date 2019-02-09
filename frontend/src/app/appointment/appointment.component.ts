import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { Observable, from } from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { Controller } from 'src/app/controller/controller';
import { HttpClient } from '@angular/common/http';
import { CustomerDent, DentFull, nametype, Appointment } from 'src/app/Model/ModelService';
import { PrintService } from 'src/app/Model/PrintService'


@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {
  //firstname: String
  //lastname:String
  FullName: String
  FullName1: Array<String>
  nameType: Array<nametype>
  CustomerName: Array<CustomerDent>
  DentistName: Array<DentFull>
  App:Appointment;
  //firstname1: String
  //lastname1:String
  date: Date;
  namecus:String;
  namedent:String;
  typename:String;
  tel:String;

  constructor(private controller: Controller, private p:PrintService) {
    this.App = p.App;
  }
  myControl = new FormControl();
  options: string[]=[];
  filteredOptions: Observable<string[]>;

  myControl1 = new FormControl();
  options1: string[]=[];
  filteredOptions1: Observable<string[]>;


  ngOnInit() {
    this.controller.CustomerDent().subscribe(data => {
      //this.FullName = data[0].FullName;
      if (data != null) {
        this.CustomerName = data;
        this.CustomerName.forEach(element => {
          this.options.push(element.FullName);
        });
        this.filteredOptions = this.myControl.valueChanges
          .pipe(
            startWith(''),
            map(value => this._filter(value,this.options))
          );
      }
      console.log(this.options);
    });
    this.controller.getnametype().subscribe(data => {
      this.nameType = data;
      console.log(this.nameType);
    });
    this.controller.DentFull().subscribe(data => {
      if (data != null){
        this.DentistName = data;
        this.DentistName.forEach(element => {
          this.options1.push(element.FullName);
        });
        this.filteredOptions1 = this.myControl1.valueChanges
          .pipe(
            startWith(''),
            map(value => this._filter(value,this.options1))
          );
      }
      console.log(this.options1);
    });
    this.controller.getAppointment().subscribe(data => {
      this.date = data;
      console.log(this.date);
    });
  }
  private _filter(value: string,options:string[]): string[] {
    const filterValue = value.toLowerCase();

    return options.filter(option => option.toLowerCase().includes(filterValue));
  }
  Save() {
    if (this.namecus == null) {
      alert('No Customer!!');
    }
    else if (this.namedent == null) {
      alert('No Doctor!! ');
    }
    else if (this.typename == null) {
      alert('No type!!');
    }
    else if(this.date == null){
      alert('No BirthDay!!');
    }
    else if(this.tel == null){
      alert('No PhoneNumber!!');
    }
    else {
      this.save_func();
    }


  }
  save_func(){
    if(this.namecus!=""||this.namecus!=undefined)
    alert('Success!!');
    {
      this.controller.Appointment(this.namecus,this.namedent,this.typename,this.date,this.tel).subscribe(data =>{
        this.App.namecus = data.customer.firstname+" "+data.customer.lastname;
        console.log(data);
        this.App.namedent = data.dentistData.firstname+" "+data.dentistData.lastname;
        this.App.typename = data.type.nameType;
        this.App.date = data.date;
        this.App.tel = data.tel;

      });
    }

  }


}
