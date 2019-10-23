import { Component, OnInit } from '@angular/core';
import{GerantService} from '../services/gerant.service';
import { Conseiller } from '../model/conseiller';

@Component({
  selector: 'app-liste-conseillers',
  templateUrl: './liste-conseillers.component.html',
  styleUrls: ['./liste-conseillers.component.css']
})
export class ListeConseillersComponent implements OnInit {
  idGerant:number;
  listeConseillers:Conseiller[];
  constructor(private gerantService:GerantService) { }

  ngOnInit() {
    this.idGerant=parseInt(localStorage.getItem("token"));
    this.gerantService.listeConseillersByGerant(this.idGerant).subscribe((data:Conseiller[])=>{
      this.listeConseillers=data;
  })
  }

  deleteConseiller(idConseiller: number){
    this.gerantService.deleteConseiller(idConseiller).subscribe(() => {
      this.idGerant=parseInt(localStorage.getItem("token"));
      this.gerantService.listeConseillersByGerant(this.idGerant).subscribe((data:Conseiller[])=>{
        this.listeConseillers=data
      })
   
    }
  
    )
  }
}
