import { Component, OnInit } from '@angular/core';
import { ConseillerService } from 'src/app/services/conseiller.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Compte } from 'src/app/model/compte';

@Component({
  selector: 'app-virement',
  templateUrl: './virement.component.html',
  styleUrls: ['./virement.component.css']
})
export class VirementComponent implements OnInit {
  idConseiller:number;
  listeComptes:Compte[];
  constructor(private conseillerService:ConseillerService,private router:Router) { }

  ngOnInit() {
    this.idConseiller=+localStorage.getItem("token");
    this.conseillerService.listeComptes().subscribe((listeComptes:Compte[])=>{
      this.listeComptes=listeComptes;
    console.log(this.listeComptes)
    })
  }
  onSubmit(userForm: NgForm){
    const data={
      idCompte1:userForm.value.idCompte1,
      idCompte2:userForm.value.idCompte2,
      montant:userForm.value.montant,
      idConseiller:this.idConseiller+''
    }
    this.conseillerService.virement(data).subscribe(()=>{
      this.router.navigate(["/list-clients"]);
    });
  }

}
