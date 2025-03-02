import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrl: './payments.component.css'
})
export class PaymentsComponent implements OnInit {
   public payments : any;
   public dataSource :any;
   public displayedColumns : string[] = ['id','date','amount','type','status','firstname'];
   @ViewChild(MatPaginator) paginator!: MatPaginator;


  constructor(private http : HttpClient){
    
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8021/payments")
    .subscribe({
      next : data =>{
        this.payments = data; //getting data
        this.dataSource = new MatTableDataSource(this.payments);
        this.dataSource.paginator = this.paginator;

      },
      error : err =>{
        console.log(err);
      }
    })
  }

  

}
