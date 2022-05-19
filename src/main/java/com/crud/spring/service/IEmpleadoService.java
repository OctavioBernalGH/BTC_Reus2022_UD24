package com.crud.spring.service;

import java.util.List;

import com.crud.spring.dto.Empleado;

public interface IEmpleadoService {
	
	/** Listar todos los empleados */
	public List <Empleado> listarEmpleados(); 	
	/** Guardar/Crear un nuevo empleado */
	public Empleado guardarEmpleado(Empleado empleado); 
	/** Buscar empleado por ID */
	public Empleado buscarEmpleadoId(Long id); 
	/** Listar clientes por trabajo */
	public List<Empleado> listarEmpleadoTrabajo(String trabajo);
	/** Listar empleados por nombre */
	public List<Empleado> listarEmpleadoNombre(String nombre);
	/** Eliminar empleados por ID */
	public void eliminarEmpleado(Long id);
	/** Modificar un empleado */
	public Empleado modificarEmpleado(Empleado empleado);
	
}
