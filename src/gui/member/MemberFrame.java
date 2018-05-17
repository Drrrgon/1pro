package gui.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import gui.main.MainFrame;
import system.DAO.imp.CafeDAOImp;
import vo.MemberVo;
import javax.swing.JList;

public class MemberFrame extends JFrame implements ActionListener {

	private JPanel contentPane, panel;
	private JTextField txtMember1, txtMember2;
	private JLabel label, label_1, lblCafe;
	private JButton btnMember5;
	private JButton btnMember4;
	private CafeDAOImp cafeDAOImp;
	private JButton btnMember2;
	private JButton btnMember3;
	private JTextField textField;
	private JList<String> memberList;
	
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
		label.setBounds(48, 128, 96, 29);
		label.setFont(new Font("Arial", Font.PLAIN, 17));
		contentPane.add(label);
		
		label_1 = new JLabel("이름");
		label_1.setBounds(48, 174, 110, 29);
		label_1.setFont(new Font("Arial", Font.PLAIN, 17));
		contentPane.add(label_1);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(227, 27, 200, 50);
		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 50));
		contentPane.add(lblCafe);
		
		btnMember5 = new JButton("HOME");
		btnMember5.setBounds(699, 518, 83, 39);
		btnMember5.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnMember5.addActionListener(this);
		btnMember5.setForeground(Color.BLACK);
		contentPane.add(btnMember5);
		
		txtMember1 = new JTextField();
		txtMember1.setBounds(145, 122, 200, 39);
		txtMember1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		contentPane.add(txtMember1);
		txtMember1.setColumns(10);
		
		txtMember2 = new JTextField();
		txtMember2.setBounds(145, 168, 200, 39);
		txtMember2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		txtMember2.setColumns(10);
		contentPane.add(txtMember2);
		
		btnMember4 = new JButton("회원 삭제");
		btnMember4.setBounds(250, 397, 114, 39);
		btnMember4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember4.addActionListener(this);
		btnMember4.setForeground(Color.BLACK);
		contentPane.add(btnMember4);
		
		btnMember2 = new JButton("회원 검색");
		btnMember2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember2.setBounds(371, 123, 117, 39);
		contentPane.add(btnMember2);
		
		btnMember3 = new JButton("회원 등록");
		btnMember3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember3.setBounds(371, 171, 117, 39);
		contentPane.add(btnMember3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(40, 222, 573, 21);
		contentPane.add(textField);
		
		
	    memberList = new JList();
	    memberList.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
	    memberList.setBounds(35, 229, 573, 160);
		contentPane.add(memberList);
		memberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane sp = new JScrollPane(memberList);
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
		if(resource == btnMember4){
			MemberVo member = new MemberVo();
			if(txtMember1.getText().length() == 0 || txtMember2.getText().length() == 0  ) {
				JOptionPane.showConfirmDialog(resource, "이름과 전화 번호를 정확히 입력해 주세요.", "공백 오류", JOptionPane.PLAIN_MESSAGE);
			}
			member.setmName(txtMember1.getText());
			member.setTelNo(txtMember2.getText());
			int re = cafeDAOImp.insertMember(member);
			System.out.println(re);
			
			
			JOptionPane.showConfirmDialog(resource, "회원등록되었습니다.", "회원등록", JOptionPane.PLAIN_MESSAGE);
			txtMember1.setText("");
			txtMember2.setText("");
		}
		if(resource == btnMember5){
			this.dispose();
			MainFrame home = new MainFrame();
			home.setVisible(true);
		}
	}
}
