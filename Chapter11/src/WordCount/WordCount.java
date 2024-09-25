package WordCount;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

/*

Program: WordCount.java          Last Date of this Revision: September 24, 2024

Purpose: A program that locates a text file, reads it, and counts the words and letters, outputting the number of words and average word length

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class WordCount 
{
	//GUI element definitions (No unnecessary ones this time)
	private JFrame frame;
	private JTextField filePathInput;
	private JButton countButton;
	private JLabel wordTotalOut;
	private JLabel averageLengthOut;
	
	//Variable for the file
	private File source;
	
	//Variables to store data
	private ArrayList<String> words = new ArrayList<String>();
	private int letters;
	
	//Variables to process data
	private String line;
	private String word;
	private char character;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() //Create thread
		{
			public void run() //Run thread
			{
				try //Don't see a need for the try/catch but Windowbuilder puts it here
				{
					WordCount window = new WordCount(); //Create GUI
					window.frame.setVisible(true); //Set it visible
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public WordCount() //Constructor for GUI
	{
		initialize(); //Run initialize method
	}

	/*
	 * Set up elements in the GUI object when the constructor is run
	 * Note: I am aware that code standards say not to add the extra asterisks to these, however Eclipse does it automatically
	 */
	private void initialize() 
	{
		//Create main JFrame
		frame = new JFrame("WordCount");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null); //Center on screen
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create a main content panel with a vertical single column grid layout
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 15, 15));
		
		//Create a simple label to give instructions for the JTextField
		JLabel instructions = new JLabel("Enter file path of file to scan below:");
		instructions.setFont(new Font("Tahoma", Font.PLAIN, 15));
		instructions.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(instructions);
		
		//JTextField to allow input for the file path to locate
		filePathInput = new JTextField();
		filePathInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		filePathInput.setHorizontalAlignment(SwingConstants.CENTER);
		filePathInput.setText("src//WordCount//source.txt"); //By default, searches this path
		panel.add(filePathInput);
		filePathInput.setColumns(10);
		
		//Button to process the file
		countButton = new JButton("Count words");
		countButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				count(); //Just runs the count() method on click
			}
		});
		countButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(countButton);
		
		//Output for the total number of words
		wordTotalOut = new JLabel("Total words:");
		wordTotalOut.setHorizontalAlignment(SwingConstants.CENTER);
		wordTotalOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(wordTotalOut);
		
		//Output for the average word length
		averageLengthOut = new JLabel("Average word length:");
		averageLengthOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		averageLengthOut.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(averageLengthOut);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Tests to see if the file path given in he JTextField filePathInput exists
	 * @return true if the file exists, false if the file does not exist
	 */
	private boolean getFile()
	{
		source = new File(filePathInput.getText()); //Assign the source object to a file at the inputted path
		
		if (source.exists()) //If it exists
		{
			return true; //Return true, and the program continues running
		}
		else //If it does not exist
		{
			//Output an error message
			JOptionPane.showMessageDialog(null, "File with path '" + filePathInput.getText() + "' could not be found", "File not found", JOptionPane.INFORMATION_MESSAGE); //Error message
			return false; //Return false (the program will not continue running)
		}
	}
	
	/*
	 * Reads a text file, counting the letters and storing the words, and then outputting via GUI
	 */
	private void count()
	{
		//Reset any preexisting data
		words.clear(); //Clear words ArrayList
		letters = 0; //Set letters to 0
		
		line = ""; //Set line to blank
		word = ""; //Set word to blank
		character = ' '; //Set character to a blank space
		
		if (getFile()) //If the file given in the JTextField exists (no else, since getFile() handles failure itself)
		{
			try //Catch any errors with reading the file
			{
				BufferedReader in = new BufferedReader(new FileReader(source)); //Create a BufferedReader (I chose to put this in one object instead of creating an independent FileReader as it makes it much easier to read in my opinion. If there is a reason to separate them that I am unaware of, please notify me for future reference)
				
				while ((line = in.readLine()) != null) //Read the next line, and continue the loop as long as it is not null
				{
					for (int i = 0; i < line.length(); i++) //For each character in the line
					{
						character = line.charAt(i); //Set the character to the character at the current index in the line
						
						if (character == ' ' || i == line.length()-1) //If the character is a space, or if it is the last character in the line
						{
							words.add(word); //Add the current word to the ArrayList
							word = ""; //Reset the current word
						}
						else if (Character.isLetter(character)) //If the character is not a space or the last character and is a letter (ignores punctuation and numbers)
						{
							letters++; //Increment letters by 1
							word += character; //Add the character to the current word
						}
					}
				}
				
				wordTotalOut.setText("Total words: " + words.size()); //Set text of the first label to the number of words gathered (ArrayList length)
				averageLengthOut.setText("Average word length: " + (Math.round((double) letters/words.size())) + " letters"); //Set the text of the second label to the average word length (Total letters divided by number of words (cast to double so that it rounds instead of flooring))
				
				in.close(); //Close the reader
			}
			catch (IOException e) //Catch any IOExceptions and output an error message
			{
				JOptionPane.showMessageDialog(null, "An error occured while reading the file", "Error", JOptionPane.INFORMATION_MESSAGE); //Error message
			}
		}
	}
}