package Vehicle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*

Program: TestGUI.java          Last Date of this Revision: November 6, 2024

Purpose: Class that creates GUI to run the vehicle subclasses as demonstration

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class TestGUI 
{
	//Define necessary GUI elements
	private JFrame frame;
	private JTextPane textPane;
	private JButton driveButton;
	private JButton parkButton;
	private JButton methodButton;
	
	//Define vehicle object (becomes an object of a subclass since Vehicle is abstract)
	private Vehicle v;
	
	/*
	 * Regular WindowBuilder main() method
	 */
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
	
	/*
	 * Constructor
	 */
	public TestGUI()
	{
		initialize(); //Run initialize method
	}
	
	/*
	 * Sets up GUI
	 */
	private void initialize() 
	{
		//Main frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); //Center on screen
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Borders
		frame.getContentPane().setLayout(new GridLayout(1, 3, 15, 15)); //Grid layout
		
		//Left bar
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 1, 15, 15)); //Grid layout
		
		//Button to create a car object
		JButton createCarButton = new JButton("Create car");
		createCarButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Variables
				int fuelEconomyCity = 0;
				int fuelEconomyHwy = 0;
				int seatingCapacity = 0;
				int cargoVolume = 0;
				int carVariable = 0;
				
				//Try/catch to get input
				try
				{
					//Get input for all the variables
					fuelEconomyCity = Integer.parseInt(JOptionPane.showInputDialog("Enter city fuel economy:"));
					fuelEconomyHwy = Integer.parseInt(JOptionPane.showInputDialog("Enter highway fuel economy:"));
					seatingCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter seating capacity:"));
					cargoVolume = Integer.parseInt(JOptionPane.showInputDialog("Enter cargo volume:"));
					carVariable = Integer.parseInt(JOptionPane.showInputDialog("Enter car variable:"));
				}
				catch (Exception e1) //If the input is invalid then give an error message
				{
					JOptionPane.showMessageDialog(null, "Invalid input", "Input error", JOptionPane.ERROR_MESSAGE);
				}
				
				//Create the car object
				v = new Car(fuelEconomyCity, fuelEconomyHwy, seatingCapacity, cargoVolume, carVariable);
				
				//Update all the GUI
				textPane.setText(v.toString());
				methodButton.setText("Car method");
				driveButton.setEnabled(true);
				parkButton.setEnabled(true);
				methodButton.setEnabled(true);
			}
		});
		panel.add(createCarButton);
		
		//Repeat for truck instead of car
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
				methodButton.setText("Truck method");
				driveButton.setEnabled(true);
				parkButton.setEnabled(true);
				methodButton.setEnabled(true);
			}
		});
		panel.add(createTruckButton);
		
		//Repeat for minivan instead of car/truck
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
				methodButton.setText("Minivan method");
				driveButton.setEnabled(true);
				parkButton.setEnabled(true);
				methodButton.setEnabled(true);
			}
		});
		panel.add(createMinivanButton);
		
		//Text pane to display object toString()
		textPane = new JTextPane();
		frame.getContentPane().add(textPane);
		
		//Right bar
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 15, 15));
		
		//Button to run object's drive method
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
		
		//Button to run object's park method
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
		
		//Button that runs the corresponding subclass method for the object
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