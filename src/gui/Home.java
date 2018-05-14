package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnExit;
	private JButton btnOrder1, btnOrder2, btnOrder3, btnSale1, btnMenu1, btnMenu2, btnMember1, btnMember2;
	private JLabel label, label_1, label_2, label_3, lblCafe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setResizable(false);
		setTitle("Cafe24");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOrder1 = new JButton("주문등록");
		btnOrder1.setBounds(114, 80, 99, 29);
		contentPane.add(btnOrder1);
		btnOrder1.addActionListener(this);
		
		btnOrder2 = new JButton("주문취소");
		btnOrder2.setBounds(225, 80, 99, 29);
		contentPane.add(btnOrder2);
		btnOrder2.addActionListener(this);
	
		btnOrder3 = new JButton("주문현황");
		btnOrder3.setBounds(336, 80, 99, 29);
		contentPane.add(btnOrder3);
		btnOrder3.addActionListener(this);
		
		label = new JLabel("1. 주문관리");
		label.setBounds(30, 85, 79, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 매출관리");
		label_1.setBounds(30, 132, 79, 16);
		contentPane.add(label_1);
		
		btnSale1 = new JButton("일별/월별 매출 조회");
		btnSale1.addActionListener(this);
		btnSale1.setBounds(114, 127, 142, 29);
		contentPane.add(btnSale1);
		
		label_2 = new JLabel("3. 메뉴관리");
		label_2.setBounds(30, 176, 79, 16);
		contentPane.add(label_2);
		
		btnMenu1 = new JButton("메뉴 등록/삭제");		
		btnMenu1.setBounds(114, 171, 142, 29);
		contentPane.add(btnMenu1);
		btnMenu1.addActionListener(this);
		
		label_3 = new JLabel("4. 회원관리");
		label_3.setBounds(30, 217, 79, 16);
		contentPane.add(label_3);
		
		btnMember2 = new JButton("회원삭제");
		btnMember2.setBounds(225, 212, 99, 29);
		contentPane.add(btnMember2);
		btnMember2.addActionListener(this);
		
		btnMember1 = new JButton("회원등록");
		btnMember1.setBounds(114, 212, 99, 29);
		contentPane.add(btnMember1);
		btnMember1.addActionListener(this);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(187, 23, 69, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblCafe);
		
//	    btnExit = new JButton("종료");
//		btnExit.setBounds(365, 243, 79, 29);
//		btnExit.setForeground(Color.RED);
//		contentPane.add(btnExit);
//		btnExit.addActionListener(this);
		
//		btnMenu2 = new JButton("메뉴 전체 조회");
//		btnMenu2.setBounds(268, 171, 142, 29);
//		contentPane.add(btnMenu2);
//		btnMenu2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton)e.getSource();
		if(resource == btnExit){
			this.dispose();
		}
		if(resource == btnOrder1){
			this.dispose();
			Order1 o1 = new Order1();
			o1.setVisible(true);
		}
		/*
		if(resource == btnMenu1){
			System.out.println("3");
			this.dispose();
			MenuFrame mF = new MenuFrame();
			mF.setVisible(true);
		}
		*/
		if(resource == btnOrder2){
			this.dispose();
			Order4 o4 = new Order4();
			o4.setVisible(true);
		}
		if(resource == btnOrder3){
			this.dispose();
			Order5 o5 = new Order5();
			o5.setVisible(true);
		}
		if(resource == btnSale1){
			this.dispose();
			Sale1 s1 = new Sale1();
			s1.setVisible(true);
		}
		if(resource == btnMenu1){
			this.dispose();
			MenuFrame m1 = new MenuFrame();
			m1.setVisible(true);
		}
		if(resource == btnMenu2){
			this.dispose();
			Menu2 m2 = new Menu2();
			m2.setVisible(true);
		}
		if(resource == btnMember1){
			this.dispose();
			Member1 mem1 = new Member1();
			mem1.setVisible(true);
		}
		if(resource == btnMember2){
			this.dispose();
			Member2 mem2 = new Member2();
			mem2.setVisible(true);
		}
	}
}
