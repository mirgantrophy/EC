/*
 * TODO
 * implement strength length limiters
 */
package com.example.ecenter;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

public class Book extends HorizontalLayout
{
	private TextField search, firstName, lastName, email, address, phoneNumber, startDate;
	private Panel mainPanel;
	private VerticalLayout panelLayout;
	private Button create, edit, delete;
	private String date; //perhaps there is an easier way to do this
	private Connector c;
	
	public Book()
	{
		moreStuff();
		//Notification n = new Notification("Hello, world!");
		//n.setDelayMsec(20000);
		//n.show(Page.getCurrent());
		//doStuff();
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
		
		lastName = new TextField();
		lastName.setPlaceholder("Last Name");
		
		email = new TextField();
		email.setPlaceholder("Email Address");
		
		address = new TextField();
		address.setPlaceholder("Home Address");
		
		phoneNumber = new TextField();
		phoneNumber.setPlaceholder("Phone Number");
		
		startDate = new TextField();
		startDate.setPlaceholder("Date Started"); 
		//date should be checked or converted into the proper type!
		
		create = new Button("Add Client");
		create.addClickListener(new Button.ClickListener() 
		{
			
			@Override
			public void buttonClick(ClickEvent event) 
			{
				
				Client temp = new Client();
				//parseDate();
				temp.setfirstName(firstName.getValue());
				temp.setlastName(lastName.getValue());
				temp.setEmail(email.getValue());
				temp.setAddress(address.getValue());
				temp.setphoneNumber(phoneNumber.getValue()); 
				temp.setdateStarted(startDate.getValue());
				Notification x = new Notification("Client *CREATED* in *MEMORY*");
				x.setDelayMsec(20000);
				x.show(Page.getCurrent());
				}
			
		});
		
		
		panelLayout.addComponent(firstName);
		panelLayout.addComponent(lastName);
		panelLayout.addComponent(email);
		panelLayout.addComponent(address);
		panelLayout.addComponent(phoneNumber);
		panelLayout.addComponent(startDate);
		
		panelLayout.addComponent(create);
		
		this.addComponent(panelLayout); //add all the items to the newly created object
			
	}
	
	private void parseDate() //array index out of bounds exception (-1)
	//though this worked in prior applications
	//need to further investigate the implementation of getValue();
	{
		date = "";
		String entry = startDate.getValue();
		String month = entry.substring(0, entry.indexOf("-"));
		String day = entry.substring(entry.indexOf("-")+1, entry.lastIndexOf("-"));
		String year = entry.substring(entry.lastIndexOf("-")+ 1);
		date = year + "-" + month + "-" + day;
	}
}
