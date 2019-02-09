package Mini_Project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Mini_Project_All_Stat extends JFrame implements ActionListener {

	private JLabel lsno,lsname,lmarks1,lmarks2,lmarks3,lresult;
	private JTextField tname,tmarks1,tmarks2,tmarks3,tresult;
	private JComboBox jcbtno;
	private JButton bresult,bdetails;
	Connection con=null;
	Statement st=null;
	PreparedStatement ps=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	CallableStatement cs=null;
	
	// constructor
	public Mini_Project_All_Stat()
	{
		System.out.println("Mini_Project_All_Stat.Mini_Project_All_Stat()");
		setTitle("Mini Project");
		setSize(300,300);
		setLayout(new FlowLayout());
		setBackground(Color.CYAN);
		
		// add Components
		lsno=new JLabel("Student No:");
		add(lsno);
		
		
		jcbtno= new JComboBox();
		add(jcbtno);
		bdetails =new JButton("Details");
		bdetails.addActionListener(this);
		add(bdetails);
		
		
		
		lsname=new JLabel("Student Name:");
		add(lsname);
		tname=new JTextField (10);
		add(tname);
		
		lmarks1=new JLabel("Marks 1:");
		add(lmarks1);
		tmarks1=new JTextField(10);
		add(tmarks1);
		
		lmarks2 = new JLabel("Marks 2 :");
		add(lmarks2);
		tmarks2 = new JTextField(10);
		add(tmarks2);
		
		lmarks3 = new JLabel("Marks 3 :");
		add(lmarks3);
		tmarks3 = new JTextField(10);
		add(tmarks3);
		
		bresult =new JButton("Result");
		bresult.addActionListener(this);
		add(bresult);
		tresult=new JTextField(10);
		add(tresult);
		
		// disable editing of comp
		tname.setEditable(false);
		tmarks1.setEditable(false);
		tmarks2.setEditable(false);
		tmarks3.setEditable(false);
		

		setVisible(true);
		this.addWindowListener(new MyWindowAdapter());
		loaditem();
	}// constructor
	
	private void loaditem()
	{
		try
		{
			// register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Establish connection 
			con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","sagar9027");
		// create statement obj for send and execute query
		st=con.createStatement();
		// store result in result set object
		rs1=st.executeQuery
				("select sno from stud_result");
		// copy resultset obj values to combobox
		if(rs1!=null)
		{
			while(rs1.next())
			{
				jcbtno.addItem(rs1.getInt(1));
			}//while
		}//if
		
		// create prepared statement object
		if(con!=null)
			ps=con.prepareStatement("select * from stud_result where sno=?");
		//create callable statement object
		if(con!=null)
		{
			cs=con.prepareCall("{call Find_Pass_Fail(?,?,?,?)}");
			cs.registerOutParameter(4,Types.VARCHAR);
		}
		
		
		}//try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf)
		{
			cnf.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int sno=0,m1=0,m2=0,m3=0;
		String result=null;
		
		System.out.println("Mini_Project_All_Stat.actionPerformed()");
		if(e.getSource()==bdetails)
		{
			System.out.println("Details button is clicked");
           try 
           {
        	   
			// get selected value from combox
			sno=(int) jcbtno.getSelectedItem();
			// set value to query prameter
			if(ps!=null)
			{
				ps.setInt(1,sno);
           // execute the query
			rs2=ps.executeQuery();
		   }//if
			
			//set resultset object record to textboxes
			if(rs2!=null)
			{
				if(rs2.next())
				{
					tname.setText(rs2.getString(2));
					tmarks1.setText(rs2.getString(3));
					tmarks2.setText(rs2.getString(4));
					tmarks3.setText(rs2.getString(5));
				}//if
			}//if
           }//try
           catch(SQLException se)
           {
        	   se.printStackTrace();
           }//catch
           }//eif
		else 
		{
			System.out.println("result button is clicked");
			try 
			{
				//read textbox values(m1,m2,m3)
				m1=Integer.parseInt(tmarks1.getText());
				m2=Integer.parseInt(tmarks2.getText());
				m3=Integer.parseInt(tmarks3.getText());
				// set in param values
				if(cs!=null)
				{
					cs.setInt(1,m1);
					cs.setInt(2,m2);
					cs.setInt(3,m3);
				}
				//execute pl/sql procedure
				cs.execute();
			    // gather value from out parameter  and get result
				result=cs.getString(4);
				// set result to text box
				tresult.setText(result);
			}// try
			catch(SQLException se)
			{
				se.printStackTrace();
			}//catch
		}// else
				
	}// action performed(-)
	
	public static void main(String args[])
	{
		System.out.println("Mini_Project_All_Stat.main()");
		Mini_Project_All_Stat test=new Mini_Project_All_Stat();
	}
	private class MyWindowAdapter extends WindowAdapter
	{
		public void windowsClosing(WindowEvent e) 
		{
			System.out.println("window closing");
		try
		{
			if(rs1!=null)
			{
				rs1.close();
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		try
		{
			if(rs2!=null)
			{
				rs2.close();
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		try
		{
			if(cs!=null)
			{
				cs.close();
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		try
		{
			if(cs!=null)
			{
				cs.close();
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		try
		{
			if(st!=null)
			{
				st.close();
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		try
		{
			if(con!=null)
			{
				con.close();
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		}//catch
	}// window adapter(inner class0
}//class
