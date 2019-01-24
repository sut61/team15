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

}
