package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vo.OrdersVo;

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
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.Rectangle;

public class Order4 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCafe;
	private JButton btnOrder11;
	private JButton btnOrder10;
	private JTextField txtOrder5;
	private JList listOrder1;
	private JLabel lblNewLabel;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order4 frame = new Order4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Order4() {
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(271, 35, 98, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		contentPane.add(lblCafe);
		
		lblNewLabel = new JLabel("주문 현황");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(48, 81, 79, 16);
		contentPane.add(lblNewLabel);
		
		btnOrder11 = new JButton("HOME");
		btnOrder11.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder11.setBounds(555, 416, 79, 36);
		btnOrder11.addActionListener(this);
		btnOrder11.setForeground(Color.BLACK);
		contentPane.add(btnOrder11);
		
		btnOrder10 = new JButton("주문취소");
		btnOrder10.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnOrder10.addActionListener(this);
		btnOrder10.setForeground(Color.BLACK);
		btnOrder10.setBounds(270, 368, 96, 36);
		contentPane.add(btnOrder10);
		
		txtOrder5 = new JTextField();
		txtOrder5.setEditable(false);
		txtOrder5.setColumns(10);
		txtOrder5.setBounds(41, 109, 558, 21);
		contentPane.add(txtOrder5);
		
		JScrollPane sp = new JScrollPane(listOrder1);
		sp.setPreferredSize(new Dimension(549, 221));
		sp.setVisible(true);
				
		//String [] a = {"aaaaaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa","aaa"};
		//listOrder1 = new JList(a);
		listOrder1 = new JList();
		listOrder1.setSize(new Dimension(400, 400));
		listOrder1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOrder1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		listOrder1.setSize(400, 400);
		sp.setViewportView(listOrder1);
		
		panel = new JPanel();
		panel.setSize(new Dimension(400, 400));
		panel.setBounds(48, 142, 549, 221);
		panel.add(sp);
		contentPane.add(panel);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnOrder10){
			JOptionPane.showConfirmDialog(resource, "주문취소되었습니다.","주문취소", JOptionPane.PLAIN_MESSAGE);
		}
		if(resource == btnOrder11){
			this.dispose();
			Home home = new Home();
			home.setVisible(true);
		}
	}
}
