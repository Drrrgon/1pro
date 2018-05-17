package gui.main;

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

import gui.member.MemberFrame;
import gui.member.MemberDeleteFrame;
import gui.menu.MenuFrame;
import gui.order.OrderDeleteFrame;
import gui.order.OrderFrame;
import gui.sale.SaleFrame;
import system.DAO.imp.CafeDAOImp;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnExit;
	private JButton btnOrder1, btnOrder2, btnSale1, btnMenu1, btnMenu2, btnMember1;
	private JLabel lblCafe;
	private JLabel lblNewLabel;
	private JLabel lbll;
	private JLabel label_1;
	private JLabel label_2;
	private CafeDAOImp cafeDAOImp;
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
		cafeDAOImp = CafeDAOImp.getInstance();
		
		setResizable(false);
		setTitle("Cafe24");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOrder1 = new JButton("주문 등록");
		btnOrder1.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnOrder1.setBounds(151, 210, 181, 50);
		contentPane.add(btnOrder1);
		btnOrder1.addActionListener(this);
		
		btnOrder2 = new JButton("주문 현황/취소");
		btnOrder2.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnOrder2.setBounds(335, 210, 196, 50);
		contentPane.add(btnOrder2);
		btnOrder2.addActionListener(this);
		
		btnSale1 = new JButton("일별 / 월별 매출 조회");
		btnSale1.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnSale1.addActionListener(this);
		btnSale1.setBounds(153, 272, 378, 50);
		contentPane.add(btnSale1);
		
		btnMenu1 = new JButton("메뉴 등록 / 삭제");		
		btnMenu1.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnMenu1.setBounds(151, 334, 380, 50);
		contentPane.add(btnMenu1);
		btnMenu1.addActionListener(this);
		

		btnMember1 = new JButton("회원 등록 / 검색 / 삭제");
		btnMember1.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnMember1.setBounds(151, 396, 380, 50);
		btnMember1.addActionListener(this);
		
//		btnMember1 = new JButton("회원등록");
//		btnMember1.setFont(new Font("Dialog", Font.PLAIN, 25));
//		btnMember1.setBounds(255, 397, 183, 50);
//
		contentPane.add(btnMember1);
		btnMember1.addActionListener(this);
		
		lblCafe = new JLabel("Cafe24");

     	lblCafe.setBounds(200, 69, 263, 81);

//		lblCafe.setBounds(230, 71, 233, 81);

		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 70));
		contentPane.add(lblCafe);

//		
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
			MemberFrame mem1 = new MemberFrame();
			mem1.setVisible(true);
		}
	}
}
