package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.listener.MenuFrameListener;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;

public class MenuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtMenuname;
	private JTextField txtMenuprice;
	public JButton btnReg;
	public JList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
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
	public MenuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMenuname = new JTextField();
		txtMenuname.setText("Menuname");
		txtMenuname.setBounds(213, 35, 116, 21);
		contentPane.add(txtMenuname);
		txtMenuname.setColumns(10);
		
		txtMenuprice = new JTextField();
		txtMenuprice.setText("MenuPrice");
		txtMenuprice.setBounds(213, 98, 116, 21);
		contentPane.add(txtMenuprice);
		txtMenuprice.setColumns(10);
		
		JTextPane txtpnMenuname = new JTextPane();
		txtpnMenuname.setText("MenuName");
		txtpnMenuname.setBounds(213, 152, 116, 27);
		contentPane.add(txtpnMenuname);
		
		JLabel lblMenuname = new JLabel("MenuName");
		lblMenuname.setBounds(47, 35, 120, 21);
		contentPane.add(lblMenuname);
		
		JLabel lblMenuprice = new JLabel("MenuPrice");
		lblMenuprice.setBounds(47, 101, 84, 18);
		contentPane.add(lblMenuprice);
		
		JLabel lblOriginalprice = new JLabel("OriginalPrice");
		lblOriginalprice.setBounds(47, 148, 84, 31);
		contentPane.add(lblOriginalprice);
		
		btnReg = new JButton("reg");
		btnReg.setBounds(341, 34, 97, 23);
		contentPane.add(btnReg);
		
		JButton btnDel = new JButton("del");
		btnDel.setBounds(460, 34, 97, 23);
		contentPane.add(btnDel);
		
		JButton btnPrint = new JButton("print");
		btnPrint.setBounds(341, 97, 97, 23);
		contentPane.add(btnPrint);
		
	    list = new JList();
		list.setBounds(40, 234, 517, 195);
		contentPane.add(list);
		
		btnReg.addActionListener(new MenuFrameListener(this));
		btnPrint.addActionListener(new MenuFrameListener(this));
		
	}
	public void launchFrame() {
		
		
	}
}
