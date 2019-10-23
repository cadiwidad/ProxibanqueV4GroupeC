import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Client } from 'src/app/model/client';
import { Compte } from '../model/compte';

@Injectable({
  providedIn: 'root'
})
export class ConseillerService {
  constructor(private httpClient:HttpClient) { }
  login(login:string,password:string){
    return this.httpClient.get("proxiBanque/connecterConseiller/"+login+"/"+password);
  }
  listeClientConseiler(idConseiller:number){
    return this.httpClient.get<Client>("proxiBanque/listeClients/"+idConseiller);
  }

  listeClientVcSolde(idConseiller:number){
    return this.httpClient.get<Client>("proxiBanque/listeClientVcSolde/"+idConseiller);
  }
  listeClientVcSolde2(){
    return this.httpClient.get<Client>("proxiBanque/listeClientVcSolde");
  }

  createClient(client){
    return this.httpClient.post("proxiBanque/addClient",client);
  }
  updateClient(client: Client) {
    return this.httpClient.put<Client>("proxiBanque/updateClient", client)
  }
  deleteClient(idClient:number){
    return this.httpClient.delete<Client>("proxiBanque/clients/"+idClient)}
 

    virement(compte) {

      return this.httpClient.put<Compte>("proxiBanque/virement",compte);
    }
    listeComptes(){
      return this.httpClient.get<Compte>("proxiBanque/listeComptes");
    }
    listeCompteClient(idClient:number){
      return this.httpClient.get("proxiBanque/listeCompteClient/"+idClient);
    
    }
}
