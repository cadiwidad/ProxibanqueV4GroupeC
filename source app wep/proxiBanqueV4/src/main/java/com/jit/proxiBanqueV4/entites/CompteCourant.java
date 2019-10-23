package com.jit.proxiBanqueV4.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private double decouvert;

	public CompteCourant(Date dateCreation, double solde, double decouvert) {
		super(dateCreation, solde);
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
