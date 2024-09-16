package LocalBank;

import java.awt.EventQueue.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		addAccount = new JButton("Add Account");
		addAccount.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		addAccount.setToolTipText("Create a new account");
		addAccount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftBar.add(addAccount);
		
		viewAccount = new JButton("View Account");
		viewAccount.setEnabled(false);
		viewAccount.setToolTipText("Load an existing account");
		viewAccount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftBar.add(viewAccount);
		
		accountWindow = new JPanel();
		splitPane.setRightComponent(accountWindow);
		accountWindow.setLayout(new GridLayout(6, 1, 15, 15));
		
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
		depositButton.setEnabled(false);
		depositButton.setToolTipText("Deposit money into the selected account");
		depositButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		accountWindow.add(depositButton);
		
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setToolTipText("Withdraw money from the selected account");
		withdrawButton.setEnabled(false);
		withdrawButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		accountWindow.add(withdrawButton);
		
		deleteButton = new JButton("Delete account");
		deleteButton.setToolTipText("Delete the selected account (this cannot be undone)");
		deleteButton.setEnabled(false);
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		accountWindow.add(deleteButton);
	}
	
	private void update()
	{
		if (bank.getAccountTotal() > 0)
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
			balanceLabel.setText("Current balance: " + selectedAccount.getBalance());
			
			depositButton.setEnabled(true);
			withdrawButton.setEnabled(true);
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
			deleteButton.setEnabled(false);
		}
	}
}
