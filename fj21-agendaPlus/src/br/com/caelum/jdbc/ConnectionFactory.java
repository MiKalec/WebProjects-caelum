package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
    public Connection getConnection(){
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "senha");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
