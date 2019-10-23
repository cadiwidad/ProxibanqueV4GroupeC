package com.jit.proxiBanqueV4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jit.proxiBanqueV4.entites.Compte;
import com.jit.proxiBanqueV4.metier.ICompteMetier;

@RestController
public class CompteRestService {
	@Autowired
	private ICompteMetier compteMetier;
	
	@RequestMapping(value = "/proxiBanque/comptes",method = RequestMethod.GET)
	public int countCompteMoinsDecouvert() {
		return compteMetier.countCompteMoinsDecouvert();
	}

	@RequestMapping(value = "/proxiBanque/comptes",method = RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte compte) {
		return compteMetier.saveCompte(compte);
	}

	@RequestMapping(value = "/proxiBanque/comptes/{idCompte}",method = RequestMethod.GET)
	public Compte getCompteById(@PathVariable String idCompte) {
		return compteMetier.getCompteById(idCompte);
	}

}
