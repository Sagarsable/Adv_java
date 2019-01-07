package com.java.jdbc;
import java.sql.*;
public class Conn_test 
{
	public static void main(String args [])
	throws Exception{
		Connection con =DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
		if (con==null)
		{
			System.out.println("Connection failed");
		}
		else
			System.out.println("Connection successful");
	}

}
