package Move;

/*

Program: RoverMovementSonar.java          Last Date of this Revision: November 19, 2024

Purpose: Moves the Phidget rover forward or backward depending on whether the sonar Phidget detects an obstacle

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

//Add Phidgets Library
import com.phidget22.*;

public class RoverMovementSonar 
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
		
		//Infinite loop
		while (true) 
		{
            if (sonar.getDistance() < 150) //If it is within 15cm/150mm of an object
            {
                leftMotors.setTargetVelocity(0.25); //Back up
                rightMotors.setTargetVelocity(0.25);
            } 
            else //If it is not
            {
                leftMotors.setTargetVelocity(-0.25); //Continue driving forwards
                rightMotors.setTargetVelocity(-0.25);
            }

            Thread.sleep(100); //Wait 100ms then repeat
        }
	}
}