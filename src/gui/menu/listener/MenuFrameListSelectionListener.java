package gui.listener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.MenuFrame;
import system.DAO.imp.CafeDAOImp;

public class MenuListSelectionListener0 implements ListSelectionListener {
	MenuFrame menuFrame;
	CafeDAOImp cafeDAOImp; 
	public MenuListSelectionListener0(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
		cafeDAOImp = CafeDAOImp.getInstance();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == menuFrame.menuList)
        {
            String str = (String)menuFrame.menuList.getSelectedValue();
            menuFrame.resultField.setText(str);
        }
	}
}
