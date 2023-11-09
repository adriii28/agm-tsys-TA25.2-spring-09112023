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

import com.example.demo.dto.Departamento;
import com.example.demo.services.DepartamentoServiceImpl;

@RestController
@RequestMapping("/api")
public class DepartamentoController {
	
	@Autowired
	DepartamentoServiceImpl dptoSer;
	
	@GetMapping("/departamentos")
	public List<Departamento> listarDpto(){
		return dptoSer.listarDepartamentos();
	}
	
	@GetMapping("/departamentos/{id}")
	public Departamento listarDptoById(@PathVariable(name="id") Integer id) {
		return dptoSer.listarDepartamentoById(id);
	}
	
	@PostMapping("/departamentos")
	public Departamento guardarNuevo(@RequestBody Departamento departamento) {
		return dptoSer.guardarNuevo(departamento);
	}
	
	@PutMapping("/departamentos/{id}")
	public Departamento actualizarDpto(@RequestBody Departamento departamento, @PathVariable(name="id") Integer id) {
		Departamento d1 = listarDptoById(id);
		Departamento d2 = new Departamento();
		
		d1.setCodigo(departamento.getCodigo());
		d1.setNombre(departamento.getNombre());
		d1.setPresupuesto(departamento.getPresupuesto());
		
		d2 = dptoSer.actualizarDpto(d1);
		return d2;
		
	}
	
	@DeleteMapping("/departamentos/{id}")
	public void deleteDpto(@PathVariable(name="id") Integer id) {
		dptoSer.deleteDpto(id);
	}

}
