package Example;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterExample {  
    public static void main(String[] args) {  
  
        try {  
            OutputStream outputStream = new FileOutputStream("output.txt");  
            Writer outputStreamWriter = new OutputStreamWriter(outputStream);  
  
            outputStreamWriter.write("Hello World");  
  
            outputStreamWriter.close();  
        } catch (Exception e) {  
            e.getMessage();  
        }  
    }  
}  