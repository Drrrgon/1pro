package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import gui.OrderFrame;
import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;

public class ComboBoxListener implements ActionListener{
	public OrderFrame order1;
	public MenuVo menuSelected;
	private CafeDAOImp cafeDAOImp = CafeDAOImp.getInstance();
	public ComboBoxListener(OrderFrame order1) {
		this.order1 = order1;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource().equals(order1.cbOrder1)) {
//			JComboBox jb = (JComboBox)e.getSource();
//			System.out.println(jb.getSelectedItem());
//			System.out.println((MenuVo)order1.cbOrder1.getSelectedItem());
//			menuSelected=(MenuVo)order1.cbOrder1.getSelectedItem();
//		}
		
	}
	public MenuVo getSelectedItem() {
		return menuSelected;
	}

}
