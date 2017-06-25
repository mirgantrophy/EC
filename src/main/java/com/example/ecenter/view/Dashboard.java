/*
 * add DASHBOARD and DASHBOARDMENU to a MAINVIEW
 */


package com.example.ecenter.view;


import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;

import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
@SpringComponent //anything directly injected into a new view must implement component
@SpringView(name = Dashboard.VIEW_NAME)
public class Dashboard extends Panel
{
    public static final String EDIT_ID = "dashboard-edit";
    public static final String TITLE_ID = "dashboard-title";
	public static final String VIEW_NAME = "";
	private final VerticalLayout root;
	private Label titleLabel;
	private CssLayout dashboardPanels;
	//private NotificationsButton notificationsButton;
	
	public Dashboard()
	{
		addStyleName(ValoTheme.PANEL_BORDERLESS);
		setSizeFull();
		
		root = new VerticalLayout();
		root.setSizeFull();
		root.setMargin(true);
		root.addStyleName("dashboard-view");
		setContent(root);
		Responsive.makeResponsive(root);
		
		root.addComponent(buildHeader());
		root.addComponent(buildSparklines());
		
		Component content = buildContent();
		
		root.addComponent(content);
		root.setExpandRatio(content, 1);
		
		
	
	}

	private Component buildContent() {
        dashboardPanels = new CssLayout();
        dashboardPanels.addStyleName("dashboard-panels");
        Responsive.makeResponsive(dashboardPanels);

        //dashboardPanels.addComponent(buildTopGrossingMovies());
        //dashboardPanels.addComponent(buildNotes());
        //dashboardPanels.addComponent(buildTop10TitlesByRevenue());
        //dashboardPanels.addComponent(buildPopularMovies());

        return dashboardPanels;
	}

	private Component buildHeader() 
	{
        HorizontalLayout header = new HorizontalLayout();
        header.addStyleName("viewheader");
        header.setSpacing(true);

        titleLabel = new Label("Dashboard");
        titleLabel.setId(TITLE_ID);
        titleLabel.setSizeUndefined();
        titleLabel.addStyleName(ValoTheme.LABEL_H1);
        titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        header.addComponent(titleLabel);

        //notificationsButton = buildNotificationsButton();
       // Component edit = buildEditButton();
        //HorizontalLayout tools = new HorizontalLayout(notificationsButton, edit);
       // tools.setSpacing(true);
        //tools.addStyleName("toolbar");
       // header.addComponent(tools);

        return header;
	}
	
   /* private Component buildNotes() {
        TextArea notes = new TextArea("Notes");
        notes.setValue("Remember to:\n· Zoom in and out in the Sales view\n· Filter the transactions and drag a set of them to the Reports tab\n· Create a new report\n· Change the schedule of the movie theater");
        notes.setSizeFull();
        notes.addStyleName(ValoTheme.TEXTAREA_BORDERLESS);
        Component panel = createContentWrapper(notes);
        panel.addStyleName("notes");
        return panel;
    }*/

	private Component buildSparklines() {
		// TODO Auto-generated method stub
		return null;
	}

}
