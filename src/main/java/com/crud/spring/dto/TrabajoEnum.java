package com.crud.spring.dto;

public enum TrabajoEnum {

	PANADERO ("Panadero"),
	CHARCUTERO ("Charcutero"),
	ADMINISTRADOR("Administrador");
	
	private final String nombreTrabajo;
	
	
	public int setearSueldo(String trabajo) {
		
		int sueldo = 0;
		
		switch(trabajo) {
			case "Panadero":
				sueldo = 12000;
				break;
			case "Charcutero":
				sueldo = 950;
				break;
				
			case "Administrador":
				sueldo = 55000;
				break;
		}
		
		return sueldo;
	}
	
//Getter and Setters
	TrabajoEnum(String nombreTrabajo) {
		this.nombreTrabajo = nombreTrabajo;
	}

	
	public String getNombreTrabajo() {
		return nombreTrabajo;
	}

	@Override
	public String toString() {
		return nombreTrabajo;
	}
}
