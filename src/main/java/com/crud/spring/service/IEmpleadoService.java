package com.crud.spring.service;

import java.util.List;

import com.crud.spring.dto.Empleado;

public interface IEmpleadoService {
	// Metodos CRUD
	public List <Empleado> listarEmpleados(); // Listar todo	
	public Empleado guardarEmpleado(Empleado empleado); // Create
	public Empleado buscarEmpleadoId(Long id); // Read
	public List<Empleado> listarEmpleadoNombre(String nombre); // listar empleados por nombre
	public Empleado buscarEmpleadoTrabajo(String trabajo);
	public Empleado actualizarEmpleado(Empleado empleado); // update
	public void eliminarEmpleado(Long id); // delete
	
}
