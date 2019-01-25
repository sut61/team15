import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import{Controller}from'../controller/controller';

@Component({
  selector: 'app-register',
  templateUrl: './registercus.component.html',
  styleUrls: ['./registercus.component.css']
})
export class RegistercusComponent implements OnInit {
   province: Array<any>;
   provinceNameSelect='';

   gender: Array<any>;
   genderNameSelect='';

   nametype: Array<any>;
   nameTypeSelect='';

  firstnameInput: Array<any>;
  lastnameInput: Array<any>;
  idcardInput: Array<any>;



    views: any = {

   firstnameInput: '',
   lastnameInput: '',
   idcardInput: '',
   genderNameSelect:'',
   provinceNameSelect:'',
   nameTypeSelect:'',

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

  this.controller.getnametype().subscribe(data => {
            this.nametype = data;
            console.log(this.nametype);
          });
  }
  save() {

      if(this.views.firstnameInput==null){
        alert('No found');
      }else if(this.views.lastnameInput==null){
        alert('No found');
      }else if(this.views.ageInput==null){
        alert('No found');
      }else if(this.views.genderNameSelect==null){
        alert('No found');
      }else if(this.views.provinceNameSelect==null){
        alert('No found');
      }else{
      this.save_func();
    }
}
    save_func(){
    this.httpClient.post('http://localhost:8080/customer/'+ this.views.firstnameInput +
    '/' +this.views.lastnameInput + '/' +this.views.idcardInput+ '/' +this.views.genderNameSelect+ '/'
     +this.views.provinceNameSelect+ '/' +this.views.nameTypeSelect,this.views)
        .subscribe(
             data => {
                 console.log('PUT Request is successful', data);
             },
             error => {
                  console.log('Error', error);

            }
    );
    }
}



