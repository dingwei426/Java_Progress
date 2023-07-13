package Eivonne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Replace {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Customer> customer = customer = new ArrayList<Customer>();
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
		
		for (int i = 0; i < customer.size(); i++)
		{
			System.out.println(customer.get(i).getName()+ customer.get(i).getContactNum()+ customer.get(i).getArtworkPurchases()+customer.get(i).getArtistPreference());
		}
	}

}
