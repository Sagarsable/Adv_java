
package com.java.ResulltSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ps_scrollable {
	public static void main(String args[])
	{
	
			Connection con= null;
			PreparedStatement ps= null;
			ResultSet rs=null;
					
			
			try
			{
				// register jdbc driver 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// Establish the connection
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost","system","sagar9027");
				// create statement object
				if(con!=null)
				{
					ps=con.prepareStatement("select * from student",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
				}
				if(ps!=null)
					rs=ps.executeQuery();
				if(rs!=null)
				{
					System.out.println("Top To Bottom");
					System.out.println("--------------");
					while(rs.next())
					{
						
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
					}
					System.out.println();
					System.out.println("Bottom To Top");
					System.out.println("---------------");
					while(rs.previous())
					{
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
					}
					System.out.println("-----next-------");
					
					   rs.next();
					    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
					    System.out.println("-----first-------");
					    rs.first();
					    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
					    System.out.println("-----last-----");
					    rs.last();
					    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
					
				}
				}// try
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
				
					
				}//finally
			  }// main
			}//class
	


