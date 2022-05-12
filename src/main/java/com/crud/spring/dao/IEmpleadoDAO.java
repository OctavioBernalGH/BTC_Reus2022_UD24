package com.crud.spring.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.spring.dto.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long>{
	
	// Lista los empleados por nombre
	public List<Empleado> findByNombre(String nombre);

}
