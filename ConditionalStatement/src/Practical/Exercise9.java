package Practical;

import java.util.Scanner;

public class Exercise9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input a value for year: ");
		int year = input.nextInt();
		boolean isLeapYear = true;
		
		if(year % 4 != 0) {
			isLeapYear = false;
		}
		else if(year % 4 == 0 && year % 100 == 0 && year % 400 != 0) {
			isLeapYear = false;
		}
		
		System.out.println("Year " + year + " is a leap year: " + isLeapYear);
	}
}

//import java.util.Scanner;
//public class Exercise9 {
//
//    
//  public static void main(String[] args)
//    {
//        Scanner in = new Scanner(System.in);
//
//        System.out.print("Input the year: ");
//        int year = in.nextInt();
//
//        boolean x = (year % 4) == 0;
//        boolean y = (year % 100) != 0;
//        boolean z = ((year % 100 == 0) && (year % 400 == 0));
//
//        if (x && (y || z))
//        {
//            System.out.println(year + " is a leap year");
//        }
//        else
//        {
//            System.out.println(year + " is not a leap year");
//        }
//    }
//}
