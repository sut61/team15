import { Component, OnInit } from '@angular/core';
import { ReferringComponent } from '../referring/referring.component';
import { ReferringForm } from '../Model/ModelService';
import { Controller } from '../controller/controller';
import { ShowService } from '../Model/ShowsService';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {
  ref:ReferringComponent;
  types:String;
  Date:String;
  refe:ReferringForm;
  constructor(public con:Controller,private sh:ShowService) {
    this.refe=sh.refe;
   }

  ngOnInit() {
    this.con.getReferringForm().subscribe(data=>{
      this.Date = data[0].data
    })
  }

}
