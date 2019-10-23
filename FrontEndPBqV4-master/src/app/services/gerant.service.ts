import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Conseiller } from '../model/conseiller';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root'
})
export class GerantService {
  constructor(private httpClient:HttpClient) { }
  login(login:string,password:string){
    return this.httpClient.get("proxiBanque/connecterGerant/"+login+"/"+password)
  }
  listeConseillersByGerant(idGerant:number){
    return this.httpClient.get<Conseiller>("proxiBanque/listeConseillers/"+idGerant);
  }
  deleteConseiller(idConseiller:number)
  {
    return this.httpClient.delete<Conseiller>("proxiBanque/deleteConseiller/"+idConseiller)
  }
  createConseiller(conseiller:Conseiller)
  {
    return this.httpClient.post<Conseiller>("proxiBanque/addConseiller",conseiller,{headers:new HttpHeaders({'Content-Type':'application/json'})});

}
listeClientsNonAffecter()
{  return this.httpClient.get<Client>("proxiBanque/listeClientNonAffecter");
}
affecterClient(modifIdConseiller)
{
  return this.httpClient.put<Client>("proxiBanque/affecterClient2",modifIdConseiller);
   
}
}