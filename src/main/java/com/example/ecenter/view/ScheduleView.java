package com.example.ecenter.view;

import java.util.Date;
import java.util.List;

import com.example.ecenter.Client;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.v7.ui.Calendar;
import com.vaadin.v7.ui.components.calendar.event.CalendarEvent;
import com.vaadin.v7.ui.components.calendar.event.CalendarEventProvider;
import com.vaadin.v7.ui.components.calendar.handler.BasicEventMoveHandler;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Button.ClickEvent;

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
	
		tray = buildTray();
		
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
		
	/*	calendar.setHandler(new BasicEventMoveHandler() {
			@Override
			public void eventMove(final MoveEvent event) 
			{
				CalendarEvent calendarEvent = event.getCalendarEvent();
				if(CalendarEvent instanceof Appointment)
				{
					Appointment editableEvent = (Appointment) calendarEvent;
					
					Date newFromTime = event.getNewStart();
					
					long length = editableEvent.getEnd().getTime() - editableEvent.getStart().getTime();
					setDates(editableEvent, newFromTime, new Date(newFromTime.getTime() + length));
					setTrayVisible(true);
				}
			}
		}); */
		
        java.util.Calendar initialView = java.util.Calendar.getInstance();
        initialView.add(java.util.Calendar.DAY_OF_WEEK,
                -initialView.get(java.util.Calendar.DAY_OF_WEEK) + 1);
        calendar.setStartDate(initialView.getTime());

        initialView.add(java.util.Calendar.DAY_OF_WEEK, 6);
        calendar.setEndDate(initialView.getTime());

        return calendarLayout;
	}
	
    private Component buildTray() {
        final HorizontalLayout tray = new HorizontalLayout();
        tray.setWidth(100.0f, Unit.PERCENTAGE);
        tray.addStyleName("tray");
        tray.setSpacing(true);
        tray.setMargin(true);

        Label warning = new Label(
                "You have unsaved changes made to the schedule");
        warning.addStyleName("warning");
        warning.addStyleName("icon-attention");
        tray.addComponent(warning);
        tray.setComponentAlignment(warning, Alignment.MIDDLE_LEFT);
        tray.setExpandRatio(warning, 1);

        ClickListener close = new ClickListener() {
            @Override
            public void buttonClick(final ClickEvent event) {
                setTrayVisible(false);
            }
        };

        Button confirm = new Button("Confirm");
        confirm.addStyleName(ValoTheme.BUTTON_PRIMARY);
        confirm.addClickListener(close);
        tray.addComponent(confirm);
        tray.setComponentAlignment(confirm, Alignment.MIDDLE_LEFT);

        Button discard = new Button("Discard");
        discard.addClickListener(close);
        discard.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(final ClickEvent event) {
                calendar.markAsDirty();
            }
        });
        tray.addComponent(discard);
        tray.setComponentAlignment(discard, Alignment.MIDDLE_LEFT);
        return tray;
    }
	
    private void setTrayVisible(final boolean visible) {
        final String styleReveal = "v-animate-reveal";
        if (visible) {
            tray.addStyleName(styleReveal);
        } else {
            tray.removeStyleName(styleReveal);
        }
    }
    
    /*@Subscribe
    public void browserWindowResized(final BrowserResizeEvent event) {
        if (Page.getCurrent().getBrowserWindowWidth() < 800) {
            calendar.setEndDate(calendar.getStartDate());
        }
    }*/
    
	
	@Override
	public void enter(ViewChangeEvent event) 
	{
		// TODO Auto-generated method stub
		
	}
	
	private class AppointmentProvider implements CalendarEventProvider 
	{
		@Override
		public List<CalendarEvent> getEvents(final Date startDate, final Date endDate)
		{
			return null;
			
		}
	}
	
	public final class Appointment implements CalendarEvent
	{
		private Client client;
		private Date start;
		private Date end;
		
		public Appointment(final Client client, final Date start, final Date end) 
		{
			this.client = client;
			this.start = start;
			this.end = end;
		}
		
		public Client getClient()
		{
			return client;
		}
		
		public void setStart(Date start)
		{
			this.start = start;
		}
		
		public void setEnd(Date end)
		{
			this.end = end;
		}

		@Override
		public String getCaption() 
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getDescription() 
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Date getEnd() 
		{
			return end;
		}

		@Override
		public Date getStart() 
		{
			return start;
		}

		@Override
		public String getStyleName() 
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isAllDay() 
		{
			// TODO Auto-generated method stub
			return false;
		}
		
	}

}
