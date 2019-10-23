package com.jit.proxiBanqueV4.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jit.proxiBanqueV4.dao.IClientDao;
import com.jit.proxiBanqueV4.dao.ICompteDao;
import com.jit.proxiBanqueV4.dao.IConseillerDao;
import com.jit.proxiBanqueV4.entites.Client;
import com.jit.proxiBanqueV4.entites.Compte;
import com.jit.proxiBanqueV4.entites.CompteCourant;
import com.jit.proxiBanqueV4.entites.Conseiller;
@Service
public class ConseillerMetierImpl implements IConseillerMetier {
	@Autowired
	private IConseillerDao conseillerDao;
	@Autowired
	private IClientDao clientDao;
	@Autowired
	private ICompteDao compteDao;
	@Autowired
	private ICompteMetier compteMetier;
	@Override
	public Conseiller saveConseiller(Conseiller conseiller) {
		return conseillerDao.save(conseiller);
	}

	@Override
	public List<Conseiller> listeConseillers() {
		return conseillerDao.findAll();
	}

	@Override
	public Client createClient(Client client,double solde) {
		System.out.println("eeee");
		clientDao.save(client);
		Compte compteC=new CompteCourant(new Date(),solde,3000);
		compteMetier.idCompte();
		String idCompte="CC"+compteMetier.idCompte();
		compteC.setIdCompte(idCompte);
		compteC.setClient(client);
		Conseiller conseiller=new Conseiller();
		conseiller.setIdConseiller(client.getConseiller().getIdConseiller());
		compteC.setConseiller(conseiller);
		compteDao.save(compteC);
		return client;
		
	}

	@Override
	public boolean updateClient(Client client) {
		Client clientOld=getClient(client.getIdClient());
		clientOld.setNomClient(client.getNomClient());
		clientOld.setPrenomClient(client.getPrenomClient());
		clientOld.setEmailClient(client.getEmailClient());
		clientOld.setAdresseClient(client.getAdresseClient());
		clientDao.save(clientOld);
		return true;

}

	@Override
	public Client getClient(Long idClient) {
		return clientDao.getOne(idClient) ;
	}
	@Override
	public List<Client> listeClients(Long idConseiller) {
		return clientDao.findByIdConseiller(idConseiller);
	}

	@Override
	public List<Client> alertDecouvert(Long idConseiller) {
		return clientDao.alertDecouvert(idConseiller);
	}

	@Override
	public Conseiller getConseiller(Long idConseiller) {
		return conseillerDao.getOne(idConseiller);
	}

	@Override
	public boolean updateConseiller(Conseiller conseiller) {
		Conseiller conseillerOld=getConseiller(conseiller.getIdConseiller());
		conseillerOld.setNomConseiller(conseiller.getNomConseiller());
		conseillerOld.setPrenomConseiller(conseiller.getPrenomConseiller());
		conseillerOld.setEmailConseiller(conseiller.getEmailConseiller());
		conseillerOld.setAdresseConseiller(conseiller.getAdresseConseiller());
		conseillerDao.save(conseillerOld);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteConseiller(Long idConseiller) {
		Conseiller conseiller=getConseiller(idConseiller);
		clientDao.updateIdConseillerClient(conseiller.getIdConseiller());
		compteDao.updateIdConseillerCompte(idConseiller);
		conseillerDao.delete(conseiller);
		return true;
	}

	@Override
	public int seConnecter(String emailConseiller, String password) {
		return conseillerDao.seConnecter(emailConseiller, password);
	}
}
