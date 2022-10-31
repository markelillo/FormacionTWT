package com.curso.spring.practica001;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "jefe1")
public class JefeEquipo implements Gestor {
	private int equipo;
	@Autowired
//	@Qualifier("progJava")
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
