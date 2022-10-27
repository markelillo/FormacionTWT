package com.curso.jpa.pruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.jpa.entidades.Departamento;
import com.curso.jpa.entidades.Empleado;

public class PruebasConsulasJPA {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();

		Departamento d = em.find(Departamento.class, 10);
		System.out.println("el departamento ens: " + d);

		// query nativa => select * from departments;
		// JPA Query => SELECT FROM Departamento d;

		// MODO 1
		// Query consulta = em.createQuery("SELECT alias FROM Departamento alias");
		Query consulta = em.createQuery("SELECT d FROM Departamento d WHERE d.managerId IS NULL");
		System.out.println("Lista de todos los departamentos que id maner es null modo 1");
		List<Departamento> lista = consulta.getResultList();
		for (Departamento d2 : lista) {
			System.out.println(d2);
		}

		// Modo2 Named query

		Query consulta2 = em.createNamedQuery("Deparamento.findAll");
		List<Departamento> lista2 = consulta2.getResultList();
		System.out.println("Lista de todos los departamentos modo 2");
		for (Departamento d2 : lista2) {
			System.out.println(d2);

		}

		// modo3 query nativa

		Query coslta3 = em.createNativeQuery("select * from DEPARTMENTS", Departamento.class);
		List<Departamento> lista3 = consulta2.getResultList();
		System.out.println("Lista de todos los departamentos modo 3");
		for (Departamento d3 : lista3) {
			System.out.println(d3);

		}

		// ejecutar una consula con parametros

		Query qConParams = em.createNamedQuery("Depatamneto.findByManager");
		qConParams.setParameter("IdDeManager", 108);// tambien ppuede ser en vez de "" en numero del parametro

		List<Departamento> departamentos108 = qConParams.getResultList();
		System.out.println("la lista de deparamenos con manaer 108 son:");
		for (Departamento d108 : departamentos108) {
			System.out.println(d108);
		}

		/*
		 * select E.* from
		 * departments d inner join employees e on d.manager_id = e.employee_id
		 * where d.location_id=1700;
		 */
		String consultaEmpleadoDpto1700= "SELECT e FROM Empleado e WHERE e.departamento.idLocalidad = :idLoc";
		
		int idLocalidad =1700;
		
		Query q = em.createQuery(consultaEmpleadoDpto1700);
		q.setParameter("idLoc", idLocalidad);
		List<Empleado> listEmp = q.getResultList();
		System.out.println("lsita de epleados depart localidad 1700");
		for (Empleado e : listEmp) {
			System.out.println(e);
		}
	}
}
