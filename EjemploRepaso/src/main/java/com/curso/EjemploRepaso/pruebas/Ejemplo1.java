package com.curso.EjemploRepaso.pruebas;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.curso.EjemploRepaso.entidades.Countries;
import com.curso.EjemploRepaso.entidades.Trabajo;



public class Ejemplo1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
		//buscar por id
		Countries t = em.find(Countries.class, "BR");
		System.out.println(t);
		
		//insertar uno nuevo
		Countries cNuevo =new Countries("ZP", "andorra", 3);
		em.getTransaction().begin();
		//em.persist(cNuevo);
		
		em.getTransaction().commit();
		
		//modificar
		Countries cModif =new Countries("ES", "España", 1);
		em.getTransaction().begin();
		//Countries countyEnBD = em.merge(cModif);
		em.getTransaction().commit();
		
		//Borrar
		em.getTransaction().begin();
		Countries cbor = new Countries();
		cbor.setCountryId("ZP");
		Countries Caborrar = em.find(Countries.class, cbor.getCountryId());
		//em.remove(Caborrar);
		em.getTransaction().commit();
		
		//JPA QUERY
		
		Query query = em.createQuery("select c from Countries c where c.idRegion=1");
		List<Countries> lista =  query.getResultList();
		
		System.out.println("RESULTADOS");
		for (Countries countries : lista) {
			System.out.println(countries);
			
		}
	}

}
