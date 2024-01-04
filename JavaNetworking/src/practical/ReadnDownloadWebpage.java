package practical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadnDownloadWebpage {

	public static void main(String[] args) {
	      URL url;
		try {
		  url = new URL("http://www.google.com");
	      BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	      BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
	      String line;
	      
	      while ((line = reader.readLine()) != null) {
	         System.out.println(line);
	         writer.write(line);
	         writer.newLine();
	      }
	      reader.close();
	      writer.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	   }
	}
