package com.curso.spring.repositorio;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Pedido;

@Repository
@Qualifier("pedidorepo")
public class PedidoRepositoryImp implements PedidoRepository {

	private static Logger log = LoggerFactory.getLogger(PedidoRepositoryImp.class);
	private static Map<Integer, Pedido> pedidos = new HashMap<Integer, Pedido>();
	private static int id;
	static {
		// añado dos pedidos
		pedidos.put(1, new Pedido(1, "Luis", "Television", new Date(), true));
		pedidos.put(2, new Pedido(2, "Luis", "Radio", new Date(), true));
		pedidos.put(3, new Pedido(3, "pepe", "WalkMan", new Date(), true));
		id = 3;
	}

	@Override
	public void add(Pedido pedido) {
		id++;
		pedido.setId(id);
		pedidos.put(id, pedido);
		log.info("has grabado un pedido en la BBDD");

	}

	@Override
	public Collection<Pedido> getPedidoByUser(String user) {
		Collection<Pedido> lista = new ArrayList();
		for (Pedido p : pedidos.values()) {
			if (p.getUser().equalsIgnoreCase(user)) {
				lista.add(p);
			}
		}
		return lista;
	}

	@Override
	public Collection<Pedido> getAll() {
		// TODO Auto-generated method stub
		return pedidos.values();
	}

	@Override
	public Pedido getById(Integer id) {
		// TODO Auto-generated method stub
		return pedidos.get(id);
	}

	@Override
	public Pedido addPedido(Pedido p) {
		id++;
		p.setId(id);
		p.setEntregado(false);
		p.setFechaPedido(new Date());
		pedidos.put(id, p);
		return p;
	}

}
