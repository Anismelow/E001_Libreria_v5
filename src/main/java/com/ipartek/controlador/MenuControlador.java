package com.ipartek.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.modelo.Libro;
import com.ipartek.modelo.Pelicula;
import com.ipartek.servicios.AutorServicio;
import com.ipartek.servicios.CategoriaServicio;
import com.ipartek.servicios.LibroServicio;
import com.ipartek.servicios.PeliculaServicio;

@Controller
public class MenuControlador {
	
	@Autowired
	private LibroServicio libroServ;
	
	@Autowired
	private AutorServicio autorServ;
	
	@Autowired
	private PeliculaServicio peliculaServ;
	
	@Autowired
	private CategoriaServicio categoriaServ;
	
	@GetMapping("/menuLibros")
	public String menuLibros(Model model) {
		model.addAttribute("listaLibros",libroServ.obtenerTodos());
		model.addAttribute("listaAutores",autorServ.obtenerTodos());
		
		model.addAttribute("objLibro", new Libro());
		
		return "home";
	}
	
	@GetMapping("/menuPeliculas")
	public String menuPeliculas(Model model ) {
		model.addAttribute("listaPeliculas", peliculaServ.obtenerTodos());
		model.addAttribute("listaCategorias", categoriaServ.obtenerTodos());
		
		model.addAttribute("objPelicula", new Pelicula());
		
		return "peliculas";
	}

}
