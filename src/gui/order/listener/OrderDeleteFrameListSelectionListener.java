package gui.listener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.OrderDeleteFrame;
import system.DAO.imp.CafeDAOImp;

public class MenuListSelectionListener2 implements ListSelectionListener {
	OrderDeleteFrame order4;
	CafeDAOImp cafeDAOImp; 
	public MenuListSelectionListener2(OrderDeleteFrame order4) {
		this.order4 = order4;
		cafeDAOImp = CafeDAOImp.getInstance();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == order4.listOrder1)
        {
            String str = (String)order4.listOrder1.getSelectedValue();
            order4.txtOrder5.setText(str);
        }
	}
}
