package Move;

/*

Program: Challenge.java          Last Date of this Revision: November 19, 2024

Purpose: Moves the Phidget rover in a square pattern, and reverses direction if it runs into an obstacle

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

//Add Phidgets Library
import com.phidget22.*;

public class Challenge 
{
	public static void main(String[] args) throws Exception 
	{
		//Server
		Net.addServer("", "192.168.100.1", 5661, "", 0);
		
		//Define 
		DCMotor leftMotors = new DCMotor();
		DCMotor rightMotors = new DCMotor();
	    DistanceSensor sonar = new DistanceSensor();
		
		//Address 
		leftMotors.setHubPort(5);
		leftMotors.setChannel(0);
		rightMotors.setHubPort(5);
		rightMotors.setChannel(1);
		sonar.setHubPort(3);
		
		//Open 
		leftMotors.open(1000);
		rightMotors.open(1000);
		sonar.open(1000);
		
		//Immediately set acceleration to maximum
		leftMotors.setAcceleration(leftMotors.getMaxAcceleration());
        rightMotors.setAcceleration(rightMotors.getMaxAcceleration());
		
		int i = 0; //Variable to tell how long the rover has been driving
		final int GOAL = 10; //Goal for how long it should drive (10 cycles, or 1000ms/1s)
		int turnDirection = 1; //Direction to turn (1 or -1, which is used to multiply the velocity of each motor)
		
		while (true) //Infinite loop
		{
            if (sonar.getDistance() < 150) //If the rover detects an obstacle
            {
            	//Turn around
                leftMotors.setTargetVelocity(0.5);
                rightMotors.setTargetVelocity(-0.5);
                Thread.sleep(1200);
                //Reverse turn direction (so it maintains the same path)
                turnDirection *= -1;
                //Set the new i to however much was left - reversing the start and end
                i = GOAL - i;
            }
            else //If it does not detect an object
            {
            	leftMotors.setTargetVelocity(-0.25); //Continue driving forwards
                rightMotors.setTargetVelocity(-0.25);
            }
            
            i++; //Increase i
            Thread.sleep(100); //Wait 100ms
            
            if (i == GOAL) //If it has driven long enough to reach the goal
            {
            	i = 0; //Reset i
            	//Turn 90 degrees (direction depends on turnDirection variable)
            	leftMotors.setTargetVelocity(0.5*turnDirection);
                rightMotors.setTargetVelocity(-0.5*turnDirection);
                Thread.sleep(625);
                //Restart the loop
            }
        }
	}
}