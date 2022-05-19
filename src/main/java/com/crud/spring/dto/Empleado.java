package com.crud.spring.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Enumerated;

@Entity
@Table(name = "empleado")
public class Empleado {
	// Atributos entidad empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "salario")
	private int salario;
	@Column(name = "dni")
	private int dni;

	@Column(name = "trabajo")
	@Enumerated(EnumType.STRING)
	private TrabajoEnum trabajoEnum;
	
	// Constructores
	public Empleado() {

	}

	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param trabajo
	 * @param salario
	 * @param dni
	 */
	public Empleado(Long id, String nombre, int salario, int dni, TrabajoEnum trabajoEnum) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.salario = trabajoEnum.setearSueldo(trabajoEnum.getNombreTrabajo());
		this.dni = dni;
		this.trabajoEnum = trabajoEnum;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the salario
	 */
	public int getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(int salario) {
		this.salario = salario;
	}

	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * @return the trabajoEnum
	 */
	public TrabajoEnum getTrabajoEnum() {
		return trabajoEnum;
	}

	/**
	 * @param trabajoEnum the trabajoEnum to set
	 */
	public void setTrabajoEnum(TrabajoEnum trabajoEnum) {
		this.trabajoEnum = trabajoEnum;
	}



}
