import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ParametrageService {
  constructor(private httpClient:HttpClient) { }
  login(login:string,password:string){
    return this.httpClient.get("proxiBanque/connecterParametrage/"+login+"/"+password)
  }
  getParametrage(idParametrage:number){
    return this.httpClient.get("proxiBanque/parametrage/"+idParametrage)
  }
  updateParametrage(modif){
    return this.httpClient.put("proxiBanque/parametrage/",modif)
  }
}
