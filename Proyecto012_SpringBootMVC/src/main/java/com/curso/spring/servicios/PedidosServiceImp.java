package com.curso.spring.servicios;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.repositorio.PedidoRepository;



@Service
//@Scope(value = "singleton")//por defecto
//@Lazy//los instacia bajo demanda y solo para los singleton
public class PedidosServiceImp implements PedidosService {
	private static Logger log = LoggerFactory.getLogger(PedidosServiceImp.class);
	
	@Autowired// te injecta esa clase inserta la clase creada en memoria ram
	@Qualifier("pedidorepo")
	private PedidoRepository repo;
	
	public PedidosServiceImp() {
		log.info("..instaciando PedidoServiceImp"+repo);
	}
	
	@PostConstruct
	public void init() {
		log.info("poscounstrunct"+ repo);
	}

	@Override
	public void generarPedido(Pedido p) {
		log.info("gestiono un pedido");
		repo.add(p);
		
	}

	@Override
	public Collection<Pedido> getPedidos(String user) {
		// TODO Auto-generated method stub
		return repo.getPedidoByUser(user);
	}
	
	
	

	

}
