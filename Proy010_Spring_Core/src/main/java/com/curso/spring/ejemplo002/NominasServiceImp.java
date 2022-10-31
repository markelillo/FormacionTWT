package com.curso.spring.ejemplo002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Service (value= "nominas")
public class NominasServiceImp implements NominasService{
	@Autowired//injecta en la variable de referecia irpfService hace  una instancia de IRPFServiceImp
	private IRPFService irpfService;
	//es basicamente instanciar una clase dentro dentro de otra
	
	 public NominasServiceImp() {
		System.out.println("...instanciondo Nominas servic imp");
	}
	
	
	
	//la instacia es para usar este metodo
	@Override
	public void CalcularNomina() {
		System.out.printf("tu nomina es  %f con un"
				+ "IRPF %5.3f %n", 
				9988.0,
		         irpfService.calcularIRPF());		
	}

}
