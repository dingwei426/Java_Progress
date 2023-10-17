package Practical;

import java.util.Scanner;

public class Exercise2 {
	private static final double METERS_PER_INCHES = 0.0254;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Inch: ");
		double inch = input.nextDouble();
		
		double meters = inch * METERS_PER_INCHES;
		
		System.out.println(inch + " Inch in Meter: " + meters);
	}
}
