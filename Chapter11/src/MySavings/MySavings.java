package MySavings;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/*

Program: MySavings.java          Last Date of this Revision: September 26, 2024

Purpose: Provides GUI for PiggyBank.java

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class MySavings 
{
	private JFrame frame;
	private JLabel coinOutLabel;
	private JLabel moneyOutLabel;
	
	private PiggyBank bank = new PiggyBank();
	private JTextField filePathField;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MySavings window = new MySavings();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MySavings() 
	{
		initialize();
	}

	private void initialize()
	{
		frame = new JFrame("MySavings");
		frame.setBounds(100, 100, 800, 500);
		frame.setLocationRelativeTo(null); //Center on screen
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.getContentPane().setLayout(new GridLayout(0, 2, 15, 15)); //2 column, indefinite row grid
		
		JPanel coinOutput = new JPanel();
		frame.getContentPane().add(coinOutput);
		coinOutput.setLayout(new GridLayout(0, 1, 15, 15));
		
		coinOutLabel = new JLabel("Coins in bank: 0 quarters, 0 dimes, 0 nickels, 0 pennies");
		coinOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		coinOutput.add(coinOutLabel);
		
		JPanel filePathPanel = new JPanel();
		frame.getContentPane().add(filePathPanel);
		filePathPanel.setLayout(new GridLayout(0, 1, 15, 15));
		
		JLabel filePathInstructions = new JLabel("Enter file path of text file to store piggy bank below:");
		filePathInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		filePathPanel.add(filePathInstructions);
		
		filePathField = new JTextField();
		filePathField.setText("src//MySavings//bank.txt");
		filePathField.setHorizontalAlignment(SwingConstants.CENTER);
		filePathPanel.add(filePathField);
		filePathField.setColumns(10);
		
		moneyOutLabel = new JLabel("Total balance in bank: $0");
		moneyOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		coinOutput.add(moneyOutLabel);
		
		JButton depositPenny = new JButton("Deposit penny");
		depositPenny.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositPenny.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.deposit(0.01);
				update();
			}
		});
		
		JButton saveToFile = new JButton("Save data to file");
		saveToFile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.write(filePathField.getText());
				update();
			}
		});
		saveToFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(saveToFile);
		
		JButton loadFile = new JButton("Load data from file");
		loadFile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.read(filePathField.getText());
				update();
			}
		});
		loadFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(loadFile);
		frame.getContentPane().add(depositPenny);
		
		JButton withdrawPenny = new JButton("Withdraw penny");
		withdrawPenny.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawPenny.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.withdraw(1, 0, 0, 0);
				update();
			}
		});
		frame.getContentPane().add(withdrawPenny);
		
		JButton depositNickel = new JButton("Deposit nickel");
		depositNickel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositNickel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.deposit(0.05);
				update();
			}
		});
		frame.getContentPane().add(depositNickel);
		
		JButton withdrawNickel = new JButton("Withdraw nickel");
		withdrawNickel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawNickel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.withdraw(0, 1, 0, 0);
				update();
			}
		});
		frame.getContentPane().add(withdrawNickel);
		
		JButton depositDime = new JButton("Deposit dime");
		depositDime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositDime.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.deposit(0.10);
				update();
			}
		});
		frame.getContentPane().add(depositDime);
		
		JButton withdrawDime = new JButton("Withdraw dime");
		withdrawDime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawDime.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.withdraw(0, 0, 1, 0);
				update();
			}
		});
		frame.getContentPane().add(withdrawDime);
		
		JButton depositQuarter = new JButton("Deposit quarter");
		depositQuarter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositQuarter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.deposit(0.25);
				update();
			}
		});
		frame.getContentPane().add(depositQuarter);
		
		JButton withdrawQuarter = new JButton("Withdraw quarter");
		withdrawQuarter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawQuarter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.withdraw(0, 0, 0, 1);
				update();
			}
		});
		frame.getContentPane().add(withdrawQuarter);
		
		JButton depositCustom = new JButton("Deposit custom amount");
		depositCustom.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				double deposit = 0;
				
				try
				{
					deposit = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter value in dollars to deposit:", "Input", JOptionPane.QUESTION_MESSAGE));
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter a number", "Input error", JOptionPane.ERROR_MESSAGE); //Error message
				}
				
				bank.deposit(deposit);
				update();
			}
		});
		depositCustom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(depositCustom);
		
		JButton withdrawCustom = new JButton("Withdraw custom amount");
		withdrawCustom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(withdrawCustom);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void update()
	{
		int[] coins = bank.returnCoins();
		coinOutLabel.setText("Coins in bank: Pennies: " + coins[0] + ", Nickels: " + coins[1] + ", Dimes: " + coins[2] + ", Quarters: " + coins[3]);
		moneyOutLabel.setText("Total balance in bank: $" + bank.returnAmount());
	}
}
