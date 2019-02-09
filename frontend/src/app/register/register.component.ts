import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import{Controller}from'../controller/controller';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
   province: Array<any>;
   provinceNameSelect='';

   gender: Array<any>;
   genderNameSelect='';

   title: Array<any>;
   titleNameSelect='';

  firstnameInput: Array<any>;
  lastnameInput: Array<any>;
  ageInput: Array<any>;
  phoneInput: Array<any>;
  idcardInput: Array<any>;
  emailInput: Array<any>;
  passwordInput: Array<any>;


    views: any = {

   titleNameSelect:'',
   firstnameInput: '',
   lastnameInput: '',
   ageInput: '',
   phoneInput:'',
   idcardInput:'',
   genderNameSelect:'',
   provinceNameSelect:'',
   emailInput:'',
   passwordInput:''
  };
constructor(private controller:Controller,private httpClient: HttpClient) { }

  ngOnInit() {
  this.controller.getprovince().subscribe(data => {
            this.province = data;
            console.log(this.province);
          });

  this.controller.getgender().subscribe(data => {
            this.gender = data;
            console.log(this.gender);
          });
  this.controller.gettitle().subscribe(data => {
            this.title = data;
            console.log(this.title);
          });

  }
  save() {

      if(this.views.titleNameSelect==null){
        alert('No found');
      }else if(this.views.firstnameInput==null){
        alert('No found');
      }else if(this.views.lastnameInput==null){
        alert('No found');
      }else if(this.views.ageInput==null){
        alert('No found');
      }else if(this.views.phoneInput==null){
        alert('No found');
      }else if(this.views.idcardInput==null){
        alert('No found');
      }else if(this.views.genderNameSelect==null){
        alert('No found');
      }else if(this.views.provinceNameSelect==null){
        alert('No found');
      }else if(this.views.emailInput==null){
        alert('No found');
      }else if(this.views.passwordInput==null){
        alert('No found');
      }else{
      this.save_func();
    }
}
    save_func(){
    this.httpClient.post('http://localhost:8080/user/'+ this.views.titleNameSelect+ '/' +this.views.firstnameInput
                        +'/' +this.views.lastnameInput + '/' +this.views.ageInput+ '/' +this.views.phoneInput+'/' +this.views.idcardInput+
                         '/' +this.views.genderNameSelect+ '/' +this.views.provinceNameSelect+ '/' +this.views.emailInput
                        + '/' +this.views.passwordInput,this.views)
        .subscribe(
             data => {
                 console.log('PUT Request is successful', data);
                 alert('บันทึกข้อมูลพนักงานสำเร็จ');
             },
             error => {
                  console.log('Error', error);
                   alert('ข้อมูลผิดพลาด');

            }
    );
    }
}



