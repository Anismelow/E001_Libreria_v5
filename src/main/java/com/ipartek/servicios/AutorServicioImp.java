package com.ipartek.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.modelo.Autor;
import com.ipartek.repositorio.AutorRepositorio;

@Service
public class AutorServicioImp implements AutorServicio {

	@Autowired
	private AutorRepositorio autorRepo;

	@Override
	public List<Autor> obtenerTodos() {
		try {
			return autorRepo.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Autor obtenerPorId(Integer id) {
		try {
			return autorRepo.findById(id).orElse(new Autor());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Autor insertar(Autor aut) {
		
		try {
			if (aut.getId()==null) {
				return autorRepo.save(aut);
			}else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public Autor modificar(Autor aut) {
		try {
			if (autorRepo.existsById(aut.getId())) {
				return autorRepo.save(aut);
			}else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean borrar(Integer id) {
		try {
			if (autorRepo.existsById(id)) {
				 autorRepo.deleteById(id);
				 return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return null;
		}
	}

}
