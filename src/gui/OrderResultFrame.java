package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vo.MemberVo;
import vo.OrdersVo;

public class OrderResultFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtOrder1, txtOrder2;
	private JLabel label, label_1, lblCafe;
	private JButton btnOrder9;
	private JLabel label_2;
	private OrdersVo order;
	private MemberVo member;
	/**
	 * Create the frame.
	 */
	public OrderResultFrame(OrdersVo order, MemberVo member) {
		setTitle("주문 확인");
		this.order = order;
		this.member = member;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 주문번호");
		label.setFont(new Font("Dialog", Font.PLAIN, 17));
		label.setBounds(179, 214, 96, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 잔여 마일리지");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_1.setBounds(179, 274, 127, 16);
		contentPane.add(label_1);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(274, 34, 80, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		contentPane.add(lblCafe);
		
		btnOrder9 = new JButton("HOME");
		btnOrder9.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnOrder9.addActionListener(this);
		btnOrder9.setBounds(555, 411, 79, 41);
		btnOrder9.setForeground(Color.BLACK);
		contentPane.add(btnOrder9);
		
		txtOrder1 = new JTextField();
		txtOrder1.setEditable(false);
		txtOrder1.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtOrder1.setBounds(318, 209, 153, 26);
		contentPane.add(txtOrder1);
		txtOrder1.setColumns(10);
		txtOrder1.setText(order.toString());
		
		txtOrder2 = new JTextField();
		txtOrder2.setEditable(false);
		txtOrder2.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtOrder2.setColumns(10);
		txtOrder2.setBounds(318, 269, 153, 26);
		contentPane.add(txtOrder2);
		if(member != null) {
			txtOrder2.setText(member.getmBonus()+"");
		}
		
		
		label_2 = new JLabel("주문완료!");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_2.setBounds(285, 137, 80, 16);
		contentPane.add(label_2);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnOrder9){
			this.dispose();
			MainFrame home = new MainFrame();
			home.setVisible(true);
		}
	}
}