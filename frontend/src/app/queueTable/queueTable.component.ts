import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import{Controller}from'../controller/controller';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';
export interface History {

}

@Component({
  selector: 'app-categoryCar',
  templateUrl: './queueTable.component.html',
  styleUrls: ['./queueTable.component.css']
})
export class QueueTableComponent implements OnInit{

AllReserve: Array<any>;
  displayedColumns: string[] = ['No','Customer','Room','Queue'];
  dataSource = new HistoryDataSource(this.controller);

constructor(private controller:Controller) { }

ngOnInit() {

  this.controller.getAllReserve().subscribe(data => {
          this.AllReserve = data;
        });
  }
}

export class HistoryDataSource extends DataSource<any> {
   constructor(private controller:Controller) {
    super();
   }
 connect(): Observable<History[]>{
    return this.controller.getAllReserve();

   }
   disconnect(){}
}
