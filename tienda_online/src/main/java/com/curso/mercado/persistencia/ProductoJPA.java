package com.curso.mercado.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.mercado.entidades.Producto;

public class ProductoJPA implements GenericDAO<Producto> {

	@Override
	public void add(Producto entidad) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
		Producto pNuevo = new Producto();
		pNuevo.setIdProducto(entidad.getIdProducto());
		pNuevo.setDescripcion(entidad.getDescripcion());
		pNuevo.setPrecio(entidad.getPrecio());
		em.getTransaction().begin();
		em.persist(pNuevo);
		
		em.getTransaction().commit();
		
	}

	@Override
	public List<Producto> getAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		Query query = em.createQuery("select p from Producto p");
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
	}

	@Override
	public Producto getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

}
