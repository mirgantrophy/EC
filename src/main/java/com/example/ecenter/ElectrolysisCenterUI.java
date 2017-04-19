package com.example.ecenter;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
@Theme("valo")
public class ElectrolysisCenterUI extends UI
{
	private VerticalLayout layout;
	
	//@Autowired
	

	private void addHeader()
	{
		Label header = new Label("LOGIN VIEW");
		header.addStyleName(ValoTheme.LABEL_H1);
		layout.addComponent(header);
		
	}

	private void addForm() 
	{
		VerticalLayout loginLayout = new VerticalLayout();
		//loginLayout.setWidth("80");
		loginLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		
		VerticalLayout fieldLayout = new VerticalLayout();
		fieldLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		TextField usernameField = new TextField();
		usernameField.focus();
		TextField passwordField = new TextField();
		fieldLayout.addComponents(usernameField, passwordField);
		//we need to find a way to blur the password when typed
		//then encrypt our connection to the database
		
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		Button loginButton = new Button("Login");
		loginButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		Button registerButton = new Button("Register");
		registerButton.setStyleName(ValoTheme.BUTTON_LINK);
		buttonLayout.addComponents(loginButton, registerButton);
		
		loginLayout.addComponents(fieldLayout, buttonLayout);
		
		
		layout.addComponents(loginLayout);
		
	}

	private void addActionButtons()
	{
		// TODO Auto-generated method stub
		
	}

	private void setupLayout() 
	{
		layout = new VerticalLayout();
		layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		setContent(layout);
		
	}

	@Override
	protected void init(VaadinRequest request) 
	{
		setupLayout();
		addHeader();
		addActionButtons();
		addForm();
		
		
	}

}
