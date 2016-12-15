package com.faisalarkan.config;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

import java.sql.Connection;

public class Dbconf {

	private static Connection connection = null;	
	public static Connection getConnection (){
		
		if (connection != null){
			
			return connection;
			
		}else{			
			try {
				
				Properties prop = new Properties ();
				InputStream fileProperties = Dbconf.class.getClassLoader().getResourceAsStream("/db.properties");
				prop.load(fileProperties);
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String pass = prop.getProperty("password");
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, pass);
				
				
				
			}catch (Exception e){
				
				
				
			}
			return connection;
			
		}
	}
	
	
	
}
