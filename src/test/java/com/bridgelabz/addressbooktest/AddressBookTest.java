package com.bridgelabz.addressbooktest;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Date;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import com.bridgelabz.employeejdbc.AddressBookService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressBookTest {
	
	public AddressBookService addressBookService;
	
	@Test
	public void ifData_WhenConnected_ShouldReturnSize() throws SQLException {
		addressBookService = new AddressBookService();
		int res = addressBookService.getQuery();
		Assert.assertEquals(6, res);
	}
	
	@Test
	public void ifData_WhenUpdated_ShouldReturnTrue() throws SQLException {
		addressBookService = new AddressBookService();
		boolean res = addressBookService.getUpdate("Heema","Jetty","heema123@gmail.com");
		Assert.assertEquals(true, res);
	
	}
	
	@Test
	public void ifData_WhenGivenDate_ShouldReturnSize() throws SQLException {
		addressBookService = new AddressBookService();
		int res = addressBookService.getDataAccordingDate();
		Assert.assertEquals(6, res);
	
	}
	
	@Test
	public void ifData_WhenGivenCityOrState_ShouldReturnCount() throws SQLException {
		addressBookService = new AddressBookService();
		int res = addressBookService.getCityData("Satara");
		Assert.assertEquals(3, res);
		res = addressBookService.getStateData("Maharashtra");
		Assert.assertEquals(3, res);
	}
	
	@Test
	public void ifData_WhenNewAdded_ShouldReturnTrue() throws SQLException {
		addressBookService = new AddressBookService();
		boolean res = addressBookService.createData("Vaibhav","Kokate",75464565476L,"vaibhavk@gmail.com",Date.valueOf("2021-08-06"));
		Assert.assertEquals(true, res);
	}
}