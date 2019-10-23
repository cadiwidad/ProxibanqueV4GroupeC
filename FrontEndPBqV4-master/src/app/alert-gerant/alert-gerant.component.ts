import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client';
import { ConseillerService } from '../services/conseiller.service';

@Component({
  selector: 'app-alert-gerant',
  templateUrl: './alert-gerant.component.html',
  styleUrls: ['./alert-gerant.component.css']
})
export class AlertGerantComponent implements OnInit {
  listeClients:Client[];
  constructor(private conseillerService:ConseillerService) { }

  ngOnInit() {

    this.conseillerService.listeClientVcSolde2().subscribe((data:Client[])=>{
      this.listeClients=data;
      console.log(data)
  })

}
}
