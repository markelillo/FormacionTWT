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
import com.curso.spring.repositorio.PedidoJPARepository;
import com.curso.spring.repositorio.PedidoRepository;

@Service
//@Scope(value = "singleton")//por defecto
//@Lazy//los instacia bajo demanda y solo para los singleton
public class PedidosServiceImp implements PedidosService {
	private static Logger log = LoggerFactory.getLogger(PedidosServiceImp.class);
//no se va asar con jpa
	@Autowired // te injecta esa clase inserta la clase creada en memoria ram tiene qe coincidir con el qualifier de repo y 
				//solo si hay dos clases que extiendan de la misma interfad sinono hace alta
	@Qualifier("pedidorepo")
	private PedidoRepository repo;
	
	@Autowired
	 private PedidoJPARepository repoJPA;

	public PedidosServiceImp() {
		log.info("..instaciando PedidoServiceImp" + repo);
	}

	@PostConstruct
	public void init() {
		log.info("poscounstrunct" + repo);
	}

	@Override
	public void generarPedido(Pedido p) {
		log.info("gestiono un pedido");
		//repo.add(p); no con jpa
		repoJPA.saveAndFlush(p);
		

	}

	@Override
	public Collection<Pedido> getPedidos(String user) {
		if (user == null) {
			//return repo.getAll(); no con jpa
			return repoJPA.findAll();
		}else {
			//return repo.getPedidoByUser(user); no con jpa
			Pedido pFiltro = new Pedido();
			pFiltro.setUser(user);
			return repoJPA.findByUser(user);
		}
	}

	@Override
	public Collection<Pedido> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido getPedido(Integer id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public Pedido añadirPedido(Pedido p) {
		return repoJPA.saveAndFlush(p);
		//return repo.addPedido(p);no con jpa
	}

}
