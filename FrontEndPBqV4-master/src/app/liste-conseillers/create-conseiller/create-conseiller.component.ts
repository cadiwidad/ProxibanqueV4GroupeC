import { Component, OnInit } from '@angular/core';
import { GerantService } from 'src/app/services/gerant.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Client } from 'src/app/model/client';
import { Conseiller } from 'src/app/model/conseiller';

@Component({
  selector: 'app-create-conseiller',
  templateUrl: './create-conseiller.component.html',
  styleUrls: ['./create-conseiller.component.css']
})
export class CreateConseillerComponent implements OnInit {
  idGerant:number;
  constructor(private gerantService:GerantService,private router:Router) { }

  ngOnInit() {
    this.idGerant=+localStorage.getItem("token");
    console.log(this.idGerant)
  }
  onSubmit(userForm: NgForm) {
    let conseiller = userForm.value;
    conseiller.gerant={};
    conseiller.gerant.idGerant=+localStorage.getItem("token");
    conseiller.password=userForm.value.nomConseiller+"proxi"
    console.log(conseiller)
    this.gerantService.createConseiller(conseiller).subscribe((data: Conseiller) => {
    this.router.navigate(["/listConseillers"]);
    });
  }

}
