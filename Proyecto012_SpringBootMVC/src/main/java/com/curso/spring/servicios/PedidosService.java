package com.curso.spring.servicios;

import java.util.Collection;
import java.util.Optional;

import com.curso.spring.entidades.Pedido;

public interface PedidosService {
	
	void generarPedido(Pedido p);
	Collection<Pedido> getPedidos(String user);
	Collection<Pedido> getAll();
	Pedido getPedido(Integer id); 
	
	Pedido añadirPedido(Pedido p);
	Pedido modificar(Pedido p);
	Pedido eliminar(Integer id);
	

}
