package PA;

import java.util.*;
public class TestingClass {

	public static void main(String[] args) {

		//Create member objects and arraylist and store the objects in the arraylist
		ArrayList<Member> members = new ArrayList<Member>();
		members.add(new PlatinumMember("Peter Lai", "P1901", 220));
		members.add(new SilverMember("Jimmy Lim", "S1625", 3000, 50));
		members.add(new PlatinumMember("Mary Kuok", "P1815", 220));
		members.add(new SilverMember("John Hau", "S1318", 3000, 99));
		members.add(new SilverMember("Jay Chow", "S1709", 3000, 250));
		
		Scanner input = new Scanner(System.in);
		
		int choice;
		
		//menu-driven repeating until exit is opted
		do {
			System.out.print("1. Display member list\n"
					+ "2. Display details of member with highest fee per visit charges\n"
					+ "3. Display details of member with lowest fee per visit charges\n"
					+ "4. Display average fee per visit charges of all customers\n"
					+ "5. Display member's name based on a given member ID\n"
					+ "6. Exit\n"
					+ "Please enter your option: ");
			choice = input.nextInt();
			
			switch (choice) 
			{
			case 1: displayList(members);
					break;
			case 2: displayHighest(members);
					break;
			case 3: displayLowest(members);
					break;
			case 4: displayAverageFee(members);
					break;
			case 5: search(members);
					break;
			case 6: System.out.println("\n\tExit successfully.");
					break;
			default: System.out.println("\n\tINVALID CHOICE ENTERED. PLEASE TRY AGAIN.\n");
			}	
		} while (choice != 6);
		
		
	}
	
	//Display member list
	public static void displayList(ArrayList<Member> members)
	{
		System.out.print("\n*********************************************");
		System.out.println("\n\t\tMEMBER LIST");
		System.out.print("*********************************************");

		for (int i = 0; i < members.size(); i++)
		{
			System.out.println("\n" + (i+1) + ".\t" + members.get(i).toString());
		}
		System.out.println();
	}
	
	//display member's details of the highest fee per visit
	public static void displayHighest(ArrayList<Member> members)
	{
		double maxFeePerVisit = members.get(0).feePerVisit();
		int listNumber = 0;

		for (int i = 1; i < members.size(); i++)
		{
			if (maxFeePerVisit < members.get(i).feePerVisit())
			{
				maxFeePerVisit = members.get(i).feePerVisit();
				listNumber = i;
			}
		}
		
		System.out.println("\nDETAILS OF THE MEMBER WITH HIGHEST FEE PER VISIT");
		System.out.println(members.get(listNumber).toString() + "\n");
	}
	
	//display member's details of the lowest fee per visit
	public static void displayLowest(ArrayList<Member> members)
	{
		double minFeePerVisit = members.get(0).feePerVisit();
		int listNumber = 0;
		
		for (int i = 1; i < members.size(); i++)
		{
			if (minFeePerVisit > members.get(i).feePerVisit())
			{
				minFeePerVisit = members.get(i).feePerVisit();
				listNumber = i;
			}
		}
		
		System.out.println("\nDETAILS OF THE MEMBER WITH LOWEST FEE PER VISIT");
		System.out.println(members.get(listNumber).toString() + "\n");
	}
	
	//display average fee per visit of all member
	public static void displayAverageFee(ArrayList<Member> members)
	{
		double total = 0;
		
		for (int i = 0; i < members.size(); i++)
		{
			total += members.get(i).feePerVisit();
		}
		
		System.out.printf("\n\tThe average fee per visit charges of all members is %.2f\n\n", total/members.size());
	}
	
	//search member's name based on member ID
	public static void search(ArrayList<Member> members)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter member ID: ");
		String memberID = input.next();
		
		int listNumber = -1;
		
		for (int i = 0; i < members.size(); i++)
		{
			if (members.get(i).getMemberID().equals(memberID))
			{
				listNumber = i;
				break;
			}
		}
		
		if (listNumber == -1)
			System.out.println("\n\tThe member ID given is invalid.\n");
		else
			System.out.println("\n\tThe member's name for member ID " + memberID + " is " + members.get(listNumber).getName() + ".\n");
	}
}



