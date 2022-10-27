package com.curso.RRHH_BBDD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class EjemploUsoAPIJDBC {

	public static void main(String[] args) {
		// 1. Cargar Driver JDBC Oracle 18c

		try {
			// esto es in .jar y le pide que se cargue de forma dinaica
			// el driver de oracle jdbc y este mete los jars en la libreia
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("cargó ok");
		} catch (ClassNotFoundException e) {
			System.out.println("No cargó driver");
			e.printStackTrace();
			return;
		}
		// conexion a bbdd
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String usr = "system";
		String clave = "oracle";
		// nueva versionde try cach
		// al declaarla dentro del try si hay una clase autoclosable al final la cierra
		// al salir del try/catch

		try (Connection con = DriverManager.getConnection(url, usr, clave)) {
			// 3 consular lista de paises
			Statement st = con.createStatement();
			// 3.1 lanzar la conslta a bbdd
			ResultSet rs = st.executeQuery("SELECT * FROM HR.COUNTRIES");
			// 3.2 recorrer el resultado de la consulta
			// el rs next l.o que hace es devolverte un boolean y aeas avanza en el registro
			while (rs.next()) {
				// lee el primer registro de cada columna
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

			}
			// 4 INSER insertar un pais
			// String sentaciInsert ="INSERT INTO HR.COUNTRIES VALUES ('XX', 'PAISXX',
			// '4')";
			// int regAfectado = st.executeUpdate(sentaciInsert);
			// System.out.printf("insero %d registro", regAfectado);

			// UPDATE country
			// Metodo 1
			String updateString = "UPDATE HR.COUNTRIES SET COUNTRY_NAME = 'BELGICA' WHERE COUNTRY_ID LIKE 'BE' ";
			st.executeUpdate(updateString);

			// Metodo2
			PreparedStatement updateCountry2 = con
					.prepareStatement("UPDATE HR.COUNTRIES SET COUNTRY_NAME = ? WHERE COUNTRY_ID LIKE ? ");
			updateCountry2.setString(1, "Suiza");
			updateCountry2.setString(2, "CH");
			updateCountry2.executeUpdate();

			// DELETE

			//String sql = "DELETE FROM HR.COUNTRIES " + "WHERE COUNTRY_ID = 'XX'";
			//st.executeUpdate(sql);
			
			//crear procedimiento almaceado objeo especial que se queda alamcenado en la base de datso
			String crearProcAlmacenado = 
					"create or replace PROCEDURE    HR.Ver_NombrePais "
					+ "(PARAM_COD_PAIS IN varchar, PARAM_NOMBRE_PAIS OUT VARCHAR ) AS "
					+ "BEGIN     "
					+ "      SELECT COUNTRY_NAME  INTO PARAM_NOMBRE_PAIS "
					+ "      FROM HR.COUNTRIES    \r\n"
					+ "      WHERE COUNTRY_ID = PARAM_COD_PAIS; "
					+ "END;"
					+ "";
			//con el execue lo creas
			con.createStatement().execute(crearProcAlmacenado);


			//para llamarlo desde java a un procedimiento almacenado
			
			CallableStatement call= con.prepareCall("{call HR.Ver_NombrePais(?,?)}");
			String codigo = "AR";
			//preparamos en codio de entrada codigo pais
			call.setString(1, codigo);
			//preparar meoo de salida qu es el nombre
			call.registerOutParameter(2, java.sql.Types.VARCHAR);
			//ejecutar procedimiento almacenado
			call.executeQuery();
			//leer valor recuperado
			String nombrePaisRecuperado =  call.getString(2);
			 System.out.printf("nombre del pais %s es %s %n", codigo, nombrePaisRecuperado);
			

			 modificarPaises(con, "qq", "AU");
			 
			 String crearTablaProducto = "CREATE TABLE HR.PRODUCTOS "
						+ "   (	ID_PRODUCTO NUMBER NOT NULL ENABLE PRIMARY KEY,"
						+ "	DESCRIPCION VARCHAR2(50 BYTE) NOT NULL ENABLE,"
						+ "	PRECIO NUMBER DEFAULT 0 NOT NULL ENABLE, "
						+ "	STOCK NUMBER DEFAULT 0 NOT NULL ENABLE) ";
			//	con.createStatement().execute(crearTablaProducto);
				
			 String insertProducos = "INSERT INTO HR.PRODUCTOS "
			 		+ "(ID_PRODUCTO, DESCRIPCION, PRECIO, STOCK) "
			 		+ "VALUES (1,'TV', 1599.8, 5)";
			 String insertProducos2 = "INSERT INTO HR.PRODUCTOS "
				 		+ "(ID_PRODUCTO, DESCRIPCION, PRECIO, STOCK) "
				 		+ "VALUES (2,'Smartphone', 999.2, 6)";
			// con.createStatement().execute(insertProducos);
			// con.createStatement().execute(insertProducos2);
			System.out.println("conectó ok");
		} catch (SQLException e) {

			System.out.println("Error BD " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void modificarPaises(Connection conexion, String... codigos) {
		//crear un contextos transaccionales
		//en el que se ejecutan como un todo vaias setecias sql
		// si una falla deben fallar todas
		
		try {
			conexion.setAutoCommit(false);
			String updateString = "UPDATE HR.COUNTRIES"
					+ " SET COUNTRY_NAME = COUNTRY_NAME ||' MOIFICADO' WHERE COUNTRY_ID LIKE ? ";
			PreparedStatement modificarNombrePais = conexion.prepareStatement(updateString);
			for (String codigo: codigos) {
				modificarNombrePais.setString(1, codigo);
				modificarNombrePais.executeUpdate();
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				conexion.rollback();
				System.out.println("hecho rollback");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

}
