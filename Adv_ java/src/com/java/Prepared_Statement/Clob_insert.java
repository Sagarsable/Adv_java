package com.java.Prepared_Statement;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Clob_insert {
	public static void main(String args[])
	{
		Scanner sc=null;
		String name=null;
		long mno=0;
		String mid=null;
		String resume_path=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		Reader reader=null;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter your name");
			name=sc.nextLine();
			System.out.println("Enter your mobile no:");
			mno=sc.nextLong();
			System.out.println("Enter your Mail-Id:");
			mid=sc.nextLine();
			sc.nextLine();
			System.out.println("Enter your resume Path:");
			resume_path=sc.nextLine();
			File file=null;
			
			// register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// create connection obj to Establish jdbc connection
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
			// create preaparedstatement obj to send and execute query
			if(con!=null)
			ps=con.prepareStatement("insert into file_insert values(?,?,?,?)");
			// locate filepath
			file=new File(resume_path);
			//read file conten and store in reader 
			reader=new FileReader(file);
			if(ps!=null)
			{	
				ps.setString(1,name);// set input name into database
				ps.setLong(2,mno);// set inpute mobile intpo database
				ps.setString(3,mid);// set input mailid into database
				ps.setCharacterStream(4,reader,(int)file.length());// set resume file in database
			}
			
			if(ps!=null)	
				// process the result 
				result=ps.executeUpdate();
			if(result==0)
				System.out.println("Record not insert");
			else
				System.out.println("Record inserted");
		}// try
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
