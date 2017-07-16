/*
 * TODO
 * mainview or menu causing incorrect layout
 */
package io.valhala.ecenter.view;

import java.util.Iterator;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = DashboardView.VIEW_NAME)
@SpringComponent
public class DashboardView extends Panel implements View
{
	public static final String TITLE_ID = "dashboard-title";
	public static final String EDIT_ID = "dashboard-edit";
	public static final String VIEW_NAME = "";
	private NotificationsButton notificationsButton;
	private Label titleLabel;
	private final VerticalLayout root;
	private CssLayout dashboardPanels;
	public DashboardView()
	{
		addStyleName(ValoTheme.PANEL_BORDERLESS);
		setSizeFull();
		
		root = new VerticalLayout();
		root.setSizeFull();
		root.setMargin(true);
		root.addStyleName("dashboard-view");
		root.setSpacing(false);
		setContent(root);
		Responsive.makeResponsive(this);
		
		root.addComponent(buildHeader());
		Component content = buildContent();
		root.addComponent(content);
		root.setExpandRatio(content, 1);

	}
	
	private Component buildHeader() 
	{
		HorizontalLayout header = new HorizontalLayout();
		header.addStyleName("viewheader");
		header.setSpacing(true);
		
		titleLabel = new Label("EC Preview Alpha 4");
		titleLabel.setId(TITLE_ID);
		titleLabel.setSizeUndefined();
		titleLabel.addStyleName(ValoTheme.LABEL_H1);
		titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
		header.addComponent(titleLabel);
		
		notificationsButton = buildNotificationsButton();
		Component edit = buildEditButton();
		HorizontalLayout tools = new HorizontalLayout(notificationsButton, edit);
		tools.setSpacing(true);
		tools.addStyleName("toolbar");
		header.addComponent(tools);
		return header;
	}

	private NotificationsButton buildNotificationsButton() 
	{
		NotificationsButton result = new NotificationsButton();
		result.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(final ClickEvent event)
			{
				openNotificationsPopup(event);
			}
		});
		return result;
	}
	
	private void openNotificationsPopup(final ClickEvent event)
	{
		VerticalLayout notificationsLayout = new VerticalLayout();
		
		Label title = new Label("Notifications");
		title.addStyleName(ValoTheme.LABEL_H3);
		title.addStyleName(ValoTheme.LABEL_NO_MARGIN);
		notificationsLayout.addComponent(title);
		
	}

	private Component buildEditButton() 
	{
		Button result = new Button();
		result.setId(EDIT_ID);
		result.setIcon(FontAwesome.EDIT);
		result.addStyleName("icon-edit");
		result.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		result.setDescription("Edit Dashboard");
		result.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(final ClickEvent event)
			{
				//getUI().addWindow(new DashboardEdit(DashboardView.this, titleLabel.getValue()));
			}
		});
		return result;
	}

	private Component buildContent()
	{
		dashboardPanels = new CssLayout();
		dashboardPanels.addStyleName("dashboard-panels");
		Responsive.makeResponsive(dashboardPanels);
		
		dashboardPanels.addComponent(buildNotes());
		
		return dashboardPanels;
	}
	
	private Component buildNotes() 
	{
		TextArea notes = new TextArea("Notes");
		notes.setValue("Remember to tell Maddie she is the best. " + "\n" + "Londa was late today!");
		notes.setSizeFull();
		notes.addStyleName(ValoTheme.TEXTAREA_BORDERLESS);
		Component panel = createContentWrapper(notes);
		panel.addStyleName("notes");
		return panel;
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
	
	
	@Override
	public void enter(ViewChangeEvent event) 
	{
		
	}
	
	public static final class NotificationsButton extends Button 
	{
		private static final String STYLE_UNREAD = "unread";
		public static final String ID = "dashboard-notifications";
		
		public NotificationsButton()
		{
			setIcon(FontAwesome.BELL);
			setId(ID);
			addStyleName("notifications");
			addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		}
	}

}
