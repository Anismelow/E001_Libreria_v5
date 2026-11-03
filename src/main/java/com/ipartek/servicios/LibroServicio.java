package com.ipartek.servicios;

import java.util.List;

import com.ipartek.modelo.Libro;

public interface LibroServicio {
	
	public List<Libro> obtenerTodos();
	public List<Libro> obtenerTodosPorAutor(Integer idAutor);
	public Libro obtenerPorId(Integer id);
	public Libro insertar(Libro lib);
	public Libro modificar(Libro lib);
	public Boolean borrar(Integer id);
	public Boolean comprobarSiExiste(Integer id);
	
	
}
