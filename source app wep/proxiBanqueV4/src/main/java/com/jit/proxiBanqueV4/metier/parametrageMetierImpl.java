package com.jit.proxiBanqueV4.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jit.proxiBanqueV4.dao.IParametrageDao;
import com.jit.proxiBanqueV4.entites.Parametrage;

@Service
public class parametrageMetierImpl implements IParametrageMetier {
	@Autowired
	IParametrageDao parametrageDao;

	@Override
	public boolean controlerStatistique(Parametrage parametrage) {
		Parametrage parametrageOld=parametrageDao.getOne(parametrage.getIdParametrage());
		parametrageOld.setCommission(parametrage.getCommission());
		parametrageOld.setNbrClients(parametrage.getNbrClients());
		parametrageOld.setNbrConseillers(parametrage.getNbrConseillers());
		parametrageOld.setStyleGraphe(parametrage.getStyleGraphe());
		parametrageDao.save(parametrageOld);
		return true;
	}

	@Override
	public Parametrage getParametrage(Long idParametrage) {
		return parametrageDao.getOne(idParametrage);
	}

	@Override
	public int seConnecter(String login, String password) {
		return parametrageDao.seConnecter(login, password);
	}
	

}
