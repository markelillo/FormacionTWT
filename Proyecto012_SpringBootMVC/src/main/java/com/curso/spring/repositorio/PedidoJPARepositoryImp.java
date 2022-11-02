package com.curso.spring.repositorio;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Pedido;

@Repository
@Qualifier("pedidorepojpa")
public class PedidoJPARepositoryImp implements PedidoRepository {
	private static Logger log = LoggerFactory.getLogger(PedidoJPARepositoryImp.class);
	@Override
	public void add(Pedido pedido) {
		log.info("grabar pedido con JPA");

	}
	@Override
	public Collection<Pedido> getPedidoByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}