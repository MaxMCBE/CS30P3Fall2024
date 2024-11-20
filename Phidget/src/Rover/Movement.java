package Rover;

/*

Program: RoverMovement.java          Last Date of this Revision: November 19, 2024

Purpose: Moves the Phidget rover

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

//Add Phidgets Library
import com.phidget22.*;

public class Movement 
{
	public static void main(String[] args) throws Exception 
	{
		//Server
		Net.addServer("", "192.168.100.1", 5661, "", 0);
		
		//Define motors
		DCMotor leftMotors = new DCMotor();
		DCMotor rightMotors = new DCMotor();
		
		//Address motors
		leftMotors.setHubPort(5);
		leftMotors.setChannel(0);
		rightMotors.setHubPort(5);
		rightMotors.setChannel(1);
		
		//Open motors
		leftMotors.open(5000);
		rightMotors.open(5000);
		
		//Turn in one direction
        leftMotors.setTargetVelocity(1);
        rightMotors.setTargetVelocity(-1);

        //Wait 1 second
        Thread.sleep(1000);

        //Stop motors
        leftMotors.setTargetVelocity(0);
        rightMotors.setTargetVelocity(0);
        
        //Wait 1 second
        Thread.sleep(1000);
        
        //Turn in the other direction
        leftMotors.setTargetVelocity(-1);
        rightMotors.setTargetVelocity(1);

        //Wait 1 second
        Thread.sleep(1000);

        //Stop motors
        leftMotors.setTargetVelocity(0);
        rightMotors.setTargetVelocity(0);
        
        //Wait 1 second
        Thread.sleep(1000);
		
		//Drive forwards (positive velocity goes backwards with this rover)
		leftMotors.setTargetVelocity(-0.5);
		rightMotors.setTargetVelocity(-0.5);
		
		//Wait 2 seconds
		Thread.sleep(2000);
		
		//Stop driving
		leftMotors.setTargetVelocity(0);
		rightMotors.setTargetVelocity(0);
		
		//Close motors
		leftMotors.close();
		rightMotors.close();
	}
}