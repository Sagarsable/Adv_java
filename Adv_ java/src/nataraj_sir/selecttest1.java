package nataraj_sir;
import java.sql.*;
public class selecttest1 
{
	public static void main(String args[])
	throws Exception
	{
		//Establish database connection
		Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar9027");
	//create jdbc statement object
		Statement st=con.createStatement();
		String query="SELECT * FROM student";
		//execute query and set result in result set object
	 ResultSet rs=st.executeQuery(query);
	 
	while (rs.next()!=false)
	{
		//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		
	}}}
