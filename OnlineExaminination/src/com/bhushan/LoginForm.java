//Importing All packages
package com.bhushan;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;

/**
 * User Login using Swing
 * @author Bhushan chaudhari
 *
 */
public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UserIDTextField;
	private JPasswordField passwordField;
    private JButton btnlogin;

	 // Create the frame.
	
		public LoginForm() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(250, 50, 1014, 650);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(175, 238, 238));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
	        
	        //create label for UserID
			JLabel lbluserid = new JLabel("UserID");
			lbluserid.setForeground(new Color(255, 255, 255));
			lbluserid.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lbluserid.setBounds(323, 155, 99, 43);
	        contentPane.add(lbluserid);
		
		    //create Textfield for UserID
	        UserIDTextField = new JTextField();
	        UserIDTextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        UserIDTextField.setBounds(446, 147, 228, 50);
	        contentPane.add(UserIDTextField);
	        UserIDTextField.setColumns(10);

	        
	      
	        //create label for password field
	        JLabel lblpassword = new JLabel("Password");
	        lblpassword.setForeground(new Color(255, 255, 255));
	        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblpassword.setBounds(323, 247, 110, 29);
	        contentPane.add(lblpassword);
	        
	        //create Textfield for password
	        passwordField = new JPasswordField();
	        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        passwordField.setBounds(446, 232, 228, 50);
	        contentPane.add(passwordField);
		
	        //Craete Button for login
			btnlogin = new JButton("Login");
			btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
			btnlogin.setBounds(446, 324, 228, 50);
	        contentPane.add(btnlogin);
			btnlogin.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
 
                try {

                    String query = "SELECT * FROM user WHERE UserID='" + UserIDTextField.getText() + "'&& Password='" + passwordField.getText() + "'";

                   
					Statement sta = DBConnection.getConnection().createStatement();
                    ResultSet rs = sta.executeQuery(query);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(btnlogin, "Login Successful...!");
                        //after successful login redirect to Dashboard
                        Dashboard frame = new Dashboard();
    					frame.setVisible(true);
    					dispose();
                    }else {
                        JOptionPane.showMessageDialog(btnlogin, "Login Failed...!");
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
		
		
        //create label link for registration
        JLabel lbltoregister = new JLabel("Click here to Register");
        lbltoregister.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbltoregister.setBounds(446, 395, 228, 43);
        contentPane.add(lbltoregister);
        lbltoregister.setForeground(new Color(72, 209, 204));
        lbltoregister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\studyon_header_20161.jpg"));
        lblNewLabel.setBounds(0, 54, 998, 557);
        contentPane.add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 255, 153));
        panel.setBounds(0, 0, 998, 55);
        contentPane.add(panel);
        	panel.setLayout(null);
        
        	//create label
        	JLabel lblNewUserRegister = new JLabel("User Login");
        	lblNewUserRegister.setBounds(398, 0, 189, 49);
        	panel.add(lblNewUserRegister);
        	lblNewUserRegister.setForeground(new Color(0, 0, 0));
        	lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lbltoregister.addMouseListener(new MouseAdapter() {
        	 
            public void mouseClicked(MouseEvent e) {
            	
                //after successful registration redirect to login
            	RegistrationForm frame = new RegistrationForm();
                frame.setVisible(true);
                dispose();
            	
            }
         
        });
		
	}
}
