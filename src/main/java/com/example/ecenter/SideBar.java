package com.example.ecenter;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

public class SideBar extends Accordion
{
	private Button addressBook;
	
	public SideBar()
	{
		Accordion bar = new Accordion();
		Layout tab1 = new VerticalLayout();
		addressBook = new Button("test!");
		tab1.addComponent(addressBook);
		bar.addTab(tab1, "Test");
		this.addComponent(bar);
		
	}

}
