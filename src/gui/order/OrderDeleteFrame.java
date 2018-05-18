package gui.order;

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

import gui.main.MainFrame;
import gui.order.listener.OrderDeleteFrameListSelectionListener;
import gui.order.listener.OrderDeleteFrameListener;
import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;
import vo.OrdersVo;
import java.awt.GridLayout;
import java.awt.Toolkit;

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
	public OrderDeleteFrameListSelectionListener menuListSelectionListener;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(OrderDeleteFrame.class.getResource("/icon/login.png")));
		cafeDAOImp = CafeDAOImp.getInstance();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(259, 27, 272, 66);
		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 70));
		contentPane.add(lblCafe);
		
		lblNewLabel = new JLabel("주문 현황");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNewLabel.setBounds(41, 120, 134, 37);
		contentPane.add(lblNewLabel);
		
		btnOrder11 = new JButton("HOME");
		btnOrder11.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder11.setBounds(697, 514, 83, 39);
		btnOrder11.addActionListener(this);
		btnOrder11.setForeground(Color.BLACK);
		contentPane.add(btnOrder11);
		
		btnOrder10 = new JButton("주문취소");
		btnOrder10.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnOrder10.addActionListener(new OrderDeleteFrameListener(this));
		btnOrder10.setForeground(Color.BLACK);
		btnOrder10.setBounds(316, 456, 134, 50);
		contentPane.add(btnOrder10);
		
		txtOrder5 = new JTextField();
		txtOrder5.setEditable(false);
		txtOrder5.setColumns(10);
		txtOrder5.setBounds(41, 169, 706, 21);
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
		listOrder1.addListSelectionListener(new OrderDeleteFrameListSelectionListener(this));
		sp.setViewportView(listOrder1);
		
		panel = new JPanel();
		panel.setSize(new Dimension(400, 400));
		panel.setBounds(42, 202, 705, 221);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
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
