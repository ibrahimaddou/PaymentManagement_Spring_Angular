import { HttpClient } from '@angular/common/http';
import { Component, OnInit, viewChild, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { ClientsService } from '../services/clients.service';

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

   @ViewChild(MatSort)sort!: MatSort;


  constructor(private clientsService : ClientsService){
    
  }
  ngOnInit(): void {
    this.clientsService.getAllPayments()
    .subscribe({
      next : data =>{
        this.payments = data; //getting data
        this.dataSource = new MatTableDataSource(this.payments);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;

      },
      error : err =>{
        console.log(err);
      }
    })
  }

  

}
