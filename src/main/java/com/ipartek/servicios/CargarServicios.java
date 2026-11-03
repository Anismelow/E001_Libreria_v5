package com.ipartek.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.modelo.Categoria;

import jakarta.annotation.PostConstruct;

@Service
public class CargarServicios {

	@Autowired
	private CategoriaServicio categoriaServ;

	@PostConstruct
	public void cargarinicio() {

		Integer total = categoriaServ.contarRegistros();

		if (total != null && total == 8) {

			categoriaServ.resetearAutoIncrement();

			categoriaServ.insertarConId(new Categoria(1, "Accion"));
			categoriaServ.insertarConId(new Categoria(2, "Aventura"));
			categoriaServ.insertarConId(new Categoria(3, "Comedia"));
			categoriaServ.insertarConId(new Categoria(4, "Drama"));
			categoriaServ.insertarConId(new Categoria(5, "Terror"));
			categoriaServ.insertarConId(new Categoria(6, "Ciencia Ficcion"));
			categoriaServ.insertarConId(new Categoria(7, "Romance"));
			categoriaServ.insertarConId(new Categoria(8, "Fantasia"));
			categoriaServ.insertarConId(new Categoria(9, "Suspense"));
			categoriaServ.insertarConId(new Categoria(10, "Animacion"));
			categoriaServ.insertarConId(new Categoria(11, "Documental"));
			categoriaServ.insertarConId(new Categoria(12, "Musical"));
			categoriaServ.insertarConId(new Categoria(13, "Misterio"));
			categoriaServ.insertarConId(new Categoria(14, "Belico"));
			categoriaServ.insertarConId(new Categoria(15, "Western"));
			categoriaServ.insertarConId(new Categoria(16, "Crimen"));
			categoriaServ.insertarConId(new Categoria(17, "Historico"));
			categoriaServ.insertarConId(new Categoria(18, "Familiar"));
			categoriaServ.insertarConId(new Categoria(19, "Deportivo"));
			categoriaServ.insertarConId(new Categoria(20, "Biografico"));
		}
	}
}