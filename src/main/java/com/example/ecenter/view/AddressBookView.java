/*
 * TODO
 * Begin main panel. should list the first nth number of contacts.
 * based on recent visits or by name? scroll down and render every name alphabetically
 */
package com.example.ecenter.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.example.ecenter.Connector;
import com.example.ecenter.Client;

public class AddressBookView extends HorizontalLayout
{
	private TextField search, firstName, lastName, email, address, phoneNumber, monthField, dayField, yearField;
	private Panel mainPanel;
	private VerticalLayout panelLayout;
	private HorizontalLayout dateLayout, editPanel;
	private Button create, edit, delete;
	private String date;
	private Connector dbConnection;
	
	public AddressBookView()
	{
		moreStuff();
	}
	
	private void doStuff()
	{
		mainPanel = new Panel("Address Book");
		search = new TextField();
		search.setPlaceholder("Search...");
		mainPanel.setSizeUndefined();
		this.addComponent(mainPanel);
		
		FormLayout content = new FormLayout();
		content.addComponent(search);
		content.setSizeUndefined();
		content.setMargin(true);
		mainPanel.setContent(content);
	}
	
	private void moreStuff()
	{
		panelLayout = new VerticalLayout();
		
		firstName = new TextField();
		firstName.setPlaceholder("First Name");
		firstName.setMaxLength(30);
		
		lastName = new TextField();
		lastName.setPlaceholder("Last Name");
		lastName.setMaxLength(30);
		
		email = new TextField();
		email.setPlaceholder("Email Address");
		email.setMaxLength(50);
		
		address = new TextField();
		address.setPlaceholder("Home Address");
		address.setMaxLength(50);
		
		phoneNumber = new TextField();
		phoneNumber.setPlaceholder("Phone Number");
		phoneNumber.setMaxLength(10);
		
		dateLayout = new HorizontalLayout();
		monthField = new TextField();
		monthField.setPlaceholder("MM");
		monthField.setMaxLength(2);
		dayField = new TextField();
		dayField.setPlaceholder("DD");
		dayField.setMaxLength(2);
		yearField = new TextField();
		yearField.setPlaceholder("YYYY");
		yearField.setMaxLength(4);
		
		dateLayout.addComponent(monthField);
		dateLayout.addComponent(dayField);
		dateLayout.addComponent(yearField);

		/*
		 * TODO
		 * automatically proceed to the next field 
		 * after the string limit has been met.
		 */
		
		create = new Button("Add Client");
		create.addClickListener(new Button.ClickListener() 
		{
			
			@Override
			public void buttonClick(ClickEvent event) 
			{
				dbConnection = new Connector();
				Client temp = new Client();
				temp.setfirstName(firstName.getValue());
				temp.setlastName(lastName.getValue());
				temp.setEmail(email.getValue());
				temp.setAddress(address.getValue());
				temp.setphoneNumber(phoneNumber.getValue()); 
				temp.setstartDate(parseDate());
				dbConnection.addClient(temp); 
				
				/*
				 * TODO
				 * confirm object is created and disposed of correctly
				 * and make sure no data contaminations occur
				 */
			}
			
		});
		
		
		panelLayout.addComponent(firstName);
		panelLayout.addComponent(lastName);
		panelLayout.addComponent(email);
		panelLayout.addComponent(address);
		panelLayout.addComponent(phoneNumber);
		panelLayout.addComponent(dateLayout); 
		
		panelLayout.addComponent(create);
		
		this.addComponent(panelLayout); 
		
		/*
		 * TODO
		 * begin theme and finalize layout
		 */
			
	}
	
	private String parseDate() //SQL accepts the following: YYYY-MM-DD
	{
		return date = yearField.getValue() + "-" + monthField.getValue() + "-" + dayField.getValue();
	}
}
