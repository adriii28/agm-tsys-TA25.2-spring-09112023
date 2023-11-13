package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Empleado;

public interface IEmpleadoService {

	public List<Empleado> listarEmpleados();
	
	public Empleado listarEmpleadoById(Integer id);
	
	public Empleado guardarNuevo(Empleado e);
	
	public Empleado actualizarEmpleado(Empleado e);

	public void deleteEmpleado(Integer id);
}
