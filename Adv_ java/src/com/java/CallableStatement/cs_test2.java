package com.java.CallableStatement;


/*
 create or replace procedure p_allstud_details(initChars in varchar ,details out sys_refcursor) as
begin
open details for
select * from student where sname like initChars;
end;
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class cs_test2 {
	public static void main(String args[])
	{
		 Scanner sc=null;
		 String initChars=null;
		 Connection con=null;
		 CallableStatement cs=null;
		 String query=null;
		 ResultSet rs=null;
		 boolean flag=false;
		 try
		 {
			 // read input from keyboard 
			 sc= new Scanner(System.in);
			 System.out.println("Enter intitial character of student name-->");
			 initChars=sc.next().toLowerCase()+"%";
			 query="call p_allstud_details(?,?)";
			 
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 // Established  connection
			 con=DriverManager.getConnection
					 ("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
		     if(con!=null)
		    // create callable statement object
		    	 cs=con.prepareCall(query);
		     if(cs!=null)
		     {
		    	 // register out prams with jdbc type
		    	 cs.registerOutParameter(2,OracleTypes.CURSOR);
		    	 // register in parameters
		    	 cs.setString(1,initChars);
		    	 // execute pl/ sql procedure
		    	cs.execute();
		        //gather result form out parameters
                rs=(ResultSet) cs.getObject(2);	     
		     }// if
		     //procedure result set object 
		     if(rs!=null)
		     {
		    	 while(rs.next())
		    	 {
		    		 flag=true;
		    		 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		         }
	
		    	 if(flag==true)
		    		 System.out.println("Records are....");
		    	 else
		    		 System.out.println("Records are not found");
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
