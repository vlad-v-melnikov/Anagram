package com.foxminded.anagram;

import java.util.Scanner;

public class AnagramApplication {

	public static void main(String[] args) {

		System.out.println("Task 1. Anagram");
		Scanner keyboard = new Scanner(System.in);
		AnagramProcessor anagram = AnagramProcessor.getInstance();

		while (true) {
			System.out.println("Please enter a line that contains words for anagrams. To finish, enter 0:");
			String input = keyboard.nextLine();

			if ("0".equals(input)) {
				break;
			}
			String result = anagram.createAnagram(input);
			System.out.println("Output: " + result + "\n");
		}
		keyboard.close();
		System.out.println("Thank you. Exiting.");
	}
}
