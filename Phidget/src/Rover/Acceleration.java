package Rover;

/*

Program: Acceleration.java          Last Date of this Revision: November 20, 2024

Purpose: Moves the rover with maximum acceleration. This code is taken directly from the tutorial (values modified) because they have no suggested or requested changes, but I still wanted to put it here as this lesson is required. Unique acceleration code can be found in Challenge.java

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

//Add Phidgets Library
import com.phidget22.*;

public class Acceleration 
{
    public static void main(String[] args) throws Exception 
    {
        //Connect to wireless rover
        Net.addServer("", "192.168.100.1", 5661, "", 0);

        //Create
        DCMotor leftMotors = new DCMotor();
        DCMotor rightMotors = new DCMotor();

        //Address
        leftMotors.setHubPort(5);
        leftMotors.setChannel(0);
        rightMotors.setHubPort(5);
        rightMotors.setChannel(1);

        //Open
        leftMotors.open(1000);
        rightMotors.open(1000);

        //Increase acceleration
        leftMotors.setAcceleration(leftMotors.getMaxAcceleration());
        rightMotors.setAcceleration(rightMotors.getMaxAcceleration());

        //Move forward at full speed
        leftMotors.setTargetVelocity(-0.25);
        rightMotors.setTargetVelocity(-0.25);

        //Wait for 1 second
        Thread.sleep(1000);

        //Reverse at full speed
        leftMotors.setTargetVelocity(0.25);
        rightMotors.setTargetVelocity(0.25);

        //Wait for 1 second
        Thread.sleep(1000);

        //Stop motors
        leftMotors.setTargetVelocity(0);
        rightMotors.setTargetVelocity(0);
    }
}
