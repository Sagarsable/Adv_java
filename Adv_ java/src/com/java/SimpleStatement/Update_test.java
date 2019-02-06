package com.java.SimpleStatement;
// it is not completed
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update_test {
	public static void main(String args[])
	{
		
		Scanner sc=null;
		int sno=0;
		String sname=null;
		String sadd=null;
		Connection con=null;
		Statement st=null; 
		int result=0;
	
		try
		{
			// create scanner object to read inpute from user
			sc=new Scanner(System.in);
			System.out.println("Enter student Roll no:");
			sno=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter student Name:");
			sname=sc.nextLine();
			System.out.println("Enter Student address:");
			sadd=sc.nextLine();
			sname="'"+sname+"'";
			sadd="'"+sadd+"'";
			// register jdbc driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish jdbc connection driver
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "system","sagar9027");
		    // create statement object to run and execute query
			if(con!=null)
			st=con.createStatement();
			//create reuslt set object to store query output
			if(st!=null)
			result=st.executeUpdate("insert into student values("+sno+","+sname+","+sadd+")");
			//process the result 
			if(result==0)
				System.out.println("Record insertion failed");
			else 
				System.out.println("Rcord insertion sucessfull");
			
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

