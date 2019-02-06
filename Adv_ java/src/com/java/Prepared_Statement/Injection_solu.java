package com.java.Prepared_Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Injection_solu {
	public static void main(String args[])
	{
		Scanner scn=null;
		String uname=null;
		String pass=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag=false;
		int count=0;
		try
		{
			// create scanner object to read input form keyboard
			scn=new Scanner(System.in);
			System.out.println("Enter username :");
			uname=scn.nextLine();
			System.out.println("Enter password:");
			pass=scn.nextLine();
			
			//register jdbc driver
              Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish jdbc connection driver
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "system","sagar9027");
		    // create statement object to run and execute query
			if(con!=null)
			ps=con.prepareStatement("select count(*) from user_list where uname=? and upass=?");
			if(ps!=null)
			// set parameter value
			ps.setString(1,uname);
			ps.setString(2,pass);
			// execute seted parameter value with query
			rs=ps.executeQuery();
			// create result set object and strore output
			if(rs!=null)
			   {if(rs.next())
				   count=rs.getInt(1);
			   }
			
		if(count!=0)	
		   System.out.println("Login Sucessful");
		else
		  System.out.println("Login Failed");
		
		}// try
		catch(SQLException se)
		{
		se.printStackTrace();
		}
	catch(ClassNotFoundException cnf)
		{
		cnf.printStackTrace();
		}
	catch(Exception e)
		{
		e.printStackTrace();
		}//catch
	finally// close jdbc connection
	{
		try {
			if(ps!=null)
				ps.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}//close prepared statement 
		try
 	     {
		  if(con!=null)
			  con.close();
	     }
		catch(SQLException se)
		{
			se.printStackTrace();
		}//close jdbc connection
		try
		{
			if(scn!=null)
				scn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}//close scanner

	  }//finally
    }//main
}//class
