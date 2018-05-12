package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import gui.listener.MenuFrameListener;
import gui.listener.MenuListSelectionListener;
import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;

public class MenuFrame extends JFrame {

	public JPanel contentPane;
	public JTextField txtMenuname;
	public JTextField txtMenuprice;
	public JButton btnReg;
	public JList<String> menuList;
	public JTextField resultField;
	private CafeDAOImp cafeDAOImp;
	public JTextField originalPrice;
	public DefaultListModel<String> modelMenuList;
	public MenuListSelectionListener menuListSelectionListener;
	private List<MenuVo> list;
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
		loadCafeDAOImp();		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMenuname = new JTextField();
		txtMenuname.setBounds(213, 35, 116, 21);
		contentPane.add(txtMenuname);
		txtMenuname.setColumns(10);
		
		txtMenuprice = new JTextField();
		txtMenuprice.setBounds(213, 98, 116, 21);
		contentPane.add(txtMenuprice);
		txtMenuprice.setColumns(10);
		
		originalPrice = new JTextField();		
		originalPrice.setColumns(10);
		originalPrice.setBounds(213, 153, 116, 21);
		contentPane.add(originalPrice);
		
		JLabel lblMenuname = new JLabel("MenuName");
		lblMenuname.setBounds(47, 35, 120, 21);
		contentPane.add(lblMenuname);
		
		JLabel lblMenuprice = new JLabel("MenuPrice");
		lblMenuprice.setBounds(47, 99, 84, 18);
		contentPane.add(lblMenuprice);
		
		JLabel lblOriginalprice = new JLabel("OriginalPrice");
		lblOriginalprice.setBounds(47, 148, 84, 31);
		contentPane.add(lblOriginalprice);
		
		btnReg = new JButton("reg");
		btnReg.setBounds(341, 34, 97, 23);
		contentPane.add(btnReg);
		
		JButton btnDel = new JButton("del");
		btnDel.setBounds(460, 34, 97, 23);
		contentPane.add(btnDel);
		
		
		
		modelMenuList = getMenuList();		
	    menuList = new JList(modelMenuList);
	    menuList.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		menuList.setBounds(27, 189, 517, 195);
		contentPane.add(menuList);
		menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		menuList.addListSelectionListener(new MenuListSelectionListener(this));
		/*JScrollPane listScroller = new JScrollPane();
		listScroller.setViewportView(menuList);
		menuList.setLayoutOrientation(JList.VERTICAL);
		contentPane.add(listScroller);*/
		
		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setBounds(40, 418, 517, 21);
		contentPane.add(resultField);
		resultField.setColumns(10);
		
		
		
		
		btnDel.addActionListener(new MenuFrameListener(this));
		btnReg.addActionListener(new MenuFrameListener(this));
		
		
	}
	public void loadCafeDAOImp() {
		cafeDAOImp = new CafeDAOImp();
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
}
