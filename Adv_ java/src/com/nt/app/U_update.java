package com.nt.app;
import java.util.*;
import java.sql.*;
public class U_update {
public static void main(String args[])
throws ClassNotFoundException,SQLException
	{
	Scanner s = new Scanner(System.in);
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con =DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
	
	}
}
