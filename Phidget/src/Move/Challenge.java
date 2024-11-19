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
		
		leftMotors.setAcceleration(leftMotors.getMaxAcceleration());
        rightMotors.setAcceleration(rightMotors.getMaxAcceleration());
		
		int i = 0;
		int turnDirection = 1;
		
		while (true) 
		{
            if (sonar.getDistance() < 250)
            {
                leftMotors.setTargetVelocity(0.5); //Turn around
                rightMotors.setTargetVelocity(-0.5);
                Thread.sleep(1200);
                turnDirection *= -1;
            }
            else
            {
            	leftMotors.setTargetVelocity(-0.25); //Continue driving forwards
                rightMotors.setTargetVelocity(-0.25);
            }
            
            i++;
            Thread.sleep(100); //Wait 100ms then repeat
            
            if (i == 30)
            {
            	i = 0;
            	leftMotors.setTargetVelocity(0.5*turnDirection); //Turn around
                rightMotors.setTargetVelocity(-0.5*turnDirection);
                Thread.sleep(600);
            }
        }
	}
}