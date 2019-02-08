import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import{Controller}from'../controller/controller';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';
export interface History {

}

@Component({
  selector: 'app-categoryCar',
  templateUrl: './dispTable.component.html',
  styleUrls: ['./dispTable.component.css']
})
export class DispTableComponent implements OnInit{

AllDispense: Array<any>;
  displayedColumns: string[] = ['No','Customer','Stockmed','Id','Numberpill','Takepill','Benefit','DentistData'];
  dataSource = new HistoryDataSource(this.controller);

constructor(private controller:Controller) { }

ngOnInit() {

  this.controller.getAllDispense().subscribe(data => {
          this.AllDispense = data;
        });
  }
}

export class HistoryDataSource extends DataSource<any> {
   constructor(private controller:Controller) {
    super();
   }
 connect(): Observable<History[]>{
    return this.controller.getAllDispense();

   }
   disconnect(){}
}
