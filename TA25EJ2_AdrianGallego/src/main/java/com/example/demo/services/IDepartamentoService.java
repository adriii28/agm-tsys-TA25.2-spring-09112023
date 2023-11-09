package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Departamento;

public interface IDepartamentoService {
	
	public List<Departamento> listarDepartamentos();
	
	public Departamento listarDepartamentoById(Integer id);
	
	public Departamento guardarNuevo(Departamento departamento);
	
	public Departamento actualizarDpto(Departamento departamento);

	public void deleteDpto(Integer id);

}
