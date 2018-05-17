package gui.member;

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

import gui.main.MainFrame;
import system.DAO.imp.CafeDAOImp;
import vo.MemberVo;

public class MemberAddFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtMember1, txtMember2;
	private JLabel label, label_1, lblCafe;
	private JButton btnMember3;
	private JButton btnMember2;
	private CafeDAOImp cafeDAOImp;
	/**
	 * Create the frame.
	 */
	public MemberAddFrame() {
		cafeDAOImp = CafeDAOImp.getInstance();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 이름");
		label.setBounds(73, 240, 210, 50);
		label.setFont(new Font("Dialog", Font.PLAIN, 45));
		contentPane.add(label);
		
		label_1 = new JLabel("2. 전화번호");
		label_1.setBounds(73, 341, 249, 60);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 45));
		contentPane.add(label_1);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(259, 50, 227, 89);
		lblCafe.setFont(new Font("Dialog", Font.PLAIN, 70));
		contentPane.add(lblCafe);
		
		btnMember3 = new JButton("HOME");
		btnMember3.setBounds(672, 503, 108, 50);
		btnMember3.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnMember3.addActionListener(this);
		btnMember3.setForeground(Color.BLACK);
		contentPane.add(btnMember3);
		
		txtMember1 = new JTextField();
		txtMember1.setBounds(355, 240, 300, 50);
		txtMember1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		contentPane.add(txtMember1);
		txtMember1.setColumns(10);
		
		txtMember2 = new JTextField();
		txtMember2.setBounds(355, 341, 300, 50);
		txtMember2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		txtMember2.setColumns(10);
		contentPane.add(txtMember2);
		
		btnMember2 = new JButton("회원 등록");
		btnMember2.setBounds(284, 434, 153, 50);
		btnMember2.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnMember2.addActionListener(this);
		btnMember2.setForeground(Color.BLACK);
		contentPane.add(btnMember2);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnMember2){
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
		if(resource == btnMember3){
			this.dispose();
			MainFrame home = new MainFrame();
			home.setVisible(true);
		}
	}
}
