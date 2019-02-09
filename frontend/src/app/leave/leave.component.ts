import { Component, OnInit } from '@angular/core';
import{Controller}from'../controller/controller';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';

export interface History {

}
@Component({
  selector: 'app-leave',
  templateUrl: './leave.component.html',
  styleUrls: ['./leave.component.css']
})
export class LeaveComponent implements OnInit {
Allmedical: Array<any>;
  displayedColumns: string[] = ['No','ListOrder', 'Customer', 'Dentist', 'Treatment', 'Type', 'Comment', 'Date'];
  dataSource = new HistoryDataSource(this.controller);

  constructor(private controller:Controller) { }

  ngOnInit() {
  this.controller.getAllmedical().subscribe(data => {
          this.Allmedical = data;
        });
  }
}
export class HistoryDataSource extends DataSource<any> {
   constructor(private controller:Controller) {
    super();
   }
 connect(): Observable<History[]>{
    return this.controller.getAllmedical();

   }
   disconnect(){}
}
