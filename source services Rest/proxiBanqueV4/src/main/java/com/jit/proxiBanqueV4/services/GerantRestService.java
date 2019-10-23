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
import com.jit.proxiBanqueV4.entites.Conseiller;
import com.jit.proxiBanqueV4.entites.Gerant;
import com.jit.proxiBanqueV4.metier.IClientMetier;
import com.jit.proxiBanqueV4.metier.IConseillerMetier;
import com.jit.proxiBanqueV4.metier.IGerantMetier;

@RestController
public class GerantRestService {
	@Autowired
	private IGerantMetier gerantMetier;
	@Autowired
	private IConseillerMetier conseillerMetier;
	@Autowired
	private IClientMetier clientMetier;
	
	@RequestMapping(value = "/proxiBanque/affecterClient2",method = RequestMethod.PUT)
	public void affecterClient2(@RequestBody HashMap<String,Object> operation) {
		Long idClient=Long.valueOf((String) operation.get("idClient"));
		Long idConseiller=Long.valueOf((String) operation.get("idConseiller"));
		clientMetier.affecterClient2(idConseiller, idClient);
	}

	@RequestMapping(value ="/proxiBanque/listeClientNonAffecter",method = RequestMethod.GET)
	public List<Client> listeClientsNonAffecter() {
		return clientMetier.listeClientsNonAffecter();
	}

	@RequestMapping(value = "/proxiBanque/deleteConseiller/{idConseiller}",method = RequestMethod.DELETE)
	public boolean deleteConseiller(@PathVariable Long idConseiller) {
		return conseillerMetier.deleteConseiller(idConseiller);
	}

	@RequestMapping(value = "/proxiBanque/listeConseillers/{idGerant}",method = RequestMethod.GET)
	public List<Conseiller> listeConseillersById(@PathVariable Long idGerant) {
		return gerantMetier.listeConseillersById(idGerant);
	}

	@RequestMapping(value = "/proxiBanque/connecterGerant/{emailGerant}/{password}",method = RequestMethod.GET)
	public int seConnecter(@PathVariable String emailGerant,@PathVariable String password) {
		return gerantMetier.seConnecter(emailGerant, password);
	}

	@RequestMapping(value = "/proxiBanque/addConseiller",method = RequestMethod.POST)
	public Conseiller saveConseiller(@RequestBody Conseiller conseiller) {
		return gerantMetier.saveConseiller(conseiller);
	}

	@RequestMapping(value = "/proxiBanque/affecterClient",method = RequestMethod.PUT)
	public boolean affecterClient(@RequestBody HashMap<String,Object> operation) {
		Long idClient=Long.valueOf((String) operation.get("idClient"));
		Long idConseiller=Long.valueOf((String) operation.get("idConseiller"));
		return gerantMetier.affecterClient(idClient,idConseiller);
	}
	@RequestMapping(value = "/proxiBanque/listeConseillers",method = RequestMethod.GET)
	public List<Conseiller> listeConseillers() {
		return gerantMetier.listeConseillers();
	}

	@RequestMapping(value = "/proxiBanque/gerants",method = RequestMethod.POST)
	public Gerant saveGerant(@RequestBody Gerant gerant) {
		return gerantMetier.saveGerant(gerant);
	}

	@RequestMapping(value = "/proxiBanque/gerants",method = RequestMethod.GET)
	public List<Gerant> listeGerants() {
		return gerantMetier.listeGerants();
	}
	@RequestMapping(value = "/proxiBanque/alertDecouvert",method = RequestMethod.GET)
	public List<Client> alertDecouvert() {
		return gerantMetier.alertDecouvert();
	}

}
