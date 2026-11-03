package com.ipartek.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.modelo.Libro;
import com.ipartek.repositorio.LibroRepositorio;

@Service
public class LibroServicioImp implements LibroServicio {

	@Autowired
	private LibroRepositorio libroRepo;

	@Override
	public List<Libro> obtenerTodos() {
		try {
			return libroRepo.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Libro> obtenerTodosPorAutor(Integer idAutor) {
		try {
			return libroRepo.findByAutorFKId(idAutor);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Libro obtenerPorId(Integer id) {
		try {
			return libroRepo.findById(id).orElse(new Libro());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Libro insertar(Libro lib) {
		try {
			if (lib.getId() == null) {
				return libroRepo.save(lib);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Libro modificar(Libro lib) {
		try {
			if (libroRepo.existsById(lib.getId())) {
				return libroRepo.save(lib);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean borrar(Integer id) {
		try {
			if (libroRepo.existsById(id)) {
				libroRepo.deleteById(id);
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
			return libroRepo.existsById(id);
		} catch (Exception e) {
			return null;
		}
	}

	

}
