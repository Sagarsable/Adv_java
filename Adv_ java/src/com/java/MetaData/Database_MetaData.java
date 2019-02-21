package com.java.MetaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Wrapper;
public class Database_MetaData {
	public static void main(String args[])
	{
		Connection con=null;
		DatabaseMetaData dbmd=null;
		try
		 {
			 // register jdbc driver
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection
					 ("jdbc:oracle:thin:@localhost","system","sagar9027");
			 // get metadata
			 dbmd= con.getMetaData();
			 // the database deetails are
			 if(dbmd!=null)
			 {
				 System.out.println("database productname::"+dbmd.getDatabaseProductName());
				 System.out.println("database version::"+dbmd.getDatabaseProductVersion());
				 System.out.println("Database mejor version::"+dbmd.getDatabaseMajorVersion());
				 System.out.println("Database minor version::"+dbmd.getDatabaseMinorVersion());
				 System.out.println("Max table name length::"+dbmd.getMaxTableNameLength());
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
		
		
		try
 	     {
		  if(con!=null)
			  con.close();
	     }
		catch(SQLException se)
		{
			se.printStackTrace();
		}//close jdbc connection
		

	  }//finally
    }//main
}//class
