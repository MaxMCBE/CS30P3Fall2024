package Roster;

import java.awt.*;
import java.io.*;
import javax.swing.*;

/*

Program: Roster.java          Last Date of this Revision: September 23, 2024

Purpose: Program that collects data for a list of student names and then outputs them. The real purpose of the program is to practice programming skills, as a lot of the program is redundant

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class Roster 
{
	private File data; //Data file
	
	//GUI elements
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
					Roster window = new Roster(); //Create a GUI
					window.getRoster(); //Get the roster input
					
					window.frame.setVisible(true); //Set the GUI to visible
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	private void resetFile() //Reset data file
	{
		try //Try
		{
			data = new File("src//Roster//data.dat"); //Create a File object with the desired path
			if (data.exists()) //If it exists, delete it
			{
				data.delete();
			}
			//Create a fresh, blank file at the desired path
			data.createNewFile();
		}
		catch (IOException e) //Catch
		{
			JOptionPane.showMessageDialog(null, "Problem resetting file", "Error", JOptionPane.ERROR_MESSAGE); //Error message
		}
	}

	public Roster() //Constructor
	{
		initialize(); //Init
	}

	private void initialize() //Init
	{
		//Frame
		frame = new JFrame("Roster");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ScrollPane (to fit lots of file data on the window)
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
				
		//Panel for scrollPane view
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 15, 15)); //1 column, indefinite rows
	}
	
	private void getRoster() //Get roster data
	{
		while (true) //Loop so you can't break the program by saying there are ASDhakjwerhk students
		{
			String first; //First name
			String last; //Last name
			int students; //Number of students
			StudentName[] studentNames; //Array of names
			//First redundant thing- it could just be a String array instead of another class
			//Also the second redundant thing: why save it to an array instead of just immediately writing it to the file?
			
			try //Get number of students
			{
				students = Integer.parseInt(JOptionPane.showInputDialog(null, "How many students are in the class?", "Input", JOptionPane.QUESTION_MESSAGE));
				studentNames = new StudentName[students]; //Set array length to number of students
			}
			catch (Exception e1) //Catch exception
			{
				JOptionPane.showMessageDialog(null, "Please enter a number", "Error", JOptionPane.INFORMATION_MESSAGE); //Error message
				continue; //Loop back
			}
			
			for (int i = 1; i <= students; i++) //For each student
			{
				//Get first and last name input
				first = JOptionPane.showInputDialog(null, "What is the first name of student #" + i + "?", "Input", JOptionPane.QUESTION_MESSAGE);
				last = JOptionPane.showInputDialog(null, "What is the last name of student #" + i + "?", "Input", JOptionPane.QUESTION_MESSAGE);
				//Add it to array of names
				studentNames[i-1] = new StudentName(first, last); //This would be so much easier to save as a string
			}
			
			write(studentNames); //Write the array to a file (Would be more effective to write on line 119 instead of saving it to an array first) (or just moves lines 162-164 to in the loop)
			read(); //Immediately read the file (This is why it doesn't make sense to save it to a file, it's just getting read immediately after)
			
			break; //Break loop
		}
	}
	
	private void write(StudentName[] names) //Write array to file
	{
		resetFile(); //Reset the file
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(data)); //Create a writer
			
			out.write("Students: " + names.length); //Write total number of students
			out.newLine();
			
			for (int i = 0; i < names.length; i++) //Output each student name on a fresh line
			{
				out.write(names[i].toString());
				out.newLine();
			}
			
			out.close(); //Close
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.INFORMATION_MESSAGE); //Error message
		}
	}
	
	private void read() //Read file and output to GUI
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(data)); //Reader
			String name; //String for current name
			
			while ((name = in.readLine()) != null) //While it can read further
			{
				JLabel label = new JLabel();
				label.setText(name); //Create a new JLabel in the scrollPane panel grid with the name as the text
				panel.add(label);
			}
			
			in.close(); //Close
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.INFORMATION_MESSAGE); //Error message
		}
	}
}