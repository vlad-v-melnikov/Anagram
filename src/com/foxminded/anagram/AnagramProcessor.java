package com.foxminded.anagram;

public class AnagramProcessor {
	private static AnagramProcessor instance;

	private AnagramProcessor() {
	}

	public static AnagramProcessor getInstance() {
		if (instance == null) {
			instance = new AnagramProcessor();
		}
		return instance;
	}

	public String createAnagram(String input) {
		String result = new String();

		System.out.print("Input: ");
		System.out.println(input);

		for (String word : input.split(" ")) {
			char[] wordProcessor = word.toCharArray();
			int left = 0;
			int right = word.length() - 1;

			while (left < right) {
				char charLeft = word.charAt(left);
				char charRight = word.charAt(right);

				if (!isLetter(charLeft)) {
					++left;
					continue;
				}
				if (!isLetter(charRight)) {
					--right;
					continue;
				}

				swap(wordProcessor, left, right);

				++left;
				--right;
			}
			result += buildString(wordProcessor);
		}
		return result.trim();
	}

	private boolean isLetter(char letter) {
		return ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z'));
	}

	private void swap(char[] wordProcessor, int left, int right) {
		char temp = wordProcessor[left];
		wordProcessor[left] = wordProcessor[right];
		wordProcessor[right] = temp;
	}

	private String buildString(char[] wordProcessor) {
		StringBuilder output = new StringBuilder();
		for (char c : wordProcessor) {
			output.append(c);
		}
		output.append(" ");
		return output.toString();
	}
}
