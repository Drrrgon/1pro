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
	private JLabel label, label_1, label_2, label_3, lblCafe;
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
		btnOrder1.setBounds(164, 113, 121, 44);
		contentPane.add(btnOrder1);
		btnOrder1.addActionListener(this);
		
		btnOrder2 = new JButton("주문 현황/취소");
		btnOrder2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder2.setBounds(297, 113, 142, 44);
		contentPane.add(btnOrder2);
		btnOrder2.addActionListener(this);
		
		label = new JLabel("1. 주문관리");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(58, 126, 99, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 매출관리");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_1.setBounds(58, 199, 92, 16);
		contentPane.add(label_1);
		
		btnSale1 = new JButton("일별/월별 매출 조회");
		btnSale1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnSale1.addActionListener(this);
		btnSale1.setBounds(162, 186, 166, 44);
		contentPane.add(btnSale1);
		
		label_2 = new JLabel("3. 메뉴관리");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_2.setBounds(58, 273, 99, 16);
		contentPane.add(label_2);
		
		btnMenu1 = new JButton("메뉴 등록/삭제");		
		btnMenu1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMenu1.setBounds(164, 260, 152, 44);
		contentPane.add(btnMenu1);
		btnMenu1.addActionListener(this);
		
		label_3 = new JLabel("4. 회원관리");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_3.setBounds(60, 343, 93, 39);
		contentPane.add(label_3);
		
		btnMember2 = new JButton("회원삭제");
		btnMember2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember2.setBounds(297, 341, 121, 44);
		contentPane.add(btnMember2);
		btnMember2.addActionListener(this);
		
		btnMember1 = new JButton("회원등록");
		btnMember1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember1.setBounds(164, 341, 121, 44);
		contentPane.add(btnMember1);
		btnMember1.addActionListener(this);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(281, 35, 86, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
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
