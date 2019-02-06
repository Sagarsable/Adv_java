package com.java.SimpleStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select_test3 {
public static void main(String [] args) 
{
	Scanner sc=null;
	String sno=null;
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	boolean flag=false;
	
	try {
		//read input from user
		sc=new Scanner(System.in);
		System.out.println("Enter Student no:");
		sno=sc.nextLine();
		// sno convert sdb format
		sno="'"+sno+"'";
		
		// register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// Establish connection 
		con=DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
		
		// create statement object for send and execute query for db s/w
		if(con!=null)
		st=con.createStatement();
		
		// result set object to store output
		rs=st.executeQuery("select sno,sname,sadd from student where sno="+sno);
		// process the result
		if(rs!=null)
		{
			while(rs.next())
			{
				flag=true;
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}// while
			if(flag=true)
				System.out.println("Record found");
			else
				System.out.println("Record not found");
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
