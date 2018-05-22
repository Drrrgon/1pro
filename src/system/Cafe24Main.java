package system;

import gui.login.LoginFrame;

public class Cafe24Main {
	public static void main(String[] args) {
		try {
			LoginFrame frame = new LoginFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
