package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class Menu1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtMenu1, txtMenu2;
	private JLabel label, label_1, lblCafe;
	private JButton btnMember4;
	private JButton btnMenu2;
	private JButton btnMenu3;

	/**
	 * Create the frame.
	 */
	public Menu1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 메뉴 이름");
		label.setBounds(112, 81, 96, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 메뉴 가격");
		label_1.setBounds(112, 128, 96, 16);
		contentPane.add(label_1);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(187, 23, 69, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblCafe);
		
		btnMember4 = new JButton("HOME");
		btnMember4.addActionListener(this);
		btnMember4.setBounds(365, 243, 79, 29);
		btnMember4.setForeground(Color.BLACK);
		contentPane.add(btnMember4);
		
		txtMenu1 = new JTextField();
		txtMenu1.setBounds(220, 76, 130, 26);
		contentPane.add(txtMenu1);
		txtMenu1.setColumns(10);
		
		txtMenu2 = new JTextField();
		txtMenu2.setColumns(10);
		txtMenu2.setBounds(220, 123, 130, 26);
		contentPane.add(txtMenu2);
		
		btnMenu2 = new JButton("메뉴등록");
		btnMenu2.addActionListener(this);
		btnMenu2.setForeground(Color.BLACK);
		btnMenu2.setBounds(142, 183, 79, 29);
		contentPane.add(btnMenu2);
		
		btnMenu3 = new JButton("메뉴삭제");
		btnMenu3.addActionListener(this);
		btnMenu3.setForeground(Color.BLACK);
		btnMenu3.setBounds(220, 183, 79, 29);
		contentPane.add(btnMenu3);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnMenu2){
			JOptionPane.showConfirmDialog(resource, "메뉴가 등록되었습니다.", "메뉴등록", JOptionPane.PLAIN_MESSAGE);
		}
		if(resource == btnMenu3){
			JOptionPane.showConfirmDialog(resource, "메뉴가 삭제되었습니다.", "메뉴삭제", JOptionPane.PLAIN_MESSAGE);
		}
		if(resource == btnMember4){
			this.dispose();
			Home home = new Home();
			home.setVisible(true);
		}
	}
}
