package gui.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import gui.main.MainFrame;
import gui.menu.listener.MenuFrameButtonListener;
import gui.menu.listener.MenuFrameListSelectionListener;
import gui.order.listener.OrderDeleteFrameListSelectionListener;
import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;

public class MenuFrame extends JFrame implements ActionListener {

	public JPanel contentPane, panel;
	public JTextField txtMenuname;
	public JTextField txtMenuprice;
	public JButton btnReg;
	public JList<String> menuList;
	public JTextField resultField;
	private CafeDAOImp cafeDAOImp;
	public JTextField originalPrice;
	public DefaultListModel<String> modelMenuList;
	public OrderDeleteFrameListSelectionListener menuListSelectionListener;
	private List<MenuVo> list;
	private JButton btnHome;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
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
	public MenuFrame() {
		setResizable(false);
		setTitle("Cafe24");
		loadCafeDAOImp();		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMenuname = new JTextField();
		txtMenuname.setBounds(193, 114, 212, 30);
		contentPane.add(txtMenuname);
		txtMenuname.setColumns(10);
		
		txtMenuprice = new JTextField();
		txtMenuprice.setBounds(193, 147, 212, 30);
		contentPane.add(txtMenuprice);
		txtMenuprice.setColumns(10);
		
		originalPrice = new JTextField();		
		originalPrice.setColumns(10);
		originalPrice.setBounds(193, 180, 212, 30);
		contentPane.add(originalPrice);
		
		JLabel lblMenuname = new JLabel("메뉴 이름");
		lblMenuname.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblMenuname.setBackground(Color.BLACK);
		lblMenuname.setBounds(78, 114, 85, 29);
		contentPane.add(lblMenuname);
		
		JLabel lblMenuprice = new JLabel("메뉴 가격");
		lblMenuprice.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblMenuprice.setBounds(78, 147, 85, 29);
		contentPane.add(lblMenuprice);
		
		JLabel lblOriginalprice = new JLabel("원가");
		lblOriginalprice.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblOriginalprice.setBounds(78, 178, 85, 29);
		contentPane.add(lblOriginalprice);
		
		btnReg = new JButton("등록");
		btnReg.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnReg.setBounds(575, 175, 75, 34);
		contentPane.add(btnReg);
		
		JButton btnDel = new JButton("삭제");
		btnDel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnDel.setBounds(675, 175, 75, 34);
		contentPane.add(btnDel);
		
		JScrollPane sp = new JScrollPane(menuList);
		sp.setPreferredSize(new Dimension(549, 221));
		sp.setVisible(true);
		
		modelMenuList = getMenuList();		
//		sp.setViewportView(menuList);
		
		panel = new JPanel();
		panel.setSize(new Dimension(400, 400));
		panel.setBounds(40, 253, 710, 200);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(sp);
		menuList = new JList(modelMenuList);
		sp.setViewportView(menuList);
		menuList.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		menuList.addListSelectionListener(new MenuFrameListSelectionListener(this));
		contentPane.add(panel);		
		
		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setBounds(41, 220, 709, 21);
		contentPane.add(resultField);
		resultField.setColumns(10);
		
		btnHome = new JButton("HOME");				
		btnHome.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnHome.setBounds(667, 477, 83, 39);
		contentPane.add(btnHome);
		
		label = new JLabel("Cafe24");
		label.setFont(new Font("Dialog", Font.PLAIN, 50));
		label.setBounds(311, 24, 182, 52);
		contentPane.add(label);
		btnHome.addActionListener(this);
		
				
		btnDel.addActionListener(new MenuFrameButtonListener(this));
		btnReg.addActionListener(new MenuFrameButtonListener(this));				
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton)e.getSource();
		if (resource == btnHome) {
			this.dispose();
			MainFrame hm = new MainFrame();
			hm.setVisible(true);
		}
	}
	
	public void loadCafeDAOImp() {
		cafeDAOImp = CafeDAOImp.getInstance();
	}
	
	/**
	 * @return DefaultListModel<String>
	 * 메뉴를 불러와서 리스트 모델로 반환합니다.
	 */
	public DefaultListModel<String> getMenuList() {
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		list = cafeDAOImp.getAllMenu();		
		for(int i = 0 ; i < list.size() ; i ++) {			
			listModel.addElement(list.get(i).toString());
		}		
		return listModel;
	}
	public List<MenuVo> getMenuVoList() {
		return list;
	}
	
}//class