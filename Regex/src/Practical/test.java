package Practical;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
	}

	public static boolean Q1(String text) {
		return text.matches("^[\\w]+$");
	}

	public static boolean Q2(String text) {
		return text.matches("pqq*");
	}

	public static boolean Q4(String text) {
		return text.matches("[A-Z][a-z]+");
	}
}
