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
import gui.menu.MenuFrame;
import gui.order.OrderDeleteFrame;
import gui.order.OrderFrame;
import gui.sale.SaleFrame;
import system.DAO.imp.CafeDAOImp;
import java.awt.Toolkit;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnExit;
	private JButton addOder, deleteOrder, openSale, openMenu, btnMenu2, openMember;
	private JLabel lblCafe;
	private JLabel lblNewLabel;
	private JLabel lbll;
	private JLabel label_1;
	private JLabel label_2;
	private CafeDAOImp cafeDAOImp;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/icon/login.png")));
		cafeDAOImp = CafeDAOImp.getInstance();
		
		setResizable(false);
		setTitle("Cafe24");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800	, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addOder = new JButton("주문 등록");
		addOder.setFont(new Font("Dialog", Font.PLAIN, 25));
		addOder.setBounds(202, 211, 181, 50);
		contentPane.add(addOder);
		addOder.addActionListener(this);
		
		deleteOrder = new JButton("주문 현황/취소");
		deleteOrder.setFont(new Font("Dialog", Font.PLAIN, 25));
		deleteOrder.setBounds(384, 211, 196, 50);
		contentPane.add(deleteOrder);
		deleteOrder.addActionListener(this);
		
		openSale = new JButton("일별 / 월별 매출 조회");
		openSale.setFont(new Font("Dialog", Font.PLAIN, 25));
		openSale.addActionListener(this);
		openSale.setBounds(202, 273, 378, 50);
		contentPane.add(openSale);
		
		openMenu = new JButton("메뉴 등록 / 삭제");		
		openMenu.setFont(new Font("Dialog", Font.PLAIN, 25));
		openMenu.setBounds(202, 335, 380, 50);
		contentPane.add(openMenu);
		openMenu.addActionListener(this);
		

		openMember = new JButton("회원 등록 / 검색 / 삭제");
		openMember.setFont(new Font("Dialog", Font.PLAIN, 25));
		openMember.setBounds(202, 397, 380, 50);
		openMember.addActionListener(this);
		contentPane.add(openMember);
		
		
		lblCafe = new JLabel("Cafe24");
     	lblCafe.setBounds(277, 69, 263, 81);
		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 70));
		contentPane.add(lblCafe);

	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton)e.getSource();
		if(resource == btnExit){
			this.dispose();
		}
		if(resource == addOder){
			this.dispose();
			OrderFrame o1 = new OrderFrame();
			o1.setVisible(true);
		}
		if(resource == deleteOrder){
			this.dispose();
			OrderDeleteFrame o4 = new OrderDeleteFrame();
			o4.setVisible(true);
		}
		if(resource == openSale){
			this.dispose();
			SaleFrame s1 = new SaleFrame();
			s1.setVisible(true);
		}
		if(resource == openMenu){
			this.dispose();
			MenuFrame m1 = new MenuFrame();
			m1.setVisible(true);
		}
		if(resource == openMember){
			this.dispose();
			MemberFrame mem1 = new MemberFrame();
			mem1.setVisible(true);
		}
	}
}
