package com.curso.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario")
public class HomeController {
	
	
	@GetMapping("/")
	public String inicio(Model model) {//model es como la request.ad atribute  es el sitio dinde guardas los datos
		//model.addAttribute("nombre", "Luis");
		//con el model accedesal session atribute
		
		if (model.getAttribute("usuario")==null) {
			return "redirect:/login";//para que ademas d eir pueda acedra su controllery o derectaente a su jsp sin pasar por el
		}
		return "home";
	}
	
}
