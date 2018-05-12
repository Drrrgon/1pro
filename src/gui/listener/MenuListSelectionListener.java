package gui.listener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.MenuFrame;
import system.DAO.imp.CafeDAOImp;

public class MenuListSelectionListener implements ListSelectionListener {
	MenuFrame menuFrame;
	CafeDAOImp cafeDAOImp; 
	public MenuListSelectionListener(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
		cafeDAOImp = new CafeDAOImp();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == menuFrame.menuList)
        {
            String str = (String)menuFrame.menuList.getSelectedValue();
            menuFrame.resultField.setText(str+"을 선택 하셨습니다");
        }
	}
}
