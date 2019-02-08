import { Component, OnInit } from '@angular/core';
import{ Controller }from'../controller/controller';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from "rxjs";
export interface History {

}

@Component({
  selector: 'app-showhistory',
  templateUrl: './showhistory.component.html',
  styleUrls: ['./showhistory.component.css']
})
export class ShowhistoryComponent implements OnInit {

  Allhistory: Array<any>;
  displayedColumns: string[] = ['No','Customer','DentistData','Type','Casehis','Note','Date'];
  dataSource = new HistoryDataSource(this.controller);
  constructor(private controller: Controller) { }

  ngOnInit() {
  this.controller.getAllhistory().subscribe(data => {
          this.Allhistory = data;
        });
  }
}
export class HistoryDataSource extends DataSource<any> {
   constructor(private controller:Controller) {
    super();
   }
 connect(): Observable<History[]>{
    return this.controller.getAllhistory();

   }
   disconnect(){}
}

