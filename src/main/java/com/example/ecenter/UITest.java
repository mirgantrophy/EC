package com.example.ecenter;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI
@Theme("mytheme")
@Title("Electrolysis Center")
public class UITest extends UI 
{

	@Override
	protected void init(VaadinRequest request) 
	{
		updateContent();
		
	}

	private void updateContent() 
	{
		setContent(new Book());
	}

}
