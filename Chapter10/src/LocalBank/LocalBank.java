package LocalBank;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LocalBank 
{
	private Bank bank = new Bank();
	private Account selectedAccount = null;
	
	private JFrame frame;
	private JSplitPane splitPane;
	private JPanel leftBar;
	private JLabel title;
	private JButton addAccount;
	private JButton viewAccount;
	private JPanel accountWindow;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel balanceLabel;
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton deleteButton;
	
	private JPanel inputPanel;
	private JTextField idInput;
	private JTextField fnInput;
	private JTextField lnInput;
	private JTextField balanceInput;
	private JButton closeButton;

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
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		leftBar = new JPanel();
		splitPane.setLeftComponent(leftBar);
		leftBar.setLayout(new GridLayout(3, 1, 15, 15)); //2x2 grid layout
		
		title = new JLabel("LocalBank");
		title.setFont(new Font("Tahoma", Font.PLAIN, 15));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		leftBar.add(title);
		
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(8, 1, 5, 5));
		idInput = new JTextField();
		fnInput = new JTextField();
		lnInput = new JTextField();
		balanceInput = new JTextField();
		
		inputPanel.add(new JLabel("New account ID:"));
		inputPanel.add(idInput);
		inputPanel.add(new JLabel("Owner first name:"));
		inputPanel.add(fnInput);
		inputPanel.add(new JLabel("Owner last name:"));
		inputPanel.add(lnInput);
		inputPanel.add(new JLabel("Starting account balance:"));
		inputPanel.add(balanceInput);
		
		addAccount = new JButton("Add Account");
		addAccount.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int input = JOptionPane.showConfirmDialog(null, inputPanel, "Account Information", JOptionPane.OK_CANCEL_OPTION);
				if (input == JOptionPane.OK_OPTION) 
				{
					if (idInput.getText().equals("") || fnInput.getText().equals("") || lnInput.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please fill all fields", "Input Error", JOptionPane.ERROR_MESSAGE); //Error message
					}
					else
					{
						try
						{
							if (bank.accounts.get(idInput.getText()) == null)
							{
								bank.addAccount(idInput.getText(), Double.parseDouble(balanceInput.getText()), fnInput.getText(), lnInput.getText());
								idInput.setText(null);
								fnInput.setText(null);
								lnInput.setText(null);
								balanceInput.setText(null);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Account with this ID already exists", "Duplicate Error", JOptionPane.ERROR_MESSAGE); //Error message
							}
						}
						catch (Exception invalidBalance)
						{
							JOptionPane.showMessageDialog(null, "Please enter a number for current balance", "Input Error", JOptionPane.ERROR_MESSAGE); //Error message
						}
					}
				}
				update();
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
					selectedAccount = bank.accounts.get(inputValue);
					JOptionPane.showMessageDialog(null, "Account with ID: '" + selectedAccount.id +"' loaded successfully", "Account Loading Successful", JOptionPane.INFORMATION_MESSAGE);
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
		accountWindow.setLayout(new GridLayout(7, 1, 15, 15));
		
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
		
		deleteButton = new JButton("Delete account");
		deleteButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (JOptionPane.showConfirmDialog(null, 
						"Are you sure you want to delete account with ID '" + selectedAccount.id + "'? This can NOT be undone!", "Account Deletion Confirmation", JOptionPane.YES_NO_OPTION)
						== JOptionPane.YES_OPTION)
				{
					bank.deleteAccount(selectedAccount.id); //Includes output
					selectedAccount = null;
					update();
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
			
			balanceLabel.setEnabled(true);
			balanceLabel.setText(selectedAccount.getBalance());
			
			depositButton.setEnabled(true);
			withdrawButton.setEnabled(true);
			closeButton.setEnabled(true);
			deleteButton.setEnabled(true);
		}
		else
		{
			idLabel.setEnabled(false);
			idLabel.setText("Selected account ID: No account selected");
			
			nameLabel.setEnabled(false);
			nameLabel.setText("Account owner name: No account selected");
			
			balanceLabel.setEnabled(false);
			balanceLabel.setText("Current balance: $0.00");
			
			depositButton.setEnabled(false);
			withdrawButton.setEnabled(false);
			closeButton.setEnabled(false);
			deleteButton.setEnabled(false);
		}
	}
}
