package com.jit.proxiBanqueV4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jit.proxiBanqueV4.entites.Client;


public interface IClientDao extends JpaRepository<Client, Long> {
	@Query("select c from Client c where c.conseiller.idConseiller=:X")
	public List<Client> findByIdConseiller(@Param("X") Long idConseiller);


	@Query("select c from Client c INNER JOIN Compte cp on c.idClient=cp.client.idClient where cp.solde<0 and c.conseiller.idConseiller=:X")
	public List<Client> alertDecouvert(@Param("X") Long idConseiller);
	


	@Query("select c from Client c INNER JOIN Compte cp on c.idClient=cp.client.idClient where cp.solde<0")
	public List<Client> alertDecouvert();
	
	@Transactional
	@Modifying
	@Query("update Client c set c.conseiller.idConseiller=null where c.conseiller.idConseiller=:X")
	public void updateIdConseillerClient(@Param("X") Long idConseiller);
	

	@Transactional
	@Modifying
	@Query("update Client c set c.conseiller.idConseiller=:X where c.conseiller.idConseiller is null and c.idClient=:I")
	public void affecterClient2(@Param("X") Long idConseiller,@Param("I") Long idClient);
	
	
	@Query("select c from Client c where c.conseiller.idConseiller is null")
	public List<Client> listeClientNonAffecter();
	
	@Query("select c.idClient,c.nomClient,c.prenomClient,cp.idCompte,cp.solde from Client c  inner join Compte cp on c.idClient=cp.client.idClient WHERE c.conseiller.idConseiller=:X and cp.solde<0 GROUP BY c.nomClient")
	public List<Object> listeClientVcSolde(@Param("X") Long idConseiller);
	
	
	@Query("select c.idClient,c.nomClient,c.prenomClient,cp.idCompte,cp.solde from Client c  inner join Compte cp on c.idClient=cp.client.idClient WHERE cp.solde<0 GROUP BY c.nomClient")
	public List<Object> listeClientVcSolde();
	
	@Query("select c.nomClient,c.prenomClient,c.emailClient,c.adresseClient ,cp.idCompte,cp.solde,cp.dateCreation from Client c inner join Compte cp on c.idClient=cp.client.idClient WHERE c.idClient=:X")
	public List<Object> listeCompteClient(@Param("X") Long idClient);

	

	
	
	

}
