package MySavings;

import java.awt.*;
import javax.swing.*;

public class MySavings 
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
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null); //Center on screen
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.getContentPane().setLayout(new GridLayout(0, 2, 15, 15)); //2 column, indefinite row grid
		
		JPanel coinOutput = new JPanel();
		frame.getContentPane().add(coinOutput);
		
		JPanel moneyOutput = new JPanel();
		frame.getContentPane().add(moneyOutput);
		
		JButton depositPenny = new JButton("Deposit penny");
		frame.getContentPane().add(depositPenny);
		
		JButton withdrawPenny = new JButton("Withdraw penny");
		frame.getContentPane().add(withdrawPenny);
		
		JButton depositNickel = new JButton("Deposit nickel");
		frame.getContentPane().add(depositNickel);
		
		JButton withdrawNickel = new JButton("Withdraw nickel");
		frame.getContentPane().add(withdrawNickel);
		
		JButton depositDime = new JButton("Deposit dime");
		frame.getContentPane().add(depositDime);
		
		JButton withdrawDime = new JButton("Withdraw dime");
		frame.getContentPane().add(withdrawDime);
		
		JButton depositQuarter = new JButton("Deposit quarter");
		frame.getContentPane().add(depositQuarter);
		
		JButton withdrawQuarter = new JButton("Withdraw quarter");
		frame.getContentPane().add(withdrawQuarter);
		
		JButton depositCustom = new JButton("Deposit custom amount");
		frame.getContentPane().add(depositCustom);
		
		JButton withdrawCustom = new JButton("Withdraw custom amount");
		frame.getContentPane().add(withdrawCustom);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
