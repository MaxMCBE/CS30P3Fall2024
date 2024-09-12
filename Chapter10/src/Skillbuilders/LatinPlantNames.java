package Skillbuilders;

//Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

/*

Program: LatinPlantNames.java          Last Date of this Revision: September 12, 2024

Purpose: Returns the Latin name of a selected plant

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class LatinPlantNames 
{
	//Arrays of English and Latin names
	private String[] englishNames = {"basil", "lavender", "parsley", "peppermint", "saffron", "sage"};
	private String[] latinNames = {"ocimum", "lavandula spica", "apium", "mentha piperita", "crocus", "salvia"};
	
	//Define GUI elements
	private JFrame frame;
	private JLabel instructionLabel;
	private JComboBox<String> plantNameList;
	private JLabel outputLabel;

	//Main
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() //Create thread
		{
			public void run() //Run thread
			{
				try 
				{
					LatinPlantNames window = new LatinPlantNames(); //Create a LatinPlantNames GUI object
					window.frame.setVisible(true); //Set it to visible
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public LatinPlantNames() //Constructor
	{
		initialize(); //Creates GUI
	}

	private void initialize() //Init function to create GUI
	{
		//Create frame
		frame = new JFrame("LatinPlantNames");
		frame.setBounds(0, 0, 300, 125);
		frame.setLocationRelativeTo(null); //Center on screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); //Vertical layout
		
		//Instruction label
		instructionLabel = new JLabel("Select a plant name:");
		frame.getContentPane().add(instructionLabel);
		instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //Center it on the X
		
		//Selection box
		plantNameList = new JComboBox<>(englishNames);
		plantNameList.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Set the text to "Latin name: " followed by the Latin name at the index of the selected English name
				outputLabel.setText("Latin name: " + latinNames[Arrays.asList(englishNames).indexOf((String)plantNameList.getSelectedItem())]);
			}
		});
		frame.getContentPane().add(plantNameList);
		
		//Output label
		outputLabel = new JLabel("Latin name: ocimum");
		frame.getContentPane().add(outputLabel);
		outputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
}
