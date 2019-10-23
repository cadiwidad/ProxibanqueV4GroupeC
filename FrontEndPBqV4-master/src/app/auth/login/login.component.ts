import { Component, OnInit } from '@angular/core';
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { ConseillerService } from "src/app/services/conseiller.service";
import { GerantService } from "src/app/services/gerant.service";
import { ParametrageService } from "src/app/services/parametrage.service";
import { Conseiller } from "src/app/model/conseiller";
import { Parametrage } from "src/app/model/parametrage";
import { Gerant } from 'src/app/model/gerant';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  employe:any[]
  data1:Parametrage[]
  constructor(private router: Router,private conseillerService: ConseillerService,private gerantService:GerantService,private parametrageService:ParametrageService){}
  ngOnInit() { }
  onSubmit(form: NgForm) {
    this.conseillerService.login(form.value.emailConseiller,form.value.password).subscribe((data: Conseiller[]) => {
      if (data) {
        localStorage.setItem("token",data+'');
        console.log(typeof(data))
        this.router.navigate(["/list-clients"]);
      }else{
        alert("erreur")
      }
    });
  }
  
  }


