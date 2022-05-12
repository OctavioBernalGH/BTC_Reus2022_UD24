package com.crud.spring.service;

import java.util.List;

import com.crud.spring.dto.Empleado;

public interface IEmpleadoService {
	// Metodos CRUD
	public List <Empleado> listarEmpleados(); // Listar todo	
	public Empleado guardarEmpleado(Empleado empleado); // Create
	public Empleado buscarEmpleadoId(long id); // Read
	public List<Empleado> listarEmpleadoNombre(String nombre); // listar empleados por nombre
	public Empleado actualizarEmpleado(Empleado empleado); // update
	public void eliminarEmpleado(long id); // delete
	
}
