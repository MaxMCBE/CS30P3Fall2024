package Stats;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Stats 
{
	private JFrame frame;
	private JScrollPane scrollPane;
	private JPanel panel;
	private File test1;

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
		autofill();
		
		FileReader in;
		BufferedReader readFile;
		
		try
		{
			in = new FileReader(test1);
			readFile = new BufferedReader(in);
			
			for (int i = 1; i <= 50; i++)
			{
				JLabel label = new JLabel();
				label.setText(readFile.readLine() + " " + readFile.readLine());
				panel.add(label);
			}
			for (int i = 1; i <= 3; i++)
			{
				JLabel label = new JLabel();
				label.setText(readFile.readLine());
				panel.add(label);
			}
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Problem reading file", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void initialize() 
	{
		frame = new JFrame("Stats");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 15, 15));
	}

	private void autofill()
	{
		test1 = new File("src//Stats//test1.dat");
		FileWriter out;
		BufferedWriter writeFile;
		String name;
		double score;
		double totalScore  = 0;
		double topScore = 0;
		String topName = "";
		double bottomScore = 100;
		String bottomName = "";
		
		try
		{
			out = new FileWriter(test1);
			writeFile = new BufferedWriter(out);
			
			for (int i = 1; i <= 50; i++)
			{
				name = "Student " + i;
				score = Math.round(Math.random()*100);
				totalScore += score;
				
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
				
				writeFile.write(name);
				writeFile.newLine();
				writeFile.write(String.valueOf(score));
				writeFile.newLine();
			}
			
			double avg = Math.round(totalScore / 50);
			writeFile.write("Average: " + String.valueOf(avg));
			
			writeFile.newLine();
			writeFile.write("Top: " + topName + " with " + String.valueOf(topScore));
			
			writeFile.newLine();
			writeFile.write("Bottom: " + bottomName + " with " + String.valueOf(bottomScore));
			writeFile.close();
			out.close();
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Problem writing file", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
