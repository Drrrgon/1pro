package gui.order;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.main.MainFrame;
import system.DAO.imp.CafeDAOImp;
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
	private CafeDAOImp cafeDAOImp;
	/**
	 * Create the frame.
	 */
	public OrderResultFrame(OrdersVo order, MemberVo member) {
		setTitle("주문 확인");
		this.order = order;
		this.member = member;
		cafeDAOImp = CafeDAOImp.getInstance();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("주문번호");
		label.setFont(new Font("Dialog", Font.PLAIN, 23));
		label.setBounds(122, 231, 199, 44);
		contentPane.add(label);
		
		label_1 = new JLabel("잔여 마일리지");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 23));
		label_1.setBounds(121, 376, 282, 48);
		contentPane.add(label_1);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(274, 35, 269, 76);
		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 70));
		contentPane.add(lblCafe);
		
		btnOrder9 = new JButton("HOME");
		btnOrder9.setFont(new Font("Dialog", Font.PLAIN, 19));
		btnOrder9.addActionListener(this);
		btnOrder9.setBounds(683, 514, 97, 39);
		btnOrder9.setForeground(Color.BLACK);
		contentPane.add(btnOrder9);
		
		txtOrder1 = new JTextField();
		txtOrder1.setEditable(false);
		txtOrder1.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtOrder1.setBounds(118, 287, 555, 50);
		contentPane.add(txtOrder1);
		txtOrder1.setColumns(10);
		HashMap<String, Object> map =cafeDAOImp.getOrderByString(order);
		txtOrder1.setText("몌뉴 : "+map.get("MNAME")+" 수량 : "+map.get("COUNT")+
				" 총 가격 : "+map.get("TOTAL")+"원 주문 시각 : "+map.get("TIME"));
		
		txtOrder2 = new JTextField();
		txtOrder2.setEditable(false);
		txtOrder2.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtOrder2.setColumns(10);
		txtOrder2.setBounds(118, 436, 555, 50);
		contentPane.add(txtOrder2);
		if(member != null) {
			txtOrder2.setText(member.getmBonus()+"");
		}
		
		
		label_2 = new JLabel("주문완료!");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 27));
		label_2.setBounds(341, 151, 174, 48);
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
