import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { Observable } from 'rxjs';
import { Client, Payment } from '../model/clients.model';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor(private http :HttpClient) { }
 
  public getAllPayments():Observable<Array<Payment>>{
    return this.http.get<Array<Payment>>(`${environment.backendHost}/payments`); 
  }

  public getClients():Observable<Array<Client>>{
    return this.http.get<Array<Client>>(`${environment.backendHost}/clients`); 
  }
}
