import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private httpClient: HttpClient) { }
  getClientById(idClient:number){ return this.httpClient.get<Client>("proxiBanque/getClient/"+idClient)
}
}
