package com.java.SimpleStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login_app {
	public static void main(String argws [])
	{
		Scanner sc=null;
		String uname=null;
		String pass=null;
		Connection con=null;
		Statement st = null;
		ResultSet rs=null;
		boolean flag=false;
		try
		{
			// to create scanner object to give inpute from user
			sc= new Scanner(System.in);
			System.out.println("Enter Username:");
			uname=sc.nextLine();
			uname="'"+uname+"'";
			System.out.println("Enter password:");
			pass=sc.nextLine();
			pass="'"+pass+"'";
			
			// register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Established connection between jaava app and db s/w
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
			// create statement object
			if(con!=null)
			st=con.createStatement();
			// create result set object to send and execute query

			// result set object to store output
			rs=st.executeQuery("select name,uname from user_list where uname="+uname+" and upass="+pass);
			// process the result
			if(rs!=null)
			{
				while(rs.next())
				{
					flag=true;
					System.out.println("name:"+rs.getString(1));
					System.out.println("Username:"+rs.getString(2));
				}// while
				if(flag=true)
					System.out.println("Login Sucessfull");
				else
					System.out.println("Login Failed");
			}
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
