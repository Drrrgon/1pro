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

public class Order1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel label, label_1, label_2, lblCafe;
	private JButton btnOrder4, btnOrder5;
	private JRadioButton rdbtnOrder1, rdbtnOrder2;
	private JComboBox cbOrder1;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order1 frame = new Order1();
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
	public Order1() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("1. 메뉴선택");
		label.setBounds(30, 85, 91, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("2. 수량");
		label_1.setBounds(30, 132, 61, 16);
		contentPane.add(label_1);
		
		label_2 = new JLabel("3. 회원/비회원");
		label_2.setBounds(30, 176, 112, 16);
		contentPane.add(label_2);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(187, 23, 69, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblCafe);
		
		btnOrder5 = new JButton(">>");
		btnOrder5.addActionListener(this);
		btnOrder5.setBounds(365, 243, 79, 29);
		btnOrder5.setForeground(Color.BLACK);
		contentPane.add(btnOrder5);
		
		JComboBox cbOrder1 = new JComboBox();
		cbOrder1.setBounds(150, 80, 212, 27);
		contentPane.add(cbOrder1);
		
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(150, 126, 45, 29);
		contentPane.add(spinner);
		
		JRadioButton rdbtnOrder1 = new JRadioButton("회원");
		rdbtnOrder1.setBounds(150, 173, 61, 23);
		contentPane.add(rdbtnOrder1);
		
		JRadioButton rdbtnOrder2 = new JRadioButton("비회원");
		rdbtnOrder2.setSelected(true);
		rdbtnOrder2.setBounds(220, 173, 69, 23);
		contentPane.add(rdbtnOrder2);
		ButtonGroup bG = new ButtonGroup();
		bG.add(rdbtnOrder1);
		bG.add(rdbtnOrder2);
		
		btnOrder4 = new JButton("<<");
		btnOrder4.addActionListener(this);
		btnOrder4.setForeground(Color.BLACK);
		btnOrder4.setBounds(6, 243, 79, 29);
		contentPane.add(btnOrder4);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnOrder4){
			this.dispose();
			Home home = new Home();
			home.setVisible(true);
		}
		if(resource == btnOrder5){
			this.dispose();
			Order2 o2 = new Order2();
			o2.setVisible(true);
		}
	}
}
