package FindAndReplace;

//Imports
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.ArrayList;

/*

Program: FindAndReplace.java          Last Date of this Revision: October 1, 2024

Purpose: A program that searches a file for all instances of a target phrase, which it replaces with another if found

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class FindAndReplace 
{
	//Declare necessary GUI elements
	private JFrame frame;
	private JTextField filePathField;
	private JTextField targetField;
	private JTextField replacementField;
	private JLabel replacedLabel;
	private JButton runButton;
	
	private File textFile; //The file that will be used by the program- the path will be assigned in methods
	
	private int wordsReplaced; //Counter for number of words replaced by the program
	
	private String line; //Current text line being processed
	private ArrayList<String> lines = new ArrayList<String>(); //ArrayList of processed text lines
	
	private String target; //Target string to be replaced
	private String replacement; //Replacement for target string

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() //Create thread
		{
			public void run() //Run thread
			{
				try //Windowbuilder try-catch statement
				{
					FindAndReplace window = new FindAndReplace(); //Create GUI object
					window.frame.setVisible(true); //Set the frame to visible
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public FindAndReplace() //Constructor for GUI objects
	{
		initialize(); //Run initialize method
	}

	/*
	 * Sets up GUI elements
	 */
	private void initialize() 
	{
		//Main frame
		frame = new JFrame("FindAndReplace");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null); //Center on screen
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.getContentPane().setLayout(new GridLayout(0, 2, 15, 15)); //2 column, indefinite row grid
		
		//Instructional label for first field
		JLabel fileInLabel = new JLabel("Enter path of desired file:"); 
		fileInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fileInLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(fileInLabel);
		
		//Field for file path (defaults to text.txt)
		filePathField = new JTextField();
		filePathField.setHorizontalAlignment(SwingConstants.CENTER);
		filePathField.setText("src//FindAndReplace//text.txt");
		filePathField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(filePathField);
		filePathField.setColumns(10);
		
		//Instructional label for second field
		JLabel wordFindLabel = new JLabel("Enter word to replace:");
		wordFindLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordFindLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(wordFindLabel);
		
		//Field for target word
		targetField = new JTextField();
		targetField.setHorizontalAlignment(SwingConstants.CENTER);
		targetField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(targetField);
		targetField.setColumns(10);
		
		//Instructional label for third field
		JLabel replacementLabel = new JLabel("Enter replacement:");
		replacementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		replacementLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(replacementLabel);
		
		//Field for replacement word
		replacementField = new JTextField();
		replacementField.setHorizontalAlignment(SwingConstants.CENTER);
		replacementField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(replacementField);
		replacementField.setColumns(10);
		
		//Button to run the findAndReplace() method
		runButton = new JButton("Find and replace");
		runButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				findAndReplace(); //Just runs the method on click, very simple
			}
		});
		runButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(runButton);
		
		//Output label for total words replaced
		replacedLabel = new JLabel("Words replaced: 0");
		replacedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		replacedLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(replacedLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Tests to see if a given file exists
	 * @param path file path of the desired file
	 * @return true if the file exists, false if the file does not exist
	 */
	private boolean getFile(String path)
	{
		textFile = new File(path); //Assign the source object to a file at the inputted path
		
		if (textFile.exists()) //If it exists
		{
			return true; //Return true, and the program continues running
		}
		else //If it does not exist
		{
			//Output an error message
			JOptionPane.showMessageDialog(null, "File with path '" + path + "' could not be found", "File not found", JOptionPane.ERROR_MESSAGE); //Error message
			return false; //Return false (the program will not continue running)
		}
	}
	
	/*
	 * Tests to see if a target string exists in another string starting at a given index
	 * @param outer the outer string to be tested for the inner string
	 * @param target the inner string that the outer string is being tested for
	 * @param startIndex the index of the outer string that the inner string should begin on
	 * @return true if the inner string exists at the given index, false if it does not
	 */
	private boolean compare(String outer, String target, int startIndex)
	{
		for (int i = 0; i < target.length(); i++) //For each character in the target word
		{
			if (!(outer.charAt(startIndex+i) == target.charAt(i))) //If the corresponding character in the outer word is NOT equal to the target
			{
				return false; //Return false
			}
		}
		return true; //If never returned false (everything matches) return true
	}
	
	/*
	 * Uses GUI elements to gather input, and then search the given file for the given target to replace with the given replacement
	 */
	private void findAndReplace()
	{
		//Reset variables
		wordsReplaced = 0; //Words replaced to 0
		
		line = ""; //Current line to blank
		lines.clear(); //Lines ArrayList emptied
		
		target = targetField.getText(); //Set target to field input
		replacement = replacementField.getText(); //Set replacement to field input
		
		if (getFile(filePathField.getText())) //If the file exists (no else statement as getFile() handles failure)
		{
			if (!target.equals("") && !replacement.equals("")) //If the target and replacement fields are NOT blank
			{
				try //try-catch for IOException
				{
					BufferedReader in = new BufferedReader(new FileReader(textFile)); //Create a BufferedReader
					
					while ((line = in.readLine()) != null) //Read the next line, and continue the loop as long as it is not null
					{
						for (int i = 0; i < line.length(); i++) //For each character in the line
						{
							if (line.charAt(i) == target.charAt(0)) //If the current character in the line is equal to the first character of the target word
							{
								if (compare(line, target, i)) //Compare the line starting at the current character to the target word; if true
								{
									line = line.substring(0, i) + line.substring(i+target.length()); //Remove everything between the current index and the index target length past current (remove the target word)
									i -= 1; //Move current index back 1, as the character it was on got removed
									line = line.substring(0, i+1) + replacement + line.substring(i+1); //Insert the replacement at the current index
									wordsReplaced++; //Increment the words replaced
									i += replacement.length(); //Advance the current index forwards past the replacement, to prevent infinite loops of replacing itself (such as a->a or b->bbbb)
								}
								//If false, it doesn't match and just moves on to the next character
							}
						}
						lines.add(line); //After the line has been looped through completely, add it to the ArrayList
					}
					
					BufferedWriter out = new BufferedWriter(new FileWriter(textFile)); //Create a BufferedWriter
					
					for (int i = 0; i < lines.size(); i++) //For each line in the ArrayList
					{
						out.write(lines.get(i)); //Write the line
						out.newLine(); //Move to a new line for the next one
					}
					
					replacedLabel.setText("Words replaced: " + wordsReplaced); //Output the number of words replaced
					JOptionPane.showMessageDialog(null, "All instances of '" + target + "' replaced with '" + replacement + "'", "Replacement complete", JOptionPane.INFORMATION_MESSAGE); //Basic output message
					
					in.close(); //Close reader stream
					out.close(); //Close writer stream
				}
				catch (IOException e) //If something goes wrong with the reader or writer
				{
					JOptionPane.showMessageDialog(null, "An error occured while reading the file", "Error", JOptionPane.ERROR_MESSAGE); //Error message
				}
			}
			else //If the target or replacement fields are blank
			{
				JOptionPane.showMessageDialog(null, "Something went wrong with input values. Please ensure that no fields are blank", "Error", JOptionPane.ERROR_MESSAGE); //Error message
			}
		}
	}
}

//Screen Dumps: N/A, no console output for GUI programs