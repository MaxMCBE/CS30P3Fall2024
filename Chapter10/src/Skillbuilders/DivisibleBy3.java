package Skillbuilders;

//Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*

Program: DivisibleBy3.java          Last Date of this Revision: September 12, 2024

Purpose: Tests if an inputted number is divisible by 3

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class DivisibleBy3 
{
	//Define GUI elements
	private JFrame frame;
	private JTextField inputField;
	private JLabel outputLabel;
	private JButton checkButton;

	//Main
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() //Create thread
		{
			public void run() //Run thread
			{
				try 
				{
					DivisibleBy3 window = new DivisibleBy3(); //Create GUI window
					window.frame.setVisible(true); //Make visible
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public DivisibleBy3() //Constructor
	{
		initialize(); //Init
	}

	private void initialize() //Init GUI
	{
		//Main frame
		frame = new JFrame("DivisibleBy3");
		frame.setBounds(0, 0, 400, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 2, 15, 15)); //2x2 grid layout
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		//Instruction label
		JLabel inputInstructions = new JLabel("Enter an integer:");
		inputInstructions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(inputInstructions);
		
		//Input field
		inputField = new JTextField();
		inputField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(inputField);
		inputField.setColumns(10);
		
		//Input button
		checkButton = new JButton("Check");
		checkButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) //On click
			{
				try //Try to get input
				{
					int in = Integer.parseInt(inputField.getText()); //Get input
					
					if (in%3 == 0) //Test if it is divisible by 3 with no remainder
					{
						outputLabel.setText("Number is divisible by 3"); //Update output
					}
					else //If not
					{
						outputLabel.setText("Number is not divisible by 3"); //Update output
					}
				}
				catch (Exception invalidDataType) //If the input is not an integer
				{
					JOptionPane.showMessageDialog(frame, "Please enter an integer", "Input Error", JOptionPane.ERROR_MESSAGE); //Error message
					inputField.setText(null); //Reset input
					outputLabel.setText("Number is not divisible by 3"); //Reset output
				}
			}
		});
		checkButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(checkButton);
		
		//Output label
		outputLabel = new JLabel("Number is not divisible by 3");
		outputLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(outputLabel);
	}

}
