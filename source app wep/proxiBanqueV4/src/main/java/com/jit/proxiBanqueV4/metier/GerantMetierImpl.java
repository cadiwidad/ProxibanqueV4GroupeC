package com.jit.proxiBanqueV4.metier;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jit.proxiBanqueV4.dao.IClientDao;
import com.jit.proxiBanqueV4.dao.IConseillerDao;
import com.jit.proxiBanqueV4.dao.IGerantDao;
import com.jit.proxiBanqueV4.entites.Client;
import com.jit.proxiBanqueV4.entites.Conseiller;
import com.jit.proxiBanqueV4.entites.Gerant;
@Service
public class GerantMetierImpl implements IGerantMetier {
	@Autowired
	private IGerantDao gerantDao;
	@Autowired
	private IConseillerDao conseillerDao;
	@Autowired
	private IClientDao clientDao;
	@Override
	public Gerant saveGerant(Gerant gerant) {
		return gerantDao.save(gerant);
	}

	@Override
	public List<Gerant> listeGerants() {
		return gerantDao.findAll();
	}

	@Override
	public Conseiller saveConseiller(Conseiller conseiller) {
		return conseillerDao.save(conseiller);
	}

	@Override
	public List<Conseiller> listeConseillers() {
		return conseillerDao.findAll();
	}

	@Override
	@Transactional
	public boolean affecterClient(Long idClient,Long idConseiller) {
		Client client=clientDao.findById(idClient).orElse(null);
		Conseiller conseiller=conseillerDao.findById(idConseiller).orElse(null);
		client.setConseiller(conseiller);
		clientDao.save(client);
		return true;
	}

	@Override
	public List<Client> alertDecouvert() {
		return clientDao.alertDecouvert();
	}

	@Override
	public int seConnecter(String emailGerant, String password) {
		return gerantDao.seConnecter(emailGerant, password);
	}

	@Override
	public List<Conseiller> listeConseillersById(Long idGerant) {
		return conseillerDao.findByIdGerant(idGerant);
	}

}
