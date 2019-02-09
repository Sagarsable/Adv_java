package com.java.Swing;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class First_gui {

	public static void main(String args[])
	{
		abc obj=new abc();
		
	}
}
class abc extends JFrame
{
	abc()
	{
		// Boiler plate swing code
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create user name field
		// create java label
		JLabel luname=new JLabel("\nEnter User Name:");
	    JTextField jutext=new JTextField(20);
		add(luname);add(jutext);
		System.out.println();
		
		//create password field
		JLabel lpass_name=new JLabel("\nEnter Password:");
		JTextField jpass_text=new JTextField(20);
		add(lpass_name);add(jpass_text);
		
		
		
	}

}
