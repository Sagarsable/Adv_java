package com.java.SimpleStatement;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn_test {

	public static void main(String args [])
	throws Exception{
		Connection con =DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
		if (con==null)
		{
			System.out.println("Connection failed");
		}
		else
			System.out.println("Connection successful");
	}

}
