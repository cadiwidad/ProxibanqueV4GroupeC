import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { ListClientsComponent } from './list-clients/list-clients.component';
import { ListCompteClientComponent } from './list-clients/list-compte-client/list-compte-client.component';
import { HeaderComponent } from './header/header.component';
import { VirementComponent } from './virement/virement/virement.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CreateClientComponent } from './list-clients/create-client/create-client.component';
import { EditClientComponent } from './list-clients/edit-client/edit-client.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { LoginGerantComponent } from './auth/login-gerant/login-gerant.component';
import { LoginParametrageComponent } from './auth/login-parametrage/login-parametrage.component';
import { ListeConseillersComponent } from './liste-conseillers/liste-conseillers.component';
import { HeaderGerantComponent } from './header-gerant/header-gerant.component';
import { CreateConseillerComponent } from './liste-conseillers/create-conseiller/create-conseiller.component';
import { ListeClientNonAffecterComponent } from './liste-conseillers/liste-client-non-affecter/liste-client-non-affecter.component';
import { AlertComponent } from './alert/alert.component';
import { AlertGerantComponent } from './alert-gerant/alert-gerant.component';
import { ParametrageComponent } from './parametrage/parametrage.component';
import { ConsulterCompteClientComponent } from './list-clients/consulter-compte-client/consulter-compte-client.component';
import { HistoComponent } from './histo/histo.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListClientsComponent,
    ListCompteClientComponent,
    HeaderComponent,
    VirementComponent,
    CreateClientComponent,
    EditClientComponent,
    AcceuilComponent,
    LoginGerantComponent,
    LoginParametrageComponent,
    ListeConseillersComponent,
    HeaderGerantComponent,
    CreateConseillerComponent,
    ListeClientNonAffecterComponent,
    AlertComponent,
    AlertGerantComponent,
    ParametrageComponent,
    ConsulterCompteClientComponent,
    HistoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
