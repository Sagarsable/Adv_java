package com.java.Prepared_Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Prep_Stat_insert {
	public static void main(String args[])
	{
		Scanner sc=null;
		int rno=0;
		String sname=null;
		String sadd=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter Student Roll_no:");
			rno=sc.nextInt();
			System.out.println("Enter student Name: ");
			sc.nextLine();
			sname=sc.nextLine();
			System.out.println("Enter Student Address:");
			sadd=sc.nextLine();
			
			//register jdbc driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish jdbc connection driver
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "system","sagar9027");
		    // create statement object to run and execute query
			if(con!=null)
				ps=con.prepareStatement("insert into Student values(?,?,?)");
			if(ps!=null)	
			{
				ps.setInt(1,rno);
				ps.setString(2,sname);
				ps.setString(3,sadd);
			}
			   
			if(ps!=null)
				rs=ps.executeQuery();
			if(rs!=null)
				System.out.println("data inserted");
			else
				System.out.println("data not inserted");
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
			if(sc!=null)
				sc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}//close scanner

	  }//finally
    }//main
}//class
