package com.java.jdbc;
import java.sql.*;
import java.util.Scanner;
public class selecttest2 
{
	public static void main(String args[])
	throws Exception
	{
  // get user input address using scanner
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Student address");
		String saddr=scn.next();
		saddr="'"+saddr+"'";
		
  //Establish database connection
	    Connection con=DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
	
  //create jdbc statement object
		Statement st=con.createStatement();
		
  //execute query and set result in result set object
	    ResultSet rs=st.executeQuery("SELECT * FROM student where sadd="+saddr);
	    boolean flag=false;
	    while (rs.next()!=false)
		{
		   flag=true;
		   System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		} 
		   if(flag==false) System.out.println("Record not found");
		
		
	    }
	}