/*
 * TODO
 * Begin main panel. should list the first nth number of contacts.
 * based on recent visits or by name? scroll down and render every name alphabetically
 */
package com.example.ecenter.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Button.ClickEvent;

import java.util.Arrays;
import java.util.List;

import com.example.ecenter.Connector;
import com.mirgantrophy.ecenter.ui.Menu;
import com.example.ecenter.Client;
@SpringView(name = AddressBookView.VIEW_NAME)
@SpringComponent
public class AddressBookView extends HorizontalLayout implements View
{
	public static final String VIEW_NAME = "Address Book";
	private Menu menu;
	private TextField search, firstName, lastName, email, address, phoneNumber, monthField, dayField, yearField;
	private Panel mainPanel;
	private VerticalLayout panelLayout;
	private HorizontalLayout dateLayout, editPanel;
	private Button create, edit, delete;
	private String date;
	Grid<Client> contactList = new Grid<>();
	private List<Client> clients = Arrays.asList(
			new Client("Madeline", "A", "123 Test St.", "test@gmail.gov", "555-555-5554", "February 2017", "N/A", "N/A", 1),
			new Client("Ashlee", "B", "123 Test St.", "test@gmail.com", "555-555-5555", "February 2017", "N/A", "N/A", 2),
			new Client("Londa", "C", "123 Test St.", "test@gmail.net", "555-555-5556", "February 2017", "N/A", "N/A", 3),
			new Client("Gabbie", "D", "123 Test St.", "test@gmail.org", "555-555-5557", "February 2017", "N/A", "N/A", 4),
			new Client("Londa", "E", "123 Test St.", "test@gmail.net", "555-555-5558", "February 2017", "N/A", "N/A", 5),
			new Client("Avorion", "F", "123 Test St.", "test@gmail.net", "555-555-5559", "February 2017", "N/A", "N/A", 6),
			new Client("Xanion", "G", "123 Test St.", "test@gmail.net", "555-555-5560", "February 2017", "N/A", "N/A", 7),
			new Client("Trinium", "H", "123 Test St.", "test@gmail.net", "555-555-5561", "February 2017", "N/A", "N/A", 8),
			new Client("Naonite", "I", "123 Test St.", "test@gmail.net", "555-555-5562", "February 2017", "N/A", "N/A", 9),
			new Client("Squillium", "J", "123 Test St.", "test@gmail.net", "555-555-5563", "February 2017", "N/A", "N/A", 10),
			new Client("Picard", "K", "123 Test St.", "test@gmail.net", "555-555-5564", "February 2017", "N/A", "N/A", 11),
			new Client("Richard", "L", "123 Test St.", "test@gmail.net", "555-555-5565", "February 2017", "N/A", "N/A", 12),
			new Client("Rickard", "M", "123 Test St.", "test@gmail.net", "555-555-5566", "February 2017", "N/A", "N/A", 13),
			new Client("Bobby", "N", "123 Test St.", "test@gmail.net", "555-555-5567", "February 2017", "N/A", "N/A", 14),
			new Client("Bob", "O", "123 Test St.", "test@gmail.net", "555-555-5568", "February 2017", "N/A", "N/A", 15),
			new Client("Ron", "P", "123 Test St.", "test@gmail.net", "555-555-5569", "February 2017", "N/A", "N/A", 16),
			new Client("Bill", "Q", "123 Test St.", "test@gmail.net", "555-555-5570", "February 2017", "N/A", "N/A", 17),
			new Client("Greg", "R", "123 Test St.", "test@gmail.net", "555-555-5571", "February 2017", "N/A", "N/A", 18),
			new Client("Juan", "S", "123 Test St.", "test@gmail.net", "555-555-5572", "February 2017", "N/A", "N/A", 19),
			new Client("Squidward", "T", "123 Test St.", "test@gmail.net", "555-555-5573", "February 2017", "N/A", "N/A", 20));
	
	private TextField filter = new TextField();
	private Button addContact = new Button("New Client");
	//InformationForm infoForm = new InformationForm();
	
	
	
	public AddressBookView()
	{
		initConfig();
		buildLayout();	
	}
	
	private void buildLayout() 
	{
		HorizontalLayout actionBar = new HorizontalLayout(filter, addContact);
		actionBar.setWidth("100%");
		filter.setWidth("100%");
		actionBar.setExpandRatio(filter, 1);
		
		VerticalLayout left = new VerticalLayout(actionBar, contactList);
		left.setSizeFull();
		contactList.setSizeFull();
		left.setExpandRatio(contactList, 1);
		
		HorizontalLayout mainLayout = new HorizontalLayout(left);
		mainLayout.setSizeFull();
		mainLayout.setExpandRatio(left, 1);
		
		addComponent(mainLayout);
		
	}

	private void initConfig() 
	{
		//addContact.addClickListener(e -> infoForm.edit(new Client()));
		filter.setPlaceholder("Search clients...");
		filter.addStyleName(ValoTheme.BUTTON_PRIMARY);
		//filter.addValueChangeListener(e -> refreshClients(e.getText()));
		
		
		contactList.setSelectionMode(Grid.SelectionMode.SINGLE);
		contactList.setItems(clients);
		contactList.addColumn(Client::getfirstName).setCaption("First Name");
		contactList.addColumn(Client::getlastName).setCaption("Last Name");
		//contactList.addSelectionListener(e -> infoForm.edit((Client) contactList.getSelectedItems()));
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
				//dbConnection = new Connector();
				Client temp = new Client();
				temp.setfirstName(firstName.getValue());
				temp.setlastName(lastName.getValue());
				temp.setEmail(email.getValue());
				temp.setAddress(address.getValue());
				temp.setphoneNumber(phoneNumber.getValue()); 
				temp.setstartDate(parseDate());
				//dbConnection.addClient(temp); 
				
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

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
