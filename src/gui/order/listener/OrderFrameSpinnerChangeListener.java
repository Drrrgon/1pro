package gui.order.listener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.order.OrderFrame;

public class OrderFrameSpinnerChangeListener implements ChangeListener {
	private OrderFrame orderFrame;
	private int countValue;
	public OrderFrameSpinnerChangeListener(OrderFrame orderFrame) {
		this.orderFrame = orderFrame;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == orderFrame.spinner) {
			System.out.println(orderFrame.spinner.getValue());
			countValue = (int)orderFrame.spinner.getValue();		
		}
	}
	/**
	 * @return Integer
	 * 라디오 버튼의 선택된 값을 반환합니다.
	 */
	public int getCountValue() {
		return countValue;
	}
}