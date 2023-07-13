package Eivonne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer extends Person implements InformationHandling{ 
	
	private String contactNum;
	private String artistPreference;
	private ArrayList <String> artworkPurchases;
	private ArrayList<Customer> customer;
	public Customer()
	{
		
	}
	public Customer(String name, String dob,String contactNum,String artistPreference,ArrayList <String> artworkPurchases)
	{
		super(name,dob);
		this.contactNum = contactNum;
		this.artistPreference =artistPreference;
		this.artworkPurchases =artworkPurchases;
		customer = new ArrayList<Customer>();
	}
	
	public ArrayList <Customer> getCustomerList()
	{
		return customer;
	}
	
	public String getContactNum()
	{
		return contactNum;
	}
	
	public String getArtistPreference()
	{
		return artistPreference;
	}
	
	public ArrayList <String> getArtworkPurchases()
	{
		return artworkPurchases;
	}
	
	public void setContactNum(String contactNum)
	{
		this.contactNum = contactNum;
	}
	public void setArtistPreference(String artistPreference)
	{
		this.artistPreference = artistPreference;
	}
	
	public void setArtworkPurchase(ArrayList <String> artworkPurchases)
	{
		this.artworkPurchases = artworkPurchases;
	}

	@Override
	public void viewInfo() {
		System.out.println("\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println("Customer Name\t\t\t\tContact \t\tArtwork Purchases \t\tArtist Preference");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		int num =1 ;
		for(int i =0;i <customer.size();i++)
		{	
			//System.out.printf("%d. %-35s%-12s\t\t\t%-10d\t\t%-35s", num,customer.get(i).getName(), customer.get(i).getContactNum(), customer.get(i).getArtworkPurchases(),customer.get(i).getArtistPreference());
			System.out.println(customer.get(i).getName()+ customer.get(i).getContactNum()+ customer.get(i).getArtworkPurchases()+customer.get(i).getArtistPreference());
			System.out.println();
			num ++;
		}
	}

	@Override
	public void addInfo() {
		ArrayList <String> artwork = new ArrayList<String>();
		boolean exit = false;
		boolean proceed = true;
		Scanner input= new Scanner(System.in);;
		try {
		do {
		System.out.println("Press Enter to Continue...");
		String name = input.nextLine(); //avoid bug
		System.out.println("Please enter the name :");
		name = input.nextLine();
		System.out.println("Please enter the date of birth (DD/MMM/YYYY):");
		String DOB = input.next();
		System.out.println("Please enter the contact information : ");
		String contact = input.next();
		input.nextLine(); //avoid bug
		System.out.println("Please enter the artist preferences : ");
		String artist = input.nextLine();
		while(proceed) 
		{
		System.out.println("Please enter the artwork purchases : ");
		String artworkPurchase = input.nextLine();
		artwork.add(artworkPurchase);
		String answer;
		System.out.println("Have another artwork purchases? (y/n):");
		answer = input.next();
		if(answer.contentEquals("n")|| answer.contentEquals("N"))
			proceed = false;
		}
		Customer addCustomer = new Customer(name, DOB,contact, artist, artwork);
		customer.add(addCustomer);
		System.out.println("Do you wish to continue(y/n) :");
		String continueAdd = input.next();
		if(continueAdd.contentEquals("N")||continueAdd.contentEquals("n"))
		{
			exit = true;
		}
		writeFile();
			}while(!exit);
		
			}catch(InputMismatchException ex) {
				System.out.println("Try again. ("+"Incorrect input)");
				input.nextLine();}
		
		
	}

	@Override
	public void removeInfo() {
		Scanner input = new Scanner(System.in);
		boolean exit = false;
		while(!exit)
		{
		customer.removeAll(customer);
		try {
			readFile();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
			e.printStackTrace();
		}
		int oriSize = customer.size();
		String removeName = input.nextLine();//avoid bug
		System.out.println("Please enter the customer name you wish to remove : ");
		removeName = input.nextLine();
		for (int i =0 ; i < customer.size();i ++)
		{
			if (customer.get(i).getName().equals(removeName))
			{
				customer.remove(i);
			}
		}
		if(oriSize != customer.size())
		{
			System.out.println("Remove successfully !");
			System.out.println("Press Enter to Continue...");
			exit= true;
			
		}
		else
		{
			System.out.println("Customer Not Found !");
			System.out.println("Press Enter to Continue...");
		}
			
			
		}
		writeFile();
		input.close();
		
	}

	@Override
	public void modifyInfo() {
		boolean exit = false;
		Scanner input = new Scanner(System.in);
		int numCustomer;
		do {
		customer.removeAll(customer);
		try {
			readFile();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found !");
			e.printStackTrace();
		}
		String modifyCustomer = input.nextLine(); //avoid bug
		System.out.println("Please enter the customer name to modify the information :");
		modifyCustomer = input.nextLine();
		numCustomer= customer.size();
		for (int i =0; i < customer.size();i ++)
		{
			if((customer.get(i).getName()).contentEquals(modifyCustomer))
				numCustomer =i;
			else
				break;
		}
		if(numCustomer == customer.size())
		{
			System.out.println("Customer Not Found !");
			System.out.println("Press Enter to Continue...");
		}
		}while(numCustomer == customer.size());
		System.out.println("What information do you want to modify?");
		System.out.println("1. Name");
		System.out.println("2. Contact");
		System.out.println("3. Artwork Purchases");
		System.out.println("4. Artist Preference");
		int bChoice = input.nextInt();
		switch (bChoice)
		{
		case 1 :
			String confirm;
			String changedName;
			input.nextLine();//avoid bug
			do {
			System.out.println("Please enter the name:");
			changedName = input.nextLine();
			System.out.println("Please confirm that the name entered is :" + changedName);
			System.out.println("Press any key other than '0' to continue...");
			System.out.println("Press 0 to re-enter the name...");
			confirm = input.next();
			}while(confirm.contentEquals("0"));
			customer.get(numCustomer).setName(changedName);
			writeFile();
			break;
		case 2:
			String changedContact;
			String confirm1;
			do {
			System.out.println("Please enter the new contact:");
			changedContact = input.next();
			System.out.println("Please confirm that the contact number entered is :" + changedContact);
			System.out.println("Press any key other than '0' to continue...");
			System.out.println("Press 0 to re-enter the contact...");
			confirm1 = input.next();
			}while(confirm1.contentEquals("0"));
			customer.get(numCustomer).setContactNum(changedContact);
			writeFile();
			break;
		case 3:
			String changedPurchased;
			String confirm3;
			do {
			System.out.println("Please enter the new artwork purchased amount:");
			changedPurchased = input.next();
			System.out.println("Please confirm that the new artwork purchased amount entered is :" + changedPurchased);
			System.out.println("Press any key other than '0' to continue...");
			System.out.println("Press 0 to re-enter the artwork purchased amount...");
			confirm3 = input.next();
			}while(confirm3.contentEquals("0"));
			customer.get(numCustomer).setContactNum(changedPurchased);
			writeFile();
			break;
		case 4:
			String changedArtist;
			String confirm2;
			do {
			input.nextLine();//avoid bug
			System.out.println("Please enter the new artist preference:");
			changedArtist = input.nextLine();
			System.out.println("Please confirm that the new artist preference entered is :" + changedArtist);
			System.out.println("Press any key other than '0' to continue...");
			System.out.println("Press 0 to re-enter the artist preference...");
			confirm2 = input.next();
			}while(confirm2.contentEquals("0"));
			customer.get(numCustomer).setContactNum(changedArtist);
			writeFile();
			break;
		case 5:
			exit = true;
	}
		System.out.println("Modified successfully !");
		System.out.println("Do you wish to perform any action? (y/n)");
		String answer = input.next();
		if(answer.contentEquals("N")||answer.contentEquals("n"))
			exit = true;
		input.close();	
	}
	public void writeFile()
	{
			try {
				FileWriter customerWriter = new FileWriter("Customer.txt", false);
				for (int i =0 ; i< customer.size();i ++)
				{
					customerWriter.write(customer.get(i).getName() + ","+customer.get(i).getDob() +","+customer.get(i).getContactNum());
				}
				for(int a =0; a <customer.get(a).artworkPurchases.size();a++)
				{
					customerWriter.write(","+customer.get(a).artworkPurchases.get(a));
				}
				customerWriter.close();
			} catch (IOException e) {
				System.out.println("File not found!");
				e.printStackTrace();
			}
		
	}
	
	public void readFile() throws FileNotFoundException
	{
		ArrayList<String> artworkPurchases = new ArrayList<String>();
		
		File customerFile = new File("Customer1.txt");
		Scanner scan = new Scanner(customerFile);
		String[] c = new String[5];
		String readName = "0";
		String readDOB;
		String readContactNum;
		String readArtist;
		String readArtworkPurchase;		
		
		while (scan.hasNext())
		{
			readName = scan.next().replace("_", " ");
			readDOB = scan.next().replace("_", " ");
			readContactNum = scan.next().replace("_", " ");
			readArtist = scan.next().replace("_", " ");
			readArtworkPurchase = scan.next().replace("_", " ");
			
			int count = 1; //assume got record
			for (int i = 0; i < readArtworkPurchase.length(); i++) {
			    if (readArtworkPurchase.charAt(i) == ',') {
			        count++;
			    }
			}
			
			String[] artworkPurchaseArr = readArtworkPurchase.split(",", count);
			for (int i = 0; i < count; i++)
			{
				artworkPurchases.add(artworkPurchaseArr[i]);
			}
			customer.add(new Customer(readName,readDOB,readContactNum,readArtist,artworkPurchases));
		}

		scan.close();
	}
	
	public void showMenu()
	{
		System.out.println("\t\t__________________________________________");
		System.out.println("\t\t|                                        |");
		System.out.println("\t\t|                                        |");
		System.out.println("\t\t|             Customer List              |");
		System.out.println("\t\t|                                        |");
		System.out.println("\t\t|________________________________________|");
		for(int i =0; i < 5; i ++)
			System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("\t\t 1.View Customer");
		System.out.println("\t\t 2.Add Customer");
		System.out.println("\t\t 3.Remove Customer");
		System.out.println("\t\t 4.Modify Customer Information");
		System.out.println("\t\t 5.Exit to Main Menu");
		System.out.println("----------------------------------------------------------------------------------------------");
	}
	
}
