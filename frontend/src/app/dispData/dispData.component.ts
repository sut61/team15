import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import{Controller}from'../controller/controller';
@Component({
  selector: 'app-reserveQueue',
  templateUrl: './dispData.component.html',
  styleUrls: ['./dispData.component.css']
})
export class DispDataComponent implements OnInit {
  customer: Array<any>;
  cusNameSelect='';

  dentis: Array<any>;
  docNameSelect='';

  instruction: Array<any>;
  takeNameSelect='';

  stockmed: Array<any>;
  medNameSelect='';


  idlabelInput: Array<any>;
  numberpillInput: Array<any>;
  benefitInput: Array<any>;

  views: any = {
   cusNameSelect: '',
   docNameSelect: '',
   medNameSelect: '',
   takeNameSelect: '',
   idlabelInput: '',
   numberpillInput: '',
   benefitInput: '',
  };
  constructor(private controller:Controller,private httpClient: HttpClient) { }
  ngOnInit() {
  this.controller.getcustomer().subscribe(data => {
            this.customer = data;
            console.log(this.customer);
    });

  this.controller.getDentis().subscribe(data => {
            this.dentis = data;
            console.log(this.dentis);
    });

  this.controller.getinstruction().subscribe(data => {
            this.instruction = data;
            console.log(this.instruction);
    });

  this.controller.getStockmed().subscribe(data => {
            this.stockmed = data;
            console.log(this.stockmed);
          });
  }
  save() {

      if(this.views.cusNameSelect==null){
        alert('No found');
      }
      else if(this.views.docNameSelect==null){
        alert('No found');
      }
      else if(this.views.medNameSelect==null){
        alert('No found');
      }
      else if(this.views.takeNameSelect==null){
        alert('No found');
      }
      else if(this.views.idlabelInput==null){
        alert('No found');
      }
      else if(this.views.numberpillInput==null){
        alert('No found');
      }
      else if(this.views.benefitInput==null){
        alert('No found');
      }else{
      this.save_func();
    }

  }
  save_func(){
    this.httpClient.post('http://localhost:8080/dispense/' + this.views.cusNameSelect + '/' + this.views.medNameSelect +
    '/' + this.views.idlabelInput + '/' + this.views.numberpillInput + '/' + this.views.takeNameSelect +
    '/' + this.views.benefitInput + '/' + this.views.docNameSelect ,this.views)
        .subscribe(
             data => {
                 console.log('PUT Request is successful', data);
                 alert('บันทึกข้อมูลสำเร็จ');
             },
             error => {
                  console.log('Error', error);
                  alert('ข้อมูลผิดพลาด โปรดตรวจสอบข้อมูล');
            }
    );
    }
}
