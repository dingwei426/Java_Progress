package Eivonne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class error {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		readFile();
	}

	public static void readFile() throws FileNotFoundException
	{

		//ArrayList<Customer> customer = customer = new ArrayList<Customer>();

		ArrayList<String> artworkPurchases = new ArrayList<String>();
		File customerFile = new File("Customer.txt");
		Scanner scan = new Scanner(customerFile);
		String customerDetails;
		String readName;
		String readDOB;
		String readContactNum;
		String readArtist;
		String readArtworkPurchase;		
		
		while (scan.hasNextLine())
		{
			customerDetails = scan.next();
			scan.useDelimiter(",");
			Scanner a = new Scanner(customerDetails);
			while(a.hasNext())
			{
				readName = a.next();
				readDOB = a.next();
				readContactNum = a.next();
				readArtist = a.next();
				//readArtworkPurchase = a.next();
				//customer.add(new Customer(readName,readDOB,readContactNum,readArtist,artworkPurchases));
			}
			
			/*
			readName = scan.nextLine().trim();
			readDOB =scan.nextLine().trim();
			readContactNum =scan.nextLine().trim();
			readArtist = scan.nextLine().trim();
			readArtworkPurchase = scan.nextLine().trim();
			artworkPurchases.add(readArtworkPurchase);
			customer.add(new Customer(readName,readDOB,readContactNum,readArtist,artworkPurchases));
			*/
		}

		/*
		while(scan.hasNext())
		{
			readArtworkPurchase = scan.next().trim();
			artworkPurchases.add(readArtworkPurchase);
		}
		customer.add(count, new Customer(readName,readDOB,readContactNum,readArtist,artworkPurchases));
		count++;
		*/
		
		
		/*
		for (int i  = 0; i < count; i++)
		{
			System.out.println(customer.get(i).getName() + customer.get(i).getDob() + customer.get(i).getContactNum() + customer.get(i).getArtistPreference() + customer.get(i).getArtistPreference());
		}
		*/
		//System.out.println(readName + readName + readDOB + readContactNum + readArtist + readArtworkPurchase);
		//System.out.println(customer.get(0).getName()+ customer.get(0).getContactNum()+ customer.get(0).getArtworkPurchases()+customer.get(0).getArtistPreference());
		//System.out.println(customer.size());
	}
}
