package com.curso.spring.ejemplo001;

import java.util.logging.Logger;
public class SaludoServiceImp implements SaludoService {
	Logger logger = Logger.getLogger("SaludoServiceImp");
	private String cabeceraMensaje;
	
	public SaludoServiceImp(){
		logger.info("...instaciamos el servicio");
		this.cabeceraMensaje = "hola";
	}
	public SaludoServiceImp(String mensaje) {
		logger.info("............ Instanciando servicio");
		this.cabeceraMensaje = mensaje;
	}

	@Override
	public void saludar(String men) {
		if (men == null) {
			logger.severe("error con sobrepeso");
			throw new IllegalArgumentException("el mensaje viene null");
		}
		logger.fine("saludadon");
		logger.info(this.cabeceraMensaje+  men+"!!!!!!!!!!!!!!!!");

	}

}
