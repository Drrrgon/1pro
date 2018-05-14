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

public class Member2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtMember3, txtMember4;
	private JLabel label, label_1, lblCafe;
	private JButton btnMember6;
	private JButton btnMember5;
	private JButton btnMember4;

	/**
	 * Create the frame.
	 */
	public Member2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 전화번호");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(143, 153, 96, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 회원 이름");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_1.setBounds(143, 216, 96, 16);
		contentPane.add(label_1);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(269, 37, 95, 38);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		contentPane.add(lblCafe);
		
		btnMember6 = new JButton("HOME");
		btnMember6.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember6.addActionListener(this);
		btnMember6.setBounds(555, 414, 79, 38);
		btnMember6.setForeground(Color.BLACK);
		contentPane.add(btnMember6);
		
		txtMember3 = new JTextField();
		txtMember3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		txtMember3.setBounds(251, 148, 183, 26);
		contentPane.add(txtMember3);
		txtMember3.setColumns(10);
		
		txtMember4 = new JTextField();
		txtMember4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		txtMember4.setColumns(10);
		txtMember4.setBounds(251, 211, 183, 26);
		contentPane.add(txtMember4);
		
		btnMember5 = new JButton("회원 삭제");
		btnMember5.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember5.addActionListener(this);
		btnMember5.setForeground(Color.BLACK);
		btnMember5.setBounds(269, 273, 86, 38);
		contentPane.add(btnMember5);
		
		btnMember4 = new JButton("검색");
		btnMember4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember4.setForeground(Color.BLACK);
		btnMember4.setBounds(446, 143, 50, 38);
		contentPane.add(btnMember4);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnMember5){
			JOptionPane.showConfirmDialog(resource, "회원삭제되었습니다.", "회원삭제", JOptionPane.PLAIN_MESSAGE);
		}
		if(resource == btnMember6){
			this.dispose();
			Home home = new Home();
			home.setVisible(true);
		}
	}
}
