package com.java.SimpleStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select_test {

	public static void main(String []args)
	throws Exception{
		//Establish database connection
		Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
	//create jdbc statement object
		Statement st=con.createStatement();
		//execute query and set result in result set object
	 ResultSet rs=st.executeQuery("SELECT * FROM Book16");
	 while(rs.next()!=false)
	 {
		 System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
	 }
	 
	}

}
