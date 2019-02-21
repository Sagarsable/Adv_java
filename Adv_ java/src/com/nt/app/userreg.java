package com.nt.app;
import java.util.*;
import java.sql.*;
public class userreg {
	public static void main(String args[])
throws ClassNotFoundException,SQLException
{
		Scanner s =new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
		System.out.println("-----Choice-----");
		System.out.println("1.User Registration\n2.User Login\n3.View User Details");
		int choice=Integer.parseInt(s.nextLine());
		switch(choice)
		{
		case 1:
			PreparedStatement ps1=con.prepareStatement
			("insert into userreg16 values(?,?,?,?,?,?,?)");
			
			System.out.println("Enter User_Name");
			String uname=s.nextLine();
			ps1.setString(1,uname);
			
			System.out.println("Enter PassWord");
			String pword=s.nextLine();
			ps1.setString(2,pword);
			
			System.out.println("Enter First_Name");
			String fname=s.nextLine();
			ps1.setString(3,fname);
			
			System.out.println("Enter Last_Name");
			String lname=s.nextLine();
			ps1.setString(4,lname);
			
			System.out.println("Enter Address");
			String addr=s.nextLine();
			ps1.setString(5,addr);
			
			System.out.println("Enter Phone_Number");
			Long phno=Long.parseLong(s.nextLine());
			ps1.setLong(6,phno);
			
			System.out.println("Enter Mail_Id");
			String mid=s.nextLine();
			ps1.setString(7,mid);
			int k=ps1.executeUpdate();
			if(k>0)
			{
				System.out.println("Registration Sucessfull");
			}
			else
			{
				System.out.println("Registration failed");
			}break;
		case 2:
			PreparedStatement ps2=con.prepareStatement
			("select * from userreg16 where uname=? and pword=?");
			System.out.println("Enter UserName");
			uname=s.nextLine();
			ps2.setString(1,uname);
			
			System.out.println("Enter PassWord");
			pword=s.nextLine();
			ps2.setString(2,pword);
			ResultSet rs=ps2.executeQuery();
			if(rs.next())
			{
				System.out.println("Logged in Successful....");
			}
			else
			{
				System.out.println("User name and Password incorrect...");
			}break;
		case 3:
			PreparedStatement ps3=con.prepareStatement
			("select * from userreg16 where uname=? and pword=?");
			System.out.println("Enter username:");
			ps3.setString(1,s.nextLine());
			System.out.println("Enter Password");
			ps3.setString(2,s.nextLine());
			ResultSet rs3=ps3.executeQuery();
			if(rs3.next())
			{
				System.out.println("First name:"+rs3.getString(3));
				System.out.println("Last Name:"+rs3.getString(4));
				System.out.println("Address:"+rs3.getString(5));
				System.out.println("Phone No:"+rs3.getString(6));
				System.out.println("E-mail Id:"+rs3.getString(7));
				
			}
			else
			{
				System.out.println("Invalid Username and Password");
			}
			break;
			default: 
				System.out.println("Invalid Choice");
		con.close();
		s.close();
    }}}

