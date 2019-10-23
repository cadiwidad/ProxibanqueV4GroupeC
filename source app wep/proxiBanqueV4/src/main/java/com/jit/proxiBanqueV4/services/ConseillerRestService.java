package com.jit.proxiBanqueV4.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jit.proxiBanqueV4.entites.Client;
import com.jit.proxiBanqueV4.entites.Compte;
import com.jit.proxiBanqueV4.entites.Conseiller;
import com.jit.proxiBanqueV4.metier.IClientMetier;
import com.jit.proxiBanqueV4.metier.ICompteMetier;
import com.jit.proxiBanqueV4.metier.IConseillerMetier;

@RestController
public class ConseillerRestService {
	@Autowired
	private IConseillerMetier conseillerMetier;
	@Autowired
	private ICompteMetier CompteMetier;

	@Autowired
	private IClientMetier clientMetier;
	
	@RequestMapping(value = "/proxiBanque/listeCompteClient/{idClient}",method = RequestMethod.GET)
	public List<Object> listeCompteClient(@PathVariable Long idClient) {
		return clientMetier.listeCompteClient(idClient);
	}
	@RequestMapping(value = "/proxiBanque/listeClientVcSolde",method = RequestMethod.GET)
	public List<Object> listeClientVcSolde() {
		return clientMetier.listeClientVcSolde();
	}
	@RequestMapping(value = "/proxiBanque/listeClientVcSolde/{idConseiller}",method = RequestMethod.GET)
	public List<Object> listeClientVcSolde(@PathVariable Long idConseiller) {
		return clientMetier.listeClientVcSolde(idConseiller);
	}

	@RequestMapping(value = "/proxiBanque/listeComptes",method = RequestMethod.GET)
	public List<Compte> listeComptes() {
		return CompteMetier.listeComptes();
	}

	@RequestMapping(value = "/proxiBanque/connecterConseiller/{emailConseiller}/{password}",method = RequestMethod.GET)
	public int seConnecter(@PathVariable String emailConseiller,@PathVariable String password) {
		return conseillerMetier.seConnecter(emailConseiller, password);
	}

	@RequestMapping(value = "/proxiBanque/alertDecouvert/{idConseiller}",method = RequestMethod.GET)
	public List<Client> alertDecouvert(@PathVariable Long idConseiller) {
		return conseillerMetier.alertDecouvert(idConseiller);
	}
	
	@RequestMapping(value = "/proxiBanque/listeClients/{idConseiller}",method = RequestMethod.GET)
	public List<Client> listeClients(@PathVariable Long idConseiller) {
		return conseillerMetier.listeClients(idConseiller);
	}
	
	@RequestMapping(value = "/proxiBanque/getClient/{idClient}",method = RequestMethod.GET)
	public Client getClient(@PathVariable Long idClient) {
		return clientMetier.getClient(idClient);
	}
	
	@RequestMapping(value = "/proxiBanque/updateClient",method = RequestMethod.PUT)
	public boolean updateClient(@RequestBody Client client) {
		return clientMetier.updateClient(client);
	}
	@RequestMapping(value = "/proxiBanque/addClient",method = RequestMethod.POST)
	public Client createClient(@RequestBody HashMap<String,Object> data) {
		String nomClient=(String) data.get("nomClient");
		String prennomClient=(String) data.get("prenomClient");
		String emailClient=(String) data.get("emailClient");
		String adresseClient=(String) data.get("adresseClient");
		Long idConseiller=Long.valueOf((String) data.get("idConseiller"));
		double solde=(int) data.get("solde");
		Client client=new Client(nomClient,prennomClient,emailClient,adresseClient);
		Conseiller conseiller=new Conseiller();
		conseiller.setIdConseiller(idConseiller);
		client.setConseiller(conseiller);
		return conseillerMetier.createClient(client,solde);
	}
	@RequestMapping(value = "/proxiBanque/conseillers",method = RequestMethod.POST)
	public Conseiller saveConseiller(@RequestBody Conseiller conseiller) {
		return conseillerMetier.saveConseiller(conseiller);
	}
	@RequestMapping(value = "/proxiBanque/conseillers",method = RequestMethod.GET)
	public List<Conseiller> listeConseillers() {
		return conseillerMetier.listeConseillers();
	}

}
