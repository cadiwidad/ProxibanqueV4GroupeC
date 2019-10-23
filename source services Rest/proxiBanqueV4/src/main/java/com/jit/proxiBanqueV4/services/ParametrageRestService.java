package com.jit.proxiBanqueV4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jit.proxiBanqueV4.entites.Parametrage;
import com.jit.proxiBanqueV4.metier.IParametrageMetier;

@RestController
public class ParametrageRestService {
	@Autowired
	private IParametrageMetier parametrageMetier;
	
	@RequestMapping(value = "/proxiBanque/connecterParametrage/{login}/{password}",method = RequestMethod.GET)
	public int seConnecter( @PathVariable String login,@PathVariable String password) {
		return parametrageMetier.seConnecter(login, password);
	}
	@RequestMapping(value = "/proxiBanque/parametrage/{idParametrage}",method = RequestMethod.GET)
	public Parametrage getParametrage(@PathVariable Long idParametrage) {
		return parametrageMetier.getParametrage(idParametrage);
	}
	@RequestMapping(value = "/proxiBanque/parametrage",method = RequestMethod.PUT)
	public boolean controlerStatistique(@RequestBody Parametrage parametrage) {
		return parametrageMetier.controlerStatistique(parametrage);
	}

}
