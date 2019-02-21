package com.java.Batch_Processing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch_Process_ps {
	public static void main(String args[])
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result[]=null;
	    try
		 {
	    	// register jdbc driver
	    				Class.forName("oracle.jdbc.driver.OracleDriver");
	    				// Establish jdbc driver 
	    				con=DriverManager.getConnection
	    						("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
			// create preparedstatement object
			if(con!=null)
			   ps=con.prepareStatement("insert into student values(?,?,?)");
			if(ps!=null)
			{
				// add multiple set param values to the batch
				ps.setInt(1,158);ps.setString(2,"djj");ps.setString(3,"jjd");
				ps.addBatch();
				ps.setInt(1,159);ps.setString(2,"jjds");ps.setString(3,"djjj");
				ps.addBatch();
				result=ps.executeBatch();
			}// end if
			if(result!=null)
				System.out.println("Record inserted");
			else
				System.out.println("Record not inserted");
			
			}// end of try
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
					if(ps!=null)
						ps.close();
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
		}// end of main
	}// end of class
