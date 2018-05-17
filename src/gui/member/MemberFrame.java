package gui.member;

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
import gui.member.listener.MemberFrameListSelectionListener;
import system.DAO.imp.CafeDAOImp;
import vo.MemberVo;
import vo.MenuVo;

public class MemberFrame extends JFrame implements ActionListener {

	private JPanel contentPane, panel;
	private JTextField telNumber, name;
	private JLabel label, label_1, lblCafe;
	private JButton home;
	private JButton deleteMember;
	private CafeDAOImp cafeDAOImp;
	private JButton serchMember;
	private JButton addMember;
	public JTextField resultField;
	public JList<String> memberList;
	public DefaultListModel<String> modelMenuList;
	private List<MemberVo> list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberFrame frame = new MemberFrame();
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
	public MemberFrame() {
		cafeDAOImp = CafeDAOImp.getInstance();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("전화번호");
		label.setBounds(48, 128, 110, 29);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		contentPane.add(label);
		
		label_1 = new JLabel("이름");
		label_1.setBounds(48, 174, 110, 29);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		contentPane.add(label_1);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(227, 27, 200, 50);
		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 50));
		contentPane.add(lblCafe);
		
		home = new JButton("HOME");
		home.setBounds(699, 518, 83, 39);
		home.setFont(new Font("Dialog", Font.PLAIN, 15));
		home.addActionListener(this);
		home.setForeground(Color.BLACK);
		contentPane.add(home);
		
		telNumber = new JTextField();
		telNumber.setBounds(145, 122, 200, 39);
		telNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		contentPane.add(telNumber);
		telNumber.setColumns(10);
		
		name = new JTextField();
		name.setBounds(145, 168, 200, 39);
		name.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		name.setColumns(10);
		contentPane.add(name);
		
		deleteMember = new JButton("회원 삭제");
		deleteMember.setBounds(250, 397, 114, 39);
		deleteMember.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		deleteMember.addActionListener(this);
		deleteMember.setForeground(Color.BLACK);
		contentPane.add(deleteMember);
		
		serchMember = new JButton("회원 검색");
		serchMember.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		serchMember.setBounds(371, 123, 117, 39);
		contentPane.add(serchMember);
		
		addMember = new JButton("회원 등록");
		addMember.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		addMember.setBounds(371, 171, 117, 39);
		contentPane.add(addMember);
		
		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setColumns(10);
		resultField.setBounds(40, 222, 573, 21);
		contentPane.add(resultField);
		
		modelMenuList = getMenuList();
	    memberList = new JList(modelMenuList);
	    memberList.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
	    memberList.setBounds(35, 229, 573, 160);
		contentPane.add(memberList);
		memberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane sp = new JScrollPane(memberList);
		memberList.addListSelectionListener(new MemberFrameListSelectionListener(this));
		
		sp.setPreferredSize(new Dimension(549, 221));
		sp.setVisible(true);
//		sp.setViewportView(memberList);
		 
		panel = new JPanel();
		panel.setSize(new Dimension(400, 400));
		panel.setBounds(40, 243, 573, 142);
		panel.add(sp);
		contentPane.add(panel);		

	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == deleteMember){
			MemberVo member = new MemberVo();
			if(telNumber.getText().length() == 0 || name.getText().length() == 0  ) {
				JOptionPane.showConfirmDialog(resource, "이름과 전화 번호를 정확히 입력해 주세요.", "공백 오류", JOptionPane.PLAIN_MESSAGE);
			}
			member.setmName(telNumber.getText());
			member.setTelNo(name.getText());
			int re = cafeDAOImp.insertMember(member);
			System.out.println(re);
			
			
			JOptionPane.showConfirmDialog(resource, "회원등록되었습니다.", "회원등록", JOptionPane.PLAIN_MESSAGE);
			telNumber.setText("");
			name.setText("");
		}
		if(resource == home){
			this.dispose();
			MainFrame home = new MainFrame();
			home.setVisible(true);
		}
	}
	
	/**
	 * @return DefaultListModel<String>
	 * 메뉴를 불러와서 리스트 모델로 반환합니다.
	 */
	public DefaultListModel<String> getMenuList() {
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		list = cafeDAOImp.getAllMember();		
		for(int i = 0 ; i < list.size() ; i ++) {			
			listModel.addElement(list.get(i).toString());
		}		
		return listModel;
	}
}
