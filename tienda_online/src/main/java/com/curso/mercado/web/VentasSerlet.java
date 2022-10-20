package com.curso.mercado.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.servicios.ProductosService;
import com.curso.mercado.servicios.VentasService;
import com.curso.mercado.servicios.excepciones.VentasException;

//@WebServlet(urlPatterns = "comprar")
public class VentasSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VentasSerlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//leer parametro que recibe el idProducto
		//comprar 1 unidad
		//pilla el parametro desde la url despues del ?
		String paramId = request.getParameter("idProducto");
		String cantidad = request.getParameter("cantidad");
		int idProducto = 0;
		int int_cantidad = 1;
		if (paramId != null) {
			idProducto =  Integer.parseInt(paramId);
		}
		if (cantidad!=null) {
			int_cantidad=Integer.parseInt(cantidad);
		}
		
		VentasService servicio = new VentasService();
		String mensaje ="";
		try {
			servicio.comprarProducto(idProducto, int_cantidad);
			mensaje="ha comprado una unidad" ;
			//si va bien
			//volver a la lista
		} catch (VentasException e) {
			//creo aributo mensaje que indique que a pasado y volver a lista y que se muestre el arror
			mensaje="No se ha comprado una unidad. "+e.getMessage() ;
		}
		//ProductosService service = new  ProductosService();
		request.setAttribute("mensaje", mensaje);
	//	RequestDispatcher rd = request.getRequestDispatcher("lista-productos.jsp");
		//despaco la peticionde lista producos Sevlet
		//esta se encarga de pone la lista y despaca a la pagjsp lista-productos
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaProductos");
		rd.forward(request, response);
		
		
	}

	
}
