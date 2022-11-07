package com.curso.spring.servicios;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.repositorio.PedidoJPARepository;
import com.curso.spring.repositorio.PedidoRepository;

@Service
//@Scope(value = "singleton")//por defecto
//@Lazy//los instacia bajo demanda y solo para los singleton
@Transactional(propagation = Propagation.REQUIRED)
public class PedidosServiceImp implements PedidosService {
	private static Logger log = LoggerFactory.getLogger(PedidosServiceImp.class);
//no se va asar con jpa
	@Autowired // te injecta esa clase inserta la clase creada en memoria ram tiene qe coincidir con el qualifier de repo y 
				//solo si hay dos clases que extiendan de la misma interfad sinono hace alta
	@Qualifier("pedidorepo")
	private PedidoRepository repo;
	
	@Autowired
	 private PedidoJPARepository repoJPA;//no ace fala crea la clase con el interface te la crea el automaticamente

	public PedidosServiceImp() {
		log.info("..instaciando PedidoServiceImp" + repo);
	}

	@PostConstruct
	public void init() {
		log.info("poscounstrunct" + repo);
	}

	@Override
	public void generarPedido(Pedido p) {//hasta ws depsues añadir
		log.info("gestiono un pedido");
		//repo.add(p); no con jpa
		repoJPA.saveAndFlush(p);
		

	}
	
	/* antes de ws
	 * 
	 * @Override
	public void generarPedido(Pedido p) {
		log.info("gestiono un pedido");
		//repo.add(p); no con jpa
		repoJPA.saveAndFlush(p);
		

	}*/

	@Override
	@Transactional(readOnly = true)
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
	public Pedido añadirPedido(Pedido p) {
		//return repoJPA.saveAndFlush(p);//hasta ws
		//return repo.addPedido(p);no con jpa
		
		log.info("gestionando pedido");
		//el save tambien añade lo que tnegas en el body
		return repoJPA.save(p);
		
	}

	
	@Override
	public Pedido getPedido(Integer id) {//solo sin Jpa
		// TODO Auto-generated method stub
		//return repo.getById(id); no con jpA
		Optional<Pedido> p = repoJPA.findById(id);
		return p.get();
	}

	@Override
	public Pedido modificar(Pedido p) {
		repoJPA.save(p);
		return null;
	}

	

	@Override
	public Pedido eliminar(Integer id) {
		repoJPA.deleteById(id);
		return null;
	}

	
	
}
