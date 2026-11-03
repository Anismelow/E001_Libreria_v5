package com.ipartek.servicios;

import java.util.List;

import com.ipartek.modelo.Pelicula;

public interface PeliculaServicio {
	public List<Pelicula> obtenerTodos();
	public Pelicula obtenerPorId(Integer id);
	public Pelicula insertar(Pelicula pel);
	public Pelicula modificar(Pelicula pel);
	public Boolean borrar(Integer id);
	public Boolean borrarMultiple(Integer[] ids);
	public Boolean comprobarSiExiste(Integer id);
}
