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
    //B5807819 sprint#2
      getformmed(): Observable<any> {
      return this.httpClient.get(this.API + '/Formmed');
      }
      getdrugtype(): Observable<any> {
      return this.httpClient.get(this.API + '/Drugtype');
      }
      getapackage(): Observable<any> {
      return this.httpClient.get(this.API + '/Apackage');
      }
      getStockmed(): Observable<any>{
      return this.httpClient.get(this.API+'/Stockmed');
      }
      getAllStockmed(): Observable<any>{
      return this.httpClient.get(this.API+'/Stockmed');
      }

      //B5814909 sprint2
      getinstruction(): Observable<any> {
          return this.httpClient.get(this.API + '/Instruction');
          }
      getDispense(): Observable<any>{
          return this.httpClient.get(this.API+'/Dispense');
      }
      getAllDispense(): Observable<any> {
          return this.httpClient.get(this.API + '/Dispense');
      }

      //B5800995 Sprint2
      getReferringForm(): Observable<any> {
            return this.httpClient.get(this.API + '/ReferringForm');
            }
            getBloodGroup(): Observable<any>{
                return this.httpClient.get(this.API+'/BloodGroup');
            }
            getnamegroup(): Observable<any> {
                  return this.httpClient.get(this.API + '/BloodGroup');
                  }
            ReferringForm(cusName:String,DentName:String,type:String,b:String,db:Date,tel:String): Observable<any>{
            return this.httpClient.get(this.API+"/ReferringForm/"+db+"/"+cusName+"/"+DentName+"/"+type+"/"+b+"/"+tel);
            }

      //B5815074 SP2

      getdoctorname(): Observable<any> {
      return this.httpClient.get(this.API + '/DentistData');
      }
      getcasehis(): Observable<any> {
      return this.httpClient.get(this.API + '/Casehis');
      }
      getAllhistory(): Observable<any> {
      return this.httpClient.get(this.API + '/History');
      }

}
