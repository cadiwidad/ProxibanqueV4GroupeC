package com.jit.proxiBanqueV4.metier;

import java.util.List;

import com.jit.proxiBanqueV4.entites.Client;
import com.jit.proxiBanqueV4.entites.Conseiller;
import com.jit.proxiBanqueV4.entites.Gerant;

public interface IGerantMetier {
	public Gerant saveGerant(Gerant gerant);
	public List<Gerant> listeGerants();
	public int seConnecter(String emailGerant,String password);
	
	
	

	public Conseiller saveConseiller(Conseiller conseiller);

	public List<Conseiller> listeConseillers();
	
	public boolean affecterClient(Long idClient,Long idConseiller);
	
	public List<Client> alertDecouvert(); 
	

	public List<Conseiller> listeConseillersById(Long idGerant);
	
	
}
