package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;


import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;

public class Order1 extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JLabel label, label_1, label_2, lblCafe;
	private JButton btnOrder4, btnOrder5;
	private JRadioButton rdbtnOrder1, rdbtnOrder2;
	private JComboBox cbOrder1;
	private JSpinner spinner;
	private CafeDAOImp cafeDAOImp;
	public List<MenuVo> list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order1 frame = new Order1();
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
	public Order1() {
		setTitle("주문");
		cafeDAOImp = CafeDAOImp.getInstance();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 메뉴선택");
		label.setBounds(30, 85, 91, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 수량");
		label_1.setBounds(30, 132, 61, 16);
		contentPane.add(label_1);
		
		label_2 = new JLabel("3. 회원/비회원");
		label_2.setBounds(30, 176, 112, 16);
		contentPane.add(label_2);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(187, 23, 69, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblCafe);
		
		btnOrder5 = new JButton(">>");
		btnOrder5.addActionListener(this);
		btnOrder5.setBounds(365, 243, 79, 29);
		btnOrder5.setForeground(Color.BLACK);
		contentPane.add(btnOrder5);
		
		JComboBox cbOrder1 = new JComboBox();
		cbOrder1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == cbOrder1) {
					System.out.println((MenuVo)cbOrder1.getSelectedItem());
				}
			}
		});
		cbOrder1.setBounds(150, 80, 294, 27);
		contentPane.add(cbOrder1);
		list =cafeDAOImp.getAllMenu();
		for (MenuVo a : list) {
			cbOrder1.addItem(a);
		}
		
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(150, 126, 69, 29);
		contentPane.add(spinner);
		
		JRadioButton rdbtnOrder1 = new JRadioButton("회원");
		rdbtnOrder1.setBounds(150, 173, 61, 23);
		contentPane.add(rdbtnOrder1);
		rdbtnOrder1.addActionListener(this);
		
		JRadioButton rdbtnOrder2 = new JRadioButton("비회원");
		rdbtnOrder2.setSelected(true);
		rdbtnOrder2.setBounds(220, 173, 97, 23);
		contentPane.add(rdbtnOrder2);
		rdbtnOrder2.addActionListener(this);
		
		ButtonGroup bG = new ButtonGroup();
		bG.add(rdbtnOrder1);
		bG.add(rdbtnOrder2);
		
		
		btnOrder4 = new JButton("<<");
		btnOrder4.addActionListener(this);
		btnOrder4.setForeground(Color.BLACK);
		btnOrder4.setBounds(6, 243, 79, 29);
		contentPane.add(btnOrder4);
	}
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "<<":
			this.dispose();
			Home home = new Home();
			home.setVisible(true);
			break;
			
		case ">>":
			MenuVo temp=(MenuVo)cbOrder1.getSelectedItem();
			System.out.println((MenuVo)cbOrder1.getSelectedItem());
			break;
		default:
			break;
		}
//		JButton resource = (JButton) e.getSource();
//		JComboBox<MenuVo> jB = (JComboBox)e.getSource();
//		JRadioButton jR = (JRadioButton)e.getSource();
//		if(resource == btnOrder4){
//			this.dispose();
//			Home home = new Home();
//			home.setVisible(true);
//		}
//		if(resource == btnOrder5){
//			if(rdbtnOrder1.isSelected()) {
//				System.out.println(cbOrder1.getSelectedItem() + "회원 ");
//			}else {
//				System.out.println(cbOrder1.getSelectedItem() + "비회원 ");
//			}
//			String str = (String)jB.getSelectedItem();
//			System.out.println(str+ "회원 ");
//			
//			this.dispose();
//			Order2 o2 = new Order2();
//			o2.setVisible(true);
//		}
//		if(e.getSource() == cbOrder1 && rdbtnOrder1.isSelected() && resource == btnOrder5) {
//			System.out.println(cbOrder1.getSelectedItem() + "회원 ");
//		}
	}
}
