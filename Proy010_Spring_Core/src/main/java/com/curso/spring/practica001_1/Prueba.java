package com.curso.spring.practica001_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Prueba {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurarBeansApp.class);
		Gestor servicio = (Gestor) context.getBean("jefe1");
		servicio.gestionar();
	}

}
