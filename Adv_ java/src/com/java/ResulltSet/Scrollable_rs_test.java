package com.java.ResulltSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Scrollable_rs_test {
	public static void main(String args[])
	{
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			// register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// established connection
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "system","sagar9027");
			// create statement object to send and execute query
			if(con!=null)
				st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
			// create result set object to store query result
			if(st!=null)
			{	
				rs=st.executeQuery("select * from student");
			}
			System.out.println("Top to Bottom");
			System.out.println("-----------------------");
			if(rs!=null)
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
                     		
				}
			System.out.println("Bottom TO Top");
			System.out.println("----------------------------");
			while(rs.previous())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

			}
			System.out.println("rs,next");
			System.out.println("-----------------------");
			rs.next();
			System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+" "+rs.getString(3));

			System.out.println("rs.relatives");
			System.out.println("-----------------------");
			rs.relative(2);
			System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+" "+rs.getString(3));
			System.out.println("rs.absolute");
			System.out.println("-----------------------");
			rs.absolute(3);
			System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+" "+rs.getString(3));
		}// try
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(st!=null)
					st.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(sc!=null)
					sc.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//finally
	  }// main
	}//class
