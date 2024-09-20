package Stats;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stats 
{
	private int students = 0;
	private final int EXTRA = 3;
	
	private JFrame frame;
	private JScrollPane scrollPane;
	private JPanel panel;
	private File test;
	private JPanel header;
	private JButton generateButton;
	private JButton inputButton;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Stats window = new Stats();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Stats()
	{
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame("Stats");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 15, 15));
		
		header = new JPanel();
		header.setBackground(new Color(255, 255, 255));
		scrollPane.setColumnHeaderView(header);
		header.setLayout(new GridLayout(0, 2, 15, 15));
		
		generateButton = new JButton("Generate random data");
		generateButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				autofill();
				read();
			}
		});
		header.add(generateButton);
		
		inputButton = new JButton("Input students and grades");
		inputButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				input();
				read();
			}
		});
		header.add(inputButton);
	}
	
	private void read()
	{
		FileReader in;
		BufferedReader readFile;
		
		try
		{
			//Clear old data
			panel.removeAll();
			if (header.getComponentCount() == 2+EXTRA)
			{
				for (int i = EXTRA; i > 0; i--)
				{
					header.remove(2+i-1);
				}
			}
			
			//Create reader
			in = new FileReader(test);
			readFile = new BufferedReader(in);
			
			//For requested students
			for (int i = 1; i <= students; i++)
			{
				JLabel label = new JLabel();
				label.setText(readFile.readLine() + ": " + readFile.readLine()); //Add a label with text "Name: score" to the scroll panel
				panel.add(label);
			}
			//Add extra data from the end
			for (int i = 1; i <= EXTRA; i++)
			{
				JLabel label = new JLabel();
				label.setText(readFile.readLine());
				header.add(label); //Add these to the header
			}
			
			//Close
			in.close();
			readFile.close();
			
			frame.repaint();
			frame.revalidate();
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Problem reading file", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void resetFile()
	{
		try
		{
			test = new File("src//Stats//test.dat");
			if (test.exists())
			{
				test.delete();
			}
			test.createNewFile();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Problem resetting file", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void input()
	{
		//File for test
		test = new File("src//Stats//test.dat");
		resetFile();
				
		//Create writer
		FileWriter out;
		BufferedWriter writeFile;
				
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
			out = new FileWriter(test);
			writeFile = new BufferedWriter(out);
			
			students = Integer.parseInt(JOptionPane.showInputDialog(null, "How many students would you like to enter grades for?", "Student Input", JOptionPane.QUESTION_MESSAGE));
			
			for (int i = 1; i <= students; i++)
			{
				name = JOptionPane.showInputDialog(null, "Please enter the name of student #" + i + ":", "Input", JOptionPane.QUESTION_MESSAGE);
				score = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the score of student #" + i + ":", "Input", JOptionPane.QUESTION_MESSAGE));
				
				totalScore += score;
				
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
				writeFile.write(name);
				writeFile.newLine();
				writeFile.write(String.valueOf(score));
				writeFile.newLine();
			}
			
			//The EXTRA lines
			writeFile.write("Top: " + topName + " with " + String.valueOf(topScore));
			writeFile.newLine();
			
			writeFile.write("Bottom: " + bottomName + " with " + String.valueOf(bottomScore));
			writeFile.newLine();
			
			double avg = Math.round(totalScore / students);
			writeFile.write("Average: " + String.valueOf(avg));
			
			//Close
			writeFile.close();
			out.close();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong, please try again", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void autofill()
	{
		//File for test
		test = new File("src//Stats//test.dat");
		resetFile();
		
		//Create writer
		FileWriter out;
		BufferedWriter writeFile;
		
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
			students = Integer.parseInt(JOptionPane.showInputDialog(null, "How many students would you like to generate grades for?", "Student Input", JOptionPane.QUESTION_MESSAGE));
			
			out = new FileWriter(test);
			writeFile = new BufferedWriter(out);
			
			for (int i = 1; i <= students; i++)
			{
				name = "Student " + i; //Set name to student number
				score = Math.round(Math.random()*100); //Generate a random score
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
				
				//Add name and score to file
				writeFile.write(name);
				writeFile.newLine();
				writeFile.write(String.valueOf(score));
				writeFile.newLine();
			}
			
			//The EXTRA lines
			writeFile.write("Top: " + topName + " with " + String.valueOf(topScore));
			writeFile.newLine();
			
			writeFile.write("Bottom: " + bottomName + " with " + String.valueOf(bottomScore));
			writeFile.newLine();
			
			double avg = Math.round(totalScore / students);
			writeFile.write("Average: " + String.valueOf(avg));
			
			//Close
			writeFile.close();
			out.close();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong, please try again", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
