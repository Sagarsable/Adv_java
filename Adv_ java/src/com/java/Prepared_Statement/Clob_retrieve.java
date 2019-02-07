package com.java.Prepared_Statement;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Clob_retrieve {
	public static void main(String args[])
	{
		
		Scanner sc=null;
		String name=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		File file=null;
		Reader reader=null;
		Writer writer=null;
		char[] buffer=null;
		int charRead=0;
		try
	    {
			// create scanner object to read inpute from keyboard
			sc=new Scanner(System.in);
			System.out.println("Enter your name:");
			name=sc.nextLine();
			
			// register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// create connection object to establish connection
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
			// create prepared statement object to send and execute query
			if(con!=null)
				ps=con.prepareStatement("select * from file_insert where name=?");
			if(ps!=null)
				ps.setString(1,name);
			if(ps!=null)
				// execute query and store result in  resultset
				rs=ps.executeQuery();
			if(rs!=null)
				// process resultset object
				if(rs.next())
					reader=rs.getCharacterStream(4);
			// create outpute stream for destination file
			writer=new FileWriter("D:\\Adv_img\\Adv_file\\resume.txt");
			buffer=new char[2048];
			while((charRead=reader.read(buffer))!=-1)
			{
				writer.write(buffer,0,charRead);
				
			}//
			System.out.println("clob retrieved");
	    }//try
	    catch(Exception e)
	    {
		  e.printStackTrace();
		  System.out.println("record insertion failed");
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
