package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vo.OrdersVo;

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

public class Order3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtOrder1, txtOrder2;
	private JLabel label, label_1, lblCafe;
	private JButton btnOrder9;
	private JLabel label_2;
	private OrdersVo order;
	/**
	 * Create the frame.
	 */
	public Order3(OrdersVo order) {
		setTitle("주문 확인");
		this.order = order;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 주문번호");
		label.setBounds(14, 130, 96, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 잔여 마일리지");
		label_1.setBounds(14, 177, 107, 16);
		contentPane.add(label_1);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(274, 23, 69, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblCafe);
		
		btnOrder9 = new JButton("HOME");
		btnOrder9.addActionListener(this);
		btnOrder9.setBounds(541, 404, 79, 29);
		btnOrder9.setForeground(Color.BLACK);
		contentPane.add(btnOrder9);
		
		txtOrder1 = new JTextField();
		txtOrder1.setEditable(false);
		txtOrder1.setBounds(134, 125, 445, 26);
		contentPane.add(txtOrder1);
		txtOrder1.setColumns(10);
		txtOrder1.setText(order.toString());
		
		txtOrder2 = new JTextField();
		txtOrder2.setEditable(false);
		txtOrder2.setColumns(10);
		txtOrder2.setBounds(135, 172, 96, 26);
		contentPane.add(txtOrder2);
//		txtOrder2.setText(order.toString());
		
		label_2 = new JLabel("주문완료!");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_2.setBounds(245, 177, 69, 16);
		contentPane.add(label_2);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnOrder9){
			this.dispose();
			Home home = new Home();
			home.setVisible(true);
		}
	}
}
