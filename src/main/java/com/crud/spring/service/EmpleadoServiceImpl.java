package com.crud.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.crud.spring.dao.IEmpleadoDAO;
import com.crud.spring.dto.Empleado;

public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	IEmpleadoDAO iEmpleadoDAO;
	@Override
	public List<Empleado> listarEmpleados() {
		// Devuelve una lista de Empleados.
		return iEmpleadoDAO.findAll();
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		// Crear un empleado del tipo Empleado.
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public Empleado buscarEmpleadoId(long id) {
		// Devuelve un empleado buscando por ID.
		return iEmpleadoDAO.findById(id).get();
	}

	@Override
	public List<Empleado> listarEmpleadoNombre(String nombre) {
		// Lista/Buscar empleado por nombre.
		return iEmpleadoDAO.findByNombre(nombre);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		// Actualiza un empleado.
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public void eliminarEmpleado(long id) {
		// Eliminar empleado buscando por ID.
		iEmpleadoDAO.deleteById(id);
	}

}
