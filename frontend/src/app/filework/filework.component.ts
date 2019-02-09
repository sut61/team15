import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import{Controller}from'../controller/controller';

@Component({
  selector: 'app-filework',
  templateUrl: './filework.component.html',
  styleUrls: ['./filework.component.css']
})
export class FileworkComponent implements OnInit {
   nametype: Array<any>;
   nameTypeSelect='';

   gender: Array<any>;
   genderNameSelect='';

   hospital: Array<any>;
   hospitalSelect='';

  firstnameInput: Array<any>;
  lastnameInput: Array<any>;
  numberInput: Array<any>;



    views: any = {

   hospitalSelect:'',
   firstnameInput: '',
   lastnameInput: '',
   numberInput:'',
   genderNameSelect:'',
   nameTypeSelect:'',



  };
constructor(private controller:Controller,private httpClient: HttpClient) { }

  ngOnInit() {
  this.controller.getnametype().subscribe(data => {
            this.nametype = data;
            console.log(this.nametype);
          });

  this.controller.getgender().subscribe(data => {
            this.gender = data;
            console.log(this.gender);
          });
  this.controller.gethospital().subscribe(data => {
            this.hospital = data;
            console.log(this.hospital);
          });

  }
  save() {

      if(this.views.numberInput==null){
        alert('No found');
      }else if(this.views.firstnameInput==null){
        alert('No found');
      }else if(this.views.lastnameInput==null){
        alert('No found');
      }else if(this.views.genderSelect==null){
        alert('No found');
      }else if(this.views.nameTypeSelect==null){
        alert('No found');
      }else if(this.views.hospitalSelect==null){
        alert('No found');
      }else{
      this.save_func();
    }
}
    save_func(){
    this.httpClient.post('http://localhost:8080/dentistData/' + this.views.numberInput + '/' + this.views.firstnameInput
                        + '/' + this.views.lastnameInput + '/' + this.views.genderNameSelect + '/'
                        + this.views.nameTypeSelect + '/' + this.views.hospitalSelect,this.views)
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



