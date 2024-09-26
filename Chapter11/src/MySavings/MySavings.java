package MySavings;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MySavings 
{
	private JFrame frame;
	private JLabel coinOutLabel;
	private JLabel moneyOutLabel;
	
	private PiggyBank bank = new PiggyBank();

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
		frame.setBounds(100, 100, 800, 300);
		frame.setLocationRelativeTo(null); //Center on screen
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.getContentPane().setLayout(new GridLayout(0, 2, 15, 15)); //2 column, indefinite row grid
		
		JPanel coinOutput = new JPanel();
		frame.getContentPane().add(coinOutput);
		
		coinOutLabel = new JLabel("Coins in bank: 0 quarters, 0 dimes, 0 nickels, 0 pennies");
		coinOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		coinOutput.add(coinOutLabel);
		
		JPanel moneyOutput = new JPanel();
		frame.getContentPane().add(moneyOutput);
		
		moneyOutLabel = new JLabel("Total balance in bank: $0");
		moneyOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyOutput.add(moneyOutLabel);
		
		JButton depositPenny = new JButton("Deposit penny");
		depositPenny.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bank.deposit(0.01);
				update();
			}
		});
		frame.getContentPane().add(depositPenny);
		
		JButton withdrawPenny = new JButton("Withdraw penny");
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
		frame.getContentPane().add(depositCustom);
		
		JButton withdrawCustom = new JButton("Withdraw custom amount");
		frame.getContentPane().add(withdrawCustom);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void update()
	{
		coinOutLabel.setText("Coins in bank: " + bank.returnCoins());
		moneyOutLabel.setText("Total balance in bank: $" + bank.returnAmount());
	}
}
