import { Component, OnInit } from '@angular/core';
import{ Controller }from'../controller/controller';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from "rxjs";

export interface History {
Content:string;
Point:number;
}

@Component({
  selector: 'app-editornext',
  templateUrl: './editornext.component.html',
  styleUrls: ['./editornext.component.css']
})

export class EditornextComponent implements OnInit {

  Allcontent: Array<any>;
  displayedColumns: string[] = ['No','Customer','Docter','Content','Point'];
  dataSource = new HistoryDataSource(this.controller);

  constructor(private controller: Controller) { }

  ngOnInit() {
  this.controller.getAllcontent().subscribe(data => {
          this.Allcontent = data;
        });
  }
}
export class HistoryDataSource extends DataSource<any> {
   constructor(private controller:Controller) {
    super();
   }
 connect(): Observable<History[]>{
    return this.controller.getAllcontent();

   }
   disconnect(){}
}


