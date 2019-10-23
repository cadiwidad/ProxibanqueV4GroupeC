package com.jit.proxiBanqueV4.metier;

import java.math.BigInteger;
import java.util.List;

import com.jit.proxiBanqueV4.entites.Compte;

public interface ICompteMetier {
	public Compte saveCompte(Compte compte);
	public Compte getCompteById(String idCompte);
	public List<Compte> listeComptes();
	public boolean deleteCompte(String idCompte);
	
	public BigInteger idCompte();
	public int countCompteMoinsDecouvert();

}
