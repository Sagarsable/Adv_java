 package com.java.Prepared_Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Insert_date {
	public static void main(String args[])
	{
		Scanner sc=null;
		String sname=null;
		String sdob=null;
		java.util.Date udob=null;
		SimpleDateFormat sdf=null;
		long ms=0;
		java.sql.Date sqldob=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
			try 
		{
			sc=new Scanner(System.in);
			if(sc!=null)
			{
				System.out.println("Enter student name:");
				sname=sc.nextLine();
				System.out.println("Enter student dob(dd/MM/yyyy");
				sdob=sc.nextLine();
				//converting string date formate into sql date format
				sdf=new SimpleDateFormat("dd/MM/yyyy");
				if(sdf!=null)
					udob=sdf.parse(sdob);//gives java.util.Date object
				if(udob!=null)
					ms=udob.getTime();
				sqldob=new java.sql.Date(ms);//gives java.sql.date object
				 
				
				// register jdbc driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Established jdbc connection
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
				if(con!=null)
					// create prepare statement object
					ps=con.prepareStatement("INSERT INTO STUD_DETAIL VALUES(?,?)");
			    if(ps!=null)
			    	ps.setString(1,sname);
			        ps.setDate(2,sqldob);
					//execute query
			        if(ps!=null)
			          result=ps.executeUpdate();
			        if(result==0)
			        	System.out.println("Record not inserted");
			        else
			        	System.out.println("Record inserted");
			       }
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
