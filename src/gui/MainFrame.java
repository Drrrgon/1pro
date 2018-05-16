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

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnExit;
	private JButton btnOrder1, btnOrder2, btnSale1, btnMenu1, btnMenu2, btnMember1, btnMember2;
	private JLabel label, lblCafe;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setResizable(false);
		setTitle("Cafe24");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOrder1 = new JButton("주문 등록");
		btnOrder1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder1.setBounds(216, 113, 117, 44);
		contentPane.add(btnOrder1);
		btnOrder1.addActionListener(this);
		
		btnOrder2 = new JButton("주문 현황/취소");
		btnOrder2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder2.setBounds(347, 113, 144, 44);
		contentPane.add(btnOrder2);
		btnOrder2.addActionListener(this);
		
		label = new JLabel("1. 주문관리");
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		label.setBounds(92, 120, 110, 29);
		contentPane.add(label);
		
		btnSale1 = new JButton("일별 / 월별 매출 조회");
		btnSale1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnSale1.addActionListener(this);
		btnSale1.setBounds(214, 186, 277, 44);
		contentPane.add(btnSale1);
		
		btnMenu1 = new JButton("메뉴 등록/ 삭제");		
		btnMenu1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMenu1.setBounds(216, 260, 275, 44);
		contentPane.add(btnMenu1);
		btnMenu1.addActionListener(this);
		
		btnMember2 = new JButton("회원삭제");
		btnMember2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember2.setBounds(359, 341, 132, 44);
		contentPane.add(btnMember2);
		btnMember2.addActionListener(this);
		
		btnMember1 = new JButton("회원등록");
		btnMember1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember1.setBounds(216, 341, 132, 44);
		contentPane.add(btnMember1);
		btnMember1.addActionListener(this);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(227, 28, 162, 44);
		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 50));
		contentPane.add(lblCafe);
		
		label_5 = new JLabel("3. 메뉴관리");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 20));
		label_5.setBounds(92, 267, 110, 29);
		contentPane.add(label_5);
		
		label_6 = new JLabel("4. 주문관리");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 20));
		label_6.setBounds(92, 348, 110, 29);
		contentPane.add(label_6);
		
		label_7 = new JLabel("2. 주문관리");
		label_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		label_7.setBounds(92, 193, 110, 29);
		contentPane.add(label_7);
		
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
			OrderFrame o1 = new OrderFrame();
			o1.setVisible(true);
		}
		if(resource == btnOrder2){
			this.dispose();
			OrderDeleteFrame o4 = new OrderDeleteFrame();
			o4.setVisible(true);
		}
		if(resource == btnSale1){
			this.dispose();
			SaleFrame s1 = new SaleFrame();
			s1.setVisible(true);
		}
		if(resource == btnMenu1){
			this.dispose();
			MenuFrame m1 = new MenuFrame();
			m1.setVisible(true);
		}
		if(resource == btnMember1){
			this.dispose();
			MemberAddFrame mem1 = new MemberAddFrame();
			mem1.setVisible(true);
		}
		if(resource == btnMember2){
			this.dispose();
			MemberDeleteFrame mem2 = new MemberDeleteFrame();
			mem2.setVisible(true);
		}
	}
}
