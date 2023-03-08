package com.abc.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static Connection connection;
	
	static {
		
		Properties properties= new Properties();
		
		String filePath="C:\\Users\\srika\\eclipse-workspace\\CRUDAPPMINI\\src\\com\\abc\\properties\\application.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			properties.load(fis);
			String url= properties.getProperty("jdbc.url");
			String username= properties.getProperty("jdbc.username");
			String password= properties.getProperty("jdbc.password");
			
			connection=DriverManager.getConnection(url, username, password);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getDbConnection(){
		return connection;
		
	}
	public static void close(ResultSet resultSet, Statement statement, Connection connection ) {
		//closing JDBC resources
		try {
			if(resultSet!=null) {
				resultSet.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(statement!=null) {
				statement.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(connection!=null) {
				connection.close();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
