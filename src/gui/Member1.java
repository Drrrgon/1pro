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

public class Member1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtMember1, txtMember2;
	private JLabel label, label_1, lblCafe;
	private JButton btnMember3;
	private JButton btnMember2;

	/**
	 * Create the frame.
	 */
	public Member1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 이름");
		label.setBounds(140, 156, 96, 16);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		contentPane.add(label);
		
		label_1 = new JLabel("2. 전화번호");
		label_1.setBounds(140, 216, 96, 16);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		contentPane.add(label_1);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(280, 41, 83, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		contentPane.add(lblCafe);
		
		btnMember3 = new JButton("HOME");
		btnMember3.setBounds(555, 406, 79, 46);
		btnMember3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember3.addActionListener(this);
		btnMember3.setForeground(Color.BLACK);
		contentPane.add(btnMember3);
		
		txtMember1 = new JTextField();
		txtMember1.setBounds(248, 151, 183, 26);
		txtMember1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		contentPane.add(txtMember1);
		txtMember1.setColumns(10);
		
		txtMember2 = new JTextField();
		txtMember2.setBounds(248, 211, 183, 26);
		txtMember2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		txtMember2.setColumns(10);
		contentPane.add(txtMember2);
		
		btnMember2 = new JButton("회원 등록");
		btnMember2.setBounds(267, 274, 96, 39);
		btnMember2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember2.addActionListener(this);
		btnMember2.setForeground(Color.BLACK);
		contentPane.add(btnMember2);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnMember2){
			JOptionPane.showConfirmDialog(resource, "회원등록되었습니다.", "회원등록", JOptionPane.PLAIN_MESSAGE);
		}
		if(resource == btnMember3){
			this.dispose();
			Home home = new Home();
			home.setVisible(true);
		}
	}
}
