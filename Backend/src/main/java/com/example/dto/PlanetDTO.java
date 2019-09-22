package com.example.dto;

import java.io.Serializable;



public class PlanetDTO extends EntityBeanDTO implements Serializable{



private String nombre;
private String size;
private StarDTO star;


public PlanetDTO() {
	
}

public PlanetDTO(String nombre, String size, StarDTO star) {
	
	this.nombre = nombre;
	this.size = size;
	this.star = star;
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

public StarDTO getStar() {
	return star;
}
public void setStar(StarDTO star) {
	this.star = star;
}

	
}
