package Eivonne;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReader {
	public static void main(String[] args) throws IOException
	{
		// implements buffered reading from a character stream
	    BufferedReader in = new BufferedReader(
	                        // implements reading character files
	                        new FileReader("books.txt"));
	    // read the next line of the file
	    String line = in.readLine();

	    // parse the line into its columns
	    String[] columns = line.split("\t");
	    String code = columns[0];
	    String description = columns[1];
	    String price = columns[2];

	    // create a book object from the data in the columns
	    Book p = new Book(
	        code, description, Double.parseDouble(price));

	    // print the Book object
	    System.out.println(p);

	    // close the input stream
	    in.close();
	}
}
