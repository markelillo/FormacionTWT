package com.curso.jpa.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Customer;
import com.curso.jpa.entidades.Order;
import com.curso.jpa.entidades.Record;

public class PruebaOnetoMany {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
//		
//		Order pedido = new Order();
//		Customer cr7 =new Customer();
//		cr7.setId(2);
//		pedido.setCustomer(cr7);
//		
//		pedido.setDescripcion("Pedido suuuuper importante");
//		
//		
//		em.getTransaction().begin();
//		em.persist(pedido);
//		em.getTransaction().commit();
		
		//busca pedido 13 y tae ademas el cliente
		
		Order o = em.find(Order.class, 210L);//ind busca la PK de la clase que le pasas
		System.out.printf("el pedido %s ha "
				+ "sido realizado por %s %n",
				o.getDescripcion(),o.getCustomer().getCustomerName());
		//la Selecto con el mismo dato solo lo hace una ver aunque se lo pidas dos veces pero al final te lo imprime dos veces
//		System.out.println("/////////////////////////////////////////////");
//		
//		Order o = em.find(Order.class, 210L);//ind busca la PK de la clase que le pasas
//		System.out.printf("el pedido %s ha "
//				+ "sido realizado por %s",
//				o.getDescripcion(),o.getCustomer().getCustomerName());

		Customer markel = em.find(Customer.class, 2);
		System.out.println("el cliente "+ markel.getCustomerName());
		System.out.println("pedidos");
		for (Order p : markel.getPedidos()) {
			System.out.println(p.getDescripcion());
		}
		
	}

}
