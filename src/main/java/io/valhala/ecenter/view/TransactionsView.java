package io.valhala.ecenter.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;

@SpringComponent
@SpringView(name = TransactionsView.VIEW_NAME)
public class TransactionsView implements View
{

	public static final String VIEW_NAME = "Transactions";
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
