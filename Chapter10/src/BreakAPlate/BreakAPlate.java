package BreakAPlate;

//Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*

Program: BreakAPlate.java          Last Date of this Revision: September 12, 2024

Purpose: Game that generates 3 random numbers. If the maximum is generated, the player receives the better prize. Otherwise they receive the worse prize. Communicated through images.

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class BreakAPlate 
{
	//GUI definitions
	private JFrame frame;
	private JLabel plates;
	private JButton playButton;
	private JLabel outLabel;
	private JLabel outImageLabel;
	
	//Images
	private ImageIcon platesImage = new ImageIcon(this.getClass().getResource("plates.gif"));
	private ImageIcon lossImage = new ImageIcon(this.getClass().getResource("plates_two_broken.gif"));
	private ImageIcon winImage = new ImageIcon(this.getClass().getResource("plates_all_broken.gif"));
	private ImageIcon placeholderImage = new ImageIcon(this.getClass().getResource("placeholder.gif"));
	private ImageIcon tigerImage = new ImageIcon(this.getClass().getResource("tiger_plush.gif"));
	private ImageIcon stickerImage = new ImageIcon(this.getClass().getResource("sticker.gif"));
	
	//Playable boolean
	private boolean playable = true;

	//Main
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() //Create thread
		{
			public void run() //Run thread
			{
				try 
				{
					BreakAPlate window = new BreakAPlate(); //Create GUI
					window.frame.setVisible(true); //Set visible
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public BreakAPlate() //Constructor
	{
		initialize(); //Create a GUI
	}

	private void initialize() //Create GUI method
	{
		//Frame
		frame = new JFrame("BreakAPlate");
		frame.setBounds(0, 0, 450, 350);
		frame.setLocationRelativeTo(null); //Center on screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Border
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); //Vertical box layout
		
		//Main image of plates
		plates = new JLabel(platesImage); //Use default plates image
		frame.getContentPane().add(plates);
		plates.setAlignmentX(Component.CENTER_ALIGNMENT); //Center on frame
		
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,15))); //Invisible spacer object to make it look nicer and less cramped
		
		//Button to play
		playButton = new JButton("Play!");
		playButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) //When clicked
			{
				if (playable) //If playable
				{
					//Generate the 3 random numbers
					int result = (int) (Math.round(Math.random()) + Math.round(Math.random()) + Math.round(Math.random()));
					
					if (result == 3) //If the maximum is generated
					{
						plates.setIcon(winImage); //Break all plates
						outImageLabel.setIcon(tigerImage); //Show tiger plush
					}
					else //If the maximum is not generated
					{
						plates.setIcon(lossImage); //Break only 2 plates
						outImageLabel.setIcon(stickerImage); //Show sticker
					}
					
					//Change text to ask to play again
					playButton.setText("Play again?");
					playable = false; //Set playable false
				}
				else //If playable is false
				{
					playable = true; //Reset playable and GUI
					plates.setIcon(platesImage);
					outImageLabel.setIcon(placeholderImage);
					playButton.setText("Play!");
				}
			}
		});
		playButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(playButton);
		playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,15))); //Another spacer
		
		//Output label, just says what the image is
		outLabel = new JLabel("Prize:");
		outLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(outLabel);
		outLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Prize image
		outImageLabel = new JLabel(placeholderImage);
		frame.getContentPane().add(outImageLabel);
		outImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
}