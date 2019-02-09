import { Component, OnInit } from '@angular/core';
import{Controller}from'../controller/controller';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';
export interface History {
re_ID: number;
customerName: string;
driverName: string;
Payment: number;
datePay:Date;
placename:String;
placeEnd:String;
distance:number;

}
@Component({
  selector: 'app-recipt',
  templateUrl: './recipt.component.html',
  styleUrls: ['./recipt.component.css']
})
export class ReciptComponent implements OnInit {
AllRecipt: Array<any>;
  displayedColumns: string[] = ['No', 'CustomerName', 'DriverName', 'DatePay', 'PayMent', 'Type','Number'];
  dataSource = new HistoryDataSource(this.controller);

 constructor(private controller:Controller) { }

 ngOnInit() {
this.controller.getAllRecipt().subscribe(data => {
          this.AllRecipt = data;
        });

  }
}
export class HistoryDataSource extends DataSource<any> {
   constructor(private controller:Controller) {
    super();
   }
 connect(): Observable<History[]>{
    return this.controller.getAllRecipt();

   }
   disconnect(){}
}
