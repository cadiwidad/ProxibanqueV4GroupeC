package com.jit.proxiBanqueV4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jit.proxiBanqueV4.entites.Conseiller;

public interface IConseillerDao extends JpaRepository<Conseiller, Long> {

	@Query("select c.idConseiller from Conseiller c  where c.emailConseiller=:E and c.password=:P")
	public int seConnecter(@Param("E")String emailConseiller,@Param("P")String password);
	
	@Query("select c from Conseiller c where c.gerant.idGerant=:X")
	public List<Conseiller> findByIdGerant(@Param("X") Long idGerant);
	

}
