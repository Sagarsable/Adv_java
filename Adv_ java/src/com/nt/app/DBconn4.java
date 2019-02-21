package com.nt.app;
import java.util.*;
import java.sql.*;
public class DBconn4 {
	public static void main(String args[])
	throws ClassNotFoundException,SQLException
	{
		Scanner s = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
		System.out.println("------Choice-----");
		System.out.println("1.View All Product\n 2.View Product Byte Code");
		int choice=Integer.parseInt(s.nextLine());
		switch(choice)
		{
		case 1:
			PreparedStatement ps1=con.prepareStatement("select * from product16");
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+rs.getFloat(3)
			                   +"\t"+rs.getInt(4));
		}break;
		case 2:
			System.out.println("Enter the Product Code:");
			String pcode=s.nextLine();
			PreparedStatement ps2=con.prepareStatement
					("select * from Product16 where pcode=?");
			ps2.setString(1,pcode);
			ResultSet rs2= ps2.executeQuery();
			if(rs2.next())
			{
				System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+
			       rs2.getFloat(3)+"\t"+rs2.getInt(4));
			}// end if 
			else 
			{
				System.out.println("Invalid code");
				
			}break;
			default:
				System.out.println("Invalid option");
		}// end of switch
		con.close();
		s.close();	
		}
		
	}


