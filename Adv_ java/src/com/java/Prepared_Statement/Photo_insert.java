package com.java.Prepared_Statement;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Photo_insert {

  public static void main(String args[]) 
	{
		Scanner sc=null;
		String name=null;
		Long mobno = null;
		String addr=null;
		File file=null;
		InputStream is=null;
		String photopath=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;	
		try 
		{
			sc=new Scanner(System.in);
			if(sc!=null)
			{
				System.out.println("Enter your name:");//sagar
				name=sc.nextLine();
				System.out.println("Enter your mobile nol:");
				mobno=sc.nextLong();
				System.out.println("Enter your address:");
				addr=sc.nextLine();
				sc.nextLine();
				System.out.println("Enter your photo path:");
				photopath=sc.nextLine();
				
			}//if
			// create fileinputStream to locate file based photopath
			file= new File(photopath);
			is=new FileInputStream(file);
			// Register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish jdbc connection
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
			if(con!=null)
			{//prepare query for inserting values in db s/w
			   ps=con.prepareStatement("INSERT INTO PHOTO_INSERT values(?,?,?,?)");
			}
			if(ps!=null)
			{
				ps.setString(1,name);
				ps.setLong(2,mobno);
				ps.setString(3,addr);
				ps.setBinaryStream(4,is,file.length());
			}
			// Execute Sql query
			
			
				result=ps.executeUpdate();
			
			if(result!=0)
				System.out.println("Record inserted Sucessful");
			else
				System.out.println("Record Not inserted");
	   }//try
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
				if(ps!=null)
					ps.close();
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
		}// finally
	}//main
}//class
