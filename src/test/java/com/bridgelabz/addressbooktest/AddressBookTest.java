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
}
