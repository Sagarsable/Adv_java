package nataraj_sir;
import java.sql.*;
public class selecttest2 
{
	public static void main(String args[])
	throws Exception
	{
		//Establish database connection
		Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
	//create jdbc statement object
		Statement st=con.createStatement();
		//execute query and set result in result set object
	 ResultSet rs=st.executeQuery("SELECT * FROM student");
	while (rs.next()!=false)
	{
	
	}}}
