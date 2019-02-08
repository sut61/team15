import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import{Controller}from'../controller/controller';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
   customer: Array<any>;

   doctor: Array<any>;

   casehis: Array<any>;

   nameType: Array<any>;

   noteInput: Array<any>;

    views: any = {

   noteInput: '',
   customerSelect: '',
   doctorSelect:'',
   casehisSelectSelect:'',
   nameTypeSelect:'',

  };

constructor(private controller:Controller,private httpClient: HttpClient) { }

  ngOnInit() {
  this.controller.getcustomername().subscribe(data => {
            this.customer = data;
            console.log(this.customer);
          });

  this.controller.getdoctorname().subscribe(data => {
            this.doctor = data;
            console.log(this.doctor);
          });

  this.controller.getnametype().subscribe(data => {
            this.nameType = data;
            console.log(this.nameType);
          });

  this.controller.getcasehis().subscribe(data => {
            this.casehis = data;
            console.log(this.casehis);
          });

  }
  save() {

      if(this.views.customerSelect==null){
        alert('No found');
      }else if(this.views.doctorSelect==null){
        alert('No found');
      }else if(this.views.typeSelect==null){
        alert('No found');
      }else if(this.views.casehisSelectSelect==null){
        alert('No found');
      }else if(this.views.noteInput==null){
        alert('No found');
      }else{
      this.save_func();
    }
}
    save_func(){

    this.httpClient.post('http://localhost:8080/History/'+ this.views.customerSelect +
    '/' +this.views.doctorSelect + '/' +this.views.nameTypeSelect+ '/' +this.views.casehisSelect+ '/'
     +this.views.noteInput,this.views)
        .subscribe(
             data => {
                 console.log('PUT Request is successful', data);
                 alert('บันทึกสำเร็จ');
             },
             error => {
                  console.log('Error', error);
                  alert('error');


            }
    );
    }
}



