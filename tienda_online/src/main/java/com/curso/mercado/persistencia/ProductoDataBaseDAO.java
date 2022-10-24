package com.curso.mercado.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.curso.mercado.entidades.Producto;

public class ProductoDataBaseDAO implements GenericDAO<Producto> {

	private Connection con;

	public ProductoDataBaseDAO(Connection con) {
		this.con = con;
	}

	@Override
	public void add(Producto entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Producto> getAll() {
		ArrayList<Producto> producos = new ArrayList<Producto>();
		String consulta = "SELECT * FROM HR.PRODUCTOS";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				Producto p = new Producto();
				p.setIdProducto(rs.getInt("ID_PRODUCTO"));
				p.setDescripcion(rs.getString("DESCRIPCION"));
				p.setPrecio(rs.getDouble("PRECIO"));
				p.setStock(rs.getInt("STOCK"));
				producos.add(p);
				
				
			}
		} catch (SQLException e) {
			//lanzamos una nueva excepcion pero le pasamos e (trowable) para que eno pierda la pila de llamadas)
			//quien realmente lanza el error que en este caso es de oracle
			throw new RuntimeException("DB JDBC API " + e.getMessage(), e);
		}
		return producos;
	}

	@Override
	public Producto getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Producto entidad) {
		// TODO Auto-generated method stub

	}

}
