package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import vo.DailyVo;
import vo.MenuVo;
import vo.SaleVo;
import javax.swing.SpinnerDateModel;

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
		lblCafe.setBounds(278, 27, 93, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		contentPane.add(lblCafe);
		
		btnSale3 = new JButton("HOME");
		btnSale3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnSale3.addActionListener(this);
		btnSale3.setBounds(551, 416, 83, 36);
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
		btnSale2.setBounds(506, 94, 101, 36);
		contentPane.add(btnSale2);
		btnSale2.addActionListener(this);
		
		textAreaSale1 = new JTextArea();
		textAreaSale1.setEditable(false);
		textAreaSale1.setBounds(46, 147, 561, 213);
		contentPane.add(textAreaSale1);
		
		
		
		spinnerSale1 = new JSpinner(new SpinnerNumberModel(2018, 1990, 2999, 1));
		;
		spinnerSale1.setBounds(46, 96, 83, 29);
		contentPane.add(spinnerSale1);
		
		label = new JLabel("년");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(133, 93, 27, 35);
		contentPane.add(label);
		
		btnNewButton = new JButton("일일 마감");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton.addActionListener(this);
		
		btnNewButton.setBounds(391, 96, 101, 33);
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
			String allMenuString = "";
			
			SimpleDateFormat dateType = new SimpleDateFormat("yyyyMMdd");
			String date = dateType.format(cal.getTime());// 오늘자로 커스텀 날짜 포멧 지정
			System.out.println(date);
			cafeDAOImp.getDailyOrder(date);
			
			List<MenuVo> menuList = cafeDAOImp.getAllMenu();// 키값 MENUNO 밸류값 MNAME
			List<Integer> menuNo = new ArrayList<>();
			List<String> menuName = new ArrayList<>();			
			List<Integer> countMenu = new ArrayList<>();
			int total = 0 ;
			int totalOriginal = 0;
			int countAll = 0;
			
			List<DailyVo> orderList = cafeDAOImp.getDailyOrder(date); // 포멧에 맞는 날짜의 오더를 모두 검색
			
			for(MenuVo temp : menuList) {
				menuNo.add(temp.getMenuNo());
				menuName.add(temp.getmName());
			}
			for(Integer av : menuNo) {
				for(DailyVo ov : orderList) {
					if(av == ov.getMenuNo()) {
						System.out.println(ov.getMenuNo());
						countAll++;
					}
				}
				countMenu.add(countAll);
				countAll = 0;
			}
			
			for(Integer s: countMenu) {
				System.out.println(s);
			}
						
			for(DailyVo k : orderList) {
				totalOriginal += k.getMoriginalPrice();
				total += k.getTotal();
			}
			for(int i = 0 ; i < menuList.size() ; i ++) {
				allMenuString +=" 메뉴번호 : "+ menuNo.get(i)+" 메뉴이름 : "+ menuName.get(i)+" 수량 : "+ countMenu.get(i)+"\n";
			}
			
			System.out.println(allMenuString);
			SaleVo sale = new SaleVo(allMenuString,total,totalOriginal);
			System.out.println(cafeDAOImp.insertDailyClosed(sale));
			textAreaSale1.setText(sale.toString());			
		}
		
		if(resource == btnSale2) {
			textAreaSale1.setText("");
			SaleVo sale = new SaleVo();
			int a = (int) spinnerSale1.getValue();
			int b = (int) spinnerSale2.getValue();
			int c = (int) spinnerSale3.getValue();
			
			String str="";
			
			if(b<10) {
				if(c<10) {
					 
					String b1 = String.format( "%02d" , b );
					String c1 = String.format( "%02d" , c );
					str = ""+a+b1+c1;
				}else {
					String b1 = String.format( "%02d" , b );
					str = ""+a+b1+c;
				}
			}else {
				if(c<10) {
					String c1 = String.format( "%02d" , c );
					str = ""+a+b+c1;
				}
				str = ""+a+b+c;
			}
			Date date;
			System.out.println(str);
			try {
				date = new SimpleDateFormat("yyyyMMdd").parse(str);
				System.out.println(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			sale = cafeDAOImp.getDailyByDate(str);
			textAreaSale1.setText(sale.toString());
			
			
			
		}
	}
}
