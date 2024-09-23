package Stats;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

/*

Program: Stats.java          Last Date of this Revision: September 23, 2024

Purpose: Program that gathers test result input for a group of students, which it can then output

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class Stats 
{
	private int students = 0; //Number of students
	private final int EXTRA = 3; //Extra lines of data after student data
	
	//GUI elements
	private JFrame frame;
	private JScrollPane scrollPane;
	private JPanel panel;
	private File test;
	private JPanel header;
	private JButton generateButton;
	private JButton inputButton;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() //Create thread
		{
			public void run() //Run
			{
				try
				{
					Stats window = new Stats(); //Create a Stats GUI
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Stats() //Constructor
	{
		initialize(); //Run initialize()
	}

	private void initialize() 
	{
		//Frame
		frame = new JFrame("Stats");
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
		
		//scrollPane header
		header = new JPanel();
		header.setBackground(new Color(255, 255, 255));
		scrollPane.setColumnHeaderView(header);
		header.setLayout(new GridLayout(0, 2, 15, 15)); //2 columns, indefinite rows
		
		//Button to autofill data
		generateButton = new JButton("Generate random data");
		generateButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				autofill(); //Autofill data file
				read(); //Read and output data file
			}
		});
		header.add(generateButton);
		
		//Button to input data
		inputButton = new JButton("Input students and grades");
		inputButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				input(); //Get input and write it into data file
				read(); //Read and output data file
			}
		});
		header.add(inputButton);
	}
	
	private void read() //Read and output data file
	{
		try
		{
			//Clear old data
			panel.removeAll(); //Clear panel
			if (header.getComponentCount() == 2+EXTRA) //If the header is filled 
			{
				for (int i = EXTRA; i > 0; i--) //Loop through extra elements
				{
					header.remove(2+i-1); //Remove them (This math is not simplified but 2 (buttons) + i (extra element) - 1 (to get index) makes more sense to read in my opinion than 1 + i)
				}
			}
			
			//Create reader
			BufferedReader in = new BufferedReader(new FileReader(test)); //I chose to define the FileReader inside the BufferedReader as it felt redundant to separate it. Please correct me if there is an important reason to separate this out 
			
			//For requested students
			for (int i = 1; i <= students; i++)
			{
				JLabel label = new JLabel();
				label.setText(in.readLine() + ": " + in.readLine()); //Add a label with text "Name: score" to the scroll panel
				panel.add(label);
			}
			//Add extra data from the end
			for (int i = 1; i <= EXTRA; i++)
			{
				JLabel label = new JLabel();
				label.setText(in.readLine());
				header.add(label); //Add these to the header
			}
			
			//Close
			in.close();
			
			frame.repaint(); //Rebuild the GUI so the user doesn't need to update it by scrolling/etc
			frame.revalidate();
		}
		catch (IOException e) //Catch exception
		{
			JOptionPane.showMessageDialog(null, "Problem reading file", "Error", JOptionPane.ERROR_MESSAGE); //Error message
		}
	}
	
	private void resetFile() //Reset data file
	{
		try //Try
		{
			test = new File("src//Stats//test.dat"); //Create a File object with the desired path
			if (test.exists()) //If it exists, delete it
			{
				test.delete();
			}
			//Create a fresh, blank file at the desired path
			test.createNewFile();
		}
		catch (IOException e) //Catch
		{
			JOptionPane.showMessageDialog(null, "Problem resetting file", "Error", JOptionPane.ERROR_MESSAGE); //Error message
		}
	}
	
	private void input() //Get user input and add it to the file
	{
		//Data file
		test = new File("src//Stats//test.dat");
		resetFile(); //Reset data (it will be overwritten anyways, but this prevents line 54 from remaining unchanged when going from 100 to 50 students)
		
		//Variables for current name and score
		String name;
		double score;
		//Total score
		double totalScore  = 0;
		//Top and bottom scores and corresponding names
		double topScore = 0;
		String topName = "";
		double bottomScore = 100;
		String bottomName = "";
		
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(test)); //Same note as read()
			
			//Get input for number of students
			students = Integer.parseInt(JOptionPane.showInputDialog(null, "How many students would you like to enter grades for?", "Student Input", JOptionPane.QUESTION_MESSAGE));
			
			for (int i = 1; i <= students; i++) //For each student
			{
				name = JOptionPane.showInputDialog(null, "Please enter the name of student #" + i + ":", "Input", JOptionPane.QUESTION_MESSAGE); //Get input for the name of the student
				score = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the score of student " + name + ":", "Input", JOptionPane.QUESTION_MESSAGE)); //Get input for the score of the student
				
				totalScore += score; //Add the score to the total
				
				//Replace high and low if necessary
				if (score > topScore)
				{
					topName = name;
					topScore = score;
				}
				if (score < bottomScore)
				{
					bottomName = name;
					bottomScore = score;
				}
				
				//Add name and score to file
				out.write(name);
				out.newLine();
				out.write(String.valueOf(score));
				out.newLine();
			}
			
			//The EXTRA lines
			out.write("Top: " + topName + " with " + String.valueOf(topScore)); //Add top score and name
			out.newLine();
			
			out.write("Bottom: " + bottomName + " with " + String.valueOf(bottomScore)); //Add bottom score and name
			out.newLine();
			
			double avg = Math.round(totalScore / students);
			out.write("Average: " + String.valueOf(avg)); //Add average
			
			//Close
			out.close();
		}
		catch (Exception e) //Catch exceptions (IOException or data types)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong, please try again", "Error", JOptionPane.ERROR_MESSAGE); //Error message
		}
	}

	private void autofill() //Autofill random student data (for testing)
	{
		//Data file
		test = new File("src//Stats//test.dat");
		resetFile();
		
		//Variables for current name and score
		String name;
		double score;
		//Total score
		double totalScore  = 0;
		//Top and bottom scores and corresponding names
		double topScore = 0;
		String topName = "";
		
		double bottomScore = 100;
		String bottomName = "";
		
		try //To catch exceptions
		{
			//Get input for number of students
			students = Integer.parseInt(JOptionPane.showInputDialog(null, "How many students would you like to generate grades for?", "Student Input", JOptionPane.QUESTION_MESSAGE));

			//Create writer
			BufferedWriter out = new BufferedWriter(new FileWriter(test)); //Same note as read()
			
			for (int i = 1; i <= students; i++) //For each student
			{
				name = "Student " + i; //Set name to student number
				score = Math.round(Math.random()*100); //Generate a random score (0 to 100)
				totalScore += score; //Add score to total
				
				//Replace high and low if necessary
				if (score > topScore)
				{
					topName = name;
					topScore = score;
				}
				if (score < bottomScore)
				{
					bottomName = name;
					bottomScore = score;
				}
				
				//Add name and score to file on 2 lines
				out.write(name);
				out.newLine();
				out.write(String.valueOf(score));
				out.newLine();
			}
			
			//The EXTRA lines
			out.write("Top: " + topName + " with " + String.valueOf(topScore)); //Add top score
			out.newLine();
			
			out.write("Bottom: " + bottomName + " with " + String.valueOf(bottomScore)); //Add bottom score
			out.newLine();
			
			double avg = Math.round(totalScore / students); //Add average
			out.write("Average: " + String.valueOf(avg));
			
			//Close
			out.close();
		}
		catch (Exception e) //Catch exceptions (IOException or data types)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong, please try again", "Error", JOptionPane.ERROR_MESSAGE); //Error message
		}
	}
}