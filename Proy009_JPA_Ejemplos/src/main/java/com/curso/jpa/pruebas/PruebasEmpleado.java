package com.curso.jpa.pruebas;



import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.curso.jpa.entidades.Empleado;

public class PruebasEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1-crear la factoria de entity manager
		//2-crear un entity manage
		//3-crear una transaccion 
		//4-crea un empleado nuevo
		//5-persisitrlo
		//6-confirma ransaccion  hacer un rollback si hay fallo
		
		
		
		
		
		/////////////////////////////////////////////////////////////////////////
		//1
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		
		/////////////////////////////////////////////////////////////////////////
		//2
		
		EntityManager em = factory.createEntityManager();
		
		/////////////////////////////////////////////////////////////////////////
		//3
		try {
			em.getTransaction().begin();
			
			
			//4
			Empleado empleadoMod = new Empleado();
			empleadoMod.setNombre("Markel");
			empleadoMod.setApellidos("Etxebarria");
			empleadoMod.setEmail("a@a.com");
			empleadoMod.setTelefono("484654684664");
			empleadoMod.setFechaContratacion(new java.util.Date());
			empleadoMod.setIdDepartamento(10);
			empleadoMod.setIdTrabajo("ST_MAN");
			em.persist(empleadoMod);
			System.out.println("se creo el empleado");
			
			//5
			em.getTransaction().commit();
			
		} catch (Exception e) {
			
			//6
			em.getTransaction().rollback();
		}
		
		

	}

}
