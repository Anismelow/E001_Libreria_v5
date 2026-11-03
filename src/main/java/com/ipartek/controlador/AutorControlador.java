package com.ipartek.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.modelo.Autor;
import com.ipartek.servicios.AutorServicio;

@Controller
public class AutorControlador {

	@Autowired
	private AutorServicio autorServ;

	@GetMapping("/obtenerTodosAutores")
	public String obtenerTodosAutores() {

		List<Autor> lista = autorServ.obtenerTodos();

		for (Autor elem : lista) {
			System.out.println(elem);
		}

		return "";
	}

}
