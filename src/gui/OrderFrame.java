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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import gui.listener.ComboBoxListener;
import gui.listener.RadioButtonListener;
import gui.listener.SpinnerChangeListener;
import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;
import vo.OrdersVo;

public class OrderFrame extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JLabel label, label_1, label_2, lblCafe;
	private JButton btnOrder4, btnOrder5;
	private JRadioButton rdbtnOrder1, rdbtnOrder2;
	public JComboBox cbOrder1;
	public JSpinner spinner;
	private CafeDAOImp cafeDAOImp;
	public List<MenuVo> list;
	public MenuVo selectedMenu;
	public ComboBoxListener comboBox;
	public SpinnerChangeListener spinnerChangeListener;
	public RadioButtonListener radioButtonListener;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame();
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
	public OrderFrame() {
		setTitle("주문");
		cafeDAOImp = CafeDAOImp.getInstance();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 메뉴선택");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(91, 116, 91, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 수량");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_1.setBounds(92, 181, 61, 16);
		contentPane.add(label_1);
		
		label_2 = new JLabel("3. 회원/비회원");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_2.setBounds(91, 247, 112, 16);
		contentPane.add(label_2);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(281, 29, 80, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		contentPane.add(lblCafe);
		
		btnOrder5 = new JButton(">>");
		btnOrder5.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder5.addActionListener(this);
		btnOrder5.setBounds(555, 416, 79, 36);
		btnOrder5.setForeground(Color.BLACK);
		contentPane.add(btnOrder5);
		
		JComboBox cbOrder1 = new JComboBox();				
		cbOrder1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		contentPane.add(cbOrder1);	
		comboBox = new ComboBoxListener(this) {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(cbOrder1)) {				
					System.out.println((MenuVo)cbOrder1.getSelectedItem());
					selectedMenu=(MenuVo)cbOrder1.getSelectedItem();
				}
				
			}
		};	
		cbOrder1.setBounds(239, 107, 294, 36);
		cbOrder1.addActionListener(comboBox);
		list = cafeDAOImp.getAllMenu();
		for (MenuVo a : list) {
			cbOrder1.addItem(a);
		}
		
		
		spinner = new JSpinner();
		spinner.setToolTipText("");
		spinner.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(240, 171, 69, 29);
		contentPane.add(spinner);
		spinnerChangeListener = new SpinnerChangeListener(this);
		spinner.addChangeListener(spinnerChangeListener);
		
		
		JRadioButton rdbtnOrder1 = new JRadioButton("회원");
		rdbtnOrder1.setBounds(239, 243, 69, 23);
		contentPane.add(rdbtnOrder1);		
		rdbtnOrder1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		JRadioButton rdbtnOrder2 = new JRadioButton("비회원");
		rdbtnOrder2.setSelected(false);
		rdbtnOrder2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		rdbtnOrder2.setBounds(327, 243, 97, 23);
		contentPane.add(rdbtnOrder2);		
		ButtonGroup bG = new ButtonGroup();
		bG.add(rdbtnOrder1);
		bG.add(rdbtnOrder2);
		radioButtonListener = new RadioButtonListener(this);
		rdbtnOrder1.addItemListener(radioButtonListener);
		rdbtnOrder2.addItemListener(radioButtonListener);
		
		btnOrder4 = new JButton("<<");
		btnOrder4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder4.addActionListener(this);
		btnOrder4.setForeground(Color.BLACK);
		btnOrder4.setBounds(6, 416, 79, 36);
		contentPane.add(btnOrder4);
	}
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "<<":
			this.dispose();
			MainFrame home = new MainFrame();
			home.setVisible(true);
			break;
			
		case ">>":
			if(radioButtonListener.getMemberStatement() && spinnerChangeListener.getCountValue() !=0) {
				this.dispose();
				
				MemberOrderFrame order2 = new MemberOrderFrame(selectedMenu, spinnerChangeListener.getCountValue());
				order2.setVisible(true);
			}else if(radioButtonListener.getMemberStatement() == false && spinnerChangeListener.getCountValue() !=0){
				// else if 구문은 비회원 일 시 실행
				this.dispose();
				
				OrdersVo order = new OrdersVo();				
				order.setCount(spinnerChangeListener.getCountValue());
				order.setMenuNo((selectedMenu.getMenuNo()));
				int s = cafeDAOImp.getMenuPrice(selectedMenu.getMenuNo());
				order.setTotal(cafeDAOImp.getMenuPrice(selectedMenu.getMenuNo()) * spinnerChangeListener.getCountValue());
				order.setTelNo("9999");
				int re = cafeDAOImp.insertOrder(order);
				order.setOrederNo(order.getOrederNo());				
				OrderResultFrame order3 = new OrderResultFrame(order,null);
				order3.setVisible(true);
			}else {
				JButton resource = (JButton) e.getSource();
				JOptionPane.showConfirmDialog(resource, "잘못된 선택입니다.",">>", JOptionPane.PLAIN_MESSAGE);
			}
			
//			System.out.println(selectedMenu);
//			System.out.println(radioButtonListener.getMemberStatement());
//			System.out.println(spinnerChangeListener.getCountValue());	
			
			break;
		default:
			break;
		}
	}
}
