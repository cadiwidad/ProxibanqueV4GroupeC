package com.jit.proxiBanqueV4.metier;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jit.proxiBanqueV4.dao.ICompteDao;
import com.jit.proxiBanqueV4.entites.Compte;

@Service
public class CompteMetierImpl implements ICompteMetier {
	@Autowired
	private ICompteDao compteDao;

	@Override
	public Compte saveCompte(Compte compte) {
		compte.setDateCreation(new Date());
		return compteDao.save(compte);
	}

	@Override
	public Compte getCompteById(String idCompte) {
		return compteDao.getOne(idCompte);
	}

	@Override
	public BigInteger idCompte() {
		BigInteger bigInteger = new BigInteger("2000000000000");
		BigInteger min = new BigInteger("1000000000");
		BigInteger bigInteger1 = bigInteger.subtract(min);
		Random rnd = new Random();
		int maxNumBitLength = bigInteger.bitLength();

		BigInteger aRandomBigInt;

		aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
		if (aRandomBigInt.compareTo(min) < 0)
			aRandomBigInt = aRandomBigInt.add(min);
		if (aRandomBigInt.compareTo(bigInteger) >= 0)
			aRandomBigInt = aRandomBigInt.mod(bigInteger1).add(min);

		return aRandomBigInt;
	}

	@Override
	public List<Compte> listeComptes() {
		return compteDao.findAll();
	}

	@Override
	public boolean deleteCompte(String idCompte) {
		Compte compte=getCompteById(idCompte);
		compteDao.delete(compte);
		return false;
	}

	@Override
	public int countCompteMoinsDecouvert() {
		return compteDao.countCompteMoinsDecouvert();
	}

}
