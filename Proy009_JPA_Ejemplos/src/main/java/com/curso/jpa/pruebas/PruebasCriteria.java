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

public class PruebasCriteria {

	public static void main(String[] args) {
		// 1 Usando Criteria Builder
		// obtener todas los departamentos
		// por localiadad or manager

		// condicion localidad y manaer es opcional
		//si no me pasal localidad ni manager devuelvo odos
		//si silo me pasa localidad devuelvo los que son de esa localidad
		//si solo me pasas los de manager devulvo los que son de ese manager
		
		
		
		
		
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
		Integer localidad = 2700;
		Integer manager = 114;
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Departamento> cq = cb.createQuery(Departamento.class);

		Root<Departamento> departamento = cq.from(Departamento.class);
		
		//predicado para cada variable
		List<Predicate> condiciones = new ArrayList<>();
		if (localidad !=null) {
			condiciones.add(cb.equal(departamento.get("idLocalidad"), localidad));
		}
		
		if (manager !=null) {
			condiciones.add(cb.equal(departamento.get("idLocalidad"), localidad));
		}
		
		
		//ejecua la consulta
		Query qDepartamentos =  em.createQuery(cq);
		List<Departamento> listaDep = qDepartamentos.getResultList();
		for (Departamento departamento1 : listaDep) {
			System.out.printf("%s %s %n", departamento1.getNombreDeparmento(), departamento1.getIdLocalidad());
		}
		
		
	}

}
