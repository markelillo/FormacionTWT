package com.curso.spring.restController;

import java.net.http.HttpRequest;
import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.excepciones.PedidosException;
import com.curso.spring.repositorio.PedidoJPARepositoryImp;
import com.curso.spring.servicios.PedidosService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" } , 
methods = {RequestMethod.GET,
		RequestMethod.POST, 
		RequestMethod.DELETE, 
		RequestMethod.PUT,
		RequestMethod.OPTIONS
})//permitir que puedas acceder desde el servidor 8080 al 4200

public class PedidosRestfullController {
	private static Logger log = LoggerFactory.getLogger(PedidoJPARepositoryImp.class);

	@Autowired
	private PedidosService pedidosService;

	@GetMapping("/ws/pedidos")
	public Collection<Pedido> all() {
		return pedidosService.getPedidos(null);
	}

	@GetMapping("/ws/pedidos/{id}")
	public Pedido pedidoById(@PathVariable Integer id) {
		log.info("el id es" + id);
		return pedidosService.getPedido(id);

	}
//en el body {"id":1,"user":"luis","desc":"pizza","fechaPedido":null,"entregado":false} alo asi
	@PostMapping("/ws/pedidos")
	public Pedido insertar(@RequestBody Pedido newPedido) {
		Pedido pconid = pedidosService.a??adirPedido(newPedido);
		
		return pconid;
	}
	// get by id
	// instert
	// update
	// delete
	//en el body {"id":1,"user":"luis","desc":"pizza","fechaPedido":null,"entregado":false} alo asi
	@PutMapping("/ws/pedidos")
	public Pedido update(@RequestBody Pedido newPedido) {
		Pedido pModif = pedidosService.modificar(newPedido);
		
		return pModif;
	}
	
	@DeleteMapping("/ws/pedidos/delete/{id}")
	public void delete(@PathVariable Integer id) throws PedidosException {
		pedidosService.eliminar(id);
		//return "{ok}";//esto es para que si va bien te lo de vuelva i sino pone a este mensaje
		
		
	}
	
	/*@ExceptionHandler({PedidosException.class, Exception.class})
	public String manejarExcepcion(HttpRequest req, Exception e){
		return "error"+ e.getMessage();
		
	}*/
}
