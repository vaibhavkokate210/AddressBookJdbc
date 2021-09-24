package com.bridgelabz.employeejdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBookService 
{
	public AddressBookJdbc addressBookJdbc;
	
	public int getQuery() throws SQLException {
		String query = "select p.firstname,p.lastname,p.phonenumber,p.email,a.residence_address,a.city,a.state,a.country,a.zip,r.type\r\n" + 
				"from address a,address_book ab,person_details p,relation_type r\r\n" + 
				"where ab.person_id = p.person_id\r\n" + 
				"and ab.relation_id = r.relation_id\r\n" + 
				"and p.person_id = a.person_id;";
		ResultSet queries = getQuerries(query);
		return printSet(queries);
	}
	
	private int printSet(ResultSet queries) throws SQLException {
		int i=0;
		while(queries.next()) {
			i++;
			String firstname = queries.getString("p.firstname");
			String lastname = queries.getString("p.lastname");
			System.out.println(firstname+" "+lastname);
		}
		return i;
	}

	private ResultSet getQuerries(String query) throws SQLException {
		addressBookJdbc = AddressBookJdbc.getInstance();
		Connection connection = addressBookJdbc.dbConnect();
		Statement statement = connection.createStatement();
		
		return statement.executeQuery(query);
	}

	public boolean getUpdate(String firstName, String lastName, String email) throws SQLException {
		String query = String.format("update person_details set email = '%s' where firstname = '%s' and lastname = '%s';",email,firstName,lastName);
		addressBookJdbc = AddressBookJdbc.getInstance();
		Connection connection = addressBookJdbc.dbConnect();
		Statement statement = connection.createStatement();
		int z = statement.executeUpdate(query);
		ResultSet queries = getQuerries(String.format("Select email from person_details where firstname = '%s' and lastname = '%s';",firstName,lastName));
		while(queries.next()) {
			if (queries.getString("email").equals(email)) return true;
		}
		return false;
	}
	
	public int getDataAccordingDate() throws SQLException {
		Date dateStart = Date.valueOf("2018-01-01");
		Date dateEnd = Date.valueOf("2021-12-30");
		String query = String.format("select p.firstname,p.lastname from person_details p where date_added between '%tF' and '%tF';",dateStart,dateEnd);
		ResultSet queries = getQuerries(query);
		return printSet(queries);
	}

	public int getCityData(String city )throws SQLException {
		String query = String.format("select a.city,count(*) from address a,person_details p where p.person_id = a.person_id and city = '%s';",city);
		ResultSet queries = getQuerries(query);
		while(queries.next()) {
			return queries.getInt("count(*)");
		}
		return 0;
	}

	public int getStateData(String state) throws SQLException {
		String query = String.format("select a.state,count(*) from address a,person_details p where p.person_id = a.person_id and state = '%s';",state);
		ResultSet queries = getQuerries(query);
		while(queries.next()) {
			return queries.getInt("count(*)");
		}
		return 0;
	}
}
