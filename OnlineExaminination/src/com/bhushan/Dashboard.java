package com.bhushan;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1014, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
        JButton btnstartexam = new JButton("Start Exam");
        btnstartexam.setForeground(new Color(0, 0, 0));
        btnstartexam.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int a=JOptionPane.showConfirmDialog(btnstartexam, "Are you sure");
				if(a==JOptionPane.YES_OPTION)
				{
        		MainPage frame = new MainPage("Java Online Exam");
				frame.setVisible(true);
				dispose();
				}
				
        	}
        });
        btnstartexam.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnstartexam.setBounds(10, 105, 204, 44);
        contentPane.add(btnstartexam);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\studyon_header_20161.jpg"));
        lblNewLabel_1.setBounds(0, 44, 998, 567);
        contentPane.add(lblNewLabel_1);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 255, 153));
        panel.setBounds(0, 0, 998, 44);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton btnUpdate = new JButton("Update Profile");
        btnUpdate.setBounds(643, 5, 184, 35);
        panel.add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		UpdateProfile frame = new UpdateProfile();
				frame.setVisible(true);
				dispose();
        	}
        	
        });
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 22));
        
        
        JButton btnlogout = new JButton("LogOut");
        btnlogout.setBounds(858, 6, 130, 32);
        panel.add(btnlogout);
        btnlogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int a=JOptionPane.showConfirmDialog(btnlogout, "Are you sure");
        		
        		if(a==JOptionPane.YES_OPTION)
        		{
        			
        			LoginForm frame = new LoginForm();
        			frame.setVisible(true);
        			dispose();
        		}
        	}
        });
        btnlogout.setFont(new Font("Tahoma", Font.PLAIN, 22));
        
        JLabel lblNewLabel = new JLabel("Welcome to Online Examination");
        lblNewLabel.setBounds(10, 9, 398, 26);
        panel.add(lblNewLabel);
        lblNewLabel.setForeground(new Color(0, 0, 153));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
	}
}
