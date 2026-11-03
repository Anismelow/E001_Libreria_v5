package com.ipartek.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InicioControlador {
	
	@GetMapping("/")
	public String inicio() {
		return "redirect:/menuLibros";
	}
	

}
