package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vo.MenuVo;

public class Order2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtOrder1, txtOrder2;
	private JLabel label, label_1, label_2, lblCafe;
	private JButton btnOrder6, btnOrder7, btnOrder8;
	private JRadioButton rdbtnOrder3, rdbtnOrder4;	
	private ButtonGroup radioButtonGroup = new ButtonGroup();
	private MenuVo selectedMenu;
	private int count;	

	/**
	 * Create the frame.
	 */
	public Order2(MenuVo selectedMenu, int count) {
		this.selectedMenu = selectedMenu;
		this.count = count;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 회원 전화번호");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(107, 122, 120, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 잔여 마일리지");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_1.setBounds(107, 187, 120, 16);
		contentPane.add(label_1);
		
		label_2 = new JLabel("3. 적립/사용");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_2.setBounds(107, 259, 120, 16);
		contentPane.add(label_2);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(276, 30, 90, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		contentPane.add(lblCafe);
		
		btnOrder8 = new JButton(">>");
		btnOrder8.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder8.setBounds(555, 417, 79, 35);
		btnOrder8.setForeground(Color.BLACK);
		contentPane.add(btnOrder8);
		btnOrder8.addActionListener(this);
		
		rdbtnOrder3 = new JRadioButton("적립");
		rdbtnOrder3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		radioButtonGroup.add(rdbtnOrder3);
		rdbtnOrder3.setBounds(271, 260, 71, 23);
		contentPane.add(rdbtnOrder3);
		
		rdbtnOrder4 = new JRadioButton("사용");
		rdbtnOrder4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		radioButtonGroup.add(rdbtnOrder4);
		rdbtnOrder4.setBounds(354, 260, 69, 23);
		contentPane.add(rdbtnOrder4);
		
		btnOrder7 = new JButton("<<");
		btnOrder7.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder7.addActionListener(this);
		btnOrder7.setBounds(6, 417, 79, 35);
		btnOrder7.setForeground(Color.BLACK);
		contentPane.add(btnOrder7);
		
		txtOrder1 = new JTextField();
		txtOrder1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		txtOrder1.setBounds(271, 117, 190, 26);
		contentPane.add(txtOrder1);
		txtOrder1.setColumns(10);
		
		btnOrder6 = new JButton("검색");
		btnOrder6.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder6.setForeground(Color.BLACK);
		btnOrder6.setBounds(473, 117, 69, 29);
		contentPane.add(btnOrder6);
		
		txtOrder2 = new JTextField();
		txtOrder2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		txtOrder2.setColumns(10);
		txtOrder2.setBounds(271, 182, 190, 26);
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
//			Order3 o3 = new Order3();
//			o3.setVisible(true);
		}
	}
}
