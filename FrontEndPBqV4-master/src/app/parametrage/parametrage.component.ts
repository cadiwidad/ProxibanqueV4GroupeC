import { Component, OnInit, ɵConsole } from '@angular/core';
import { ParametrageService } from '../services/parametrage.service';
import { Parametrage } from '../model/parametrage';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-parametrage',
  templateUrl: './parametrage.component.html',
  styleUrls: ['./parametrage.component.css']
})
export class ParametrageComponent implements OnInit {
  idParametrage:number
parametrage:Parametrage
  constructor(private parametrageService:ParametrageService,private fb : FormBuilder,private route: Router) { }

    userForm : FormGroup;
  ngOnInit() {    this.userForm = this.fb.group({
    idParametrage:[''],
    login:[''],
    password: [''],
    decouvert: [''],
    commission:[''],
    nbrClients:[''],
    nbrConseillers:[''],
    solde:[''],
    styleGraphe:['']
  });
  this.idParametrage=+localStorage.getItem("token");
    this.parametrageService.getParametrage(this.idParametrage).subscribe((data:Parametrage)=>{
      this.userForm.setValue(data)
      console.log(data)
  })}

  onSubmit(){
    this.userForm.value.idParametrage=this.idParametrage
    console.log(this.userForm.value)
    this.parametrageService.updateParametrage(this.userForm.value).subscribe(() =>{
      
    });
  }

  logout(){
    localStorage.removeItem("token")
    this.route.navigate([""]);
  }

}
