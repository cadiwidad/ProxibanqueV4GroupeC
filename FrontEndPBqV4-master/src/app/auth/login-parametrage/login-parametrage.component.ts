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
  selector: 'app-login-parametrage',
  templateUrl: './login-parametrage.component.html',
  styleUrls: ['./login-parametrage.component.css']
})
export class LoginParametrageComponent implements OnInit {
  constructor(private router: Router,private parametrageService:ParametrageService){}
  ngOnInit() { }
  onSubmit(form: NgForm) {
    this.parametrageService.login(form.value.login,form.value.password).subscribe((data: Parametrage[]) => {
      if (data) {
        localStorage.setItem("token",data+'');
        console.log(typeof(data))
        this.router.navigate(["/parametrage"]);
      }else{
        alert("erreur")
      }
    });
  }
  
  }
