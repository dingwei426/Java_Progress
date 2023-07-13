package Eivonne;

import java.io.IOException;
import java.util.Scanner;

public class TestingClass {

	public static void main(String [] args) throws IOException
	{
		Scanner input= new Scanner(System.in); ;
		Customer customer = new Customer();
		Artist artist = new Artist();
		Artwork artwork = new Artwork();
		boolean exit = false;
		boolean exit1 =false;
		do {
			System.out.println("\t\t__________________________________________");
			System.out.println("\t\t|                                        |");
			System.out.println("\t\t|                                        |");
			System.out.println("\t\t|      UX Gallery Management System      |");
			System.out.println("\t\t|                                        |");
			System.out.println("\t\t|________________________________________|");
			System.out.print("\t\t Username :");
			String username = input.nextLine();
			System.out.print("\t\t Password :");
			String password = input.next();
			
			if ( username.equals("Ali") && password.equals("abcd"))
			{
				do {
				for(int i =0; i < 17; i ++)//clear screen
					System.out.println();//clear screen
					System.out.println("\t\t__________________________________________");
					System.out.println("\t\t|                                        |");
					System.out.println("\t\t|                                        |");
					System.out.println("\t\t|      UX Gallery Management System      |");
					System.out.println("\t\t|                                        |");
					System.out.println("\t\t|________________________________________|");
					for(int i =0; i < 5; i ++)
						System.out.println();
					customer.readFile();
					System.out.println("----------------------------------------------------------------------------------------------");
					System.out.println("\t\t 1.Customer list");
					System.out.println("\t\t 2.Artist list");
					System.out.println("\t\t 3.Artwork information");
					System.out.println("\t\t 4.Exit");
					System.out.println("----------------------------------------------------------------------------------------------");
					int choice;
					choice = input.nextInt();
					switch(choice)
					{
					case 1 :
						for(int i =0; i < 17; i ++)//clear screen
						System.out.println();//clear screen
						customer.showMenu();
						int aChoice = input.nextInt();
						switch(aChoice)
						{
						case 1:
							customer.viewInfo();
							break;
							
						case 2:
								customer.addInfo();
								break;
						case 3:
							customer.removeInfo();
							break;
						case 4:
							customer.modifyInfo();
							break;
						}
						break;
						
					case 4:
						System.out.print("Press Enter to continue...");
						exit1 =true;
						exit = true;	
						break;
					}
					input.nextLine();
					}while(!exit1);
					
			}
			else
			{
				System.out.println("Incorrect Username or Password!");
				input.nextLine();
				//clearscreen
			}
		}while(!exit);
	}
}
						

