package com.car.mvc.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="contrat")
public class Contrat implements Serializable {
	
	public int getId() {
		return id;
	}

	public Contrat() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}
	@Id
	@GeneratedValue
	int id;
	

}
