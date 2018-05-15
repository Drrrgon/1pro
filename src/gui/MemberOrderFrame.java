package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.session.SqlSession;

import gui.listener.MemberOrderRadioButtonListener;
import system.DAO.imp.CafeDAOImp;
import vo.MemberVo;
import vo.MenuVo;
import vo.OrdersVo;

public class MemberOrderFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtOrder1, txtOrder2;
	private JLabel label, label_1, label_2, lblCafe;
	private JButton btnOrder6, btnOrder7, btnOrder8;
	private JRadioButton rdbtnOrder3, rdbtnOrder4;	
	private ButtonGroup radioButtonGroup = new ButtonGroup();
	private MenuVo selectedMenu; // 전 단계에서 주문한 메뉴
	private int count; // 전 단계에서 주문한 오더 수량	
	private CafeDAOImp cafeDAOImp;
	public MemberOrderRadioButtonListener memberOrderRadioButtonListener;
	private boolean flag = false;
	private MemberVo member;
	private int bonus;
	/**
	 * Create the frame.
	 */
	public MemberOrderFrame(MenuVo selectedMenu, int count) {
		this.selectedMenu = selectedMenu;
		this.count = count;
		cafeDAOImp = CafeDAOImp.getInstance();
		bonus = cafeDAOImp.getMenuPrice(selectedMenu.getMenuNo())/10;
		
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
		
		memberOrderRadioButtonListener = new MemberOrderRadioButtonListener(this);
		
		rdbtnOrder3 = new JRadioButton("적립");
		rdbtnOrder3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		radioButtonGroup.add(rdbtnOrder3);
		rdbtnOrder3.setBounds(271, 260, 71, 23);
		contentPane.add(rdbtnOrder3);
		rdbtnOrder3.addItemListener(memberOrderRadioButtonListener);
		
		rdbtnOrder4 = new JRadioButton("사용");
		rdbtnOrder4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		radioButtonGroup.add(rdbtnOrder4);
		rdbtnOrder4.setBounds(354, 260, 69, 23);
		contentPane.add(rdbtnOrder4);
		rdbtnOrder4.addItemListener(memberOrderRadioButtonListener);
		
		btnOrder7 = new JButton("<<");
		btnOrder7.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder7.addActionListener(this);
		btnOrder7.setBounds(6, 417, 79, 35);
		btnOrder7.setForeground(Color.BLACK);
		contentPane.add(btnOrder7);
		
		txtOrder1 = new JTextField();// 전화번호 입력란
		txtOrder1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		txtOrder1.setBounds(271, 117, 190, 26);
		contentPane.add(txtOrder1);
		txtOrder1.setColumns(10);
		
		btnOrder6 = new JButton("검색");
		btnOrder6.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder6.setForeground(Color.BLACK);
		btnOrder6.setBounds(473, 117, 69, 29);
		contentPane.add(btnOrder6);
		btnOrder6.addActionListener(this);
		
		txtOrder2 = new JTextField();
		txtOrder2.setEditable(false);
		txtOrder2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		txtOrder2.setColumns(10);
		txtOrder2.setBounds(271, 182, 190, 26);
		contentPane.add(txtOrder2);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnOrder7){
			this.dispose();
			OrderFrame o1 = new OrderFrame();
			o1.setVisible(true);
		}
		if(resource == btnOrder6) {
			try {
				member = cafeDAOImp.getMember(Integer.parseInt(txtOrder1.getText()));
				if(member == null) {
					JOptionPane.showConfirmDialog(resource, "검색 실패","검색 오류", JOptionPane.PLAIN_MESSAGE);
				}else {
					txtOrder2.setText(member.getmBonus()+"");
					flag = true;		
					rdbtnOrder3.setSelected(true);
				}
			}catch(NumberFormatException v){
				JOptionPane.showConfirmDialog(resource, "잘못된 입력","입력 오류", JOptionPane.PLAIN_MESSAGE);
			}						
		}
		if(resource == btnOrder8 && flag){			
					if(memberOrderRadioButtonListener.getMemberStatement()) {//사용 
						if(member.getmBonus()==0) {
							JOptionPane.showConfirmDialog(resource, "사용할 마일리지가 없습니다.","마일리지 오류", JOptionPane.PLAIN_MESSAGE);
							rdbtnOrder3.setSelected(true);
						}else {
							OrdersVo order = new OrdersVo();
							order.setCount(count);
							order.setMenuNo(selectedMenu.getMenuNo());
							order.setTelNo(txtOrder1.getText());
							int newTotal = 0;
							int newBonus = 0;
							MemberVo temp = new MemberVo();
							if((selectedMenu.getmPrice() * count) >= member.getmBonus()) {
								newTotal =(selectedMenu.getmPrice() * count) - member.getmBonus();
								order.setTotal(newTotal);
								cafeDAOImp.insertOrderMember(order); // 오더를 만들고 집어넣음
								order.setOrederNo(order.getOrederNo());
								temp.setTelNo(txtOrder1.getText());
								temp.setmBonus(member.getmBonus());
								cafeDAOImp.minusBonus(temp);
								temp.setmBonus(0);
							}else {
//								newBonus = member.getmBonus() - (selectedMenu.getmPrice() * count);
								order.setTotal(newTotal);
								cafeDAOImp.insertOrder(order); // 오더를 만들고 집어넣음								
								temp.setTelNo(txtOrder1.getText());
								temp.setmBonus((selectedMenu.getmPrice() * count));
								cafeDAOImp.minusBonus(temp);
								temp.setmBonus(member.getmBonus() - (selectedMenu.getmPrice() * count));
							}
							
							
							OrderResultFrame o3 = new OrderResultFrame(order, temp);							
							this.dispose();
							o3.setVisible(true);
						}
						
						
						
						
						
						
					}else if(memberOrderRadioButtonListener.getMemberStatement() == false){// 적립
						int newTotal = 0;
						int newBonus = 0;
						OrdersVo order = new OrdersVo();
						MemberVo member = new MemberVo();
						order.setCount(count);
						order.setMenuNo(selectedMenu.getMenuNo());
						order.setTelNo(txtOrder1.getText());
						newTotal = selectedMenu.getmPrice()*count;
						newBonus = (int)(newTotal/10);
						order.setTotal(newTotal);
						
						cafeDAOImp.insertOrderMember(order); // 오더를 만들고 집어넣음
						order.setOrederNo(order.getOrederNo());
						
						member.setTelNo(txtOrder1.getText());
						member.setmBonus(newBonus);
						cafeDAOImp.addBonus(member);
						member.setmBonus(cafeDAOImp.getBouns(member));
						
						OrderResultFrame o3 = new OrderResultFrame(order, member);							
						this.dispose();
						o3.setVisible(true);
						
					}else {
						JOptionPane.showConfirmDialog(resource, "적립 혹은 사용을 선택해 주세요","버튼 오류", JOptionPane.PLAIN_MESSAGE);
					}
											
		}else if(resource == btnOrder8 && flag == false){
			JOptionPane.showConfirmDialog(resource, "전화번호를 검색해 주세요.","검색 오류", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
