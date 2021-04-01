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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Shipment {
	//INSTANCE VARIABLES
    private ArrayList <Package> packages; // array holds Package objects
    private LinkedHashMap <String,Double> totalAmounts;  // holds Package object and calculated cost
    private DecimalFormat decimal;
    private NumberFormat currency;
    
    //CONSTRUCTOR- zero parameter
    public Shipment() {
    	//Instantiate new objects of ArrayList,LinkedHashMap, DecimalFormat and NumberFormat
    	this.packages = new ArrayList<Package>();
    	this.totalAmounts = new LinkedHashMap <String,Double>();
    	this.decimal = new DecimalFormat("0.0");
    	this.currency = NumberFormat.getCurrencyInstance();
    }
    
    //METHODS
    
    public void inputPackages() {
    	/* instantiate a new Package Object and pass it to Shipment's inputPackage() method */
    	this.inputPackage(new Package());
    }
    
    public void inputPackage(Package p) {
    	/* instantiate Package Object with values inputed by user and add to packages array */
    	p.inputLength();
    	p.inputWidth();
    	p.inputHeight();
    	packages.add(p);
    }
    
    public void calculateCost() {
    	/* calculate cost for each package obj in packages array and store them with their cost to totalAmounts LinkedHashMap*/
    	double costToShipPack;
    	int numOfPacks = 1;
    	
    	for(Package p: this.packages) {
    		costToShipPack = 3 + (p.calcVolume() - 1);
    		this.totalAmounts.put("Package "+numOfPacks, costToShipPack);
    		numOfPacks++;
    	}
  	
    }
    
    public void display() {
    	/* initiate the Shipment interface program */
    	System.out.println("Welcome to Yousef Linares's Shipping Calculator!\n");

		System.out.println("Enter first package dimensions");
		this.inputPackages();
		
		System.out.println();
		System.out.println("Enter second package dimensions");
		this.inputPackages();
    	
		this.calculateCost();
		
    	System.out.println();
    	System.out.print("First Package ");
    	this.packages.get(0).displayDimensions();
    	System.out.println(", Volume = "+decimal.format(this.packages.get(0).calcVolume()) );
    	
    	System.out.print("Second Package ");
    	this.packages.get(1).displayDimensions();
    	System.out.println(", Volume = "+decimal.format(this.packages.get(1).calcVolume()));
    	
    	// array holds largest costly package and cost as strings
    	String[] largestToCompare = {"Package 1",this.totalAmounts.get("Package 1").toString()}; 
    	
    	//iterate LinkedHashMap, display both package number and cost, and figure out largest costly package obj and store
    	for(String k : this.totalAmounts.keySet()){
    		System.out.println(k + " will cost "+ currency.format(this.totalAmounts.get(k)) +" to ship.");
    		
    		if(this.totalAmounts.get(k) > Double.parseDouble(largestToCompare[1]) ) {
    			largestToCompare[0] = k;
    			largestToCompare[1] = this.totalAmounts.get(k).toString();
    		}
    		
    	}
    	
    	String packageX; //largest valued package string representation
    	String packageY; // smallest valued package string representation
    	double largeValue = Double.parseDouble(largestToCompare[1]); //largest costly package value as double
    	double smallValue; //smallest costly package value
    	
    	//grab largest costly package string name and store appropriate string representation for packageX or packageY
    	if(largestToCompare[0].equals("Package 1")){
    		packageX = "first package";
    		packageY = "second package";
    		smallValue = this.totalAmounts.get("Package 2"); 
    	}else {
    		packageX = "second package";
    		packageY = "first package";
    		smallValue = this.totalAmounts.get("Package 1");
    	}
    	
    	//figure out how many times larger, the largest costly package object is to smallest costly package object
    	if(largeValue == smallValue) {
    	    System.out.println("The first package is the same cost as the second package.");
    	}else if(largeValue < smallValue * 2) {
    		System.out.println("The "+packageX+" is slighty more than the "+packageY+".");
    	}else if(largeValue < smallValue * 3) {
    		System.out.println("The "+packageX+" is twice the "+packageY+".");
    	}else if(largeValue < smallValue * 4) {
    		System.out.println("The "+packageX+" is triple the "+packageY+".");
    	}else if(largeValue < smallValue * 5) {
    		System.out.println("The "+packageX+" is quadruple the "+packageY+".");
    	}else {
    		System.out.println("The "+packageX+" is "+ decimal.format((largeValue / smallValue)) +" times the "+packageY+".");
    	}  	
    	
    }
    
}
