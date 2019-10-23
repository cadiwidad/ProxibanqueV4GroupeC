import { Component, OnInit } from '@angular/core';
import { CompteService } from "src/app/services/compte.service";
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  notification:boolean
  constructor(private compteService:CompteService,private route: Router) { }

  ngOnInit() {
    this.compteService.countCompteMoinsDecouvert().subscribe((nbrCompte:number)=>{
      if(nbrCompte>0){this.notification=true}
      })
  }
  logout(){
    localStorage.removeItem("token")
    this.route.navigate([""]);
  }
}
