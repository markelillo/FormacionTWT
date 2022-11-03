package com.curso.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Usuario;

@Controller
@SessionAttributes("usuario")
public class LoginController {

//	@Autowired
//	private LoginService loginService;

	// fomrulario en el que pido usuario y clave
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("usuarioForm", new Usuario());

		return "login";
	}

	@PostMapping("/login")
	public String irAHome(Model model, @ModelAttribute("usuarioForm") @Valid Usuario usr, BindingResult bindinResult) {
		//ver si pasa la validacion
		if (bindinResult.hasErrors()) {
			return "login";
		}
		
		boolean valido = true;
		if (usr.getNombre().trim().equalsIgnoreCase("luis")) {// trim eliminar espacios y equaliarecase compara sin
																// tener en cuenta mayus o minus
			usr.setRol("cliente");
		} else {
			usr.setRol("admin");
		}

		if (valido)
			model.addAttribute("usuario", usr);// metemos usuarios en la sesion

		return "home";
	}
	// recojo los datos del formulario
}
