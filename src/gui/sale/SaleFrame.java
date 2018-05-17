package gui.sale;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import gui.main.MainFrame;
import system.DAO.imp.CafeDAOImp;
import vo.DailyVo;
import vo.MenuVo;
import vo.SaleVo;

public class SaleFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCafe;
	private JButton btnSale3;
//	private JRadioButton rdbtnOrder1, rdbtnOrder2;
	private JComboBox cbOrder1;
//	private JSpinner spinner;
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
	private Calendar cal;
//	private SaleVo sale;
	/**
	 * Create the frame.
	 */
	public SaleFrame() {
		cafeDAOImp = CafeDAOImp.getInstance();
		cal = Calendar.getInstance();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(260, 57, 227, 79);
		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 70));
		contentPane.add(lblCafe);
		
		btnSale3 = new JButton("HOME");
		btnSale3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnSale3.addActionListener(this);
		btnSale3.setBounds(697, 514, 83, 39);
		btnSale3.setForeground(Color.BLACK);
		contentPane.add(btnSale3);
		
		spinnerSale2 = new JSpinner();
		spinnerSale2.setModel(new SpinnerNumberModel(cal.get(Calendar.MONTH)+1, 1, 12, 1));
		spinnerSale2.setBounds(184, 208, 62, 40);
		contentPane.add(spinnerSale2);
		
		spinnerSale3 = new JSpinner();
		spinnerSale3.setModel(new SpinnerNumberModel(cal.get(Calendar.DATE), 1, 31, 1));
		spinnerSale3.setBounds(297, 208, 47, 40);
		contentPane.add(spinnerSale3);
		
		label_1 = new JLabel("월");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_1.setBounds(260, 215, 27, 35);
		contentPane.add(label_1);
		
		label_2 = new JLabel("일");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_2.setBounds(358, 218, 27, 29);
		contentPane.add(label_2);
		
		btnSale2 = new JButton("매출 조회");
		btnSale2.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnSale2.setBounds(571, 208, 130, 40);
		contentPane.add(btnSale2);
		btnSale2.addActionListener(this);
		
		textAreaSale1 = new JTextArea();
		textAreaSale1.setEditable(false);
		textAreaSale1.setBounds(46, 269, 645, 213);
		contentPane.add(textAreaSale1);		
		
		spinnerSale1 = new JSpinner(new SpinnerNumberModel(cal.get(Calendar.YEAR), 1990, 2999, 1));
		spinnerSale1.setBounds(46, 208, 95, 40);
		contentPane.add(spinnerSale1);
		
		label = new JLabel("년");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(156, 215, 27, 35);
		contentPane.add(label);
		
		btnNewButton = new JButton("일일 마감");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnNewButton.addActionListener(this);
		
		btnNewButton.setBounds(437, 208, 130, 40);
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
			int re = cafeDAOImp.dailyClosing(date);
			System.out.println(re);
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
