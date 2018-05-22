package gui.login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import gui.login.listener.LoginFrameListener;
import gui.main.MainFrame;
import system.DAO.imp.CafeDAOImp;
import java.awt.Font;
import java.awt.Toolkit;

public class LoginFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	public JTextField login;
	public JPasswordField passwordField;
	public JButton loginButton;
	private CafeDAOImp cafeDAOImp;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/icon/login.png")));
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
		login.setBounds(243, 151, 116, 24);
		contentPane.add(login);
		login.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(243, 187, 116, 24);
		contentPane.add(passwordField);
		
		JLabel title = new JLabel("");
		title.setIcon(new ImageIcon(LoginFrame.class.getResource("/icon/login.png")));
		title.setBounds(39, 6, 142, 130);
		contentPane.add(title);
		
		JLabel id = new JLabel("ID");
		id.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		id.setBounds(49, 152, 78, 24);
		contentPane.add(id);
		id.addKeyListener(new LoginFrameListener(this));
		
		JLabel password = new JLabel("PASSWORD");
		password.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		password.setBounds(49, 187, 132, 24);
		contentPane.add(password);
		password.addKeyListener(new LoginFrameListener(this));
		
		loginButton = new JButton("LOGIN");
		loginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		loginButton.setBounds(153, 223, 78, 36);
		contentPane.add(loginButton);
		loginButton.addActionListener(new LoginFrameListener(this));
		
		
		lblNewLabel = new JLabel("Cafe24 Login");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(209, 65, 162, 27);
		contentPane.add(lblNewLabel);
		
		SwingUtilities.getRootPane(loginButton).setDefaultButton(loginButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
}
