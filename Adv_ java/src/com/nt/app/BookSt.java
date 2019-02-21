package com.nt.app;
import java.sql.*;
public class BookSt 
{
	public static void main(String[] args)
	throws ClassNotFoundException,SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl", "system", "sagar9027");
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select * from book2");
		while(rs.next()) 
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
		}
		con.close();
	}
}
