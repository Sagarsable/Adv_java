package com.java.CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*create or replace procedure p_get_stu_details(no number,name out varchar2,add out varchar2) as
begin
select sname,sadd into name,add from student where sno=no;
end;
*/

public class cs_test1 {
	public static void main(String args[])
	{
		 Scanner sc=null;
		 int no=0;
		 Connection con=null;
		 CallableStatement cs=null;
		 String query=null;
	
		 try
		 {
			 // read input from user
			 sc=new Scanner(System.in);
			 if(sc!=null)
			 {
				 System.out.println("Enter student no:");
				 no=sc.nextInt();
			 }
			 // register jdbc driver
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 // Established  connection
			 con=DriverManager.getConnection
					 ("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
			 if(con!=null)
			 {// create cs object for send and execute query
				 query="call p_get_stu_details(?,?,?)";
				 cs=con.prepareCall(query);
			 }
			 if(cs!=null)		
			 {
				 // register out parameter
				 cs.registerOutParameter(2,Types.VARCHAR);
				 cs.registerOutParameter(3,Types.VARCHAR);
				 //register in parameters
				 cs.setInt(1,no);
				 // call pl/sql procedure
				 cs.execute();
				 // gather result from out param
				 System.out.println("Student name --> "+cs.getString(2));
				 System.out.println("Student address --> "+cs.getString(3));
			 }//if
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
