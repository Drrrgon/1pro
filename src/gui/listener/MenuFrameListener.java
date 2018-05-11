package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import gui.MenuFrame;
import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;

public class MenuFrameListener implements ActionListener{
	MenuFrame menuFrame;
	CafeDAOImp cafeDAOImp; 
	
	public MenuFrameListener(MenuFrame menuFrame){
		this.menuFrame = menuFrame;
		cafeDAOImp = new CafeDAOImp();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "print":
						
			List<MenuVo> list = cafeDAOImp.getAllMenu();
			String temp[]= new String[list.size()+1];
			for(int i = 0 ; i < list.size() ; i ++) {
				temp[i] = list.get(i).toString();			
			}
			menuFrame.list.setListData(temp);
			menuFrame.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			break;

		default:
			break;
		}
	}

}
