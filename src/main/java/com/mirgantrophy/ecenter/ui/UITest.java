package com.mirgantrophy.ecenter.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import com.example.ecenter.view.*;

@SuppressWarnings("serial")
@SpringUI
@Theme("mytheme")
@Title("Electrolysis Center")
@Widgetset("com.vaadin.v7.Vaadin7WidgetSet")
public class UITest extends UI //pass the UI to the main view and create a navigator.
{
	
	@Override
	protected void init(VaadinRequest request) 
	{
        Responsive.makeResponsive(this);
        setLocale(request.getLocale());

        showMainView();
        //setContent(new LoginView());
	}

	private void showMainView() 
	{
		addStyleName(ValoTheme.UI_WITH_MENU);
        setContent(new Home(UITest.this));
        getNavigator().navigateTo(getNavigator().getState());
		
	}

	public static UITest get()
	{
		return (UITest) UI.getCurrent();
	}

}
