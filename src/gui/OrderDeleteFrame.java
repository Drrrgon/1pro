package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import gui.listener.MenuListSelectionListener2;
import gui.listener.OrderDeleteFrameListener;
import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;
import vo.OrdersVo;

public class OrderDeleteFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCafe;
	private JButton btnOrder11;
	private JButton btnOrder10;
	public JTextField txtOrder5;
	public JList listOrder1;
	private JLabel lblNewLabel;
	private JPanel panel;
	private CafeDAOImp cafeDAOImp;
	public DefaultListModel<String> modelMenuList;
	public MenuListSelectionListener2 menuListSelectionListener;
	private List<String> stringList;
	private List<OrdersVo> orderList;
	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDeleteFrame frame = new OrderDeleteFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public OrderDeleteFrame() {
		cafeDAOImp = CafeDAOImp.getInstance();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(271, 35, 98, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		contentPane.add(lblCafe);
		
		lblNewLabel = new JLabel("주문 현황");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(48, 81, 79, 16);
		contentPane.add(lblNewLabel);
		
		btnOrder11 = new JButton("HOME");
		btnOrder11.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder11.setBounds(555, 416, 79, 36);
		btnOrder11.addActionListener(this);
		btnOrder11.setForeground(Color.BLACK);
		contentPane.add(btnOrder11);
		
		btnOrder10 = new JButton("주문취소");
		btnOrder10.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder10.addActionListener(new OrderDeleteFrameListener(this));
		btnOrder10.setForeground(Color.BLACK);
		btnOrder10.setBounds(270, 368, 96, 36);
		contentPane.add(btnOrder10);
		
		txtOrder5 = new JTextField();
		txtOrder5.setEditable(false);
		txtOrder5.setColumns(10);
		txtOrder5.setBounds(41, 109, 558, 21);
		contentPane.add(txtOrder5);
		
		JScrollPane sp = new JScrollPane(listOrder1);
		sp.setPreferredSize(new Dimension(549, 221));
		sp.setVisible(true);
				
		//String [] a = {"aaaaaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa"};
		//listOrder1 = new JList(a);
		modelMenuList = getOrderList();		
		listOrder1 = new JList(modelMenuList);
		listOrder1.setSize(new Dimension(400, 400));
		listOrder1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOrder1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		listOrder1.setSize(400, 400);
		listOrder1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOrder1.addListSelectionListener(new MenuListSelectionListener2(this));
		sp.setViewportView(listOrder1);
		
		panel = new JPanel();
		panel.setSize(new Dimension(400, 400));
		panel.setBounds(48, 142, 549, 221);
		panel.add(sp);
		contentPane.add(panel);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnOrder10){
			JOptionPane.showConfirmDialog(resource, "주문취소되었습니다.","주문취소", JOptionPane.PLAIN_MESSAGE);
		}
		if(resource == btnOrder11){
			this.dispose();
			MainFrame home = new MainFrame();
			home.setVisible(true);
		}
	}
	public DefaultListModel<String> getOrderList() {
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		stringList = cafeDAOImp.getAllOrderByString();
		orderList = cafeDAOImp.getAllOrderByOrdersVo();
		for(int i = 0 ; i < stringList.size() ; i ++) {			
			listModel.addElement(stringList.get(i).toString());
		}		
		return listModel;
	}
	public List<OrdersVo> getOrdersVoList() {
		return orderList;
	}
}