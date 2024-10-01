package MySavings;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*

Program: MySavings.java          Last Date of this Revision: October 1, 2024

Purpose: Provides GUI for PiggyBank.java

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class MySavings 
{
	//Declare necessary GUI elements as instance variables
	private JFrame frame;
	private JLabel coinOutLabel;
	private JLabel moneyOutLabel;
	private JTextField filePathField;
	
	//Declare PiggyBank object
	private PiggyBank bank;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() //Create thread
		{
			public void run() //Run method
			{
				try //Catch exceptions (windowbuilder code)
				{
					MySavings window = new MySavings(); //Create a GUI object
					window.frame.setVisible(true); //Set it visible
				} 
				catch (Exception e) //Catch any exceptions and print the error
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MySavings() //Constructor
	{
		bank = new PiggyBank(); //Create the new PiggyBank object
		initialize(); //Run initialize method
	}

	/*
	 * Initializes the GUI for the MySavings class
	 */
	private void initialize() //WindowBuilder initialize method
	{
		//Frame
		frame = new JFrame("MySavings");
		frame.setBounds(100, 100, 800, 500);
		frame.setLocationRelativeTo(null); //Center on screen
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.getContentPane().setLayout(new GridLayout(0, 2, 15, 15)); //2 column, indefinite row grid
		
		//Panel containing output elements
		JPanel out = new JPanel();
		frame.getContentPane().add(out);
		out.setLayout(new GridLayout(0, 1, 15, 15)); //1 column, indefinite rows
		
		//Coin output label
		coinOutLabel = new JLabel("Coins in bank: 0 quarters, 0 dimes, 0 nickels, 0 pennies"); //Default to empty
		coinOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		out.add(coinOutLabel);
		
		//Money output label
		moneyOutLabel = new JLabel("Total balance in bank: $0.00"); //Default to empty
		moneyOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		out.add(moneyOutLabel);
		
		//Panel containing file path input elements
		JPanel filePathPanel = new JPanel();
		frame.getContentPane().add(filePathPanel);
		filePathPanel.setLayout(new GridLayout(0, 1, 15, 15)); //1 column, indefinite rows
		
		//Label for file path input instructions
		JLabel filePathInstructions = new JLabel("Enter file path of text file to store piggy bank below:");
		filePathInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		filePathPanel.add(filePathInstructions);
		
		//Text field for the file path input
		filePathField = new JTextField();
		filePathField.setText("src//MySavings//bank.txt"); //Default to bank.txt in the same package
		filePathField.setHorizontalAlignment(SwingConstants.CENTER);
		filePathPanel.add(filePathField);
		filePathField.setColumns(10);
		
		//Button to save data to file
		JButton saveToFile = new JButton("Save data to file");
		saveToFile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.write(filePathField.getText()); //Call the write method on the bank object at the given file path (handles its own errors if the path is invalid)
				update(); //Update GUI
			}
		});
		saveToFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(saveToFile);
		
		//Button to load data from file
		JButton loadFile = new JButton("Load data from file");
		loadFile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.read(filePathField.getText()); //Call the read method on the bank object (reads the file and sets all variables to the file's data)
				update(); //Update GUI
			}
		});
		loadFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(loadFile);
		
		//Button to deposit a penny
		JButton depositPenny = new JButton("Deposit penny");
		depositPenny.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositPenny.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.deposit(0.01); //Deposit 1 cent
				update(); //Update GUI
			}
		});
		frame.getContentPane().add(depositPenny);
		
		//Button to withdraw a penny
		JButton withdrawPenny = new JButton("Withdraw penny");
		withdrawPenny.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawPenny.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.withdraw(1, 0, 0, 0); //Withdraw 1 penny
				update(); //Update GUI
			}
		});
		frame.getContentPane().add(withdrawPenny);
		
		//Button to deposit a nickel
		JButton depositNickel = new JButton("Deposit nickel");
		depositNickel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositNickel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.deposit(0.05); //Deposit 5 cents
				update(); //Update GUI
			}
		});
		frame.getContentPane().add(depositNickel);
		
		//Button to withdraw a nickel
		JButton withdrawNickel = new JButton("Withdraw nickel");
		withdrawNickel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawNickel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.withdraw(0, 1, 0, 0); //Withdraw 1 nickel
				update(); //Update GUI
			}
		});
		frame.getContentPane().add(withdrawNickel);
		
		//Button to deposit a dime
		JButton depositDime = new JButton("Deposit dime");
		depositDime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositDime.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.deposit(0.10); //Deposit 10 cents
				update(); //Update GUI
			}
		});
		frame.getContentPane().add(depositDime);
		
		//Button to withdraw a dime
		JButton withdrawDime = new JButton("Withdraw dime");
		withdrawDime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawDime.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.withdraw(0, 0, 1, 0); //Withdraw 1 dime
				update(); //Update GUI
			}
		});
		frame.getContentPane().add(withdrawDime);
		
		//Button to deposit a quarter
		JButton depositQuarter = new JButton("Deposit quarter");
		depositQuarter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositQuarter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.deposit(0.25); //Deposit 25 cents
				update(); //Update GUI
			}
		});
		frame.getContentPane().add(depositQuarter);
		
		//Button to withdraw a quarter
		JButton withdrawQuarter = new JButton("Withdraw quarter");
		withdrawQuarter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawQuarter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.withdraw(0, 0, 0, 1); //Withdraw 1 quarter
				update(); //Update GUI
			}
		});
		frame.getContentPane().add(withdrawQuarter);
		
		//Button to deposit a custom amount of money in largest coins
		JButton depositCustom = new JButton("Deposit custom amount");
		depositCustom.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				double deposit = 0; //Value to deposit
				
				try //Catch exceptions if input is an invalid data type
				{
					//Get input for value in dollars to deposit and turn it into a double
					deposit = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter value in dollars to deposit:", "Input", JOptionPane.QUESTION_MESSAGE));
				}
				catch (Exception e1) //Catch exception
				{
					JOptionPane.showMessageDialog(null, "Please enter a number", "Input error", JOptionPane.ERROR_MESSAGE); //Error message
				}
				
				bank.deposit(deposit); //Deposit inputted value (deposits $0 if input failed)
				update(); //Update GUI
			}
		});
		depositCustom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(depositCustom);
		
		JButton withdrawCustom = new JButton("Withdraw custom amount");
		withdrawCustom.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Variables for number of each coin to withdraw
				int pennies;
				int nickels;
				int dimes;
				int quarters;
				
				try //Catch any invalid data types
				{
					//Get input for number of each type of coin to withdraw
					quarters = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter number of quarters to withdraw:", "Input", JOptionPane.QUESTION_MESSAGE));
					dimes = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter number of dimes to withdraw:", "Input", JOptionPane.QUESTION_MESSAGE));
					nickels = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter number of nickels to withdraw:", "Input", JOptionPane.QUESTION_MESSAGE));
					pennies = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter number of pennies to withdraw:", "Input", JOptionPane.QUESTION_MESSAGE));

					bank.withdraw(pennies, nickels, dimes, quarters); //Withdraw the requested coins (handles its own errors if there are not enough coins)
				}
				catch (Exception e1) //Catch exception
				{
					JOptionPane.showMessageDialog(null, "Please enter a number", "Input error", JOptionPane.ERROR_MESSAGE); //Error message
				}
				
				update(); //Update GUI
			}
		});
		withdrawCustom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(withdrawCustom);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Updates the GUI for the MySavings object
	 */
	private void update()
	{
		int[] coins = bank.returnCoins(); //Get coins in bank as an array (index 0-4, small to large value)
		coinOutLabel.setText("Coins in bank: " + coins[3] + " quarters, " + coins[2] + " dimes, " + coins[1] + " nickels, " + coins[0] + " pennies"); //Set coin output to contain the number of each coin type
		moneyOutLabel.setText("Total balance in bank: $" + bank.returnAmount()); //Set the total balance output to the total value in the bank
	}
}