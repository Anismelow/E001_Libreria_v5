package com.ipartek.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipartek.modelo.Libro;
import com.ipartek.servicios.AutorServicio;
import com.ipartek.servicios.LibroServicio;

@Controller
public class LibroControlador {

	@Autowired
	private LibroServicio libroServ;
	
	@Autowired
	private AutorServicio autorServ;

	@PostMapping("/insertarLibro")
	public String insertarLibro(RedirectAttributes redirect, @ModelAttribute Libro objLibro) {
		try {
			Libro resultado = libroServ.insertar(objLibro);
			if (resultado.getId() != null) {
				redirect.addFlashAttribute("f_mensaje", "Libro insertado correctamente");
			} else {
				redirect.addFlashAttribute("f_mensaje", "No se inserto el libro");
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("f_mensaje", "Error");
		}

		return "redirect:/menuLibros";
	}

	@GetMapping("/borrarLibro")
	public String borrarLibro(RedirectAttributes redirect, @RequestParam Integer id) {

		try {
			Boolean resultado = libroServ.borrar(id);

			if (resultado) {
				redirect.addFlashAttribute("f_mensaje", "Libro borrado correctamente");
			} else if (!resultado) {
				redirect.addFlashAttribute("f_mensaje", "Libro no borrado");
			} else {
				redirect.addFlashAttribute("f_mensaje", "Libro no borrado por null");
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("f_mensaje", "Error");
		}

		return "redirect:/menuLibros";
	}
	
	
	@GetMapping("/modificarLibro")
	public String modificarLibro(Model model, RedirectAttributes redirect, @RequestParam Integer id) {
		
		try {
			if(libroServ.comprobarSiExiste(id)) {
			
				model.addAttribute("objLibro", libroServ.obtenerPorId(id));
				model.addAttribute("listaAutores", autorServ.obtenerTodos());
				
				return "frm_modificar_libro";
			}else {
				redirect.addFlashAttribute("f_mensaje", "El libro no existe");
				return "redirect:/menuLibros";
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("f_mensaje", "Error en la BD");
			return "redirect:/menuLibros";
		}
		
	}
	
	
	@PostMapping("/modificarLibro")
	public String modificarLibro(RedirectAttributes redirect,@ModelAttribute Libro objLibro) {	
		try {
			Libro resultado = libroServ.modificar(objLibro);
			if (resultado.getId() != null) {
				redirect.addFlashAttribute("f_mensaje", "El libro se modifico");
			} else {
				redirect.addFlashAttribute("f_mensaje", "El libro no se pudo modificar");
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("f_mensaje", "Error");
		}
		
		return "redirect:/menuLibros";
	}

}
