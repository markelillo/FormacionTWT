package com.curso.jpa.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Trabajo;

public class PruebaTrabajoJPA {
	
	public static void main(String[] args) {
		
		//1. Crear una Factoria de Entiny Manager
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("OracleHRPU");
		
		//2. Obtenemos un Entity Manager 
		//   que conecta con HR DE ORACLE y mapea clases entidad 
		EntityManager em = factory.createEntityManager();
		
		//obtener el trabjo con el ID "AD_VP"
		//no necestia un contexto transaccional solo INSERT, UPDATE. DELETE
		Trabajo t = em.find(Trabajo.class, "AD_VP");
		System.out.println(t);
		
		//crear un nuevo trabajo
		
		Trabajo tNuevo = new Trabajo("BE_OL", "Tareas Suepr dificiles", 330000.0, 53000.0);
		//inicia una nueva transaccional
		em.getTransaction().begin();
		
		em.persist(tNuevo);///insert
		//obtiene la transaccion y lo confirma
		em.getTransaction().commit();
		
		
		//modificacion
		
		em.getTransaction().begin();
		Trabajo tModificado = new Trabajo("BE_OL", "Tareas Super dificiles de verdad", 330000.0, 53000.0);

		
		//MODO 1 modificar desde un find
		
		Trabajo tDesdeBD = em.find(Trabajo.class, tModificado.getId());
		
		tDesdeBD.setTituloTrabajo(tModificado.getTituloTrabajo());
		
		em.getTransaction().commit();
		
		
		
	}

}
