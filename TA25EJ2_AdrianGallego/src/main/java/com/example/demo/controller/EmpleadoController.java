package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Empleado;
import com.example.demo.services.EmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoService empSer;
	
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados(){
		return empSer.listarEmpleados();
	}
	
	@GetMapping("/empleados/{id}")
	public Empleado listarEmpleadoById(@PathVariable(name="id") Integer id) {
		return empSer.listarEmpleadoById(id);
	}
	
	@PostMapping("/empleados")
	public Empleado guardarNuevo(@RequestBody Empleado empleado) {
		return empSer.guardarNuevo(empleado);	
	}
	
	@PutMapping("/empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id") Integer id, @RequestBody Empleado empleado) {
		Empleado e1 = empSer.listarEmpleadoById(id);
		Empleado e2 = new Empleado();
		
		e1.setId(empleado.getId());
		e1.setDni(empleado.getDni());
		e1.setNombre(empleado.getNombre());
		e1.setApellidos(empleado.getApellidos());
		e1.setDepartamento(empleado.getDepartamento());
		
		e2 = empSer.actualizarEmpleado(e1);
		
		return e2;
	}
	
	@DeleteMapping("/empleados/{id}")
	public void deleteEmpleados(@PathVariable(name = "id") Integer id) {
		empSer.deleteEmpleado(id);
	}

}
