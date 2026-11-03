package com.ipartek.servicios;

import java.util.List;

import com.ipartek.modelo.Categoria;

public interface CategoriaServicio {
	public List<Categoria> obtenerTodos();

	public Categoria obtenerPorId(Integer id);

	public Categoria insertar(Categoria cat);

	public Categoria modificar(Categoria cat);

	public Boolean borrar(Integer id);

	public Boolean comprobarSiExiste(Integer id);

	public void resetearAutoIncrement();

	public void  insertarConId(Categoria cat);

	public Integer contarRegistros();
}
