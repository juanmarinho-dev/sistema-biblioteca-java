package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection conectar() {
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conectado!");
			return conn;
		
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return null;
		}

	}
}
