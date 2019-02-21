package com.java.MetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSet_Metadata {
	public static void main(String args[])
	{
		  Connection con=null;
		  Statement st=null;
		  ResultSet rs = null;
		  ResultSetMetaData rsmd=null;
		  int colCnt=0;
		
		try
		{// register jdbc driver
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection
					 ("jdbc:oracle:thin:@localhost","system","sagar9027");
			// create statement object
			if(con!=null)
				st=con.createStatement();
			// send and execute query in db s/w
			if(st!=null)
				rs=st.executeQuery("select * from student");
			// create resultsetmetadata
			rsmd=rs.getMetaData();
			// get coloumcount
			colCnt=rsmd.getColumnCount();
			// Display colomn name
			for(int i=1;i<=colCnt;++i)
			{
				System.out.print(rsmd.getColumnLabel(i)+" ");
			}// end of for
			System.out.println();
			// Display coloum type
			for(int i=1;i<=colCnt;++i)
			{
				System.out.print(rsmd.getColumnTypeName(i)+" ");
			}// end of for
			System.out.println();
			// process the resultset
			while(rs.next())
			{
				for(int i=1;i<=colCnt;++i)
				{
					System.out.print(rs.getString(i)+" ");
				}// end of for
				System.out.println();
			}// end of while
			
			
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
		  if(st!=null)
			  st.close();
	     }
		catch(SQLException se)
		{
			se.printStackTrace();
		}
			try
	 	     {
			  if(rs!=null)
				  rs.close();
		     }
			catch(SQLException se)
			{
				se.printStackTrace();
			}
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
