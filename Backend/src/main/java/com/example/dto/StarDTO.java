package com.example.dto;

import java.io.Serializable;

public class StarDTO extends EntityBeanDTO implements Serializable{
	
  
	private String nombre;
    private String densidad;

    
    
    public StarDTO() {
		
	}
	public StarDTO(String nombre, String desidad) {
		super();
		this.nombre = nombre;
		this.densidad = desidad;
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
	public void setDesidad(String densidad) {
		this.densidad = densidad;
	}
    
}
