package com.bhushan;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UpdateProfile extends JFrame {

	 private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JTextField name;
	    private JTextField phone;
	    private JTextField userID;
	    private JPasswordField passwordField;
	    private JButton btnupdateprofile;
	    private JLabel lblNewLabel;
	    private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProfile frame = new UpdateProfile();
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
	public UpdateProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        setBounds(250, 50, 1014, 650);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(175, 238, 238));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblName = new JLabel("Name");
	        lblName.setForeground(new Color(255, 255, 255));
	        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblName.setBounds(291, 139, 99, 43);
	        contentPane.add(lblName);

	        JLabel lblphone = new JLabel("Phone");
	        lblphone.setForeground(new Color(255, 255, 255));
	        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblphone.setBounds(291, 217, 110, 29);
	        contentPane.add(lblphone);

	        name = new JTextField();
	        name.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        name.setBounds(447, 131, 228, 50);
	        contentPane.add(name);
	        name.setColumns(10);

	        phone = new JTextField();
	        phone.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        phone.setBounds(447, 202, 228, 50);
	        contentPane.add(phone);
	        phone.setColumns(10);

	        userID = new JTextField();
	        userID.setEditable(false);
	        userID.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        userID.setBounds(447, 279, 228, 50);
	        contentPane.add(userID);
	        userID.setColumns(10);

	        JLabel lblUserID = new JLabel("UserID");
	        lblUserID.setForeground(new Color(255, 255, 255));
	        lblUserID.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblUserID.setBounds(291, 294, 99, 29);
	        contentPane.add(lblUserID);

	        JLabel lblPassword = new JLabel("Password");
	        lblPassword.setForeground(new Color(255, 255, 255));
	        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblPassword.setBounds(291, 374, 99, 24);
	        contentPane.add(lblPassword);

	        passwordField = new JPasswordField();
	        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        passwordField.setBounds(447, 357, 228, 50);
	        contentPane.add(passwordField);
	        
	        btnupdateprofile = new JButton("Update");
	        //Fill data of current user
	        try {
    			String query = "SELECT * FROM user where UserID=111";
        		Statement sta = DBConnection.getConnection().createStatement();
                ResultSet rs = sta.executeQuery(query);
        		 while (rs.next()){   
        		 name.setText(rs.getString(String.valueOf("Name")));
        		 phone.setText(rs.getString(String.valueOf("Phone")));
        		 userID.setText(rs.getString(String.valueOf("UserID")));
        		 passwordField.setText(rs.getString(String.valueOf("password")));
        		 }

        		 sta.close();
        		 rs.close();
    
    		}catch(Exception exception)
    		{
    			 exception.printStackTrace();
    		}
	        btnupdateprofile.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Statement stmt=null;
	        		
	        		
	        		String Name = name.getText();
	                String Phone = phone.getText();
	                String UserID = userID.getText();
	                String password = passwordField.getText();

	                try (Connection connection = DBConnection.getConnection();
	                		   PreparedStatement statement = 
	                		     connection.prepareStatement("update user set Name='" + Name + "',Phone='" + Phone + "',Password='" + password + "' where UserID='" + UserID + "'")) {
	                			statement.executeUpdate();
	                            JOptionPane.showMessageDialog(null, "Update Successful...!");
	                            //statement.close();
	                            Dashboard frame = new Dashboard();
	        					frame.setVisible(true);
	        					dispose();
	                		 } catch (SQLException ex) {
	                		 }
	        }
	        	
	        });
	        btnupdateprofile.setFont(new Font("Tahoma", Font.PLAIN, 22));
	        btnupdateprofile.setBounds(447, 448, 259, 50);
	        contentPane.add(btnupdateprofile);
	        
	        lblNewLabel = new JLabel("");
	        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\studyon_header_20161.jpg"));
	        lblNewLabel.setBounds(0, 50, 998, 561);
	        contentPane.add(lblNewLabel);
	        
	        panel = new JPanel();
	        panel.setBackground(new Color(102, 255, 153));
	        panel.setBounds(0, 0, 998, 50);
	        contentPane.add(panel);
	        
	        	        JLabel lblNewUserRegister = new JLabel("Update User Profile");
	        	        lblNewUserRegister.setBackground(new Color(102, 255, 153));
	        	        panel.add(lblNewUserRegister);
	        	        lblNewUserRegister.setForeground(new Color(0, 0, 0));
	        	        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
	}
	

}
