package com.jit.proxiBanqueV4.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_operation")
public class Operation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOperation;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name = "idCompte")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name = "idConseiller")
	private Conseiller conseiller;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	public Long getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(Long idOperation) {
		this.idOperation = idOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Conseiller getConseiller() {
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

}
