package com.efrei;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicule {
	protected int id;
	protected int plateNumber;	

	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(int plateNumber) {
		this.plateNumber = plateNumber;
	}	
}
