package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;

public class Sale1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCafe;
	private JButton btnSale3;
	private JRadioButton rdbtnOrder1, rdbtnOrder2;
	private JComboBox cbOrder1;
	private JSpinner spinner;
	private JSpinner spinnerSale1;
	private JSpinner spinnerSale2;
	private JLabel label_1;
	private JLabel label_2;
	private JButton btnSale2;
	private JTextArea textAreaSale1;


	/**
	 * Create the frame.
	 */
	public Sale1() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(187, 23, 69, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblCafe);
		
		btnSale3 = new JButton("HOME");
		btnSale3.addActionListener(this);
		btnSale3.setBounds(385, 265, 79, 29);
		btnSale3.setForeground(Color.BLACK);
		contentPane.add(btnSale3);
		
		spinnerSale1 = new JSpinner();
		spinnerSale1.setBounds(40, 83, 50, 26);
		contentPane.add(spinnerSale1);
		
		spinnerSale2 = new JSpinner();
		spinnerSale2.setBounds(119, 83, 50, 26);
		contentPane.add(spinnerSale2);
		
		label_1 = new JLabel("월");
		label_1.setBounds(99, 88, 19, 16);
		contentPane.add(label_1);
		
		label_2 = new JLabel("일");
		label_2.setBounds(178, 88, 19, 16);
		contentPane.add(label_2);
		
		btnSale2 = new JButton("매출 조회");
		btnSale2.setBounds(209, 83, 79, 29);
		contentPane.add(btnSale2);
		
		textAreaSale1 = new JTextArea();
		textAreaSale1.setBounds(40, 124, 358, 128);
		contentPane.add(textAreaSale1);
		ButtonGroup bG = new ButtonGroup();
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnSale3){
			this.dispose();
			Home home = new Home();
			home.setVisible(true);
		}
	}
}
