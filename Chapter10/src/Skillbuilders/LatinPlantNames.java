package Skillbuilders;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

/*

Program: LatinPlantNames.java          Last Date of this Revision: September 12, 2024

Purpose: Returns the Latin name of a selected plant

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class LatinPlantNames 
{
	private String[] englishNames = {"basil", "lavender", "parsley", "peppermint", "saffron", "sage"};
	private String[] latinNames = {"ocimum", "lavandula spica", "apium", "mentha piperita", "crocus", "salvia"};
	
	private JFrame frame;
	private JLabel instructionLabel;
	private JComboBox<String> plantNameList;
	private JLabel outputLabel;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LatinPlantNames window = new LatinPlantNames();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public LatinPlantNames() 
	{
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame("LatinPlantNames");
		frame.setBounds(0, 0, 300, 125);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		instructionLabel = new JLabel("Select a plant name:");
		frame.getContentPane().add(instructionLabel);
		instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		plantNameList = new JComboBox<>(englishNames);
		plantNameList.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				outputLabel.setText("Latin name: " + latinNames[Arrays.asList(englishNames).indexOf((String)plantNameList.getSelectedItem())]);
			}
		});
		frame.getContentPane().add(plantNameList);
		
		outputLabel = new JLabel("Latin name: ocimum");
		frame.getContentPane().add(outputLabel);
		outputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
}
