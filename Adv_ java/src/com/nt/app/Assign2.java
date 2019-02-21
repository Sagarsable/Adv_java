package com.nt.app;
import java.util.*;
import java.sql.*;

public class Assign2 {
public static void main(String agrs[])
throws ClassNotFoundException,SQLException
{
	Scanner s= new Scanner(System.in);
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
	PreparedStatement ps=con.prepareStatement("insert into userreg16 values(?,?,?,?,?,?,?)");
	
	System.out.println("Enter UserName:");
	String uname=s.nextLine();
	ps.setString(1,uname);
	
	System.out.println("Enter Password:");
	String pword=s.nextLine();
	ps.setString(2,pword);
	
	System.out.println("Enter FirstName:");
	String fname=s.nextLine();
	ps.setString(3,fname);
	
	System.out.println("Enter LastName:");
	String lname=s.nextLine();
	ps.setString(4,lname);
	
	System.out.println("Enter Address:");
	String addr=s.nextLine();
	ps.setString(5,addr);
	
	System.out.println("Enter PhoneNo:");
	int phno=Integer.parseInt(s.nextLine());
	ps.setInt(6,phno);
	
	System.out.println("Enter Mail-Id:");//here create critical problem
	String mid=s.nextLine();
	ps.setString(7,mid);
	int k=ps.executeUpdate();
	if(k>0)
	{
		System.out.println("Record Updated");
	}
	con.close();
	s.close();
}}
