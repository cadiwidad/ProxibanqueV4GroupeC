import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from 'src/app/services/client.service';
import { ConseillerService } from 'src/app/services/conseiller.service';

@Component({
  selector: 'app-consulter-compte-client',
  templateUrl: './consulter-compte-client.component.html',
  styleUrls: ['./consulter-compte-client.component.css']
})
export class ConsulterCompteClientComponent implements OnInit {
  constructor(private fb : FormBuilder, private activeRoute: ActivatedRoute, private router: Router,private clientService:ClientService,private conseillerService:ConseillerService) { }
  userForm : FormGroup;
  client:any[]
  ngOnInit() { 
  //let id = this.activeRoute.snapshot.paramMap.get('id');
  //console.log(id)
  this.activeRoute.params.subscribe( p => {
    console.log(p.idClient)
    this.conseillerService.listeCompteClient(p.id).subscribe( (data:any[]) => {
      this.client=data;
      console.log(this.client)
      
   
    })
  })
  }

}
