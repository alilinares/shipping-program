/*
 * CST8116 - Introduction to Computer Programming
 * Section: 451
 * Semester: 21W
 * Professor: Piyush Jangam
 * Student ID: 40630493
 * Student Email: lina0002@algonquinlive.com
 * Project 2
 */
// package project02;

import java.util.Scanner;

public class Package {
	//	INSTANCE VARIABLES
	private double length;
	private double width;
	private double	height;
	private Scanner input = new Scanner(System.in);
	
	// CONSTRUCTORS

	public Package() {
		//calling the 3 parameter constructor and giving default values
		this(1.0,1.0,1.0);
	}
	
    public Package(double length, double width, double height) {
    	//3 parameter constructor instantiating private variables length,width and height
        this.length = length;
        this.width = width;
		this.height = height;
	}
	
	public Package(Package obj) {
		//copy constructor - deep copying an already instantiated Package obj
		this.length = obj.length;
		this.width  = obj.width;
		this.height = obj.height;
	}
	
	
	//METHODS

	public void inputLength() {
		//prompting user to input length and assigning input to obj's private variable - length
		System.out.print("Enter length: ");
		this.length = input.nextDouble();
		
	}
	public void inputWidth() {
		//prompting user to input width and assigning input to obj's private variable - width
		System.out.print("Enter width: ");
		this.width = input.nextDouble();
		
	}
	public void inputHeight() {
		//prompting user to input height and assigning input to obj's private variable - height
		System.out.print("Enter height: ");
		this.height = input.nextDouble();
	
	}
	
	public double calcVolume() {
		//calculate the volume of a Package object
		return this.length * this.width * this.height;
	}
	
	
	public void displayDimensions() {
		//printing out the dimensions of Package object
		System.out.print("dimensions: "+this.length+" X "+this.width+" X "+this.height);
	}
	
}
