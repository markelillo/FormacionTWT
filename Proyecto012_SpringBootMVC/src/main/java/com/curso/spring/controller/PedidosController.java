package com.curso.spring.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/alta-pedido")
	public String AltaPedido(Model model) {
		model.addAttribute("altaForm", new Pedido() );//creo el model para tenga un objeto peido donde lueo se le mee la informacion 
		return "alta-pedido";
	}
	
	@PostMapping("/alta-pedido")
	public String AltaPedido(Model model, @Valid @ModelAttribute("altaForm")Pedido ped, BindingResult binding) {
		if (binding.hasErrors()) {
			return "alta-pedido";
		}
		
		Usuario u = (Usuario) model.getAttribute("usuario");//usuario dela session del @SessionAttributes("usuario")
		ped.setUser(u.getNombre());
		ped.setFechaPedido(new Date());//solo con jpa
		//model.addAttribute("pedido", pedidoService.añadirPedido(ped));no con jpa
		model.addAttribute("pedido", pedidoService.añadirPedido(ped));
		return "detalle-pedido";
	}
	
	
	
	
	
}
