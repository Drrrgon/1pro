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

public class Order5 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel label_1, lblCafe;
	private JButton btnOrder12;
	private JTextArea textAreaOrder2;

	/**
	 * Create the frame.
	 */
	public Order5() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_1 = new JLabel("현재 주문 현황");
		label_1.setBounds(43, 69, 96, 16);
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
		
		textAreaOrder2 = new JTextArea();
		textAreaOrder2.setBounds(43, 97, 364, 127);
		contentPane.add(textAreaOrder2);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnOrder12){
			this.dispose();
			Home home = new Home();
			home.setVisible(true);
		}
	}
}
