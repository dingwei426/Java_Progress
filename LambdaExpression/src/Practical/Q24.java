package Practical;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q24 {
	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println("Number List: " + numList.toString());
		
		int primeNumList = numList.stream().filter(x -> isPrime(x)).max((a,b) -> a-b).get();
		System.out.println("Prime Number List: " + primeNumList);
	}
	
	public static boolean isPrime(int num) {
		if(num < 2)
			return false;
		
		for(int i = 2; i < num; i++) {
			if(num % i == 0)
				return false;
		}
		
		return true;
	}
}

//import java.util.stream.LongStream;
//
//public class Main {
//  public static void main(String[] args) {
//    int n = 176;
//    System.out.println("Number: " + n);
//
//    long largestPrimeFactor = findLargestPrimeFactor(n);
//    System.out.println("Largest prime factor: " + largestPrimeFactor);
//    n = 36;
//    System.out.println("\nNumber: " + n);
//
//    largestPrimeFactor = findLargestPrimeFactor(n);
//    System.out.println("Largest prime factor: " + largestPrimeFactor);
//  }
//
//  public static long findLargestPrimeFactor(long n) {
//    for (long i = (long) Math.sqrt(n); i >= 2; i--) {
//      if (n % i == 0 && isPrime(i)) {
//        return i;
//      }
//    }
//    return n;
//  }
//
//  public static boolean isPrime(long number) {
//    return LongStream.rangeClosed(2, (long) Math.sqrt(number))
//      .allMatch(n -> number % n != 0);
//  }
//}
