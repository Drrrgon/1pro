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

public class Menu2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCafe;
	private JButton btnMenu5;
	private JLabel label;
	private JTextArea textAreaMenu1;

	/**
	 * Create the frame.
	 */
	public Menu2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCafe = new JLabel("Cafe24");
		lblCafe.setBounds(187, 23, 69, 29);
		lblCafe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblCafe);
		
		btnMenu5 = new JButton("HOME");
		btnMenu5.addActionListener(this);
		btnMenu5.setBounds(365, 243, 79, 29);
		btnMenu5.setForeground(Color.BLACK);
		contentPane.add(btnMenu5);
		
		label = new JLabel("전체 메뉴 목록");
		label.setBounds(48, 58, 111, 16);
		contentPane.add(label);
		
		textAreaMenu1 = new JTextArea();
		textAreaMenu1.setBounds(48, 86, 351, 128);
		contentPane.add(textAreaMenu1);
	}
	public void actionPerformed(ActionEvent e) {
		JButton resource = (JButton) e.getSource();
		if(resource == btnMenu5){
			this.dispose();
			MainFrame home = new MainFrame();
			home.setVisible(true);
		}
	}
}
