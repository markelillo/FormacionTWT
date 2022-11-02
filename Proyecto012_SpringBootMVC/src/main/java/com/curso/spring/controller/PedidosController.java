package com.curso.spring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.entidades.Usuario;
import com.curso.spring.servicios.PedidosService;

@Controller
@SessionAttributes("usuario")
public class PedidosController {
	@Autowired
	private PedidosService pedidoService;
	@GetMapping("/pedidos")
	public String pedidos(Model model) {
		//pedir la lista de pedidos que etse en session
		Usuario usr = (Usuario) model.getAttribute("usuario");
		Collection<Pedido> pedidos = pedidoService.getPedidos(usr.getNombre());
		model.addAttribute("listapedidos", pedidos);
		return "pedidos";
	}
}