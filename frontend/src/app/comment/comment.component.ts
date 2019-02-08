import { Component, OnInit } from '@angular/core';
import {Controller} from '../controller/controller';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],
})

export class CommentComponent implements OnInit {
  docter: Array<any>;

  customer: Array<any>;

  point: Array<any>;


  contentInput: Array<any>;

  views: any = {
    docterNameSelect: null,
    customerNameSelect: null,
    PointSelect : null,
    contentInput: null,

  };
  constructor(private controller: Controller,private httpClient: HttpClient) { }

  ngOnInit() {
    this.controller.getDentis().subscribe(data => {
            this.docter = data;
            console.log(this.docter);
  });
    this.controller.getCustomer().subscribe(data => {
            this.customer = data;
            console.log(this.customer);
  });
    this.controller.getPoint().subscribe(data => {
            this.point = data;
            console.log(this.point);
  });
  }
  save()  {
      if(this.views.docterNameSelect == null){
        alert('No found');
      }
      else if(this.views.customerNameSelect == null){
        alert('No found');
      }
      else if(this.views.PointSelect == null){
        alert('No found');
      }
      else if(this.views.contentInput == null){
        alert('No found');
      }
      else{
      this.save_func();
    }
  }

    save_func(){
    this.httpClient.post('http://localhost:8080/Comment/'+ this.views.customerNameSelect + '/' + this.views.docterNameSelect +  '/' + this.views.contentInput + '/' + this.views.PointSelect, this.views)
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
