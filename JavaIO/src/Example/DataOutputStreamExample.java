package Example;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamExample {
	public static void main(String[] args) {  
        FileOutputStream file;
		try {
			file = new FileOutputStream("testout.txt");
			DataOutputStream data = new DataOutputStream(file);  
			data.writeInt(65);  
			data.flush();  
			data.close();  
			System.out.println("Succcess...");  
		} catch (IOException e) {
			e.printStackTrace();
		}  
    }
}
