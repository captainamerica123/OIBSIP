package com.bhushan;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	 private static Connection con;

	    public static Connection getConnection() {
	        try {

	            if (con == null) {
	                //driver class load
	                Class.forName("com.mysql.cj.jdbc.Driver");

	                //create a connection..
	                con = DriverManager.
	                        getConnection("jdbc:mysql://localhost:3306/onlineexamdb", "root", "Bhushan@141");
	                
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return con;
	    }
}
