package Example;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {  
    public static void main(String[] args) {  
        try  {  
            InputStream stream = new FileInputStream("output.txt");  
            Reader reader = new InputStreamReader(stream);  
            int data = reader.read();  
            while (data != -1) {  
                System.out.print((char) data);  
                data = reader.read();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  