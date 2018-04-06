/*
package io.valhala.ElectrolysisCenter.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.Version;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
@SpringView(name = DashboardView.VIEW_NAME)

public class AboutView extends VerticalLayout implements View
{
	public static final String VIEW_NAME = "About";
	
	public AboutView()
	{
		CustomLayout aboutContent = new CustomLayout("aboutview");
		aboutContent.setStyleName("about-content");
		
		aboutContent.addComponent(new Label(VaadinIcons.INFO_CIRCLE.getHtml()
				+ " This application is using Vaadin "
				+ Version.getFullVersion(),ContentMode.HTML), "info");
		setSizeFull();
		setMargin(false);
		setStyleName("about-view");
		addComponent(aboutContent);
		setComponentAlignment(aboutContent, Alignment.MIDDLE_CENTER);
	}
	

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}

*/