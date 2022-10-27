package com.curso.jpa.pruebas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
		 * select E.* from departments d inner join employees e on d.manager_id =
		 * e.employee_id where d.location_id=1700;
		 */
		String consultaEmpleadoDpto1700 = "SELECT e FROM Empleado e WHERE e.departamento.idLocalidad = :idLoc";

		int idLocalidad = 1700;

		Query q = em.createQuery(consultaEmpleadoDpto1700);
		q.setParameter("idLoc", idLocalidad);
		List<Empleado> listEmp = q.getResultList();
		System.out.println("lsita de epleados depart localidad 1700");
		for (Empleado e : listEmp) {
			System.out.println(e);
		}
		///////////////////////////////////////////////////////////////////////////////////////
		// CRITERIA
		// PANTALLA Filo de busqueda /lista de resultado de busqueda
		// filtro NOMBRE
		// filtro ID_TRABAJO
		// ...

		String nombre = "Steven";
		Integer idJob = null;
		String lastname = null;
		Double salario = 999.0;

		CriteriaBuilder cd = em.getCriteriaBuilder();
		// entidades que quiero recuperar
		CriteriaQuery<Empleado> cq = cd.createQuery(Empleado.class);
		// From
		Root<Empleado> empleado = cq.from(Empleado.class);

		// objeto Predicate que va montando las condiciones del where
		Predicate miwhere = null;
		List<Predicate> condiciones = new ArrayList<>();

		if (nombre != null) {
			condiciones.add(cd.equal(empleado.get("nombre"), nombre));

		}
		if (lastname != null) {
			condiciones.add(cd.equal(empleado.get("apellidos"), lastname));

		}
		if (salario != null) {
			condiciones.add(cd.greaterThan(empleado.get("salario"), salario));
		}

		// OR JOBID = AD_ASST
		Predicate todosAnd = cd.and(condiciones.toArray(new Predicate[0]));
		Predicate job = cd.equal(empleado.get("idTrabajo"), "AD_ASST");

		Predicate whereFinal = cd.or(todosAnd, job);

		cq.where(whereFinal);

		// Where
		// if (condiciones.size()>0) {
//			Predicate[]condicionesFinal = new Predicate[condiciones.size()];
//			condiciones.toArray(condicionesFinal);
//			cq.where(condicionesFinal);
		// cq.where(condiciones.toArray(new Predicate[0]));//solamnete necesa de que
		// tipo va a ser el array qui le dices que es un aray de Predicates
		// }
		// EJECUAR CONSULTA
		Query qCriteria = em.createQuery(cq);
		List<Empleado> listaEmpleados = qCriteria.getResultList();

		System.out.println("...LOS EMPLEADOS CRADOSCON UN QUERY DINAMICA");

		for (Empleado emp : listaEmpleados) {
			System.out.printf("%s %s %n", emp.getNombre(), emp.getApellidos());

		}

	}
}
