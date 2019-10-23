import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client';
import { ConseillerService } from '../services/conseiller.service';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit {
  idConseiller:number;
  listeClients:Client[];
  constructor(private conseillerService:ConseillerService) { }

  ngOnInit() {

    this.idConseiller=parseInt(localStorage.getItem("token"));
    this.conseillerService.listeClientVcSolde(this.idConseiller).subscribe((data:Client[])=>{
      this.listeClients=data;
      console.log(data)
  })

}
}
