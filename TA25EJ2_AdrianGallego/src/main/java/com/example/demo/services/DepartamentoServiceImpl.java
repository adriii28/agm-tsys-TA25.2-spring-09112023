package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDepartamentoDAO;
import com.example.demo.dto.Departamento;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService{

	@Autowired
	IDepartamentoDAO dao;
	
	@Override
	public List<Departamento> listarDepartamentos() {
		return dao.findAll();
	}

	@Override
	public Departamento listarDepartamentoById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Departamento guardarNuevo(Departamento departamento) {
		return dao.save(departamento);
	}

	@Override
	public Departamento actualizarDpto(Departamento departamento) {
		return dao.save(departamento);
	}

	@Override
	public void deleteDpto(Integer id) {
		dao.deleteById(id);
	}

}
