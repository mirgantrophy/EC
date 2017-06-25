package com.example.ecenter.view;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.mirgantrophy.ecenter.ui.Menu;
import com.mirgantrophy.ecenter.ui.UITest;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.*;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

//@SpringView(name = Home.VIEW_NAME)
public class Home extends HorizontalLayout implements View 
{
//	public static final String VIEW_NAME = "";
	private Menu menu;
	private Panel dashboardPanel;
	

	public Home(UITest ui)
	{

        setSpacing(false);
        setStyleName("main-screen");
        
        
        CssLayout viewContainer = new CssLayout();
        viewContainer.addStyleName("valo-content");
        viewContainer.setSizeFull();

        final Navigator navigator = new Navigator(ui, viewContainer);        

        navigator.setErrorView(ErrorView.class);
        menu = new Menu(navigator);
        menu.addView(new SampleView(), SampleView.VIEW_NAME, "Home", VaadinIcons.HOME);
        menu.addView(new ScheduleView(), ScheduleView.VIEW_NAME,
                ScheduleView.VIEW_NAME, VaadinIcons.EDIT);
       menu.addView(new AddressBookView(), AddressBookView.VIEW_NAME, AddressBookView.VIEW_NAME,
                VaadinIcons.BOOK);
       menu.addView(new AboutView(), AboutView.VIEW_NAME, AboutView.VIEW_NAME,
               VaadinIcons.INFO_CIRCLE);
       //dashboardview and salesview

        navigator.addViewChangeListener(viewChangeListener);

        addComponent(menu);
        addComponent(viewContainer);
        setExpandRatio(viewContainer, 1);
        setSizeFull();
	}

	// notify the view menu about view changes so that it can display which view
    // is currently active
    ViewChangeListener viewChangeListener = new ViewChangeListener() {

        @Override
        public boolean beforeViewChange(ViewChangeEvent event) {
            return true;
        }
        
        @Override
        public void afterViewChange(ViewChangeEvent event) {
        	System.out.println(event.getViewName());
            menu.setActiveView(event.getViewName());
        }

    };
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}



}
