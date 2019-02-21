package com.java.Batch_Processing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch_process_Test {
	public static void main(String args[])
	{
		Connection con=null;
		Statement st=null;
		int result[]=null;
		int sum=0;
		try {
			// register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish jdbc driver 
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
			if(con!=null)
				st=con.createStatement();
			// add queries into batch
			if(st!=null)
			{
				st.addBatch("insert into student values(146,'mhh','sf')");
				st.addBatch("update student set sadd='borgav' where sno=106");
				st.addBatch("delete from student where sno=156");
				// execute batch
				result=st.executeBatch();
			}
			if(result!=null)
			{
				for(int i=0;i<=result[i];i++)
				{
					sum=sum+result[i];
				}//end of for
				System.out.println("no of records that are effected "+sum);
			}// end of if
			
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
	}// end of main
}// end of class
