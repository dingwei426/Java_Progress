package Practical;

import java.util.Arrays;
import java.util.List;

public class Q25 {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(1,2,3,4,5,6);
		numList.stream().forEach(x -> printBinaryRep(x));
	}

	public static void printBinaryRep(int num) {
		if(num > 0) {
			printBinaryRep(num / 2);
			System.out.print(num % 2);
		}
		if(num == 0)
			System.out.println();
	}
	
}
