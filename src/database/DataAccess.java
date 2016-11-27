package database;

import java.sql.DriverManager;

import java.sql.Connection;

public class DataAccess {

	public static Connection getConnection() throws Exception{
		
		String server = "localhost";
		String port = "3306";
		String database = "sistramdoc_db";
		String user = "root";
		String pass = "putO$ki";
		String url = "jdbc:mysql://" + server + ":" + port + "/" + database;
		String driver = "com.mysql.jdbc.Driver";
		Connection cn;

		try {

			Class.forName(driver);
			cn = DriverManager.getConnection(url, user, pass);
			return cn;
		} catch (Exception e) {
			throw e;
		}

	}

}
