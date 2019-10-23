package com.jit.proxiBanqueV4.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte implements Serializable {

	private static final long serialVersionUID = 1L;
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(Date dateCreation, double solde, double taux) {
		super(dateCreation, solde);
		this.taux = taux;
	}

}
