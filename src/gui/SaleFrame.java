package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import system.DAO.imp.CafeDAOImp;
import vo.MenuVo;
import vo.OrdersVo;
import vo.SaleVo;

public class SaleFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCafe;
	private JButton btnSale3;
	private JRadioButton rdbtnOrder1, rdbtnOrder2;
	private JComboBox cbOrder1;
	private JSpinner spinner;
	private JSpinner spinnerSale2;
	private JSpinner spinnerSale3;
	private JLabel label_1;
	private JLabel label_2;
	private JButton btnSale2;
	private JTextArea textAreaSale1;
	private JSpinner spinnerSale1;
	private JLabel label;
	private JButton btnNewButton;
	private CafeDAOImp cafeDAOImp;
	private SaleVo sale;
	/**
	 * Create the frame.
	 */
	public SaleFrame() {
		cafeDAOImp = CafeDAOImp.getInstance();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(216, 34, 162, 44);
		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 50));
		contentPane.add(lblCafe);
		
		btnSale3 = new JButton("HOME");
		btnSale3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnSale3.addActionListener(this);
		btnSale3.setBounds(524, 383, 83, 39);
		btnSale3.setForeground(Color.BLACK);
		contentPane.add(btnSale3);
		
		spinnerSale2 = new JSpinner();
		spinnerSale2.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerSale2.setBounds(172, 96, 47, 33);
		contentPane.add(spinnerSale2);
		
		spinnerSale3 = new JSpinner();
		spinnerSale3.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerSale3.setBounds(262, 96, 47, 33);
		contentPane.add(spinnerSale3);
		
		label_1 = new JLabel("월");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_1.setBounds(223, 94, 27, 35);
		contentPane.add(label_1);
		
		label_2 = new JLabel("일");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_2.setBounds(312, 97, 27, 29);
		contentPane.add(label_2);
		
		btnSale2 = new JButton("매출 조회");
		btnSale2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnSale2.setBounds(490, 94, 117, 36);
		contentPane.add(btnSale2);
		
		textAreaSale1 = new JTextArea();
		textAreaSale1.setEditable(false);
		textAreaSale1.setBounds(46, 147, 561, 213);
		contentPane.add(textAreaSale1);
		
		spinnerSale1 = new JSpinner();
		spinnerSale1.setModel(new SpinnerNumberModel(2018, 1990, 2999, 1));
		spinnerSale1.setBounds(46, 96, 83, 33);
		contentPane.add(spinnerSale1);
		
		label = new JLabel("년");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(133, 93, 27, 35);
		contentPane.add(label);
		
		btnNewButton = new JButton("일일 마감");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton.addActionListener(this);
		
		btnNewButton.setBounds(353, 95, 123, 33);
		contentPane.add(btnNewButton);
		ButtonGroup bG = new ButtonGroup();
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnSale3){
			this.dispose();
			MainFrame home = new MainFrame();
			home.setVisible(true);
		}
		if(resource == btnNewButton) {
			Calendar cal = Calendar.getInstance();
			sale = new SaleVo();
			String allMenuString = "";
			int total = 0 ;
			SimpleDateFormat dateType = new SimpleDateFormat("yyyyMMdd");
			String date = dateType.format(cal.getTime());// 오늘자로 커스텀 날짜 포멧 지정
			System.out.println(date);
			cafeDAOImp.getDailyOrder(date);
			
			List<OrdersVo> orderList = cafeDAOImp.getDailyOrder(date); // 포멧에 맞는 날짜의 오더를 모두 검색
			
			 SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
			    String formatted = format1.format(cal.getTime());
			    System.out.println(formatted);
			    String a = "20180516";
//			    List<OrdersVo> temp =  sqlSession.selectList("Sale.getDailyOrder", formatted);
//			    for(OrdersVo v : temp) {
//			    	System.out.println(v);
//			    }
			
			
			
			
			
			List<HashMap<String, Object>> menuList = cafeDAOImp.getAllMenuByHashMap();// 키값 MENUNO 밸류값 MNAME
			List<Integer> countMenu = new ArrayList<>();
			
			Iterator it = null;
			for(int i = 0 ; i < menuList.size() ; i ++) {
				int count = 0;
				it = menuList.get(i).keySet().iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				
				
				// 메뉴의 번호를 뽑아내고 비교하기 위한 이터레이터
				while(it.hasNext()) {
					Object menuNo = it.next() ; // 이터레이터에 MENUNO를 하나씩 가져온다.
					System.out.println(menuNo);
					for(OrdersVo v : orderList) {
						if((int)menuNo == v.getMenuNo()) {// 메뉴의 번호가 오더의 메뉴번호에 같으면 개수를 더해서 리턴
							count += v.getCount();
						}
						countMenu.add(count); //
						count = 0;
					}					
				}
			}
			for(Integer i : countMenu) {
				System.out.println(i);
			}
			
//			List<HashMap<Integer, String>> menuList = new ArrayList<>();
//			HashMap<Integer, String> = 
//			for(int i = 0 ; i < menuList.size() ; i ++) {
//				menuNo.get(menuList.get(i).getMenuNo());
//			}
			
			for(OrdersVo temp : orderList) {
				total += temp.getTotal();
				
			}
		}
	}
}
