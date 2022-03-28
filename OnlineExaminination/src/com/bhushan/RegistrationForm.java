//Import all packages

package com.bhushan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;

/**
 * User Registration using Swing
 * @author Bhushan chaudhari
 *
 */
public class RegistrationForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextField phone;
    private JTextField username;
    private JPasswordField passwordField;
    private JButton btnregister;
   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	RegistrationForm frame = new RegistrationForm();
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

    public RegistrationForm() {
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
        lblName.setBounds(284, 140, 99, 43);
        contentPane.add(lblName);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setForeground(new Color(255, 255, 255));
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblphone.setBounds(284, 218, 110, 29);
        contentPane.add(lblphone);

        name = new JTextField();
        name.setFont(new Font("Tahoma", Font.PLAIN, 32));
        name.setBounds(440, 132, 228, 50);
        contentPane.add(name);
        name.setColumns(10);

        phone = new JTextField();
        phone.setFont(new Font("Tahoma", Font.PLAIN, 32));
        phone.setBounds(440, 203, 228, 50);
        contentPane.add(phone);
        phone.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(440, 280, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUserID = new JLabel("UserID");
        lblUserID.setForeground(new Color(255, 255, 255));
        lblUserID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUserID.setBounds(284, 295, 99, 29);
        contentPane.add(lblUserID);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(284, 375, 99, 24);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(440, 358, 228, 50);
        contentPane.add(passwordField);

        btnregister = new JButton("Register");
        btnregister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Name = name.getText();
                String Phone = phone.getText();
                String UserID = username.getText();
                int len = Phone.length();
                String password = passwordField.getText();

                String msg = "" + Name;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnregister, "Enter a valid mobile number");
                    
                }

                try {

                    String query = "INSERT INTO user values('" + UserID + "','" + password + "','" +
                        Name + "','" + Phone + "')";

                    Statement sta = DBConnection.getConnection().createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnregister, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnregister,
                            "Welcome, " + msg + "Your account is sucessfully created");
                        LoginForm frame = new LoginForm();
    					frame.setVisible(true);
    					dispose();
                    }
                    //DBConnection.getConnection().close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnregister.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnregister.setBounds(440, 449, 259, 50);
        contentPane.add(btnregister);
        
        JLabel lbltologin = new JLabel("Already user? Login here");
        lbltologin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbltologin.setBounds(440, 521, 259, 43);
        contentPane.add(lbltologin);
        lbltologin.setForeground(new Color(72, 209, 204));
        lbltologin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\studyon_header_20161.jpg"));
        lblNewLabel.setBounds(0, 56, 998, 555);
        contentPane.add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(102, 255, 153));
        panel.setBounds(0, 0, 998, 56);
        contentPane.add(panel);
        
                JLabel lblNewUserRegister = new JLabel("New User Registration");
                lblNewUserRegister.setBackground(new Color(255, 255, 255));
                panel.add(lblNewUserRegister);
                lblNewUserRegister.setForeground(new Color(0, 0, 0));
                lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lbltologin.addMouseListener(new MouseAdapter() {
        	 
            public void mouseClicked(MouseEvent e) {
            	
            	LoginForm frame = new LoginForm();
                frame.setVisible(true);
                dispose();
            }
         
           
        });
    }
}