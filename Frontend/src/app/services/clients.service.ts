import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor(private http :HttpClient) { }
 
  public getAllPayments(){
    return this.http.get("http://localhost:8021/payments"); 
  }
}
