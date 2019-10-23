import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { ListClientsComponent } from './list-clients/list-clients.component';
import { ListCompteClientComponent } from './list-clients/list-compte-client/list-compte-client.component';
import { VirementComponent } from './virement/virement/virement.component';
import { CreateClientComponent } from './list-clients/create-client/create-client.component';
import { EditClientComponent } from './list-clients/edit-client/edit-client.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { LoginGerantComponent } from './auth/login-gerant/login-gerant.component';
import { LoginParametrageComponent } from './auth/login-parametrage/login-parametrage.component';
import { ListeConseillersComponent } from './liste-conseillers/liste-conseillers.component';
import { ListeClientNonAffecterComponent } from './liste-conseillers/liste-client-non-affecter/liste-client-non-affecter.component';
import { CreateConseillerComponent } from './liste-conseillers/create-conseiller/create-conseiller.component';
import { AlertComponent } from './alert/alert.component';
import { AlertGerantComponent } from './alert-gerant/alert-gerant.component';
import { ParametrageComponent } from './parametrage/parametrage.component';
import { ConsulterCompteClientComponent } from './list-clients/consulter-compte-client/consulter-compte-client.component';
import { HistoComponent } from './histo/histo.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [

  // Rooting d'acceuil la page login

  {path: 'loginConseiller', component: LoginComponent },
  {path: 'loginGerant', component: LoginGerantComponent },
  {path: 'loginParametrage', component: LoginParametrageComponent },
  {path: '', component: AcceuilComponent},
  {path: 'list-clients', component: ListClientsComponent, canActivate:[AuthGuard] },
  {path: 'listeClientsNonAffecter/:id', component: ListeClientNonAffecterComponent , canActivate:[AuthGuard] },
  {path: 'listConseillers', component: ListeConseillersComponent, canActivate:[AuthGuard]  },
  {path: 'list-clients/new-client', component: CreateClientComponent, canActivate:[AuthGuard] },
  {path: 'listConseillers/createConseiller', component: CreateConseillerComponent, canActivate:[AuthGuard] },
  {path: 'list-clients/consulterClient/:id', component: ConsulterCompteClientComponent, canActivate:[AuthGuard] },
  {path: 'list-clients/edit-client/:id', component: EditClientComponent, canActivate:[AuthGuard] },
  {path: 'list-clients/list-compte-client', component: ListCompteClientComponent, canActivate:[AuthGuard] },
  {path: 'virement/virement', component: VirementComponent, canActivate:[AuthGuard] },
  {path: 'alert', component: AlertComponent, canActivate:[AuthGuard] },
  {path: 'alertGerant', component: AlertGerantComponent, canActivate:[AuthGuard] },
  {path: 'parametrage', component: ParametrageComponent, canActivate:[AuthGuard] },
  {path: 'histo', component: HistoComponent, canActivate:[AuthGuard] },

  // Redirection vers la page d'acceuil

  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
