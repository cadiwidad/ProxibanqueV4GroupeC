package com.jit.proxiBanqueV4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jit.proxiBanqueV4.entites.Compte;

public interface ICompteDao extends JpaRepository<Compte, String> {
	@Transactional
	@Modifying
	@Query("delete from Compte c where c.client.idClient=:X")
	public void deleteCompteByIdClient(@Param("X") Long idClient);
	
	@Query("SELECT count(*) from Compte c where c.solde<0 ")
	public int countCompteMoinsDecouvert();
	
	@Transactional
	@Modifying
	@Query("update Compte c set c.conseiller.idConseiller=null where c.conseiller.idConseiller=:X")
	public void updateIdConseillerCompte(@Param("X") Long idConseiller);
	
	@Transactional
	@Modifying
	@Query("update Compte c set c.conseiller.idConseiller=:X where c.conseiller.idConseiller is null and c.client.idClient=:I")
	public void affecterCompte2(@Param("X") Long idConseiller,@Param("I") Long idClient);

}
