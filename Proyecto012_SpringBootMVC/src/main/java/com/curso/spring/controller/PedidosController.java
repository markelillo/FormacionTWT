package com.curso.spring.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
		Collection<Pedido> lista = pedidoService.getPedidos(null);
		model.addAttribute("listapedidos", lista);
		return "pedidos";
	}
	
	//localost:8080/pedidos/markel
	@GetMapping("/pedidos/{username}")
	public String pedidosCliente(Model model,
		@PathVariable("username") String name) {
		Collection<Pedido> lista = pedidoService.getPedidos(name);
		model.addAttribute("listapedidos", lista);
		return "pedidos";
	}
	
	@GetMapping("/pedido")
	public String verDetallePedido(Model model, @RequestParam("idPedido")Optional<Integer> id) {
		
		Integer idcliente = id.orElse(null);
		if (id.isEmpty()) {
			return "redirect:/pedidos";
		}
		Pedido p = pedidoService.getPedido(idcliente);
		model.addAttribute("pedido", p);
		return "detalle-pedido";
		
	}
}
