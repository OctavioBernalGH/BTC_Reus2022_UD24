package com.crud.spring.controller;

import java.util.List;
/** Se importa el sistema de anotaciones */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Se importan las clases EmpleadoServiceImpl y Empleado */
import com.crud.spring.service.EmpleadoServiceImpl;
import com.crud.spring.dto.Empleado;

@RestController
@RequestMapping("/api")

public class EmpleadoController {

	/** Se crea una instancia de EmpleadoServiceImpl */
	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;

	/**
	 * Se crea un mapeo de funcionalidad, al introducir
	 * "localhost:puerto/api/empleados" devolverá una lista con todos los empleados.
	 * 
	 * @return
	 */

	@GetMapping("/empleado")
	public List<Empleado> listarEmpleados() {
		return empleadoServiceImpl.listarEmpleados();
	}

	/**
	 * Se crea un mapeo de funcionalidad, al introducir
	 * "localhost:puerto/api/nombre/{un nombre}" devolverá una lista de Empleados
	 * que tengan el nombre que se ha introducido.
	 * 
	 * @param nombre
	 * @return
	 */
	@GetMapping("/empleado/nombre/{nombre}")
	public List<Empleado> listarEmpleadoNombre(@PathVariable(name = "nombre") String nombre) {
		return empleadoServiceImpl.listarEmpleadoNombre(nombre);
	}

	/**
	 * Se crea un empleado mediante el método post Al introducir @RequestBody se
	 * define la introducción de datos en el body.
	 * 
	 * @param empleado
	 * @return
	 */
	@PostMapping("/empleado")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		return empleadoServiceImpl.guardarEmpleado(empleado);
	}

	/**
	 * Mediante la anotación @GetMapping se busca un empleado por ID. La búsqueda se
	 * realiza mediante el parámetro de entrada ID introducido en la ruta de la api.
	 * "/empleado/{id a buscar}".
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/empleado/{id}")
	public Empleado buscarEmpleadoId(@PathVariable(name = "id") Long id) {
		return empleadoServiceImpl.buscarEmpleadoId(id);
	}

	/**
	 * Mediante la anotación @Put actualizamos los datos de un empleado mediante la
	 * ID. Para ello se introduce la ID en la ruta "/empleado/{id a actualizar}" y
	 * en el body mediante la anotación @RequestBody se actualizarán los demás
	 * campos. Una vez estén completos se ejecuta la función de actualizado de la
	 * clase EmpleadoServiceImpl.
	 * 
	 * @param id
	 * @param empleado
	 * @return
	 */
	@PutMapping("/empleado/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name = "id") Long id, @RequestBody Empleado empleado) {

		Empleado empleado_a_actualizar = new Empleado();
		Empleado empleado_actualizado = new Empleado();

		/**
		 * Se busca el empleado a modificar mediante la función de buscar empleado por
		 * id. De esta forma ya se tiene el empleado y solo faltará rellenar los demás
		 * campos.
		 */
		empleado_a_actualizar = empleadoServiceImpl.buscarEmpleadoId(id);

		/**
		 * Se obtienen los párametros del empleado mediante el get y se les asigna los
		 * nuevos valores mediante el set.
		 */
		empleado_a_actualizar.setNombre(empleado.getNombre());
		empleado_a_actualizar.setTrabajo(empleado.getTrabajo());
		empleado_a_actualizar.setSalario(empleado.getSalario());
		empleado_a_actualizar.setDni(empleado.getDni());

		/**
		 * El empleado será actualizado cuando se ejecute la función de
		 * actualizarEmpleado y reciba como parámetro los nuevos datos del empleado.
		 */
		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_a_actualizar);

		/**
		 * Por último se devuelve un empleado con los nuevos datos.
		 */
		return empleado_actualizado;

	}

	/**
	 * Mediante la anotación @DeleteMapping se eliminará un empleado filtrando por
	 * ID. Al tener @PathVariable en los parámetros de entrada se indica que la ID
	 * se proporcionará por URL. "/empleado/{id a eliminar}"
	 * 
	 * @param id
	 */
	@DeleteMapping("/empleado/{id}")
	public void eliminarEmpleado(@PathVariable(name = "id") Long id) {
		empleadoServiceImpl.eliminarEmpleado(id);
	}

	/**
	 * Mediante la anotación @GetMapping podemos buscar un empleado mediante el
	 * trabajo que tiene, para ello se escribirá la dirección
	 * /localhost:port/api/empleado/trabajo/{trabajo a filtrar} en Postman y nos
	 * devolverá el resultado filtrando por trabajo.
	 * 
	 * @param trabajo
	 * @return
	 */
	@GetMapping("/empleado/trabajo/{trabajo}")
	public Empleado buscarEmpleadoTrabajo(@PathVariable(name = "trabajo") String trabajo) {
		return empleadoServiceImpl.buscarEmpleadoTrabajo(trabajo);
	}
}
