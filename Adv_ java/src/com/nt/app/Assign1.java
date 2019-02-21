package com.nt.app;
import java.sql.*;
public class Assign1 {
	public static void main(String[] args)
	throws ClassNotFoundException, SQLException
	{
       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con = DriverManager.getConnection
    		   ("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
       Statement stm = con.createStatement();
       ResultSet rs = stm.executeQuery("select * from book16");
       while(rs.next())
       {
    	   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+
       rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
       }
     
       con.close();
       }}
