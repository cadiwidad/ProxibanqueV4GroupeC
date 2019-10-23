package com.jit.proxiBanqueV4.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeCompte",discriminatorType = DiscriminatorType.STRING,length = 2)


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
               @Type(name = "CC",value =CompteCourant.class),
               @Type(name = "CE",value =CompteEpargne.class)
               })
public abstract class Compte implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String idCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "idConseiller")
	private Conseiller conseiller;
	@OneToMany(mappedBy = "compte",fetch = FetchType.LAZY)
	private Collection<Operation> operations;
	
	public Compte(Date dateCreation, double solde) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(String idCompte) {
		this.idCompte = idCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@JsonIgnore
	public Collection<Operation> getOperations() {
		return operations;
	}
	@JsonSetter
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
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
