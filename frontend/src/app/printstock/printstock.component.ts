import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {Controller}from'../controller/controller';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';
export interface History {

}
@Component({
  selector: 'app-printstock',
  templateUrl: './printstock.component.html',
  styleUrls: ['./printstock.component.css']
})
export class PrintstockComponent implements OnInit {
  AllStockmed: Array<any>;
  displayedColumns: string[] = ['No','Name','id medicine','Drugtype','pattern','date','dateexp','number','package'];
  dataSource = new HistoryDataSource(this.controller);

  constructor(private controller:Controller) { }

  ngOnInit() {
  this.controller.getAllStockmed().subscribe(data => {
          this.AllStockmed = data;
        });
  }
}
export class HistoryDataSource extends DataSource<any> {
   constructor(private controller:Controller) {
    super();
   }
 connect(): Observable<History[]>{
    return this.controller.getAllStockmed();

   }
   disconnect(){}
}
