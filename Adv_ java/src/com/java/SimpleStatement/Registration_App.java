package com.java.SimpleStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Registration_App {
	public static void main(String args [])
	{
		Scanner sc=null;
		String name=null;
		String uname=null;
		String pass=null;
		
		Connection con =null;
		Statement st=null;
		int result=0;
	
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter full name:");
			name=sc.nextLine();
			name="'"+name+"'";
			System.out.println("Enter username:");
			uname=sc.nextLine();
			uname="'"+uname+"'";
			System.out.println("Enter password");
			pass=sc.nextLine();
			pass="'"+pass+"'";
			
			// register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//established jdbc connection
			con=DriverManager.getConnection
			    ("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
			
			if(con!=null)
			//create statement object
			st=con.createStatement();
			
			if(st!=null)
			// create result set object to send and execute query
			result=st.executeUpdate
			("insert into user_list values("+name+","+uname+","+pass+")");
			//process result set object
			if(result!=0)
				System.out.println("Registration Sucessful");
			else
				System.out.println("Registration failed");
			
		}//try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
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
				if(st!=null)
					st.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//finally
	}//main
}//class
