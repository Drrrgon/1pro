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
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class Order2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtOrder1, txtOrder2;
	private JLabel label, label_1, label_2, lblCafe;
	private JButton btnOrder6, btnOrder7, btnOrder8;
	private JRadioButton rdbtnOrder3, rdbtnOrder4;
	private final ButtonGroup radioButtonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public Order2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 회원 전화번호");
		label.setBounds(30, 85, 96, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 잔여 마일리지");
		label_1.setBounds(30, 132, 96, 16);
		contentPane.add(label_1);
		
		label_2 = new JLabel("3. 적립/사용");
		label_2.setBounds(30, 176, 79, 16);
		contentPane.add(label_2);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(187, 23, 69, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblCafe);
		
		btnOrder8 = new JButton(">>");
		btnOrder8.setBounds(365, 243, 79, 29);
		btnOrder8.setForeground(Color.BLACK);
		contentPane.add(btnOrder8);
		btnOrder8.addActionListener(this);
		
		rdbtnOrder3 = new JRadioButton("적립");
		radioButtonGroup.add(rdbtnOrder3);
		rdbtnOrder3.setBounds(138, 172, 61, 23);
		contentPane.add(rdbtnOrder3);
		
		rdbtnOrder4 = new JRadioButton("사용");
		radioButtonGroup.add(rdbtnOrder4);
		rdbtnOrder4.setBounds(202, 172, 69, 23);
		contentPane.add(rdbtnOrder4);
		
		btnOrder7 = new JButton("<<");
		btnOrder7.addActionListener(this);
		btnOrder7.setBounds(6, 243, 79, 29);
		btnOrder7.setForeground(Color.BLACK);
		contentPane.add(btnOrder7);
		
		txtOrder1 = new JTextField();
		txtOrder1.setBounds(138, 80, 152, 26);
		contentPane.add(txtOrder1);
		txtOrder1.setColumns(10);
		
		btnOrder6 = new JButton("검색");
		btnOrder6.setForeground(Color.BLACK);
		btnOrder6.setBounds(291, 80, 52, 29);
		contentPane.add(btnOrder6);
		
		txtOrder2 = new JTextField();
		txtOrder2.setColumns(10);
		txtOrder2.setBounds(138, 127, 96, 26);
		contentPane.add(txtOrder2);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnOrder7){
			this.dispose();
			Order1 o1 = new Order1();
			o1.setVisible(true);
		}
		if(resource == btnOrder8){
			this.dispose();
			Order3 o3 = new Order3();
			o3.setVisible(true);
		}
	}
}
