import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import{Controller}from'../controller/controller';

@Component({
  selector: 'app-medical',
  templateUrl: './medical.component.html',
  styleUrls: ['./medical.component.css']
})
export class MedicalComponent implements OnInit {
   type: Array<any>;
   customer: Array<any>;
   treatment: Array<any>;
   dentist: Array<any>;

  listorderInput: Array<any>;
  commentInput: Array<any>;




    views: any = {

   listorderInput:'',
   customerNameSelect: '',
   dentistDataSelect: '',
   treatmentSelect:'',
   typeSelect:'',
   commentInput:'',



  };
constructor(private controller:Controller,private httpClient: HttpClient) { }

  ngOnInit() {
  this.controller.gettype().subscribe(data => {
            this.type = data;
            console.log(this.type);
          });

  this.controller.getcustomer().subscribe(data => {
            this.customer = data;
            console.log(this.customer);
          });
  this.controller.getdentist().subscribe(data => {
            this.dentist = data;
            console.log(this.dentist);
          });
  this.controller.gettreatment().subscribe(data => {
            this.treatment = data;
            console.log(this.treatment);
          });

  }
  save() {

      if(this.views.listorderInput==null){
        alert('No found');
      }else if(this.views.customerNameSelect==null){
        alert('No found');
      }else if(this.views.dentistDataSelect==null){
        alert('No found');
      }else if(this.views.treatmentSelect==null){
        alert('No found');
      }else if(this.views.typeSelect==null){
        alert('No found');
      }else if(this.views.commentInput==null){
        alert('No found');
      }else{
      this.save_func();
    }
}
    save_func(){
    this.httpClient.post('http://localhost:8080/medicaltificate/' + this.views.listorderInput + '/' + this.views.customerNameSelect
                        + '/' + this.views.dentistDataSelect + '/' + this.views.treatmentSelect + '/'
                        + this.views.typeSelect + '/' + this.views.commentInput,this.views)
        .subscribe(
             data => {
                 console.log('PUT Request is successful', data);
                  alert('บันทึกสำเร็จ');
             },
             error => {
                  console.log('Error', error);
                    alert('กรุณาตรวจสอบข้อมูลอีกครั้ง');
            }
    );
    }
}



