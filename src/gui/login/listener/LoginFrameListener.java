package gui.login.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import gui.login.LoginFrame;
import gui.main.MainFrame;
import system.DAO.imp.CafeDAOImp;

public class LoginFrameListener implements ActionListener, KeyListener{
	private LoginFrame loginFrame;
	private CafeDAOImp cafeDAOImp;
	
	public LoginFrameListener(LoginFrame loginFrame){
		this.loginFrame = loginFrame;
		cafeDAOImp = CafeDAOImp.getInstance();
	}
	@Override
	public void keyTyped(KeyEvent a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_ENTER) {			
			char[] d = loginFrame.passwordField.getPassword();			
			String str = "";
			for(int i = 0 ; i< d.length ; i ++) {
				str+=d[i];
			}
			boolean resultLogin = cafeDAOImp.matching(loginFrame.login.getText(), str);
			if(resultLogin) {				
				MainFrame main = new MainFrame();
				loginFrame.dispose();
				main.setVisible(true);
			}else {
				JOptionPane.showConfirmDialog(loginFrame, "잘못된 입력","입력 오류", JOptionPane.PLAIN_MESSAGE);
			}
		}		
	}

	@Override
	public void keyReleased(KeyEvent a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() =="LOGIN") {
			char[] d = loginFrame.passwordField.getPassword();
			
			String str = "";
			for(int i = 0 ; i< d.length ; i ++) {
				str+=d[i];
			}
			boolean resultLogin = cafeDAOImp.matching(loginFrame.login.getText(), str);
			if(resultLogin) {				
				MainFrame main = new MainFrame();
				loginFrame.dispose();
				main.setVisible(true);
			}else {
				JOptionPane.showConfirmDialog(loginFrame, "잘못된 입력","입력 오류", JOptionPane.PLAIN_MESSAGE);
			}	
		}		
	}
}
