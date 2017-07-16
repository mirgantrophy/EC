package io.valhala.ecenter.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import io.valhala.ecenter.view.MainView;
import io.valhala.ecenter.temp.AccessControl;
import io.valhala.ecenter.temp.BasicAccessControl;
import io.valhala.ecenter.view.*;

@SuppressWarnings("serial")
@SpringUI
@Theme("mytheme")
@Title("Electrolysis Center")
@Widgetset("com.vaadin.v7.Vaadin7WidgetSet") //need a v8 widgetset that extends the v7 widgetset
public class ECUI extends UI
{
	private AccessControl accessControl = new BasicAccessControl();
	
	@Override
	protected void init(VaadinRequest request) 
	{
        Responsive.makeResponsive(this);
        setLocale(request.getLocale());

        showMainView();
	}

	private void showMainView() 
	{
		addStyleName(ValoTheme.UI_WITH_MENU);
        setContent(new MainView(ECUI.this));
        getNavigator().navigateTo(getNavigator().getState());
		
	}

	public static ECUI get()
	{
		return (ECUI) UI.getCurrent();
	}

}
