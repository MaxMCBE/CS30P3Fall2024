package Roster;

import java.awt.*;
import javax.swing.*;

/*

Program: Roster.java          Last Date of this Revision: September 23, 2024

Purpose: Program that collects data for a list of student names and then outputs them

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class Roster 
{
	private JFrame frame;
	private JScrollPane scrollPane;
	private JPanel panel;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Roster window = new Roster();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Roster() 
	{
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame("Roster");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ScrollPane (to fit lots of file data on the window)
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
				
		//Panel for main scrollPane view
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 15, 15)); //1 column, indefinite rows
	}
}