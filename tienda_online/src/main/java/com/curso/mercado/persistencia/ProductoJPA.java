package com.curso.mercado.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.mercado.entidades.Producto;

public class ProductoJPA implements GenericDAO<Producto> {
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("OracleHRPU");
	}
	@Override
	public void add(Producto entidad) {
		
		EntityManager em = factory.createEntityManager();
		Producto pNuevo = new Producto();
		pNuevo.setIdProducto(entidad.getIdProducto());
		pNuevo.setDescripcion(entidad.getDescripcion());
		pNuevo.setPrecio(entidad.getPrecio());
		pNuevo.setStock(5);
		em.getTransaction().begin();
		em.persist(pNuevo);
		
		em.getTransaction().commit();
		
	}

	@Override
	public List<Producto> getAll() {
		Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		Query query = em.createQuery("SELECT p FROM Producto p");
		List<Producto> lista =  query.getResultList();
		
		for (Producto prod : lista) {
			Producto p = new Producto();
			p.setIdProducto(prod.getIdProducto());
			p.setDescripcion(prod.getDescripcion());
			p.setPrecio(prod.getPrecio());
			p.setStock(prod.getStock());
			productos.add(p);
			
		}
		return productos;
		//return lista;
	}

	@Override
	public Producto getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Producto pbor = new Producto();
		pbor.setIdProducto(id);
		Producto Caborrar = em.find(Producto.class, pbor.getIdProducto());
		em.remove(Caborrar);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(Producto entidad) {
		// TODO Auto-generated method stub
	}


	@Override
	public void updateStock(int id) {
		EntityManager em = factory.createEntityManager();
		Producto t = em.find(Producto.class, id);
		int stock = t.getStock();
		t.setStock(stock+1);
		em.getTransaction().begin();
		Producto countyEnBD = em.merge(t);
		em.getTransaction().commit();
	}
	
	
}
