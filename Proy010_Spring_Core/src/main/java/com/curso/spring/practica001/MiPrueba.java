package com.curso.spring.practica001;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MiPrueba {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("gestion.xml");
		Gestor servicio = (Gestor) ctx.getBean("jefe1");
		servicio.gestionar();

	}

}
