import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client';
import { ConseillerService } from '../services/conseiller.service';

@Component({
  selector: 'app-list-clients',
  templateUrl: './list-clients.component.html',
  styleUrls: ['./list-clients.component.css']
})
export class ListClientsComponent implements OnInit {
  idConseiller:number;
  listeClients:Client[];
  constructor(private conseillerService:ConseillerService) { }
  
  ngOnInit() {
    this.idConseiller=parseInt(localStorage.getItem("token"));
    this.conseillerService.listeClientConseiler(this.idConseiller).subscribe((data:Client[])=>{
      this.listeClients=data
    })
  }
  deleteClient(idClient: number){
    this.conseillerService.deleteClient(idClient).subscribe(() => {
      this.idConseiller=parseInt(localStorage.getItem("token"));
      this.conseillerService.listeClientConseiler(this.idConseiller).subscribe((data:Client[])=>{
        this.listeClients=data
      })
   
    }
  
    )
  }

}
