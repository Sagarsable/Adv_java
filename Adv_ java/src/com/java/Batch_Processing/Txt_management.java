package com.java.Batch_Processing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Txt_management {
	public static void main(String args[])
	{
		Scanner sc=null;
		int srcno=0,destno=0;
		float amt=0.0f;
		Connection con=null;
		Statement st=null;
		int result[]=null;
		try
		{
			// read input from keyboard
			sc=new Scanner(System.in);
			System.out.println("Enter source account no::");
			srcno=sc.nextInt();
			System.out.println("Enter destination account no::");
			destno=sc.nextInt();
			System.out.println("Enter Transfer amount::");
			amt=sc.nextFloat();
			boolean flag=false;
			
			// register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// establish the connection
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");

			if(con!=null)
			{
				// disable auto commit
				con.setAutoCommit(false);
				// create statement object, send and execute query				
				st=con.createStatement();
			}
			if(st!=null)
			{
				st.addBatch("update Account_no set balance=balance-"+amt+"where accno="+srcno);
				st.addBatch("update Account_no set balance=balance+"+amt+"where accno="+destno);
				// execute batch
				result=st.executeBatch();			
			}//if
			//perform transaction management (commit and rollback)
			if(result!=null)
			{
				for(int i=0;i<result.length;++i)
				{
					if(result[i]==0)
					{
						flag=true;
						break;
					}//if
				}//for
				
				if(flag==true)
				{
					con.rollback();
					System.out.println("money transfer failed");
				}
				else
				{
					con.commit();
					System.out.println("Money transfer sucessful");
				}//if
					
			}//if
			
			
		
		
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
				if(sc!=null)
					con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
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
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//finally
	}//main
}// class

