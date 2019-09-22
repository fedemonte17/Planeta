package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "star")
public class Star extends EntityBean {
	
	
	@Column(name="star_nombre", unique = true)	
    private String nombre;
	
	
	@Column(name="star_densidad")
    private String densidad;

	@OneToMany(mappedBy = "star")	
    private List<Planet> planets = new ArrayList<>();

//Constructor
	
	
public Star(String nombre, String densidad) {
	
	this.nombre = nombre;
	this.densidad = densidad;
}


public Star() {

}


//Getter and Setter
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDensidad() {
	return densidad;
}
public void setDensidad(String densidad) {
	this.densidad = densidad;
}


public List<Planet> getPlanets() {
	return planets;
}


public void setPlanets(List<Planet> planets) {
	this.planets = planets;
}



}
