package Practical;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q4 {
	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(1,2,3,4,5,6);
		
		List<Integer> oddNums = numList.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
		System.out.println("Odd Numbers: " + oddNums.toString());
		
		List<Integer> evenNums = numList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println("Even Numbers: " + evenNums.toString());
	}
}