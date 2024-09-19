package MyFile;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class MyFile 
{

	private JFrame frame;
	private JButton checkBtn;
	private JButton addBtn;
	private JButton removeBtn;
	private File selectedFile;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MyFile window = new MyFile();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MyFile() 
	{
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame("MyFile");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 15, 15));
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		
		checkBtn = new JButton("Check for file");
		checkBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String input = JOptionPane.showInputDialog(null, "Enter name of file to search for, including file extension:");

				selectedFile = new File("src//MyFile//" + input);
				
				if (selectedFile.exists())
				{
					JOptionPane.showMessageDialog(null, "File '" + input + "' exists", "File located", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "File with name '" + input + "' does not exist", "File not located", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		checkBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(checkBtn);
		
		addBtn = new JButton("Create file");
		addBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String input = JOptionPane.showInputDialog(null, "Enter name of file to create, including file extension:");
				
				selectedFile = new File("src//MyFile//" + input);
				
				if (selectedFile.exists())
				{
					JOptionPane.showMessageDialog(null, "File '" + input + "' already exists", "File creation failed", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try
					{
						selectedFile.createNewFile();
						JOptionPane.showMessageDialog(null, "File '" + input + "' created", "File created", JOptionPane.INFORMATION_MESSAGE);
						
					}
					catch (Exception fileCreationFailed)
					{
						JOptionPane.showMessageDialog(null, "Could not create file '" + input + "'", "File creation failed", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(addBtn);
		
		removeBtn = new JButton("Delete file");
		removeBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String input = JOptionPane.showInputDialog(null, "Enter name of file to create, including file extension:");
				
				selectedFile = new File("src//MyFile//" + input);
				
				if (!selectedFile.exists())
				{
					JOptionPane.showMessageDialog(null, "File '" + input + "' does not exist", "File deletion failed", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try
					{
						selectedFile.delete();
						JOptionPane.showMessageDialog(null, "File '" + input + "' deleted", "File created", JOptionPane.INFORMATION_MESSAGE);
						
					}
					catch (Exception fileDeletionFailed)
					{
						JOptionPane.showMessageDialog(null, "Could not delete file '" + input + "'", "File deletion failed", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		removeBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(removeBtn);
	}
}
