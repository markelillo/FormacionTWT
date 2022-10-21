package com.curso.RRHH_BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		//nueva versionde try cach 
		//al declaarla dentro del try si hay una clase autoclosable al final la cierra al salir del try/catch 
		
		try (Connection con = DriverManager.getConnection(url, usr, clave)) {
			//3 consular lista de paises
			Statement st = con.createStatement();
			//3.1 lanzar la conslta a bbdd
			ResultSet rs = st.executeQuery("SELECT * FROM HR.COUNTRIES");
			//3.2 recorrer el resultado de la consulta
			//el rs next l.o que hace es devolverte un boolean y aeas avanza en el registro
			 while (rs.next()) {
				 //lee el primer registro de cada columna
				System.out.println(rs.getString(1)+" "+ rs.getString(2)+" "+ rs.getString(3));
				
			}
			//4 INSER insertar un pais
			// String sentaciInsert ="INSERT INTO HR.COUNTRIES VALUES ('XX', 'PAISXX', '4')";
			 //int regAfectado = st.executeUpdate(sentaciInsert);
			// System.out.printf("insero %d registro", regAfectado);
			 
			 
			 //UPDATE country
			 //Metodo 1
			 String updateString ="UPDATE HR.COUNTRIES SET COUNTRY_NAME = 'BELGICA' WHERE COUNTRY_ID LIKE 'BE' ";
			 st.executeUpdate(updateString);
			 
			 //Metodo2 
			 PreparedStatement updateCountry2 = con.prepareStatement("UPDATE HR.COUNTRIES SET COUNTRY_NAME = ? WHERE COUNTRY_ID LIKE ? ");
			 updateCountry2.setString(1, "Suiza");
			 updateCountry2.setString(2, "CH");
			 updateCountry2.executeUpdate();
			 
			System.out.println("conectó ok");
		} catch (SQLException e) {

			System.out.println("Error BD " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
