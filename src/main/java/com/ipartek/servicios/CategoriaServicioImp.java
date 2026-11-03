package com.ipartek.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.modelo.Categoria;
import com.ipartek.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServicioImp implements CategoriaServicio{
	
	@Autowired
	private CategoriaRepositorio categoriaRepo;

	@Override
	public List<Categoria> obtenerTodos() {
		try {
			return categoriaRepo.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Categoria obtenerPorId(Integer id) {
		try {
			return categoriaRepo.findById(id).orElse(new Categoria());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Categoria insertar(Categoria cat) {
		try {
			if (cat.getId()==null) {
				return categoriaRepo.save(cat);
			}else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Categoria modificar(Categoria cat) {
		try {
			if (categoriaRepo.existsById(cat.getId())) {
				return categoriaRepo.save(cat);
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
			if (categoriaRepo.existsById(id)) {
				categoriaRepo.deleteById(id);
				 return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean comprobarSiExiste(Integer id) {
		try {
			return categoriaRepo.existsById(id);
		} catch (Exception e) {
			return null;
		}
	}

}
