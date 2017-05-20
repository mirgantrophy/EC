/*
 * TODO
 * check if database exists, if not create one
 * insert client objects into database
 */
package com.example.ecenter;

import com.vaadin.ui.TextField;

public class AddressBook
{
	private TextField firstName, lastName, address, email, phoneNum;
	
	public AddressBook()
	{
		firstName = new TextField("First Name");
		phoneNum = new TextField("Phone Number");
		lastName = new TextField("Last Name");
		address = new TextField("Home Address");
		email = new TextField("Email Address");
	}

}
