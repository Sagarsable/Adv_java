package com.java.Prepared_Statement;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Photo_Retrieve {
	public static void main(String args[])
	{
		Scanner sc=null;
		String name=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		InputStream is=null;
		OutputStream os=null;
		byte [] buffer=null;
		int bytesRead=0;
		
		try
		{
			// read input from keyboard
			sc=new Scanner(System.in);
			System.out.println("enter name:");
			name=sc.nextLine();
			
			//register jdbc driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// create connection statment to establish connection
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
			// Preaperd statement object to send and execute query
			if(con!=null)
			ps=con.prepareStatement("select * from photo_insert where name=?");
			if(ps!=null)
			{
				ps.setString(1,name);
				// execute the sql query
				rs=ps.executeQuery();
			}
			if(rs.next())
				is=rs.getBinaryStream(4);
			// create outputstream for destination file
			
			os= new FileOutputStream("D:\\Adv_img\\photo.gif");
			// to copy image content to write buffer based logic
			buffer=new byte[4096];
			while((bytesRead=is.read(buffer))!=-1)
			{
				os.write(buffer,0,bytesRead);
			}//while
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
