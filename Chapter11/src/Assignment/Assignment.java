package Assignment;

import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Assignment 
{
	private JFrame frame;
	private JScrollPane scrollPane;
	private JLabel label;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Assignment window = new Assignment();
					window.frame.setVisible(true);
					
					File instructions = new File("src//Assignment//instructions.txt");
					FileReader in;
					BufferedReader readFile;
					
					try
					{
						window.label.setText("");
						in = new FileReader(instructions);
						readFile = new BufferedReader(in);
	
						window.label.setText(window.label.getText() + readFile.readLine());
						
						readFile.close();
						in.close();
					}
					catch (FileNotFoundException e)
					{
						JOptionPane.showMessageDialog(null, "Instructions file does not exist or could not be found", "File location failed", JOptionPane.ERROR_MESSAGE);
					}
					catch (IOException e)
					{
						JOptionPane.showMessageDialog(null, "Problem reading file", "File reading failed", JOptionPane.ERROR_MESSAGE);
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Assignment() 
	{
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame("Assignment");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		label = new JLabel("instructions");
		scrollPane.setViewportView(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
