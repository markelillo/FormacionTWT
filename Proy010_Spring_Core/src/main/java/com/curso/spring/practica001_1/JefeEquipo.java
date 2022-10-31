package com.curso.spring.practica001_1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;




public class JefeEquipo implements Gestor {
	private int equipo;
	//@Autowired
	@Resource(name="programadorJava")
	private Recurso recurso;

	public JefeEquipo() {
		super();
		System.out.println("...construendo jefeEquipo");
		this.equipo = 1;
		System.out.println("recurso es "+ recurso);
	}

	public JefeEquipo(int equipo, Recurso recurso) {
		super();
		this.equipo = equipo;
		this.recurso = recurso;
	}

	@PostConstruct
	public void inicio() {
	System.out.println("...postConstrunc"+ recurso);
	}
	
	@PreDestroy
	private void destruir() {
		// TODO Auto-generated method stub

	}
	

	@Override
	public void gestionar() {
		System.out.println("GESTIONO EL EQUIPO " + equipo);
		System.out.println("Iniciar recursos");
		// al llamar a recurso.trabajar lo que hacemos es llamar al.trabajar de
		// Programador ya que implementa la interface
		recurso.trabajar();

	}

}
