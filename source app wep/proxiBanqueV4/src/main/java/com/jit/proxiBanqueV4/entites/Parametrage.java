package com.jit.proxiBanqueV4.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Parametrage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idParametrage;
	private String login;
	private String password;
	private double decouvert=3000;
	private int commission=5;
	private int nbrClients=5;
	private int nbrConseillers=10;
	private double solde=20;
	private String styleGraphe;
	public Long getIdParametrage() {
		return idParametrage;
	}
	public void setIdParametrage(Long idParametrage) {
		this.idParametrage = idParametrage;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	public int getNbrClients() {
		return nbrClients;
	}
	public void setNbrClients(int nbrClients) {
		this.nbrClients = nbrClients;
	}
	public int getNbrConseillers() {
		return nbrConseillers;
	}
	public void setNbrConseillers(int nbrConseillers) {
		this.nbrConseillers = nbrConseillers;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getStyleGraphe() {
		return styleGraphe;
	}
	public void setStyleGraphe(String styleGraphe) {
		this.styleGraphe = styleGraphe;
	}
	public Parametrage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parametrage(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	

}
