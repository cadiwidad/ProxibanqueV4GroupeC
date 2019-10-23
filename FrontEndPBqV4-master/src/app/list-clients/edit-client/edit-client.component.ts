import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from 'src/app/services/client.service';
import { ConseillerService } from 'src/app/services/conseiller.service';

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit {

  constructor(private fb : FormBuilder, private activeRoute: ActivatedRoute, private router: Router,private clientService:ClientService,private conseillerService:ConseillerService) { }
  userForm : FormGroup;
  ngOnInit() {    this.userForm = this.fb.group({
    idClient:[''],
    nomClient:[''],
    prenomClient: [''],
    emailClient: [''],
    adresseClient:[''],
    conseiller:['']
  });
  //let id = this.activeRoute.snapshot.paramMap.get('id');
  //console.log(id)
  this.activeRoute.params.subscribe( p => {
    console.log(p.idClient)
    this.clientService.getClientById(p.id).subscribe( client => {
    this.userForm.setValue(client)
    })
  })
  }
  onSubmit(){
    this.conseillerService.updateClient(this.userForm.value).subscribe(() =>{
      this.router.navigate(['/list-clients']);
    });
  }
}
