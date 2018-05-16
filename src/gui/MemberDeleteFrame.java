package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import system.DAO.imp.CafeDAOImp;
import vo.MemberVo;

public class MemberDeleteFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtMember3, txtMember4;
	private JLabel label, label_1, lblCafe;
	private JButton btnMember6;
	private JButton btnMember5;
	private JButton btnMember4;
	private CafeDAOImp cafeDAOImp;
	private boolean av = false;
	/**
	 * Create the frame.
	 */
	public MemberDeleteFrame() {
		
		cafeDAOImp = CafeDAOImp.getInstance();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 전화번호");
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		label.setBounds(118, 147, 110, 29);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 회원 이름");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		label_1.setBounds(118, 220, 110, 29);
		contentPane.add(label_1);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(216, 34, 212, 53);
		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 50));
		contentPane.add(lblCafe);
		
		btnMember6 = new JButton("HOME");
		btnMember6.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember6.addActionListener(this);
		btnMember6.setBounds(524, 383, 83, 39);
		btnMember6.setForeground(Color.BLACK);
		contentPane.add(btnMember6);
		
		txtMember3 = new JTextField();
		txtMember3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		txtMember3.setBounds(251, 138, 200, 50);
		contentPane.add(txtMember3);
		txtMember3.setColumns(10);
		
		
		txtMember4 = new JTextField();
		txtMember4.setEditable(false);
		txtMember4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		txtMember4.setColumns(10);
		txtMember4.setBounds(251, 211, 200, 50);
		contentPane.add(txtMember4);
		
		
		btnMember5 = new JButton("회원 삭제");
		btnMember5.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnMember5.addActionListener(this);
		btnMember5.setForeground(Color.BLACK);
		btnMember5.setBounds(271, 302, 114, 39);
		contentPane.add(btnMember5);
		
		btnMember4 = new JButton("검색");
		btnMember4.addActionListener(this);
		btnMember4.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnMember4.setForeground(Color.BLACK);
		btnMember4.setBounds(465, 138, 72, 31);
		contentPane.add(btnMember4);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		
		if(btnMember4 == resource) {
			int temp = Integer.parseInt(txtMember3.getText());
			MemberVo str = cafeDAOImp.getMember(temp);
			txtMember4.setText(str.getmName());			
			if(str.getmName().length() == 0) {
				JOptionPane.showConfirmDialog(resource, "회원 검색을 해주세요.", "검색 오류", JOptionPane.PLAIN_MESSAGE);
//				av = true;
			}else {
//				JOptionPane.showConfirmDialog(resource, "회원 검색을 해주세요.", "검색 오류", JOptionPane.PLAIN_MESSAGE);
				av = true;
			}
			
		}
		
		if(resource == btnMember5 && av == true){
			int result = cafeDAOImp.deleteMemberByTelNo(txtMember3.getText());
			if(result != 0 ) {
			JOptionPane.showConfirmDialog(resource, "회원삭제되었습니다.", "회원삭제", JOptionPane.PLAIN_MESSAGE);
			txtMember3.setText("");
			txtMember4.setText("");
			av = false;
			}
			
		if(resource == btnMember6){
			this.dispose();
			MainFrame home = new MainFrame();
			home.setVisible(true);
		}
	}
}
}
