package Vehicle;

/*

Program: testClass.java          Last Date of this Revision: November 5, 2024

Purpose: Runs the Vehicle subclasses as demonstration. Again, I know nothing about vehicles so this is effectively gibberish.

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class testClass 
{
	public static void main(String[] args) 
	{
		//Create subclass objects
		Car v1 = new Car(1, 1, 1, 1, 1);
		Truck v2 = new Truck(2, 2, 2, 2, 2);
		Minivan v3 = new Minivan(3, 3, 3, 3, 3);
		
		//Output them
		System.out.println(v1.toString());
		System.out.println();
		System.out.println(v2.toString());
		System.out.println();
		System.out.println(v3.toString());
		System.out.println();
		
		//Switch up some variables
		v1.setCarVariable(4);
		v2.setTruckVariable(5);
		v3.setMinivanVariable(6);
		
		v1.setCargoVolume(3);
		v2.setCargoVolume(2);
		v3.setCargoVolume(1);
		
		//Output them again
		System.out.println(v1.toString());
		System.out.println();
		System.out.println(v2.toString());
		System.out.println();
		System.out.println(v3.toString());
		System.out.println();
		
		//Use the abstract methods
		v1.drive();
		v2.drive();
		v3.drive();
		System.out.println();
		v1.park();
		v2.park();
		v3.park();
	}
}

/*
Screen Dump:

Car has: 
City fuel economy: 1
Highway fuel economy: 1
Seating capacity: 1
Cargo volume: 1
Car variable: 1

Truck has: 
City fuel economy: 2
Highway fuel economy: 2
Seating capacity: 2
Cargo volume: 2
Truck variable: 2

Minivan has: 
City fuel economy: 3
Highway fuel economy: 3
Seating capacity: 3
Cargo volume: 3
Minivan variable: 3

Car has: 
City fuel economy: 1
Highway fuel economy: 1
Seating capacity: 1
Cargo volume: 3
Car variable: 4

Truck has: 
City fuel economy: 2
Highway fuel economy: 2
Seating capacity: 2
Cargo volume: 2
Truck variable: 5

Minivan has: 
City fuel economy: 3
Highway fuel economy: 3
Seating capacity: 3
Cargo volume: 1
Minivan variable: 6

Car is driving
Truck is driving
Minivan is driving

Car is parked
Truck is parked
Minivan is parked
*/