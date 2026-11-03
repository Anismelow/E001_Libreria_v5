package com.ipartek.servicios;

import java.util.List;

import com.ipartek.modelo.Autor;


public interface AutorServicio {	
	public List<Autor> obtenerTodos();
	public Autor obtenerPorId(Integer id);
	public Autor insertar(Autor aut);
	public Autor modificar(Autor aut);
	public Boolean borrar(Integer id);
}
