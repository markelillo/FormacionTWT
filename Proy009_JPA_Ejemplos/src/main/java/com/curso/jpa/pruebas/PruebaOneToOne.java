package com.curso.jpa.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Customer;
import com.curso.jpa.entidades.Record;


public class PruebaOneToOne {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		///////////////////////////////////////////////////////////////
		//crear un record
		Record rec = new Record(null, "REC_UNO");	
		em.persist(rec);
		
		Customer cus = new Customer(null, "Markel", rec);
		em.persist(cus);
		int id = cus.getId();
		Customer t = em.find(Customer.class, id);
		System.out.println(t +"RECORD:"+ t.getRecord());
		
		//////////////////////////////////////////////////////////////
		//crear un cliete que tena ese record
		//buscar el cliente que acabamos de crear
		//mostra sus datos y los de su  record
		
		
		em.getTransaction().commit();

	}

}
