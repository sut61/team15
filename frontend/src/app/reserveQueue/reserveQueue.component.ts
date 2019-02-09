import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import{Controller}from'../controller/controller';
@Component({
  selector: 'app-reserveQueue',
  templateUrl: './reserveQueue.component.html',
  styleUrls: ['./reserveQueue.component.css']
})
export class ReserveQueueComponent implements OnInit {
  customer: Array<any>;


  queue: Array<any>;


  room: Array<any>;

phonecusInput: Array<any>;

idReserveInput: Array<any>;


  views: any = {
   customerNameSelect: '',
   roomNumberSelect: '',
   queueNumberSelect: '',
 phonecusInput: '',
  idReserveInput: '',
  };
  constructor(private controller:Controller,private httpClient: HttpClient) { }
  ngOnInit() {
  this.controller.getcustomer().subscribe(data => {
            this.customer = data;
            console.log(this.customer);
    });

  this.controller.getqueue().subscribe(data => {
            this.queue = data;
            console.log(this.queue);
    });

  this.controller.getroom().subscribe(data => {
            this.room = data;
            console.log(this.room);
          });
  }
  save() {

      if(this.views.roomNumberSelect==null){
        alert('No found');
      }
      else if(this.views.queueNumberSelect==null){
        alert('No found');
      }
      else if(this.views.customerNameSelect==null){
        alert('No found');
      }
      else if(this.views.phonecusInput==null){
        alert('No found');
      }
      else if(this.views.idReserveInput==null){
        alert('No found');
      }
      else{
      this.save_func();
    }

  }
  save_func(){
    this.httpClient.post('http://localhost:8080/reserve/'+ this.views.customerNameSelect + '/' + this.views.roomNumberSelect + '/' + this.views.queueNumberSelect + '/' +  this.views.phonecusInput + '/' +  this.views.idReserveInput,this.views)
        .subscribe(
             data => {
                 console.log('PUT Request is successful', data);
                 alert('บันทึกสำเร็จ');

             },
             error => {
                  console.log('Error', error);
                  alert('กรอกข้อมูลผิดพลาด');
            }
    );
    }
}
