package io.valhala.ElectrolysisCenter;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import io.valhala.ElectrolysisCenter.view.DashboardView;
import io.valhala.ElectrolysisCenter.view.ErrorView;
import io.valhala.ElectrolysisCenter.view.components.Menu;

@SpringUI
@SpringViewDisplay
@Title("Electrolysis Center")
@Theme("mytheme")
@Widgetset("com.vaadin.v7.Vaadin7WidgetSet")
public class VDisplay extends UI implements ViewDisplay 
{
	private Menu menu;
	private HorizontalLayout root = new HorizontalLayout();
	private Panel springViewDisplay = new Panel();

	@Override
	public void showView(View view) 
	{
		springViewDisplay.setContent((Component) view);
	}

	@Override
	protected void init(VaadinRequest request) 
	{
		addStyleName("main-screen");
		springViewDisplay.addStyleName("valo-content");
		menu = new Menu();
		Responsive.makeResponsive(this);
		setContent(root);
		root.setSizeFull();
		root.addComponents(menu, springViewDisplay); //this might need to be in post construct
		root.setExpandRatio(springViewDisplay, 1.0f);
		addStyleName(ValoTheme.UI_WITH_MENU);
		root.setSpacing(false);
		springViewDisplay.setSizeFull();
		showView(new DashboardView());
	}

}
