package com.jit.proxiBanqueV4.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jit.proxiBanqueV4.dao.IClientDao;
import com.jit.proxiBanqueV4.dao.ICompteDao;
import com.jit.proxiBanqueV4.entites.Client;
@Service
public class ClientMetierImpl implements IClientMetier {
	@Autowired
	private IClientDao clientDao;
	@Autowired
	private ICompteDao compteDao;
	@Override
	public Client saveClient(Client client) {
		return clientDao.save(client);
	}

	@Override
	public List<Client> listeClients() {
		return clientDao.findAll();
	}

	@Override
	public Client getClient(Long idClient) {
		return clientDao.getOne(idClient) ;
	}

	@Override
	public boolean deleteClient(Long idClient) {
		Client client=getClient(idClient);
		clientDao.delete(client);
		compteDao.deleteCompteByIdClient(idClient);
		return true;
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
	public List<Client> listeClientsNonAffecter() {
		return clientDao.listeClientNonAffecter();
	}

	@Override
	public void affecterClient2(Long idConseiller, Long idClient) {
		clientDao.affecterClient2(idConseiller, idClient);
		compteDao.affecterCompte2(idConseiller, idClient);
		
	}

	@Override
	public List<Object> listeClientVcSolde(Long idConseiller) {
		return clientDao.listeClientVcSolde(idConseiller);
	}

	@Override
	public List<Object> listeClientVcSolde() {
		return clientDao.listeClientVcSolde();
	}

	@Override
	public List<Object> listeCompteClient(Long idClient) {
		return clientDao.listeCompteClient(idClient);
	}

}
