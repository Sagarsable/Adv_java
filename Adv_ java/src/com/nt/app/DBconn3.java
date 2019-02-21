package com.nt.app;
import java.util.*;
import java.sql.*;
public class DBconn3 {
public static void main(String args[])
throws ClassNotFoundException,SQLException
{
	Scanner s=new Scanner(System.in);
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
	PreparedStatement ps=con.prepareStatement("insert into book16 values(?,?,?,?,?)");
	System.out.println("How Many Records:");
	int n=Integer.parseInt(s.nextLine());
	for(int i=0;i<n;i++)
	{
	System.out.println("Enter BookCode:");
	int bcode=Integer.parseInt(s.nextLine());
	ps.setInt(1,bcode);
	
	System.out.println("Enter BookName:");
	String bname=s.nextLine();
	ps.setString(2,bname);
	
	System.out.println("Enter BookAuthor:");
	String bauthor= s.nextLine();
	ps.setString(3,bauthor);
	
	System.out.println("Enter BookPrice:");
	float bprice=Float.parseFloat(s.nextLine());
	ps.setFloat(4,bprice);
	
	System.out.println("Enter BookQuantity");
	int bqty=Integer.parseInt(s.nextLine());
	ps.setInt(5,bqty);
	
	int k=ps.executeUpdate();
	if(k>0)
	{
		System.out.println("Record Updated");
	}}
	con.close();
	s.close();
}
}
