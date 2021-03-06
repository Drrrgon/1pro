package gui.menu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import gui.menu.MenuFrame;
import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;

public class MenuFrameButtonListener implements ActionListener{
	MenuFrame menuFrame;
	CafeDAOImp cafeDAOImp; 
	
	
	public MenuFrameButtonListener(MenuFrame menuFrame){
		this.menuFrame = menuFrame;
		cafeDAOImp = CafeDAOImp.getInstance();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "등록":
			List<MenuVo> tempList = (List<MenuVo>) menuFrame.getMenuVoList();
			MenuVo temp= new MenuVo();
			temp.setmName(menuFrame.txtMenuname.getText());
			temp.setmPrice(Integer.parseInt(menuFrame.txtMenuprice.getText()));
			temp.setmOriginalPrice(Integer.parseInt(menuFrame.originalPrice.getText()));	
			menuFrame.txtMenuname.setText("");
			menuFrame.txtMenuprice.setText("");
			menuFrame.originalPrice.setText("");
			if(cafeDAOImp.insertMenu(temp) == 0) {
				menuFrame.resultField.setText("메뉴 추가 실패");
			}else {
				menuFrame.resultField.setText("메뉴 추가 성공");
				temp.setMenuNo(temp.getMenuNo());
				menuFrame.modelMenuList.addElement(temp.toString());
				tempList.add(temp);
			}					
			break;
			
		case "삭제":
			MenuVo temp2= new MenuVo();
			List<MenuVo> tempList2 = (List<MenuVo>) menuFrame.getMenuVoList();
			temp2 = (tempList2.get(menuFrame.menuList.getSelectedIndex()));
			if(cafeDAOImp.deleteMenu(temp2) ==0) {
				menuFrame.resultField.setText("메뉴 삭제 실패");
			}else {
				menuFrame.resultField.setText("메뉴 삭제 성공");
				tempList2.remove(temp2);
				menuFrame.modelMenuList.removeElementAt(menuFrame.menuList.getSelectedIndex());
				menuFrame.setCursor(0);
			}
			break;
		default:
			break;
		}
	}

}
