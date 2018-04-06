package io.valhala.ElectrolysisCenter.view;

import java.util.GregorianCalendar;
import com.vaadin.v7.ui.Calendar;
import java.util.Iterator;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name=DashboardView.VIEW_NAME)
@SpringComponent
public class DashboardView extends Panel implements View 
{
	public static final String VIEW_NAME = "";
	private final VerticalLayout root;
	private CssLayout dashboardPanels;
	private Panel calendarWidget, notesWidget;
	private Label titleLabel;
	
	/* what kind of panels do we want so that everything is at a glance
	 * calendar widget (DAY VIEW ONLY*?)
	 * notes widget
	 * email widget* or email page...? why not both???
	 * 
	 */
	public DashboardView()
	{
		addStyleName(ValoTheme.PANEL_BORDERLESS);
		setSizeFull();
		root = new VerticalLayout();
		root.setSizeFull();
		root.setMargin(true);
		root.setSpacing(true);
		root.addStyleName("dashboard-view");
		setContent(root);
		Responsive.makeResponsive(this);
		root.addComponent(buildHeader());
		Component content = buildWidgets();
		root.addComponent(content);
		root.setExpandRatio(content, 1.0f);
	}
	
	private Component createContentWrapper(final Component content)
	{
		final CssLayout slot = new CssLayout();
		slot.setWidth("100%");
		slot.addStyleName("dashboard-panel-slot");
		
		CssLayout card = new CssLayout();
		card.setWidth("100%");
		card.addStyleName(ValoTheme.LAYOUT_CARD);
		
		HorizontalLayout toolbar = new HorizontalLayout();
		toolbar.addStyleName("dashboard-panel-toolbar");
		toolbar.setWidth("100%");
		toolbar.setSpacing(false);
		
		Label caption = new Label(content.getCaption());
		caption.addStyleName(ValoTheme.LABEL_H4);
		caption.addStyleName(ValoTheme.LABEL_COLORED);
		caption.addStyleName(ValoTheme.LABEL_NO_MARGIN);
		content.setCaption(null);
		
		MenuBar tools = new MenuBar();
		tools.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
		MenuItem max = tools.addItem("", FontAwesome.EXPAND, new Command() {
			
			@Override 
			public void menuSelected(final MenuItem selectedItem)
			{
				if(!slot.getStyleName().contains("max"))
				{
					selectedItem.setIcon(FontAwesome.COMPRESS);
					toggleMaximized(slot, true);
				}
				else
				{
					slot.removeStyleName("max");
					selectedItem.setIcon(FontAwesome.EXPAND);
					toggleMaximized(slot, false);
				}
			}
		});
		max.setStyleName("icon-only");
		MenuItem root = tools.addItem("", FontAwesome.COG, null);
		root.addItem("Configure", new Command() {
			@Override
			public void menuSelected(final MenuItem selectedItem) 
			{
				Notification.show("not implemented in this demo");
			}
		});
		
		root.addSeparator();
		root.addItem("Close", new Command() {
			@Override
			public void menuSelected(final MenuItem selectedItem)
			{
				Notification.show("not implemented in this demo");;
			}
		});
		
		toolbar.addComponents(caption, tools);
		toolbar.setExpandRatio(caption, 1);
		toolbar.setComponentAlignment(caption, Alignment.MIDDLE_LEFT);
		
		card.addComponents(toolbar, content);
		slot.addComponent(card);
		return slot;
	}
	
	private void toggleMaximized(final Component panel, final boolean maximized)
	{
		for(Iterator<Component> it = root.iterator(); it.hasNext(); )
		{
			it.next().setVisible(!maximized);
		}
		dashboardPanels.setVisible(true);
		
		for(Iterator<Component> it = dashboardPanels.iterator(); it.hasNext();)
		{
			Component c = it.next();
			c.setVisible(!maximized);
		}
		
		if(maximized)
		{
			panel.setVisible(true);
			panel.addStyleName("max");
		}
		else
		{
			panel.removeStyleName("max");
		}
	}
	
	private Component buildHeader()
	{
		HorizontalLayout header = new HorizontalLayout();
		header.addStyleName("viewheader");
		header.setSpacing(true);
		
		titleLabel = new Label("EC BETA");
		//titleLabel.setId(TITLE_ID);
		titleLabel.setSizeUndefined();
		titleLabel.addStyleName(ValoTheme.LABEL_H1);
		titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
		header.addComponent(titleLabel);
		
		//notificationsButton = buildNotificationsButton();
		//Component edit = buildEditButton();
		HorizontalLayout tools = new HorizontalLayout(new Button(VaadinIcons.BELL_O), new Button(VaadinIcons.EDIT));
		tools.setSpacing(true);
		tools.addStyleName("toolbar");
		header.addComponent(tools);
		return header;
		
	}
	
	private Component buildWidgets()
	{
		dashboardPanels = new CssLayout();
		dashboardPanels.addStyleName("dashboard-panels");
		Responsive.makeResponsive(dashboardPanels);
		
		dashboardPanels.addComponent(buildNotes());
		//dashboardPanels.addComponent(buildCalendar());
		dashboardPanels.addComponent(buildEmail());
		
		return dashboardPanels;
	}
	
	private Component buildCalendar() 
	{
		GregorianCalendar calendarTimeCtrl;
		Calendar calendarComponent;
		Integer firstHour, lastHour, firstDay, lastDay;
		firstHour = 9;
		lastHour = 20;
		return null;
		
	}

	private Component buildEmail() 
	{
		TextArea notes = new TextArea("Placeholder");
		notes.setValue("new feature coming!");
		notes.setSizeFull();
		notes.addStyleName(ValoTheme.TEXTAREA_BORDERLESS);
		Component panel = createContentWrapper(notes);
		panel.addStyleName("notes");
		return panel;
	}

	private Component buildNotes()
	{
		TextArea notes = new TextArea("Placeholder");
		notes.setValue("new feature coming!");
		notes.setSizeFull();
		notes.addStyleName(ValoTheme.TEXTAREA_BORDERLESS);
		Component panel = createContentWrapper(notes);
		panel.addStyleName("notes");
		return panel;
	}
	


}
