import { Component, OnInit } from '@angular/core';
import{Controller}from'../controller/controller';
import { Router } from '@angular/router';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: any;
  email : string ;
  password : string ;
  count : number ;
  j:any;

  constructor(
  private controller:Controller,
  private router: Router,
  public dialog: MatDialog,private httpClient: HttpClient
  ) { }

  ngOnInit() {
   this.controller.getUser().subscribe(data => {
   this.user = data ;
   console.log(data);
 });

  }
login(){
this.count=0;
for(this.j in this.user){
    if(this.email == this.user[this.j].email && this.password == this.user[this.j].password){
    this.count = this.count+1 ;
     console.log("success");
     alert("Success");
     this.log_func()
    }
  }
if(this.email == null && this.password==null){
    alert("กรุณากรอกข้อมูลเพื่อเข้าใช้งาน");
    this.router.navigate(['/login']);
}else if(this.count == 0){
  alert("ไม่พบผู้ใช้งาน");
  this.router.navigate(['/login']);
  }
}
log_func(){
  this.httpClient.post("http://localhost:8080/email/"+ this.email +"/password/"+ this.password,"post")
          .subscribe(
            data => {
            this.user = data
            const check = this.user.type.search("admin")
            if(check >= 0) {
               this.router.navigate(['/menu'])
            }
            else {
               this.router.navigate(['/tab'])
            }
           },
           error => {
                console.log('Error', error);

          }
  );
  }
}

