package gui.order.listener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import gui.order.OrderDeleteFrame;
import system.DAO.imp.CafeDAOImp;

public class OrderDeleteFrameListSelectionListener implements ListSelectionListener {
	OrderDeleteFrame orderDeleteFrame;
	CafeDAOImp cafeDAOImp; 
	public OrderDeleteFrameListSelectionListener(OrderDeleteFrame orderDeleteFrame) {
		this.orderDeleteFrame = orderDeleteFrame;
		cafeDAOImp = CafeDAOImp.getInstance();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == orderDeleteFrame.listOrder1)
        {
            String str = (String)orderDeleteFrame.listOrder1.getSelectedValue();
            orderDeleteFrame.txtOrder5.setText(str);
        }
	}
}
