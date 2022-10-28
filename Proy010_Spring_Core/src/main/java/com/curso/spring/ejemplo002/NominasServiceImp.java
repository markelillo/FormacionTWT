package com.curso.spring.ejemplo002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NominasServiceImp implements NominasService{
	@Autowired//injecta en la variable de referecia irpfService  ina instancia de IRPFServiceImp
	private IRPFService irpfService;
	
	
	 public NominasServiceImp() {
		System.out.println("...instanciondo Nominas servic imp");
	}
	
	
	
	
	@Override
	public void CalcularNomina() {
		System.out.printf("tu nomina es  %f con un"
				+ "IRPF %5.3f %n", 
				9988.0,
		         irpfService.calcularIRPF());		
	}

}
