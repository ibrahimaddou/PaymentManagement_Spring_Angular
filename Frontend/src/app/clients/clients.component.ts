import { Component, OnInit } from '@angular/core';
import { ClientsService } from '../services/clients.service';
import { Client, Payment } from '../model/clients.model';


@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrl: './clients.component.css'
})
export class ClientsComponent  implements OnInit{
  clients! : Array<Client>;
  constructor(private clientsService : ClientsService){
      
    }
    ngOnInit(): void {
      this.clientsService.getClients()
      .subscribe({
        next: (value: Client[]) => {  
          this.clients = value;
        },
        error : err =>{
          console.log(err);
        }
      })
    }
  
    
  
  

}
