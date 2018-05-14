package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.Order1;

public class SpinnerChangeListener implements ChangeListener {
	private Order1 order1;
	private int countValue;
	public SpinnerChangeListener(Order1 order1) {
		this.order1 = order1;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == order1.spinner) {
			System.out.println(order1.spinner.getValue());
			countValue = (int)order1.spinner.getValue();		
		}
	}
	
	public int getCountValue() {
		return countValue;
	}
}