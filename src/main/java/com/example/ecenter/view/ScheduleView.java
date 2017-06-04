package com.example.ecenter.view;

import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.v7.ui.Calendar;

@SuppressWarnings("deprecation")
public class ScheduleView extends CssLayout implements View
{
	private Calendar calendar;
	private Component tray;
	
	public ScheduleView()
	{
		setSizeFull();
		addStyleName("schedule");
		
		TabSheet tabs = new TabSheet();
		tabs.setSizeFull();
		tabs.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
		
		tabs.addComponent(buildCalendarView());
	
		addComponent(tabs);
		
	}
	
	
	private Component buildCalendarView()
	{
		VerticalLayout calendarLayout = new VerticalLayout();
		calendarLayout.setCaption("Calendar");
		calendarLayout.setMargin(true);
		
		calendar = new Calendar("test");
		calendar.setWidth(100.0f, Unit.PERCENTAGE);
		calendar.setHeight(1000.0f, Unit.PIXELS);
		
		
		calendarLayout.addComponent(calendar);
		
		calendar.setFirstVisibleHourOfDay(9);
		calendar.setLastVisibleHourOfDay(22);
        java.util.Calendar initialView = java.util.Calendar.getInstance();
        initialView.add(java.util.Calendar.DAY_OF_WEEK,
                -initialView.get(java.util.Calendar.DAY_OF_WEEK) + 1);
        calendar.setStartDate(initialView.getTime());

        initialView.add(java.util.Calendar.DAY_OF_WEEK, 6);
        calendar.setEndDate(initialView.getTime());

        return calendarLayout;
	}
	

	
	
	@Override
	public void enter(ViewChangeEvent event) 
	{
		// TODO Auto-generated method stub
		
	}

}
