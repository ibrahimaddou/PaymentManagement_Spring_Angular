import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor(private http :HttpClient) { }
 
  public getAllPayments():Observable<any>{
    return this.http.get(`${environment.backendHost}/payments`); 
  }
}
