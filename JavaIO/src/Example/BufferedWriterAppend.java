package Example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferedWriterAppend {

	public static void main(String[] args) {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream("testout.txt", true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));	
			bw.write("A");
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileInputStream fin;
		try {
			fin = new FileInputStream("testout.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fin));
			int i = br.read();
			while(i != -1) {
				System.out.print((char)i);
				i = br.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
