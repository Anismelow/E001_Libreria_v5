package com.ipartek.servicios;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.modelo.Pelicula;
import com.ipartek.repositorio.PeliculaRepositorio;

@Service
public class PeliculaServicioImp implements PeliculaServicio {
	@Autowired
	private PeliculaRepositorio peliculaRepo;

	@Override
	public List<Pelicula> obtenerTodos() {
		try {
			return peliculaRepo.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Pelicula obtenerPorId(Integer id) {
		try {
			return peliculaRepo.findById(id).orElse(new Pelicula());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Pelicula insertar(Pelicula pel) {
		try {
			if (pel.getId() == null) {
				return peliculaRepo.save(pel);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Pelicula modificar(Pelicula pel) {
		try {
			if (peliculaRepo.existsById(pel.getId())) {
				return peliculaRepo.save(pel);
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
			if (peliculaRepo.existsById(id)) {
				peliculaRepo.deleteById(id);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Boolean borrarMultiple(Integer[] ids) {
		try {

			peliculaRepo.deleteAllByIdInBatch(Arrays.asList(ids));

			for (Integer elem : ids) {
				if (peliculaRepo.existsById(elem)) {
					return false;
				}
			}
			return true;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean comprobarSiExiste(Integer id) {
		try {
			return peliculaRepo.existsById(id);
		} catch (Exception e) {
			return null;
		}
	}
}
