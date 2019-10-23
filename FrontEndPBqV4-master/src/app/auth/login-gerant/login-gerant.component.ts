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
  selector: 'app-login-gerant',
  templateUrl: './login-gerant.component.html',
  styleUrls: ['./login-gerant.component.css']
})
export class LoginGerantComponent implements OnInit {
  constructor(private router: Router,private conseillerService: ConseillerService,private gerantService:GerantService,private parametrageService:ParametrageService){}
  ngOnInit() { }
  onSubmit(form: NgForm) {
    this.gerantService.login(form.value.emailConseiller,form.value.password).subscribe((data: Gerant[]) => {
      if (data) {
        localStorage.setItem("token",data+'');
        console.log(typeof(data))
        this.router.navigate(["/listConseillers"]);
      }else{
        alert("erreur")
      }
    });
  }
  
  }