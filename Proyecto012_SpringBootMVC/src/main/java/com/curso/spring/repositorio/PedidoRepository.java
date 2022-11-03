package com.curso.spring.repositorio;

import java.util.Collection;

import com.curso.spring.entidades.Pedido;

public interface PedidoRepository {
	void add(Pedido pedido);
	Collection<Pedido> getPedidoByUser(String user);
	Collection<Pedido> getAll();
	Pedido getById(Integer id);
	Pedido addPedido(Pedido p);
}
