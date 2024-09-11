package Skillbuilders;

import java.awt.*;
import javax.swing.*;

/*

Program: LatinPlantNames.java          Last Date of this Revision: September 11, 2024

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
		frame.setBounds(0, 0, 300, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
