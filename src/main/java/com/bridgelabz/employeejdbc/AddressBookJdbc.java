package com.bridgelabz.employeejdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class AddressBookJdbc 
{
	private static AddressBookJdbc addressBookJdbc;
	private AddressBookJdbc() {}
	
	public static AddressBookJdbc getInstance() {
		if (addressBookJdbc==null)
			addressBookJdbc = new AddressBookJdbc();
		return addressBookJdbc;
	}
	Connection connection;
	
	public Connection dbConnect() {
		String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_service?useSSL=false";
		String userName = "root";
		String password = "root";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded!");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find driver in classpath",e);
		}

		try {
			System.out.println("Connecting to database:"+jdbcURL);
			connection = DriverManager.getConnection(jdbcURL,userName,password);
			System.out.println("Connection is successful"+connection);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
