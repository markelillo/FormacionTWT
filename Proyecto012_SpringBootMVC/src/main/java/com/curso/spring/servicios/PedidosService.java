package com.curso.spring.servicios;

import java.util.Collection;
import java.util.Optional;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.excepciones.PedidosException;

public interface PedidosService {
	
	void generarPedido(Pedido p);
	Collection<Pedido> getPedidos(String user);
	Collection<Pedido> getAll();
	Pedido getPedido(Integer id); 
	
	Pedido añadirPedido(Pedido p);
	Pedido modificar(Pedido p);
	void eliminar(Integer id) throws PedidosException;
	
	

}
