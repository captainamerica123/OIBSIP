
//import packages
package com.bhushan;

import java.awt.EventQueue;

public class Login {

	//Execution start from this method
	public static void main(String[] args) {
		//Database Connection
		 System.out.println("connection"+ DBConnection.getConnection());
	        new LoginForm();
	        new RegistrationForm();
	        new UpdateProfile();
	        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
