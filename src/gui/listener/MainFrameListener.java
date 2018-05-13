package gui.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;

import org.apache.ibatis.session.SqlSession;

import gui.Main;
import gui.MenuFrame;
import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;

public class MainFrameListener implements ActionListener{
	Main main;
	CafeDAOImp cafeDAOImp; 
	
	
	public MainFrameListener(Main Main){
		this.main = main;
		cafeDAOImp = new CafeDAOImp();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "메뉴":
			
			break;
			
		
		default:
			break;
		}
	}

}
