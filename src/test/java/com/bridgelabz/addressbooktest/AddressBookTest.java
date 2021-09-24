package com.bridgelabz.addressbooktest;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.employeejdbc.AddressBookService;

public class AddressBookTest {
public AddressBookService addressBookService;
	
@Test
public void ifData_WhenConnected_ShouldReturnSize() throws SQLException {
	addressBookService = new AddressBookService();
	int res = addressBookService.getQuery();
	Assert.assertEquals(6, res);
}

@Test
public void ifData_WhenUpdated_ShouldReturnSize() throws SQLException {
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
	int res = addressBookService.getCityData("Silvassa");
	Assert.assertEquals(3, res);
	res = addressBookService.getStateData("Maharashtra");
	Assert.assertEquals(3, res);
}
}
