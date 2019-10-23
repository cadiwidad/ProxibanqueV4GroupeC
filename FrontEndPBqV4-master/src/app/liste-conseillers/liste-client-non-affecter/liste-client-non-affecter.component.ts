import { Component, OnInit } from '@angular/core';
import { Conseiller } from 'src/app/model/conseiller';
import { GerantService } from 'src/app/services/gerant.service';
import { Client } from 'src/app/model/client';

import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-liste-client-non-affecter',
  templateUrl: './liste-client-non-affecter.component.html',
  styleUrls: ['./liste-client-non-affecter.component.css']
})
export class ListeClientNonAffecterComponent implements OnInit {
  idGerant:number;
  idConseiller:number
  listeClientsNonAffecter:Client[];
  constructor(private gerantService:GerantService,private activeRoute: ActivatedRoute) { }
idClient:number;
  ngOnInit() {
    this.idConseiller=parseInt(localStorage.getItem("idConseiller"));
    this.idGerant=parseInt(localStorage.getItem("token"));
    this.gerantService.listeClientsNonAffecter().subscribe((data:Client[])=>{
      this.listeClientsNonAffecter=data;
      console.log(data)  
      

      
  })

  this.activeRoute.params.subscribe( p => {
    this.idConseiller=p.id
    console.log(p.id);
    
  })
}
affecterClient(idClient:number)
{
  const data={
    idClient:idClient +'',
    idConseiller:this.idConseiller+''
  }
  console.log(idClient)
  this.gerantService.affecterClient(data).subscribe(() => {
    this.idGerant=parseInt(localStorage.getItem("token"));
    this.gerantService.listeClientsNonAffecter().subscribe((data:Client[])=>{
      this.listeClientsNonAffecter=data;
      console.log(data)
    })
 
  }

  )
}
}