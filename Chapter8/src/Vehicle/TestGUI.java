package Vehicle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestGUI 
{
	private JFrame frame;
	private JTextPane textPane;
	private JButton driveButton;
	private JButton parkButton;
	private JButton methodButton;
	private Vehicle v;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					TestGUI window = new TestGUI();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public TestGUI()
	{
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		frame.getContentPane().setLayout(new GridLayout(1, 3, 15, 15));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 1, 15, 15));
		
		JButton createCarButton = new JButton("Create car");
		createCarButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int fuelEconomyCity = 0;
				int fuelEconomyHwy = 0;
				int seatingCapacity = 0;
				int cargoVolume = 0;
				int carVariable = 0;
				
				try
				{
					fuelEconomyCity = Integer.parseInt(JOptionPane.showInputDialog("Enter city fuel economy:"));
					fuelEconomyHwy = Integer.parseInt(JOptionPane.showInputDialog("Enter highway fuel economy:"));
					seatingCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter seating capacity:"));
					cargoVolume = Integer.parseInt(JOptionPane.showInputDialog("Enter cargo volume:"));
					carVariable = Integer.parseInt(JOptionPane.showInputDialog("Enter car variable:"));
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Invalid input", "Input error", JOptionPane.ERROR_MESSAGE);
				}
				
				v = new Car(fuelEconomyCity, fuelEconomyHwy, seatingCapacity, cargoVolume, carVariable);
				
				textPane.setText(v.toString());
				driveButton.setEnabled(true);
				parkButton.setEnabled(true);
				methodButton.setEnabled(true);
			}
		});
		panel.add(createCarButton);
		
		JButton createTruckButton = new JButton("Create truck");
		createTruckButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int fuelEconomyCity = 0;
				int fuelEconomyHwy = 0;
				int seatingCapacity = 0;
				int cargoVolume = 0;
				int truckVariable = 0;
				
				try
				{
					fuelEconomyCity = Integer.parseInt(JOptionPane.showInputDialog("Enter city fuel economy:"));
					fuelEconomyHwy = Integer.parseInt(JOptionPane.showInputDialog("Enter highway fuel economy:"));
					seatingCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter seating capacity:"));
					cargoVolume = Integer.parseInt(JOptionPane.showInputDialog("Enter cargo volume:"));
					truckVariable = Integer.parseInt(JOptionPane.showInputDialog("Enter truck variable:"));
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Invalid input", "Input error", JOptionPane.ERROR_MESSAGE);
				}
				
				v = new Truck(fuelEconomyCity, fuelEconomyHwy, seatingCapacity, cargoVolume, truckVariable);
				
				textPane.setText(v.toString());
				driveButton.setEnabled(true);
				parkButton.setEnabled(true);
				methodButton.setEnabled(true);
			}
		});
		panel.add(createTruckButton);
		
		JButton createMinivanButton = new JButton("Create minivan");
		createMinivanButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int fuelEconomyCity = 0;
				int fuelEconomyHwy = 0;
				int seatingCapacity = 0;
				int cargoVolume = 0;
				int minivanVariable = 0;
				
				try
				{
					fuelEconomyCity = Integer.parseInt(JOptionPane.showInputDialog("Enter city fuel economy:"));
					fuelEconomyHwy = Integer.parseInt(JOptionPane.showInputDialog("Enter highway fuel economy:"));
					seatingCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter seating capacity:"));
					cargoVolume = Integer.parseInt(JOptionPane.showInputDialog("Enter cargo volume:"));
					minivanVariable = Integer.parseInt(JOptionPane.showInputDialog("Enter minivan variable:"));
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Invalid input", "Input error", JOptionPane.ERROR_MESSAGE);
				}
				
				v = new Minivan(fuelEconomyCity, fuelEconomyHwy, seatingCapacity, cargoVolume, minivanVariable);
				
				textPane.setText(v.toString());
				driveButton.setEnabled(true);
				parkButton.setEnabled(true);
				methodButton.setEnabled(true);
			}
		});
		panel.add(createMinivanButton);
		
		textPane = new JTextPane();
		frame.getContentPane().add(textPane);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 15, 15));
		
		driveButton = new JButton("Drive");
		driveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				v.drive();
			}
		});
		driveButton.setEnabled(false);
		panel_1.add(driveButton);
		
		parkButton = new JButton("Park");
		parkButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				v.park();
			}
		});
		parkButton.setEnabled(false);
		panel_1.add(parkButton);
		
		methodButton = new JButton("Vehicle specific method");
		methodButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (v.getClass() == new Car(0, 0, 0, 0, 0).getClass())
				{
					((Car) v).carMethod();
				}
				else if (v.getClass() == new Truck(0, 0, 0, 0, 0).getClass())
				{
					((Truck) v).truckMethod();
				}
				else if (v.getClass() == new Minivan(0, 0, 0, 0, 0).getClass())
				{
					((Minivan) v).minivanMethod();
				}
			}
		});
		methodButton.setEnabled(false);
		panel_1.add(methodButton);
	}
}