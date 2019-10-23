package com.jit.proxiBanqueV4.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Gerant  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGerant;
	private String nomGerant;
	private String prenomGerant;
	private String emailGerant;
	private String password;
	private String adresseGerant;
	@OneToMany(mappedBy = "gerant",fetch = FetchType.LAZY)
	private Collection<Conseiller> conseillers;
	public Gerant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gerant(String nomGerant, String prenomGerant, String emailGerant, String password, String adresseGerant) {
		super();
		this.nomGerant = nomGerant;
		this.prenomGerant = prenomGerant;
		this.emailGerant = emailGerant;
		this.password = password;
		this.adresseGerant = adresseGerant;
	}
	public Long getIdGerant() {
		return idGerant;
	}
	public void setIdGerant(Long idGerant) {
		this.idGerant = idGerant;
	}
	public String getNomGerant() {
		return nomGerant;
	}
	public void setNomGerant(String nomGerant) {
		this.nomGerant = nomGerant;
	}
	public String getPrenomGerant() {
		return prenomGerant;
	}
	public void setPrenomGerant(String prenomGerant) {
		this.prenomGerant = prenomGerant;
	}
	public String getEmailGerant() {
		return emailGerant;
	}
	public void setEmailGerant(String emailGerant) {
		this.emailGerant = emailGerant;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdresseGerant() {
		return adresseGerant;
	}
	public void setAdresseGerant(String adresseGerant) {
		this.adresseGerant = adresseGerant;
	}
	public Collection<Conseiller> getConseillers() {
		return conseillers;
	}
	public void setConseillers(Collection<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
