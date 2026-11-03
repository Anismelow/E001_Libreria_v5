package com.ipartek.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipartek.modelo.Pelicula;
import com.ipartek.servicios.PeliculaServicio;

@Controller
public class PeliculaControlador {

	@Autowired
	private PeliculaServicio peliculaServ;

	@GetMapping("/borrarPelicula")
	public String borrarPelicula(RedirectAttributes redirect, @RequestParam Integer id) {

		try {
			if (peliculaServ.borrar(id)) {
				redirect.addFlashAttribute("f_mensaje", "Borrado correctamente");
			} else {
				redirect.addFlashAttribute("f_mensaje", "No se pudo borrar");
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("f_mensaje", "Error");
		}

		return "redirect:/menuPeliculas";
	}

	@PostMapping("/borrarMultiple")
	public String borrarMultiple(RedirectAttributes redirect, @RequestParam Integer[] multi) {
		try {
			Boolean resultado = peliculaServ.borrarMultiple(multi);
			if (resultado) {
				redirect.addFlashAttribute("f_mensaje", "Borrados todos correctamente");
			} else if (!resultado) {
				redirect.addFlashAttribute("f_mensaje", "No se pudo borrar alguno o todos");
			} else {
				redirect.addFlashAttribute("f_mensaje", "error");
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("f_mensaje", "Error");
		}

		return "redirect:/menuPeliculas";
	}

	@PostMapping("/insertarPelicula")
	public String insertarPelicula(RedirectAttributes redirect, @ModelAttribute Pelicula objPelicula) {
		try {
			Pelicula resultado = peliculaServ.insertar(objPelicula);

			if (resultado.getId() != null) {
				redirect.addFlashAttribute("f_mensaje", "insertado correctamente");
			} else {
				redirect.addFlashAttribute("f_mensaje", "No se pudo insertar");
			}

		} catch (Exception e) {
			redirect.addFlashAttribute("f_mensaje", "Error");
		}

		return "redirect:/menuPeliculas";
	}

}
