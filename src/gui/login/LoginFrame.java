package gui.login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.main.MainFrame;
import system.DAO.imp.CafeDAOImp;
import java.awt.Font;

public class LoginFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField login;
	private JPasswordField passwordField;
	private JButton loginButton;
	private CafeDAOImp cafeDAOImp;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
		cafeDAOImp = CafeDAOImp.getInstance();
		setTitle("LoginPage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		login = new JTextField();
		login.setBounds(205, 151, 116, 24);
		contentPane.add(login);
		login.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205, 187, 116, 24);
		contentPane.add(passwordField);
		
		JLabel title = new JLabel("");
		title.setIcon(new ImageIcon(LoginFrame.class.getResource("/gui/login/login.png")));
		title.setBounds(39, 6, 142, 130);
		contentPane.add(title);
		
		JLabel id = new JLabel("ID");
		id.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		id.setBounds(105, 151, 78, 24);
		contentPane.add(id);
		
		JLabel password = new JLabel("PASSWORD");
		password.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		password.setBounds(105, 187, 78, 24);
		contentPane.add(password);
		
		loginButton = new JButton("LOGIN");
		loginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		loginButton.setBounds(153, 223, 78, 36);
		contentPane.add(loginButton);
		
		lblNewLabel = new JLabel("Cafe24 Login");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(209, 65, 162, 27);
		contentPane.add(lblNewLabel);
		loginButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == loginButton) {
			char[] d = passwordField.getPassword();
			
			String str = "";
			for(int i = 0 ; i< d.length ; i ++) {
				str+=d[i];
			}
			boolean resultLogin = cafeDAOImp.matching(login.getText(), str);
			if(resultLogin) {				
				MainFrame main = new MainFrame();
				this.dispose();
				main.setVisible(true);
			}else {
				JOptionPane.showConfirmDialog(resource, "잘못된 입력","입력 오류", JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		
	}
}
