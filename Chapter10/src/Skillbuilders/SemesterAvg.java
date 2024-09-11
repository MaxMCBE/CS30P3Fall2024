package Skillbuilders;

//GUI imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//DC import
import java.text.DecimalFormat;

/*

Program: SemesterAvg.java          Last Date of this Revision: September 11, 2024

Purpose: Collects input for 3 grades and displays the average using GUI

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class SemesterAvg //Class
{
	private DecimalFormat dc = new DecimalFormat("0.00"); //DecimalFormat setup
	
	//Define GUI elements
	private JFrame frame;
	
	private JLabel inputLabel1;
	private JTextField inputField1;
	private JLabel inputLabel2;
	private JTextField inputField2;
	private JLabel inputLabel3;
	private JTextField inputField3;
	
	private JButton avgButton;
	private JLabel outputAverageLabel;

	//Main
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() //Create thread
		{
			public void run()  //Run
			{
				try 
				{
					SemesterAvg window = new SemesterAvg(); //Create a GUI window
					window.frame.setVisible(true); //Set visible
				} 
				catch (Exception e) //If there is an error
				{
					e.printStackTrace(); //Output error
				}
			}
		});
	}

	public SemesterAvg() //Constructor
	{
		initialize(); //Run initialize function
	}

	private void initialize() //Initialize function for GUI
	{
		//Frame
		frame = new JFrame("SemesterAvg");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 10, 5));
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		//Instructions for input
		inputLabel1 = new JLabel("Enter the first grade:");
		inputLabel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(inputLabel1);
		
		//Field for input
		inputField1 = new JTextField();
		inputField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(inputField1);
		inputField1.setColumns(10);
		
		//Repeat twice more
		
		inputLabel2 = new JLabel("Enter the second grade:");
		inputLabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(inputLabel2);
		
		inputField2 = new JTextField();
		inputField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(inputField2);
		inputField2.setColumns(10);
		
		inputLabel3 = new JLabel("Enter the third grade:");
		inputLabel3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(inputLabel3);
		
		inputField3 = new JTextField();
		inputField3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(inputField3);
		inputField3.setColumns(10);
		
		//Button to calculate average
		avgButton = new JButton("Average Grades");
		avgButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) //On click
			{
				try //Try to gather input (if it fails, catch the exception)
				{
					double grade1 = Double.parseDouble(inputField1.getText()); //Gather input
					double grade2 = Double.parseDouble(inputField2.getText());
					double grade3 = Double.parseDouble(inputField3.getText());
					
					if (grade1 < 0 || grade1 > 100 || grade2 < 0 || grade2 > 100 || grade3 < 0 || grade3 > 100) //Check that all grades are a valid percentage
					{
						throw new Exception("Input below 0 or over 100"); //If not, throw exception
					}
					
					double avg = (grade1+grade2+grade3)/3; //Calculate average
					outputAverageLabel.setText(dc.format(avg) + "%"); //Output average
				}
				catch (Exception invalidInput) //This code runs if the input cannot be parsed to double, or if the exception is thrown
				{
					JOptionPane.showMessageDialog(frame, "Please enter a number from 0 to 100", "Input Error", JOptionPane.ERROR_MESSAGE); //Give an error message
				}
			}
		});
		avgButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(avgButton);
		
		//Create label for average output
		outputAverageLabel = new JLabel("0.00%");
		outputAverageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		outputAverageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(outputAverageLabel);
	}
}