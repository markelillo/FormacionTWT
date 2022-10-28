package com.curso.spring.ejemplo002;

import org.springframework.stereotype.Service;

@Service
public class IRPFServiceImp implements IRPFService {
	public IRPFServiceImp() {
		System.out.println("...instanciondo ipf servic imp");
	}
	@Override
	public double calcularIRPF() {
		// TODO Auto-generated method stub
		return 10;
	}

}
