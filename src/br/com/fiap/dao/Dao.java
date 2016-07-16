package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Dao {

	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	protected void openConn() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/teatro", "root", "112628");	
		conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
	}
	
	protected void closeConn() throws SQLException {
		if(conn != null && !conn.isClosed()){
			conn.close();
		}
	}
}
