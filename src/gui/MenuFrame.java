package gui;

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

import gui.listener.MenuFrameListener;
import gui.listener.MenuListSelectionListener0;
import gui.listener.MenuListSelectionListener2;
import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
	public MenuListSelectionListener2 menuListSelectionListener;
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
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMenuname = new JTextField();
		txtMenuname.setBounds(325, 77, 116, 21);
		contentPane.add(txtMenuname);
		txtMenuname.setColumns(10);
		
		txtMenuprice = new JTextField();
		txtMenuprice.setBounds(325, 108, 116, 21);
		contentPane.add(txtMenuprice);
		txtMenuprice.setColumns(10);
		
		originalPrice = new JTextField();		
		originalPrice.setColumns(10);
		originalPrice.setBounds(325, 139, 116, 21);
		contentPane.add(originalPrice);
		
		JLabel lblMenuname = new JLabel("메뉴 이름");
		lblMenuname.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblMenuname.setBackground(Color.BLACK);
		lblMenuname.setBounds(213, 77, 120, 21);
		contentPane.add(lblMenuname);
		
		JLabel lblMenuprice = new JLabel("메뉴 가격");
		lblMenuprice.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblMenuprice.setBounds(213, 109, 84, 18);
		contentPane.add(lblMenuprice);
		
		JLabel lblOriginalprice = new JLabel("원가");
		lblOriginalprice.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblOriginalprice.setBounds(213, 137, 84, 21);
		contentPane.add(lblOriginalprice);
		
		btnReg = new JButton("등록");
		btnReg.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnReg.setBounds(239, 172, 75, 26);
		contentPane.add(btnReg);
		
		JButton btnDel = new JButton("삭제");
		btnDel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnDel.setBounds(322, 172, 75, 26);
		contentPane.add(btnDel);
		
		JScrollPane sp = new JScrollPane(menuList);
		sp.setPreferredSize(new Dimension(549, 221));
		sp.setVisible(true);
		
//		String [] a = {"aaaaaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa"};
//		menuList = new JList(a);
		modelMenuList = getMenuList();		
	    menuList = new JList(modelMenuList);
	    menuList.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		menuList.setBounds(40, 238, 573, 165);
		contentPane.add(menuList);
		menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		menuList.addListSelectionListener(new MenuListSelectionListener0(this));
//		sp.setViewportView(menuList);
		
		panel = new JPanel();
		panel.setSize(new Dimension(400, 400));
		panel.setBounds(40, 243, 573, 142);
		panel.add(sp);
		contentPane.add(panel);
		
		/*JScrollPane listScroller = new JScrollPane();
		listScroller.setViewportView(menuList);
		menuList.setLayoutOrientation(JList.VERTICAL);
		contentPane.add(listScroller);*/
		
		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setBounds(40, 210, 573, 21);
		contentPane.add(resultField);
		resultField.setColumns(10);
		
		btnHome = new JButton("HOME");				
		btnHome.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnHome.setBounds(541, 415, 93, 37);
		contentPane.add(btnHome);
		
		label = new JLabel("Cafe24");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		label.setBounds(282, 14, 84, 29);
		contentPane.add(label);
		btnHome.addActionListener(this);
		
		
		
		btnDel.addActionListener(new MenuFrameListener(this));
		btnReg.addActionListener(new MenuFrameListener(this));
		
		
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
	
	public void start() {
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
}