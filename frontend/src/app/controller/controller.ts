import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable()

export class Controller {
public API = '//localhost:8080';

constructor(
            private httpClient:HttpClient
    ){}
      getprovince(): Observable<any> {
      return this.httpClient.get(this.API + '/Province');
      }
      getgender(): Observable<any> {
      return this.httpClient.get(this.API + '/Gender');
      }
      gettitle(): Observable<any> {
      return this.httpClient.get(this.API + '/Title');
      }
      getUser(): Observable<any>{
      return this.httpClient.get(this.API+'/User');
}
      //art
      getcustomername(): Observable<any> {
      return this.httpClient.get(this.API + '/Customer');
            }
      getdentisname(): Observable<any> {
      return this.httpClient.get(this.API + '/Dentisdata');
            }
      getnametype(): Observable<any> {
      return this.httpClient.get(this.API + '/Type');
            }
      getAllRecipt(): Observable<any> {
      return this.httpClient.get(this.API + '/Payment');
            }
      gethospital(): Observable<any> {
      return this.httpClient.get(this.API + '/Hospital');
      }

      //toom
      getqueue(): Observable<any> {
          return this.httpClient.get(this.API + '/Queue');
          }
    getroom(): Observable<any> {
          return this.httpClient.get(this.API + '/Room');
          }

    getcustomer(): Observable<any> {
          return this.httpClient.get(this.API + '/Customer');
          }
    getReserve(): Observable<any>{
          return this.httpClient.get(this.API+'/Reserve');
    }

    getAllReserve(): Observable<any> {
      return this.httpClient.get(this.API + '/Reserve');
      }
      
      //Mild
      getAppointment(): Observable<any> {
            return this.httpClient.get(this.API + '/Appointment');
            }
            getType(): Observable<any> {
            return this.httpClient.get(this.API + '/Type');
            }
            DentFull(): Observable<any> {
            return this.httpClient.get(this.API + '/DentFull');
            }
            CustomerDent(): Observable<any>{
            return this.httpClient.get(this.API+'/CustomerDent');
            }
            Appointment(cusName:String,DentName:String,type:String,d:Date): Observable<any>{
            return this.httpClient.get(this.API+"/Appointment/"+d+"/"+cusName+"/"+DentName+"/"+type);
            }
            // Sprint 2 Comment
            getCustomer(): Observable<any> {
                  return this.httpClient.get(this.API + '/Customer');
                  }
                getDentis(): Observable<any> {
                  return this.httpClient.get(this.API + '/Dentisdata');
                  }
                getPoint(): Observable<any> {
                  return this.httpClient.get(this.API + '/Point');
                  }
                getComment(): Observable<any> {
                  return this.httpClient.get(this.API + '/Comment');
                  }
                  getAllcontent(): Observable<any> {
                  return this.httpClient.get(this.API + '/Comment');
                                       }

}
