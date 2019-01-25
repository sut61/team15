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

}
