package Mini_Project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ps_srollable_miniproj extends JFrame implements ActionListener{
	private JLabel lno,lname,ladd;
	private JTextField tno,tname,tadd;
	private JButton bfirst,bnext,bprevious,blast;
	private Connection con=null;
    private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	
	// constructor
	Ps_srollable_miniproj()
	{
		// student no
		JLabel lno=new JLabel("Student no");
		add(lno);
		JTextField tno= new JTextField(17);
		add(tno);
		
		// student name
		JLabel lname= new JLabel("Student Name");
		add(lname);
		JTextField tname= new JTextField(17);
		add(tname);
		// student address
		JLabel ladd= new JLabel("Student Address");
		add(ladd);
		JTextField tadd= new JTextField(17);
		add(tadd);
		
		// button
		bfirst= new JButton("FIRST");
		bfirst.addActionListener(this);
		add(bfirst);
		
		bnext=new JButton("NEXT");
		bnext.addActionListener(this);
		add(bnext);
		
		bprevious=new JButton("PREVIUOS");
		bprevious.addActionListener(this);
		add(bprevious);
		
		blast= new JButton("LAST");
		blast.addActionListener(this);
		add(blast);
		
	
		setSize(350,400);
		setLayout(new FlowLayout());
		setVisible(true);
		initialize();
		
	
	}// constructor
	
	
	
 private void initialize()
	{
	 System.out.println("Ps_srollable_miniproj.initialize()");

		try {
	

			// register jdbc driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost","system","sagar9027");
			// create statement object
			if(con!=null)
			{
				ps=con.prepareStatement("select * from student",
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
			}
			if(ps!=null)
				rs=ps.executeQuery();
			}//try
				catch(SQLException se)
				{
					se.printStackTrace();
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
			}//  make a connection
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Ps_srollable_miniproj.actionPerformed()");
	     boolean flag=false;
		try {
			//Button First
		if(e.getSource()==bfirst)
		 {
			System.out.println("click first button");
			rs.first();
			flag=true;
		 }
		else if(e.getSource()==blast)
		{
			System.out.println("click last button");
			rs.last();
			flag=true;
		}
		
		else if(e.getSource()==bnext)
		{
			System.out.println("click next button");
			if(!rs.last())
			{
				rs.next();
				flag=true;
			}
		}
		// last button
		else 
		{
			System.out.println("click previous button");
			rs.previous();
			flag=true;
		}
		// set record values to textbox
		if(flag==true)
		{
			tno.setText(rs.getString(1));
			tname.setText(rs.getString(2));
			tadd.setText(rs.getString(3));
		}
		
		}//try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		}

		public static void main(String [] args)
		{
			Ps_srollable_miniproj test=new Ps_srollable_miniproj();
		
		}//main
		}//class
