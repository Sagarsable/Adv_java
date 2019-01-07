package com.java.jdbc;
import java.sql.*;
import java.sql.DriverManager;

public class SelectTest {
	public static void main(String []args)
	throws Exception{
		//Establish database connection
		Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
	//create jdbc statement object
		Statement st=con.createStatement();
		//execute query and set result in result set object
	 ResultSet rs=st.executeQuery("SELECT * FROM Book16");
	 while(rs.next()!=false)
	 {
		 System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
	 }
	 
	}

}
