package io.valhala.ecenter.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.*;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

import io.valhala.ecenter.ui.Menu;
import io.valhala.ecenter.ui.ECUI;

public class MainView extends HorizontalLayout implements View 
{
	private Menu menu;
	public MainView(ECUI ui)
	{
        setSizeFull();
        setSpacing(false);
        addStyleName("main-screen");
        
        CssLayout viewContainer = new CssLayout();
        viewContainer.addStyleName("valo-content");
        viewContainer.setSizeFull();

        final Navigator navigator = new Navigator(ui, viewContainer);        

        navigator.setErrorView(ErrorView.class);
        menu = new Menu(navigator);
        menu.addView(new DashboardView(), DashboardView.VIEW_NAME, "Home", VaadinIcons.HOME);
        menu.addView(new ScheduleView(), ScheduleView.VIEW_NAME,
                ScheduleView.VIEW_NAME, VaadinIcons.EDIT);
        menu.addView(new AddressBookView(), AddressBookView.VIEW_NAME, AddressBookView.VIEW_NAME,
                VaadinIcons.BOOK);
        menu.addView(new TransactionsView(), TransactionsView.VIEW_NAME, TransactionsView.VIEW_NAME, VaadinIcons.CASH);
        menu.addView(new AboutView(), AboutView.VIEW_NAME, AboutView.VIEW_NAME,
               VaadinIcons.INFO_CIRCLE);
       
       
        navigator.addViewChangeListener(viewChangeListener);

        addComponent(menu);
        addComponent(viewContainer);
        setExpandRatio(viewContainer, 1);
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
            menu.setActiveView(event.getViewName());
        }

    };
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}



}
