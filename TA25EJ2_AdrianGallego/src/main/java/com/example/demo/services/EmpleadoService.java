package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.dto.Empleado;

@Service
public class EmpleadoService implements IEmpleadoService{

	@Autowired
	IEmpleadoDAO dao;
	
	@Override
	public List<Empleado> listarEmpleados() {
		return dao.findAll();
	}

	@Override
	public Empleado listarEmpleadoById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Empleado guardarNuevo(Empleado e) {
		return dao.save(e);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado e) {
		return dao.save(e);
	}

	@Override
	public void deleteEmpleado(Integer id) {
		dao.deleteById(id);
	}

}
