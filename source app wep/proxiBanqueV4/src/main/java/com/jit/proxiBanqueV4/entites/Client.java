package com.jit.proxiBanqueV4.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String nomClient;
	private String prenomClient;
	private String emailClient;
	private String adresseClient;
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	private Collection<Compte> comptes;
	@ManyToOne
	@JoinColumn(name = "idConseiller")
	private Conseiller conseiller;

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	@JsonIgnore
	public Collection<Compte> getComptes() {
		return comptes;
	}
	@JsonSetter
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Client(String nomClient, String prenomClient, String emailClient, String adresseClient) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.emailClient = emailClient;
		this.adresseClient = adresseClient;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
}
