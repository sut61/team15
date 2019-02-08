import { Component, OnInit } from '@angular/core';
import { nametype, CustomerDent, DentFull, ReferringForm, namegroup } from '../Model/ModelService';
import { Controller } from '../controller/controller';
import { ShowService } from '../Model/ShowsService';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';


@Component({
  selector: 'app-referring',
  templateUrl: './referring.component.html',
  styleUrls: ['./referring.component.css']
})
export class ReferringComponent implements OnInit {

  //firstname: String
  //lastname:String
  FullName: String
  nameType: Array<nametype>
  CustomerName: Array<CustomerDent>
  DentistName: Array<DentFull>
  nameGroup: Array<namegroup>
  refe: ReferringForm;
  //firstname1: String
  //lastname1:String
  date: Date;
  namecus: String;
  namedent: String;
  typename: String;
  group: String;
  tel:String;


  constructor(private controller: Controller, private sh: ShowService) {
    this.refe = sh.refe;
   this.tel = "";

  }
  myControl = new FormControl();
  options: string[] = [];
  filteredOptions: Observable<string[]>;

  myControl1 = new FormControl();
  options1: string[] = [];
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
            map(value => this._filter(value, this.options))
          );
      }
      console.log(this.options);
    });
    this.controller.getType().subscribe(data => {
      this.nameType = data;
      console.log(this.nameType);
    });
    this.controller.DentFull().subscribe(data => {
      if (data != null) {
        this.DentistName = data;
        this.DentistName.forEach(element => {
          this.options1.push(element.FullName);
        });
        this.filteredOptions1 = this.myControl1.valueChanges
          .pipe(
            startWith(''),
            map(value => this._filter(value, this.options1))
          );
      }
      console.log(this.options1);
    });
    this.controller.getReferringForm().subscribe(data => {
      this.date = data;
      console.log(this.date);
    });
    this.controller.getBloodGroup().subscribe(data => {
      this.nameGroup = data;
      console.log(this.nameGroup);
    });
  }
  private _filter(value: string, options: string[]): string[] {
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
    else if (this.group == null) {
      alert('No BloodGroup!!');
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
    if (this.namecus != "" || this.namecus != undefined) {
      alert('Seccess!!!')
      this.controller.ReferringForm(this.namecus, this.namedent, this.typename, this.group, this.date, this.tel).subscribe(data => {
        console.log(data);
        this.refe.namecus = data.customer.firstname + " " + data.customer.lastname;

        this.refe.namedent = data.dentistData.firstname + " " + data.dentistData.lastname;
        this.refe.typename = data.type.nameType;
        this.refe.date = data.date;
        this.refe.tel = data.tel;
        this.refe.group = data.bloodGroup.nameGroup;

      });
    }
  }


}
