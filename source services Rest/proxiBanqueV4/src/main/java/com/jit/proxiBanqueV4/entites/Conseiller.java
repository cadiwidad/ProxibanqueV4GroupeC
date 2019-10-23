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
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Conseiller implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConseiller;
	private String nomConseiller;
	private String prenomConseiller;
	private String emailConseiller;
	private String password;
	private String adresseConseiller;
	@OneToMany(mappedBy = "conseiller",fetch = FetchType.LAZY)
	private Collection<Client> clients;
	@ManyToOne
	@JoinColumn(name = "idGerant")
	private Gerant gerant;
	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conseiller(String nomConseiller, String prenomConseiller, String emailConseiller, String password,
			String adresseConseiller) {
		super();
		this.nomConseiller = nomConseiller;
		this.prenomConseiller = prenomConseiller;
		this.emailConseiller = emailConseiller;
		this.password = password;
		this.adresseConseiller = adresseConseiller;
	}
	public Long getIdConseiller() {
		return idConseiller;
	}
	public void setIdConseiller(Long idConseiller) {
		this.idConseiller = idConseiller;
	}
	public String getNomConseiller() {
		return nomConseiller;
	}
	public void setNomConseiller(String nomConseiller) {
		this.nomConseiller = nomConseiller;
	}
	public String getPrenomConseiller() {
		return prenomConseiller;
	}
	public void setPrenomConseiller(String prenomConseiller) {
		this.prenomConseiller = prenomConseiller;
	}
	public String getEmailConseiller() {
		return emailConseiller;
	}
	public void setEmailConseiller(String emailConseiller) {
		this.emailConseiller = emailConseiller;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdresseConseiller() {
		return adresseConseiller;
	}
	public void setAdresseConseiller(String adresseConseiller) {
		this.adresseConseiller = adresseConseiller;
	}
	@JsonIgnore
	public Collection<Client> getClients() {
		return clients;
	}
	@JsonSetter
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}
	@JsonIgnore
	public Gerant getGerant() {
		return gerant;
	}
	@JsonSetter
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
