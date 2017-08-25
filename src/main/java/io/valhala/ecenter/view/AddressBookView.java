/*
 * TODO
 * lazy loading + scroll down and render every name alphabetically
 * SQL accepts the following: YYYY-MM-DD
 * Make a visually appealing contactForm and historyTab
 */

package io.valhala.ecenter.view;

import com.vaadin.client.ui.VTabsheet.Tab;
import com.vaadin.data.Binder;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import io.valhala.ecenter.temp.Client;
import java.util.Arrays;
import java.util.List;

@SpringView(name = AddressBookView.VIEW_NAME)
@SpringComponent
public class AddressBookView extends HorizontalLayout implements View
{
	public static final String VIEW_NAME = "Address Book";
	private TabSheet panel = new TabSheet();
	Grid<Client> contactList = new Grid<>(Client.class);
	private List<Client> clients = Arrays.asList(
			new Client("Sernie", "A", "123 Test St.", "test@gmail.gov", "555-555-5554"),
			new Client("Ernie", "B", "123 Test St.", "test@gmail.com", "555-555-5555"),
			new Client("Bernie", "C", "123 Test St.", "test@gmail.net", "555-555-5556"),
			new Client("Ayy", "Lmao", "123 Test St.", "test@gmail.org", "555-555-5557"),
			new Client("Dax", "E", "123 Test St.", "test@gmail.net", "555-555-5558"),
			new Client("Avorion", "F", "123 Test St.", "test@gmail.net", "555-555-5559"),
			new Client("Xanion", "G", "123 Test St.", "test@gmail.net", "555-555-5560"),
			new Client("Trinium", "H", "123 Test St.", "test@gmail.net", "555-555-5561"),
			new Client("Naonite", "I", "123 Test St.", "test@gmail.net", "555-555-5562"),
			new Client("Squillium", "J", "123 Test St.", "test@gmail.net", "555-555-5563"),
			new Client("Picard", "K", "123 Test St.", "test@gmail.net", "555-555-5564"),
			new Client("Richard", "L", "123 Test St.", "test@gmail.net", "555-555-5565"),
			new Client("Rickard", "M", "123 Test St.", "test@gmail.net", "555-555-5566"),
			new Client("Bobby", "N", "123 Test St.", "test@gmail.net", "555-555-5567"),
			new Client("Bob", "O", "123 Test St.", "test@gmail.net", "555-555-5568"),
			new Client("Ron", "P", "123 Test St.", "test@gmail.net", "555-555-5569"),
			new Client("Bill", "Q", "123 Test St.", "test@gmail.net", "555-555-5570"),
			new Client("Greg", "R", "123 Test St.", "test@gmail.net", "555-555-5571"),
			new Client("Juan", "S", "123 Test St.", "test@gmail.net", "555-555-5572"),
			new Client("Squidward", "T", "123 Test St.", "test@gmail.net", "555-555-5573"));
	private ContactForm contactForm = new ContactForm();
	private TextField filter = new TextField();
	private Button addContact = new Button("New Client");
	private ClientHistory history = new ClientHistory();
	
	public AddressBookView()
	{
		setSizeFull();
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
		left.setSizeFull(); //or undefined
		left.setExpandRatio(contactList, 1);
		panel.addTab(contactForm, "Client Information");
		panel.addTab(history, "History (Coming soon!)");
		addComponents(left, panel);
		panel.setVisible(false);
		contactForm.setVisible(false);
		history.setVisible(false);
	}

	private void initConfig() 
	{
		addContact.addClickListener(event -> 
		{
			contactForm.setClient(new Client());
		});
		
		filter.setPlaceholder("Search clients...");
		addContact.addStyleName(ValoTheme.BUTTON_PRIMARY);
		//filter.addValueChangeListener(e -> refreshContacts(e.getText()));
		
		contactList.setSelectionMode(Grid.SelectionMode.SINGLE);
		contactList.setColumns("firstName", "lastName");
		contactList.setItems(clients);
		
		contactList.asSingleSelect().addValueChangeListener(event -> 
		{
			if(event.getValue() == null)
			{
				panel.setVisible(false);
				contactForm.setVisible(false);
				history.setVisible(false);
			}
			else
			{
				panel.setVisible(true);
				history.setVisible(true);
				contactForm.setClient(event.getValue());
			}
		});
		contactList.setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}
	
	private class ClientHistory extends VerticalLayout
	{
		public ClientHistory()
		{
			setSizeUndefined();
		}
	}
	
	private class ContactForm extends FormLayout
	{
		private Client client;
		private Button save, delete, cancel;
		private TextField firstName, lastName, email, address, phoneNumber;
	    private Binder<Client> binder = new Binder<>(Client.class);
		public ContactForm()
		{
			initConf();
			initLayout();
			setSizeUndefined();
			binder.bindInstanceFields(this);
		}
		
		public void initConf() 
		{
			save = new Button("Save");
			cancel = new Button("Cancel");
			cancel.addClickListener(e -> this.cancel());
			
			firstName = new TextField();
			firstName.setPlaceholder("First Name");
			
			lastName = new TextField();
			lastName.setPlaceholder("Last Name");
			
			email = new TextField();
			email.setPlaceholder("Email Address");
			
			address = new TextField();
			address.setPlaceholder("Address");
			
			phoneNumber = new TextField();
			phoneNumber.setPlaceholder("Phone Number");
			
		}
		private void cancel() 
		{
			setClient(null);
			panel.setVisible(false);
			
		}

		public void initLayout() 
		{
			HorizontalLayout actions = new HorizontalLayout(save, cancel);
			actions.setSpacing(true);
			
			addComponents(actions, firstName, lastName, email, address, phoneNumber);
		}
		
		public void setClient(Client client)
		{
			panel.setVisible(true);
			this.client = client;
			binder.setBean(client);
		}
	}
	

}
