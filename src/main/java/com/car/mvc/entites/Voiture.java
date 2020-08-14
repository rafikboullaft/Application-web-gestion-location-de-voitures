package com.car.mvc.entites;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="voiture")
public class Voiture implements Serializable {
	
	@Id
	@GeneratedValue
	int id;
	String marque;
	String matricule;
	int modele;
	String carburant;
	double kilometrage;
	boolean reserver;
	float prix;
	String image;
	Date assurance;
	Date visite;
	
	
	
	public Voiture() {
		super();
	}

	public Voiture(int id, String marque, int modele, String carburant, double kilometrage, boolean reserver,
			float prix, String image, Date assurance, Date visite,String matricule) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.modele = modele;
		this.carburant = carburant;
		this.kilometrage = kilometrage;
		this.reserver = reserver;
		this.prix = prix;
		this.image = image;
		//@DateTimeFormat(pattern ="dd/MM/yyyy")
		this.assurance = assurance;
		this.visite = visite;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getModele() {
		return modele;
	}

	public void setModele(int modele) {
		this.modele = modele;
	}

	public String getCarburant() {
		return carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public double getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}

	public boolean isReserver() {
		return reserver;
	}

	public void setReserver(boolean reserver) {
		this.reserver = reserver;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getAssurance() {
		return assurance;
	}

	public void setAssurance(Date assurance) {
		this.assurance = assurance;
	}

	public Date getVisite() {
		return visite;
	}

	public void setVisite(Date visite) {
		this.visite = visite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
