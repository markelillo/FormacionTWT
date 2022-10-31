package com.curso.spring.practica001_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ConfigurarBeansApp {
	@Bean
	public JefeEquipo jefe1() {
		return new JefeEquipo();

	}
	
	@Bean
	public Programador programador1() {
		Programador prog1 = new Programador();
		prog1.setTarea("Programando en PLSQL");
		return prog1;
	}
	
	@Bean
	public Programador programadorJava() {
		Programador prog1 = new Programador();
		prog1.setTarea("Programando en Java");
		return prog1;
	}

}
