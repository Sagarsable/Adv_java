package com.nt.app;
import java.util.*;
import java.sql.*;
public class assign3 {
public static void main (String args [])
throws ClassNotFoundException,SQLException
{
	Scanner s=new Scanner(System.in);
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
	System.out.println("-----Choice-----");
	System.out.println("1.Add Book\n2.View All Book\n3.View Book ByteCode");
	int choice=Integer.parseInt(s.nextLine());
	switch(choice)
	{
	case 1:
		PreparedStatement ps=con.prepareStatement("insert into book16 values(?,?,?,?,?)");
		
		System.out.println("Enter Book Code:");
		int bcode=Integer.parseInt(s.nextLine());
		ps.setInt(1,bcode);
		
		System.out.println("Enter Book Name:");
		String bname=s.nextLine();
		ps.setString(2,bname);
		
		System.out.println("Enter Book Author:");
		String bauthor=s.nextLine();
		ps.setString(3,bauthor);
		
		System.out.println("Enter book Price:");
		float bprice=Float.parseFloat(s.nextLine());
		ps.setFloat(4,bprice);
		
		System.out.println("Enter BookQuantity");
		int bqty=Integer.parseInt(s.nextLine());
		ps.setInt(5,bqty);
		int k=ps.executeUpdate();
		if(k>0)
		{
			System.out.println(" Book Details Update Sucessful");
		}
		break;
	
	case 2:
		PreparedStatement ps1=con.prepareStatement
		("select * from book16");
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{
			System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)
			+"\t"+rs1.getFloat(4)+"\t"+rs1.getInt(5));
		}//end of while
	break;
	
	case 3:
		System.out.println("Enter Book Code ");
	    bcode=Integer.parseInt(s.nextLine());
		
		PreparedStatement ps2=con.prepareStatement("select * from book16 where bcode=?");
		ps2.setInt(1,bcode);
		ResultSet rs2= ps2.executeQuery();
		if(rs2.next())
		{
			System.out.println(rs2.getInt(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)
			+"\t"+rs2.getFloat(4)+"\t"+rs2.getInt(5));
		}//end if
		else
		{
			System.out.println("Invalid Code");
	    }
	break;
	default:
			System.out.println("Invalid option");
	}
	con.close();
	s.close();
}}
