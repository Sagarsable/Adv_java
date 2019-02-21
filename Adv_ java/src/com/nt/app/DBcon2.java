package com.nt.app;
import java.util.*;
import java.sql.*;
public class DBcon2 {
public static void main(String[] args)
throws ClassNotFoundException,SQLException
  {
	Scanner s = new Scanner(System.in);
	System.out.println("Enter Product Code:");
	int pcode = Integer.parseInt(s.nextLine());
	System.out.println("Enter Product Name:");
	String pname = s.nextLine();
	System.out.println("Enter Product Price:");
	float pprice = Float.parseFloat(s.nextLine());
	System.out.println("Enter Product Quantity:");
	int pqty = Integer.parseInt(s.nextLine());
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con =DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
	PreparedStatement ps =con.prepareStatement("insert into Product16 values(?,?,?,?)");
	ps.setInt(1,pcode);
	ps.setString(2, pname);
	ps.setFloat(3,pprice);
	ps.setInt(4,pqty);
	int k=ps.executeUpdate();
	if(k>0)
	{
		System.out.println("Product Details Updated");
	}
	con.close();
	s.close();
  }}
