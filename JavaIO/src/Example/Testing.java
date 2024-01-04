package Example;

import java.io.IOException;

public class Testing {
	public static void main(String[] args) {
		int i;
		try {
			i = System.in.read();
			System.out.println(i);// will print the character
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// returns ASCII code of 1st character
	}
}
