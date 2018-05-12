package gui.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;

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
		case "reg":
			MenuVo temp= new MenuVo();
			temp.setmName(menuFrame.txtMenuname.getText());
			temp.setmPrice(Integer.parseInt(menuFrame.txtMenuprice.getText()));
			temp.setmOriginalPrice(Integer.parseInt(menuFrame.originalPrice.getText()));			
			if(cafeDAOImp.insertMenu(temp) == 0) {
				menuFrame.resultField.setText("메뉴 추가 실패");
			}else {
				menuFrame.resultField.setText("메뉴 추가 성공");
				menuFrame.modelMenuList.addElement(temp.toString());
			}					
			break;
			
		case "del":
			MenuVo temp2= new MenuVo();
			menuFrame.menuList.getSelectedIndex();
			break;
		default:
			break;
		}
	}

}
