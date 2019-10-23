import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Compte } from '../model/compte';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  constructor(private httpClient:HttpClient) { }
  countCompteMoinsDecouvert(){
    return this.httpClient.get("proxiBanque/comptes");
  }
}
