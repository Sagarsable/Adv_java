package com.nt1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsTest {
	public static void main(String args[])
	{
		InputStream is=null;
		Properties props=null;
		try
		{
			// Locate file using input stream
			is=new FileInputStream("src/com/nt/commons/personal_Details.properties");
			//load properties file data into javva.lang.util.properties class object
			props=new Properties();
			props.load(is);
			System.out.println("props Data  "+props);
			System.out.println("name key value::"+props.getProperty("name"));
			System.out.println("name key value::"+props.getProperty("age"));
			System.out.println("name key value::"+props.getProperty("address"));
		}//try
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
