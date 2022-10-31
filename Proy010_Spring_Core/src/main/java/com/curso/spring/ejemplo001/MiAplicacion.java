package com.curso.spring.ejemplo001;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MiAplicacion {

	public static void main(String[] args) {
		// sin Spring sin sinjeccion de la dependecia
		// se pone modo interface por que lo implemena
		// asi servivcio solo accedea saluda aunque tenga mas mas metodos
		// SaludoServiceImp por que el inerface solo tiene saludo
//		SaludoService servicio = new SaludoServiceImp();
//		servicio.saludar("amigo");

		// CON SPING
		// a o vy a crear nunca mas una instancia de la clase saludoserviceimp
		// sino que voy a solicitar al contenedor beans de Spring que me entregue la
		// instancia

		// crea un contenedor de BeansSpring
		// es el que maneja el ciclo de vida de los ojtos
		//los instacia
		ApplicationContext ctx = new ClassPathXmlApplicationContext("mis-beans.xml");
//con el lazy init en el xml lo que haceinstanciarlo al poner el ClassPathXmlApplicationContext
		SaludoService s1 = (SaludoService) ctx.getBean("saludador1");
		s1.saludar("soy saludador1");
		System.out.println(s1);
		// cuando lo hacers la seunda vez lo obtienes al tener singleton
		// con el prototype cres uno nuevo
		SaludoService s2 = (SaludoService) ctx.getBean("saludador1");
		System.out.println(s2);
		
		SaludoService s3 = (SaludoService) ctx.getBean("saludadorAdios");
		s3.saludar(" david");

	}

}
