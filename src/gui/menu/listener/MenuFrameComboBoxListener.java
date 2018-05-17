package gui.menu.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.order.OrderFrame;

public class MenuFrameComboBoxListener implements ActionListener{
	public OrderFrame orderFrame;
	public MenuFrameComboBoxListener(OrderFrame orderFrame) {
		this.orderFrame = orderFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {		
	}
}
