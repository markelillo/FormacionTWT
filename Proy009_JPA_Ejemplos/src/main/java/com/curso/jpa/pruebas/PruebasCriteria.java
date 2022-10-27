package com.curso.jpa.pruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.curso.jpa.entidades.Departamento;
import com.curso.jpa.entidades.Empleado;

public class PruebasCriteria {

	public static void main(String[] args) {
		// 1 Usando Criteria Builder
		// obtener todas los departamentos
		// por localiadad or manager

		// condicion localidad y manaer es opcional
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Departamento> cq = cb.createQuery(Departamento.class);

		Root<Departamento> empleado = cq.from(Departamento.class);
		
		Query qDepartamentos =  em.createQuery(cq);
		List<Departamento> listaDep = qDepartamentos.getResultList();
		for (Departamento departamento : listaDep) {
			System.out.printf("%s %s %n", departamento.getNombreDeparmento(), departamento.getIdLocalidad());
		}
		
		
	}

}
