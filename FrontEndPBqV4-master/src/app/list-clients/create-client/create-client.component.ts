import { Component, OnInit } from '@angular/core';
import { ConseillerService } from 'src/app/services/conseiller.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Client } from 'src/app/model/client';

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent implements OnInit {
  idConseiller:number;
  constructor(private conseillerService:ConseillerService,private router:Router) { }

  ngOnInit() {
    this.idConseiller=+localStorage.getItem("token");
    console.log(this.idConseiller)
  }
  onSubmit(userForm: NgForm) {
    let client = userForm.value;
    client.idConseiller=localStorage.getItem("token")+"";
    console.log(client)
    this.conseillerService.createClient(client).subscribe((data: Client) => {
    this.router.navigate(["/list-clients"]);
    });
  }

}
