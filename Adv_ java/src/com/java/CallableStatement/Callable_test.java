package com.java.CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Callable_test {

	public static void main(String args[])
	{
		String query=null;
		Scanner sc=null;
		int no=0;
		Connection con=null;
		CallableStatement cs=null;
		int result=0;
		try
		{
			// read input from keyboard
			sc= new Scanner (System.in);
			if(sc!=null)
			{
				System.out.println("Enter  no:");
				no=sc.nextInt();
			}

			//register jdbc driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish jdbc connection driver
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "system","sagar9027");
		    
			query="{call P_FIRST_PROj1(?,?)}";
			
			// create preapere call statement object to send and execute query
			if(con!=null)
				cs=con.prepareCall(query);
			
			if(cs!=null)
			{	// register out parameter
				cs.registerOutParameter(2,Types.INTEGER);
				// register in parameter
				cs.setInt(1,no);
				//execute pl/sql procedure
				cs.execute();
				//  gather result from out parameter
				result=cs.getInt(2);
				System.out.println("Squre result:"+result);
			}// if
			
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
			if(cs!=null)
				cs.close();
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
