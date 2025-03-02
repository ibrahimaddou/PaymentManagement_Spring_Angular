import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrl: './payments.component.css'
})
export class PaymentsComponent implements OnInit {
   public payments : any;
  constructor(private http : HttpClient){
    
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8021/payments")
    .subscribe({
      next : data =>{
        this.payments = data;
      },
      error : err =>{
        console.log(err);
      }
    })
  }

}
