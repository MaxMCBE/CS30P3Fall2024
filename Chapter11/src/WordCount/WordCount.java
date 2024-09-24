package WordCount;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class WordCount 
{
	private JFrame frame;
	private JPanel panel;
	private JTextField filePathInput;
	private JButton countButton;
	
	private File source;
	
	private ArrayList<String> words = new ArrayList<String>();
	private String word;
	private String line;
	private char character;
	
	private int letters;
	private JLabel wordTotalOut;
	private JLabel averageLengthOut;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					WordCount window = new WordCount();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public WordCount() 
	{
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame("WordCount");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 15, 15));
		
		JLabel instructions = new JLabel("Enter file path of file to scan below:");
		instructions.setFont(new Font("Tahoma", Font.PLAIN, 15));
		instructions.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(instructions);
		
		filePathInput = new JTextField();
		filePathInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		filePathInput.setHorizontalAlignment(SwingConstants.CENTER);
		filePathInput.setText("src//WordCount//source.txt");
		panel.add(filePathInput);
		filePathInput.setColumns(10);
		
		countButton = new JButton("Count words");
		countButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				count();
			}
		});
		countButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(countButton);
		
		wordTotalOut = new JLabel("Total words:");
		wordTotalOut.setHorizontalAlignment(SwingConstants.CENTER);
		wordTotalOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(wordTotalOut);
		
		averageLengthOut = new JLabel("Average word length:");
		averageLengthOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		averageLengthOut.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(averageLengthOut);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private boolean getFile()
	{
		source = new File(filePathInput.getText());
		
		if (source.exists())
		{
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "File with path '" + filePathInput.getText() + "' could not be found", "File not found", JOptionPane.INFORMATION_MESSAGE); //Error message
			return false;
		}
	}
	
	private void count()
	{
		words.clear();
		letters = 0;
		
		line = "";
		word = "";
		character = ' ';
		
		if (getFile())
		{
			try
			{
				BufferedReader in = new BufferedReader(new FileReader(source)); //Reader
				
				while ((line = in.readLine()) != null)
				{
					word = "";
					for (int i = 0; i < line.length(); i++)
					{
						character = line.charAt(i);
						
						if (character == ' ' || i == line.length()-1)
						{
							words.add(word);
							word = "";
						}
						else
						{
							letters++;
							word += character;
						}
					}
				}
				
				wordTotalOut.setText("Total words: " + words.size());
				averageLengthOut.setText("Average word length: " + (Math.round((double) letters/words.size())) + " letters");
				
				in.close();
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "An error occured while reading the file", "Error", JOptionPane.INFORMATION_MESSAGE); //Error message
			}
		}
	}
}