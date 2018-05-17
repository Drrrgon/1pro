package gui.order;

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

import gui.main.MainFrame;
import gui.menu.listener.MenuFrameComboBoxListener;
import gui.order.listener.OrderFrameRadioButtonListener;
import gui.order.listener.OrderFrameSpinnerChangeListener;
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
	public MenuFrameComboBoxListener comboBox;
	public OrderFrameSpinnerChangeListener spinnerChangeListener;
	public OrderFrameRadioButtonListener radioButtonListener;
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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 메뉴선택");
		label.setFont(new Font("Dialog", Font.PLAIN, 35));
		label.setBounds(98, 217, 204, 56);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 수량");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 35));
		label_1.setBounds(98, 285, 150, 46);
		contentPane.add(label_1);
		
		label_2 = new JLabel("3. 회원/비회원");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 35));
		label_2.setBounds(98, 343, 281, 56);
		contentPane.add(label_2);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(239, 47, 252, 97);
		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 70));
		contentPane.add(lblCafe);
		
		btnOrder5 = new JButton(">>");
		btnOrder5.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder5.addActionListener(this);
		btnOrder5.setBounds(701, 517, 79, 36);
		btnOrder5.setForeground(Color.BLACK);
		contentPane.add(btnOrder5);
		
		JComboBox cbOrder1 = new JComboBox();				
		cbOrder1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		contentPane.add(cbOrder1);

		comboBox = new MenuFrameComboBoxListener(this) {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(cbOrder1)) {				
					System.out.println((MenuVo)cbOrder1.getSelectedItem());
					selectedMenu=(MenuVo)cbOrder1.getSelectedItem();
				}				
			}
		};//상속을 위한 콤보박스 리스너
		
		cbOrder1.setBounds(341, 217, 408, 50);
		cbOrder1.addActionListener(comboBox);
		list = cafeDAOImp.getAllMenu();
		for (MenuVo a : list) {
			cbOrder1.addItem(a);
		}
				
		spinner = new JSpinner();
		spinner.setToolTipText("");
		spinner.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(669, 290, 80, 50);
		contentPane.add(spinner);
		spinnerChangeListener = new OrderFrameSpinnerChangeListener(this);
		spinner.addChangeListener(spinnerChangeListener);
		
		
		JRadioButton rdbtnOrder1 = new JRadioButton("회원");
		rdbtnOrder1.setBounds(518, 350, 100, 50);
		contentPane.add(rdbtnOrder1);		
		rdbtnOrder1.setFont(new Font("Dialog", Font.PLAIN, 25));
		JRadioButton rdbtnOrder2 = new JRadioButton("비회원");
		rdbtnOrder2.setSelected(false);
		rdbtnOrder2.setFont(new Font("Dialog", Font.PLAIN, 25));
		rdbtnOrder2.setBounds(657, 350, 100, 50);
		contentPane.add(rdbtnOrder2);		
		ButtonGroup bG = new ButtonGroup();
		bG.add(rdbtnOrder1);
		bG.add(rdbtnOrder2);
		radioButtonListener = new OrderFrameRadioButtonListener(this);
		rdbtnOrder1.addItemListener(radioButtonListener);
		rdbtnOrder2.addItemListener(radioButtonListener);
		
		btnOrder4 = new JButton("<<");
		btnOrder4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder4.addActionListener(this);
		btnOrder4.setForeground(Color.BLACK);
		btnOrder4.setBounds(14, 517, 79, 36);
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
				
				OrderByMemberFrame order2 = new OrderByMemberFrame(selectedMenu, spinnerChangeListener.getCountValue());
				order2.setVisible(true);
			}else if(radioButtonListener.getMemberStatement() == false && spinnerChangeListener.getCountValue() !=0){
				// else if 구문은 비회원 일 시 실행				
				OrdersVo order = new OrdersVo();				
				order.setCount(spinnerChangeListener.getCountValue()); //수량을 얻어옵니다.
				order.setMenuNo((selectedMenu.getMenuNo()));//메뉴번호를 얻어옵니다.
				int getPrice = cafeDAOImp.getMenuPrice(selectedMenu.getMenuNo());//DB에서 메뉴 번호로 메뉴의 가격을 불러옵니다.
//				System.out.println(getPrice);// 쿼리 실행 확인.
				order.setTotal(cafeDAOImp.getMenuPrice(selectedMenu.getMenuNo()) * spinnerChangeListener.getCountValue());
				//불러온 정보를 토대로 합산을 합니다.
				order.setTelNo("9999"); // 비회원의 번호는 9999가 디폴트 값
				int insertResult = cafeDAOImp.insertOrder(order); // DB에 ISERT쿼리를 보냅니다.
//				System.out.println(insertResult);// 쿼리 실행 확인.
				order.setOrederNo(order.getOrederNo());				
				OrderResultFrame order3 = new OrderResultFrame(order,null);
				this.dispose();
				order3.setVisible(true);
			}else {
				JButton resource = (JButton) e.getSource();
				JOptionPane.showConfirmDialog(resource, "잘못된 선택입니다.",">>", JOptionPane.PLAIN_MESSAGE);
			}

			break;
		default:
			break;
		}
	}
}
