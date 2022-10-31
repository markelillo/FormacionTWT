package com.curso.spring.practica001_1;




public class Programador implements Recurso {
	private String tarea;

	public Programador() {
		super();
		this.tarea ="Programar";
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	@Override
	public void trabajar() {
		System.out.println("se realizo la tarea "+ tarea);
		
	}

}
