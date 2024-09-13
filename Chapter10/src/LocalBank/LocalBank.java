package LocalBank;

import java.awt.EventQueue.*;
import java.awt.*;
import javax.swing.*;

public class LocalBank 
{
	private JFrame frame;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LocalBank window = new LocalBank();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public LocalBank() 
	{
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame("LocalBank");
		frame.setBounds(0, 0, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel leftBar = new JPanel();
		splitPane.setLeftComponent(leftBar);
		leftBar.setLayout(new BoxLayout(leftBar, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("LocalBank");
		leftBar.add(title);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton addAccount = new JButton("Add Account");
		leftBar.add(addAccount);
		addAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton viewAccount = new JButton("View Account");
		leftBar.add(viewAccount);
		viewAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel accountWindow = new JPanel();
		splitPane.setRightComponent(accountWindow);
	}
}
