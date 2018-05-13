package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Order4 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtOrder5;
	private JLabel label, label_1, lblCafe;
	private JButton btnOrder12;
	private JTextArea textAreaOrder1;
	private JButton btnOrder11;
	private JButton btnOrder10;

	/**
	 * Create the frame.
	 */
	public Order4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 주문번호");
		label.setBounds(44, 77, 96, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 주문내역");
		label_1.setBounds(44, 105, 96, 16);
		contentPane.add(label_1);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(187, 23, 69, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblCafe);
		
		btnOrder12 = new JButton("HOME");
		btnOrder12.setBounds(365, 243, 79, 29);
		btnOrder12.addActionListener(this);
		btnOrder12.setForeground(Color.BLACK);
		contentPane.add(btnOrder12);
		
		txtOrder5 = new JTextField();
		txtOrder5.setBounds(130, 72, 118, 26);
		contentPane.add(txtOrder5);
		txtOrder5.setColumns(10);
		
		textAreaOrder1 = new JTextArea();
		textAreaOrder1.setBounds(54, 133, 325, 79);
		contentPane.add(textAreaOrder1);
		
		btnOrder11 = new JButton("주문취소");
		btnOrder11.addActionListener(this);
		btnOrder11.setForeground(Color.BLACK);
		btnOrder11.setBounds(168, 220, 79, 29);
		contentPane.add(btnOrder11);
		
		btnOrder10 = new JButton("검색");
		btnOrder10.setForeground(Color.BLACK);
		btnOrder10.setBounds(260, 72, 54, 29);
		contentPane.add(btnOrder10);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnOrder11){
			JOptionPane.showConfirmDialog(resource, "주문취소되었습니다.","주문취소", JOptionPane.PLAIN_MESSAGE);
		}
		if(resource == btnOrder12){
			this.dispose();
			Home home = new Home();
			home.setVisible(true);
		}
	}
}
