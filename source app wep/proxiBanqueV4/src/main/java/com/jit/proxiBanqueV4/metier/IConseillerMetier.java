package com.jit.proxiBanqueV4.metier;

import java.util.List;


import com.jit.proxiBanqueV4.entites.Client;
import com.jit.proxiBanqueV4.entites.Conseiller;

public interface IConseillerMetier {
	public Conseiller saveConseiller(Conseiller conseiller);
	public List<Conseiller> listeConseillers();
	public Conseiller getConseiller(Long idConseiller);
	public boolean updateConseiller(Conseiller conseiller);
	public boolean deleteConseiller(Long idConseiller);
	public int seConnecter(String emailConseiller,String password);
	
	
	
	public Client createClient(Client client,double solde);
	public Client getClient(Long idClient);
	public boolean updateClient(Client client);
	public List<Client> listeClients(Long idConseiller);
	public List<Client> alertDecouvert(Long idConseiller);
	

}
