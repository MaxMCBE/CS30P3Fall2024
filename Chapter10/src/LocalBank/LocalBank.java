package LocalBank;

//Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*

Program: LocalBank.java          Last Date of this Revision: September 17, 2024

Purpose: Creates and manages GUI using Bank.java and Account.java to make a basic bank manager interface as specified in the textbook with modifications to user experience and the addition of PINs

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class LocalBank 
{
	private Bank bank = new Bank(); //Create a bank object
	private Account selectedAccount = null; //Set selected account to null at the beginning
	
	//Define the many GUI elements so that they can be used anywhere in the init function without worrying about what is above what (although I don't believe it should conflict much anyways)
	private JFrame frame;
	
	private JSplitPane splitPane;
	
	//Left bar
	private JPanel leftBar;
	private JLabel title;
	private JButton addAccount;
	private JButton viewAccount;
	
	private JPanel accountWindow;
	//Right bar labels
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel balanceLabel;
	
	//Right bar buttons
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton closeButton;
	private JButton addressButton;
	private JButton pinButton;
	private JButton deleteButton;
	
	//Acccount creation input panel for use with JOptionPane (Breaks windowbuilder, addAccount must be commented out to view the main window in Design view)
	private JPanel inputPanel;
	private JTextField idInput;
	private JTextField pinInput;
	private JTextField fnInput;
	private JTextField lnInput;
	private JTextField streetInput;
	private JTextField cityInput;
	private JTextField provinceInput;
	private JTextField zipInput;
	private JTextField balanceInput;

	//Main
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() //Create thread
		{
			public void run() //Run method
			{
				//The try/catch is default windowbuilder code. I don't 100% understand the purpose, so I apologize if the comments are insufficient
				try //Try to create window
				{
					LocalBank window = new LocalBank(); //Create a LocalBank GUI
					window.frame.setVisible(true); //Set it to be visible (done here instead of constructor/init to stop the unused error on window
				} 
				catch (Exception e) //If interrupted, print error
				{
					e.printStackTrace();
				}
			}
		});
	}

	public LocalBank() //Constructor
	{
		initialize(); //Run initialize method
	}

	//The big method that builds all the GUI (sorry code standards, this is going to be a lot longer than suggested. I assume it's expected with windowbuilder though)
	private void initialize() 
	{
		//Create main frame
		frame = new JFrame("LocalBank");
		frame.setBounds(0, 0, 600, 450); //Dimensions (can be modified easily by dragging the window larger or smaller, but this tends to work from my testing)
		frame.setLocationRelativeTo(null); //Center on screen
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		splitPane = new JSplitPane(); //Create a SplitPane to fill the frame
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		//Left side of the SplitPane
		leftBar = new JPanel();
		splitPane.setLeftComponent(leftBar);
		leftBar.setLayout(new GridLayout(0, 1, 15, 15)); //Grid layout, which functions as a Y box layout with padding here
		
		//Title
		title = new JLabel("LocalBank");
		title.setFont(new Font("Tahoma", Font.PLAIN, 15));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		leftBar.add(title);
		
		//Input panel for account creation (breaks windowbuilder)
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(0, 1, 5, 5)); //Grid layout
		
		//The many input text fields
		idInput = new JTextField();
		pinInput = new JTextField();
		fnInput = new JTextField();
		lnInput = new JTextField();
		streetInput = new JTextField();
		cityInput = new JTextField();
		provinceInput = new JTextField();
		zipInput = new JTextField();
		balanceInput = new JTextField();
		
		//Add all textfields and corresponding labels to the input panel
		inputPanel.add(new JLabel("New account ID:"));
		inputPanel.add(idInput);
		inputPanel.add(new JLabel("Account PIN:"));
		inputPanel.add(pinInput);
		
		inputPanel.add(new JLabel("Owner first name:"));
		inputPanel.add(fnInput);
		inputPanel.add(new JLabel("Owner last name:"));
		inputPanel.add(lnInput);
		
		inputPanel.add(new JLabel("Street:"));
		inputPanel.add(streetInput);
		inputPanel.add(new JLabel("City:"));
		inputPanel.add(cityInput);
		inputPanel.add(new JLabel("Province:"));
		inputPanel.add(provinceInput);
		inputPanel.add(new JLabel("ZIP code:"));
		inputPanel.add(zipInput);
		
		inputPanel.add(new JLabel("Starting account balance:"));
		inputPanel.add(balanceInput);
		
		//Button to create an account (uses inputPanel)
		addAccount = new JButton("Add Account");
		addAccount.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) //On click
			{
				int input = JOptionPane.showConfirmDialog(null, inputPanel, "Account Information", JOptionPane.OK_CANCEL_OPTION); //Show a JOptionPane with the inputPanel as content and yes/no option
				if (input == JOptionPane.OK_OPTION) //If input is submitted
				{
					//This is gross but I'm not sure how to do it better. Just checks if any field is empty EXCEPT the numbers as they'll be checked later when converting to ints
					if (idInput.getText().equals("") || fnInput.getText().equals("") || lnInput.getText().equals("") || streetInput.getText().equals("") || cityInput.getText().equals("") || provinceInput.getText().equals("") || zipInput.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please fill all fields", "Input Error", JOptionPane.ERROR_MESSAGE); //Error message
					}
					else //Assuming everything is nice
					{
						try //Try to do the following (if any parseInts fail or an exception is thrown, catch it)
						{
							if (bank.accounts.get(idInput.getText()) == null) //If there is no account with the requested ID
							{
								if (pinInput.getText().length() == 4 && Integer.parseInt(pinInput.getText()) >= 0) //If the PIN is 4 digits long (and doesn't use a negative to hit 4 characters!)
								{
									bank.addAccount(
											idInput.getText(), Integer.parseInt(pinInput.getText()), 
											fnInput.getText(), lnInput.getText(),
											streetInput.getText(), cityInput.getText(), provinceInput.getText(), zipInput.getText(),
											Double.parseDouble(balanceInput.getText())
											); //Add an account. Used new lines to make the parameters a bit more manageable
									//Reset all the fields, so that if you try to create another account it won't still have all the old data. Doesn't really matter here but it'd be a huge security issue in a real program obviously
									idInput.setText(null);
									pinInput.setText(null);
									fnInput.setText(null);
									lnInput.setText(null);
									streetInput.setText(null);
									cityInput.setText(null);
									provinceInput.setText(null);
									zipInput.setText(null);
									balanceInput.setText(null);
								}
								else //If the PIN is not 4 digits
								{
									throw new Exception(); //Just throw an exception, easier and less repetition than just making a slightly different error message appear
								}
							}
							else //If there is an account with the requested ID
							{
								JOptionPane.showMessageDialog(null, "Account with this ID already exists", "Duplicate Error", JOptionPane.ERROR_MESSAGE); //Error message
								idInput.setText(null); //Reset that field (everything else will be there when reopened so it's less annoying to fix)
							}
						}
						catch (Exception invalidInput) //If any of the numbers are not numbers, or if the PIN is not 4 digits
						{
							JOptionPane.showMessageDialog(null, "Please enter a number for current balance and a 4 digit number for PIN", "Input Error", JOptionPane.ERROR_MESSAGE); //Error message
						}
					}
				}
				//No else- if someone clicks to cancel out of the input window, nothign happens
				update(); //Update GUI
			}
		});
		addAccount.setToolTipText("Create a new account");
		addAccount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftBar.add(addAccount);
		
		viewAccount = new JButton("View Account");
		viewAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String inputValue = JOptionPane.showInputDialog("Enter ID of account to view:");
				
				if (bank.accounts.get(inputValue) != null)
				{
					String pinValue = JOptionPane.showInputDialog("Enter PIN of account with ID '" + inputValue + "':");
					try
					{
						if (bank.accounts.get(inputValue).checkPin(Integer.parseInt(pinValue)))
						{
							selectedAccount = bank.accounts.get(inputValue);
							JOptionPane.showMessageDialog(null, "Account with ID: '" + selectedAccount.id +"' loaded successfully", "Account Loading Successful", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							throw new Exception();
						}
					}
					catch (Exception invalidPIN)
					{
						JOptionPane.showMessageDialog(null, "Invalid PIN", "Credential Error", JOptionPane.ERROR_MESSAGE); //Error message
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Account with ID '" + inputValue + "' does not exist", "Input Error", JOptionPane.ERROR_MESSAGE); //Error message
				}
				
				update();
			}
		});
		viewAccount.setEnabled(false);
		viewAccount.setToolTipText("Load an existing account");
		viewAccount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftBar.add(viewAccount);
		
		accountWindow = new JPanel();
		splitPane.setRightComponent(accountWindow);
		accountWindow.setLayout(new GridLayout(0, 1, 15, 15));
		
		idLabel = new JLabel("Selected account ID: No account selected");
		idLabel.setEnabled(false);
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountWindow.add(idLabel);
		
		nameLabel = new JLabel("Account owner name: No account selected");
		nameLabel.setEnabled(false);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountWindow.add(nameLabel);
		
		addressLabel = new JLabel("Account owner address: No account selected");
		addressLabel.setEnabled(false);
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountWindow.add(addressLabel);
		
		balanceLabel = new JLabel("Current balance: $0.00");
		balanceLabel.setEnabled(false);
		balanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountWindow.add(balanceLabel);
		
		depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					double inputValue = Double.parseDouble(JOptionPane.showInputDialog("How much would you like to deposit?:"));
					
					if (inputValue > 0)
					{
						bank.accounts.get(selectedAccount.id).deposit(inputValue); 
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please enter a number above 0", "Input Error", JOptionPane.ERROR_MESSAGE); //Error message
					}
				}
				catch (Exception notANumber)
				{
					JOptionPane.showMessageDialog(null, "Please enter a number", "Input Error", JOptionPane.ERROR_MESSAGE); //Error message
				}
				
				update();
			}
		});
		depositButton.setEnabled(false);
		depositButton.setToolTipText("Deposit money into the selected account");
		depositButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		accountWindow.add(depositButton);
		
		withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					double inputValue = Double.parseDouble(JOptionPane.showInputDialog("How much would you like to withdraw?:"));
					
					if (inputValue > 0)
					{
						bank.accounts.get(selectedAccount.id).withdraw(inputValue); 
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please enter a number above 0", "Input Error", JOptionPane.ERROR_MESSAGE); //Error message
					}
				}
				catch (Exception notANumber)
				{
					JOptionPane.showMessageDialog(null, "Please enter a number", "Input Error", JOptionPane.ERROR_MESSAGE); //Error message
				}
				
				update();
			}
		});
		withdrawButton.setToolTipText("Withdraw money from the selected account");
		withdrawButton.setEnabled(false);
		withdrawButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		accountWindow.add(withdrawButton);
		
		closeButton = new JButton("Unload account");
		closeButton.setToolTipText("Unload the account and return to home");
		closeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Account with ID: '" + selectedAccount.id +"' unloaded successfully", "Account Unloading Successful", JOptionPane.INFORMATION_MESSAGE);
				selectedAccount = null;
				update();
			}
		});
		closeButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		closeButton.setEnabled(false);
		accountWindow.add(closeButton);
		
		addressButton = new JButton("Change address");
		addressButton.setToolTipText("Change account address");
		addressButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String street = JOptionPane.showInputDialog("Street:");
				String city = JOptionPane.showInputDialog("City:");
				String province = JOptionPane.showInputDialog("Province:");
				String zip = JOptionPane.showInputDialog("ZIP code:");
				
				selectedAccount.changeAddress(street, city, province, zip);
				update();
			}
		});
		addressButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addressButton.setEnabled(false);
		accountWindow.add(addressButton);
		
		pinButton = new JButton("Change PIN");
		pinButton.setToolTipText("Change account PIN");
		pinButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{ 
					int currentPin = Integer.parseInt(JOptionPane.showInputDialog("Confirm current PIN:"));
					if (selectedAccount.checkPin(currentPin))
					{
						int newPin = Integer.parseInt(JOptionPane.showInputDialog("Enter new PIN:"));
						selectedAccount.changePin(currentPin, newPin);
					}
					else
					{
						throw new Exception();
					}
				}
				catch (Exception invalidPIN)
				{
					JOptionPane.showMessageDialog(null, "Invalid PIN", "Credential Error", JOptionPane.ERROR_MESSAGE); //Error message
				}
			}
		});
		pinButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pinButton.setEnabled(false);
		accountWindow.add(pinButton);
		
		deleteButton = new JButton("Delete account");
		deleteButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (JOptionPane.showConfirmDialog(null, 
						"Are you sure you want to delete account with ID '" + selectedAccount.id + "'? This can NOT be undone!", "Account Deletion Confirmation", JOptionPane.YES_NO_OPTION)
						== JOptionPane.YES_OPTION)
				{
					try
					{
						int pin = Integer.parseInt(JOptionPane.showInputDialog("Confirm PIN:"));
						if (selectedAccount.checkPin(pin))
						{
							bank.deleteAccount(selectedAccount.id); //Includes output
							selectedAccount = null;
							update();
						}
						else
						{
							throw new Exception();
						}
					}
					catch (Exception invalidPIN)
					{
						JOptionPane.showMessageDialog(null, "Invalid PIN", "Credential Error", JOptionPane.ERROR_MESSAGE); //Error message
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Account with ID: '" + selectedAccount.id +"' deletion cancelled", "Account Deletion Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		deleteButton.setToolTipText("Delete the selected account (this cannot be undone)");
		deleteButton.setEnabled(false);
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		accountWindow.add(deleteButton);
	}
	
	private void update()
	{
		if (bank.accounts.size() > 0)
		{
			viewAccount.setEnabled(true);
		}
		else
		{
			viewAccount.setEnabled(false);
		}
		
		if (selectedAccount != null)
		{
			idLabel.setEnabled(true);
			idLabel.setText("Selected account ID: " + selectedAccount.id);
			
			nameLabel.setEnabled(true);
			nameLabel.setText("Account owner name: " + selectedAccount.getName());
			
			addressLabel.setEnabled(true);
			addressLabel.setText("Account owner address: " + selectedAccount.getAddress());
			
			balanceLabel.setEnabled(true);
			balanceLabel.setText(selectedAccount.getBalance());
			
			depositButton.setEnabled(true);
			withdrawButton.setEnabled(true);
			closeButton.setEnabled(true);
			addressButton.setEnabled(true);
			pinButton.setEnabled(true);
			deleteButton.setEnabled(true);
		}
		else
		{
			idLabel.setEnabled(false);
			idLabel.setText("Selected account ID: No account selected");
			
			nameLabel.setEnabled(false);
			nameLabel.setText("Account owner name: No account selected");
			
			addressLabel.setEnabled(false);
			addressLabel.setText("Account owner address: No account selected");
			
			balanceLabel.setEnabled(false);
			balanceLabel.setText("Current balance: $0.00");
			
			depositButton.setEnabled(false);
			withdrawButton.setEnabled(false);
			closeButton.setEnabled(false);
			addressButton.setEnabled(false);
			pinButton.setEnabled(false);
			deleteButton.setEnabled(false);
		}
	}
}