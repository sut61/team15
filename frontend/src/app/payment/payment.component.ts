import { Component, OnInit } from '@angular/core';
import{Controller}from'../controller/controller';
import { HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
firstname: Array<any>;
doctorname: Array<any>;
nametype:Array<any>;

views: any = {
    fristNameSelect: null,
    doctorNameSelect:null,
    payMentInput: null,
    typeSelect:null,
  };

  constructor(private controller:Controller, private httpClient: HttpClient) { }

  ngOnInit() {
this.controller.getcustomername().subscribe(data => {
          this.firstname = data;
          console.log(this.firstname);
        });
this.controller.getdentisname().subscribe(data => {
          this.doctorname = data;
          console.log(this.doctorname);
        });
this.controller.getnametype().subscribe(data => {
          this.nametype = data;
          console.log(this.nametype);
        });
  }
  save() {
      if( this.views.fristNameSelect==null){
            alert('No Customer!!');
      }else if(this.views.doctorNameSelect==null){
            alert('No Doctor!! ');
      }else if(this.views.payMentInput==null){
            alert('No price!!');
      }
      else if(this.views.typeSelect==null){
            alert('No type!!');
      }else{
          this.save_func();
        }
  }
  save_func() {
        this.httpClient.post('http://localhost:8080/Payment/'+this.views.fristNameSelect + '/' +this.views.doctorNameSelect + '/' + this.views.payMentInput+'/'+this.views.typeSelect+'/'+this.views.phoneInput, this.views)
        .subscribe(
             data => {

                 console.log('PUT Request is successful', data);
                  alert('บันทึกสำเร็จ');
             },
             error => {
                  console.log('Error', error);
                  alert('Input Error');
            }
    );
  }
}
