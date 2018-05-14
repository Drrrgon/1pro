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
	private JSpinner spinnerSale2;
	private JSpinner spinnerSale3;
	private JLabel label_1;
	private JLabel label_2;
	private JButton btnSale2;
	private JTextArea textAreaSale1;
	private JSpinner spinnerSale1;
	private JLabel label;


	/**
	 * Create the frame.
	 */
	public Sale1() {
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
		spinnerSale2.setBounds(172, 96, 47, 33);
		contentPane.add(spinnerSale2);
		
		spinnerSale3 = new JSpinner();
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
		
		textAreaSale1 = new JTextArea();
		textAreaSale1.setBounds(46, 147, 561, 213);
		contentPane.add(textAreaSale1);
		
		spinnerSale1 = new JSpinner();
		spinnerSale1.setBounds(46, 96, 83, 33);
		contentPane.add(spinnerSale1);
		
		label = new JLabel("년");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(133, 93, 27, 35);
		contentPane.add(label);
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
