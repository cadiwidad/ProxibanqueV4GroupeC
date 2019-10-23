import { Component, OnInit } from '@angular/core';
import { CompteService } from "src/app/services/compte.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-header-gerant',
  templateUrl: './header-gerant.component.html',
  styleUrls: ['./header-gerant.component.css']
})
export class HeaderGerantComponent implements OnInit {
  notification:boolean
  constructor(private compteService:CompteService,private route: Router) { }

  ngOnInit() {
    this.compteService.countCompteMoinsDecouvert().subscribe((nbrCompte:number)=>{
      if(nbrCompte>0){this.notification=true}else{this.notification=false}
      })
  }
  logout(){
    localStorage.removeItem("token")
    this.route.navigate([""]);
  }

}
