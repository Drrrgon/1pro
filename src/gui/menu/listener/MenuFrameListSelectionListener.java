package gui.menu.listener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import gui.menu.MenuFrame;
import system.DAO.imp.CafeDAOImp;

public class MenuFrameListSelectionListener implements ListSelectionListener {
	MenuFrame menuFrame;
	CafeDAOImp cafeDAOImp; 
	public MenuFrameListSelectionListener(MenuFrame menuFrame) {
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
