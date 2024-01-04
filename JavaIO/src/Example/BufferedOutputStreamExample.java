package Example;

import java.io.*;

public class BufferedOutputStreamExample {
	public static void main(String args[]) {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream("testout.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			String s = "Welcome to javaTpoint.";
			byte b[] = s.getBytes();
			bout.write(b);
			bout.flush();
			bout.close();
			fout.close();
			System.out.println("success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}