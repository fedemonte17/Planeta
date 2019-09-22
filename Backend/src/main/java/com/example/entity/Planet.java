package com.example.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "planet")
public class Planet extends EntityBean {

	@Column(name="planet_nombre", unique = true)
	private String nombre;
	
	@Column(name="planet_size")
	private String size;
	
	

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "star_id")
	private Star star;
	//Constructor
	
	public Planet(String nombre, String size) {
		this.nombre = nombre;
		this.size = size;
	}
	
	
	
	
	
	public Planet(String nombre, String size, Star star) {
		super();
		this.nombre = nombre;
		this.size = size;
		this.star = star;
	}





	public Planet() {
		
	}



	//Getter and Setter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	public Star getStar() {
		return star;
	}


	public void setStar(Star star) {
		this.star = star;
	}
	
	
	
}
