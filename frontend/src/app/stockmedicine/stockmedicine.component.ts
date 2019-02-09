import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import{Controller}from'../controller/controller';

@Component({
  selector: 'app-stockmedicine',
  templateUrl: './stockmedicine.component.html',
  styleUrls: ['./stockmedicine.component.css']
})
export class StockmedicineComponent implements OnInit {
   formmed: Array<any>;
   formmedNameSelect='';

   drugtype: Array<any>;
   drugtypeNameSelect='';

   apackage: Array<any>;
   apackageNameSelect='';

  nameInput: Array<any>;
  IdmedicineInput: Array<any>;
  dateInput: Array<any>;
  dateexpInput: Array<any>;
  numberInput: Array<any>;

    views: any = {

   nameInput: '',
   idmedicineInput: '',
   dateInput: '',
   dateexpInput:'',
   drugtypeNameSelect:'',
   formmedNameSelect:'',
   numberInput:'',
   apackageNameSelect:''
  };

  constructor(private controller:Controller,private httpClient: HttpClient) { }

  ngOnInit() {
  this.controller.getformmed().subscribe(data => {
            this.formmed = data;
            console.log(this.formmed);
          });

  this.controller.getdrugtype().subscribe(data => {
            this.drugtype = data;
            console.log(this.drugtype);
          });
  this.controller.getapackage().subscribe(data => {
            this.apackage = data;
            console.log(this.apackage);
          });

  }

  save() {
      if(this.views.nameInput==null){
        alert('No found');
      }else if(this.views.idmedicineInput==null){
        alert('No found');
      }else if(this.views.dateInput==null){
        alert('No found');
      }else if(this.views.dateexpInput==null){
        alert('No found');
      }else if(this.views.drugtypeNameSelect==null){
        alert('No found');
      }else if(this.views.formmedNameSelect==null){
        alert('No found');
      }else if(this.views.numberInput==null){
        alert('No found');
      }else if(this.views.apackageNameSelect==null){
        alert('No found');
      }else{
      this.save_func();
    }
}
    save_func(){
    this.httpClient.post('http://localhost:8080/stockmed/'+ this.views.nameInput+ '/' +this.views.idmedicineInput
                        +'/' +this.views.dateInput + '/' +this.views.dateexpInput+ '/' +this.views.drugtypeNameSelect+ '/'
                        +this.views.formmedNameSelect+ '/' +this.views.numberInput+ '/' +this.views.apackageNameSelect,this.views)
        .subscribe(
             data => {
                 console.log('PUT is successful', data);
                 alert('บันทึกข้อมูลยาสำเร็จ!!');
             },
             error => {
                  console.log('Error', error);
                  alert('ข้อมูลผิดพลาดไม่สมบูรณ์');
            }
    );
  }

}
