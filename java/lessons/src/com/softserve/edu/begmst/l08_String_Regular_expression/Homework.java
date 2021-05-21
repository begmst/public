package com.softserve.edu.begmst.l08_String_Regular_expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework {
	
	private static Scanner s;
	
	static {
		s = new Scanner(System.in);
	}

	/**
	 * Enter in the console sentence of five words.
	 * - display the longest word in the sentence
	 * - determine the number of its letters
	 * - bring the second word in reverse order
	 */
	public static void task1() {
		System.out.print("Enter a sentense: ");
		String sentence = s.nextLine();
		String[] words = sentence.split("\\W");
		
		int maxLength = 0;
		String longestWord = words[0]; 
		for (String word: words) {
			if (word.length() > maxLength) {
				maxLength = word.length();
				longestWord = word;
			}
		}
		System.out.println(String.format("The lognest word is \"%s\".", longestWord));
		
		ArrayList<String> sortedWords = new ArrayList<String>(Arrays.asList(words));
		sortedWords.sort((b, a) -> { return ((String)a).length() - ((String)b).length(); });
		System.out.println(String.format("The lognest word is \"%s\".", sortedWords.get(0)));
	}
	
	/**
	 * Enter a sentence that contains the words between more than one space.
	 * Convert all spaces, consecutive, one. 
	 * For example, if we introduce the sentence "I    am      learning     Java   Core», 
	 * we have to get the "I'm learning Java Core».
	 */
	public static void task2() {		
		System.out.print("Enter a sentense with spaces: ");
		String sentence = s.nextLine();
		sentence = sentence.replaceAll("\\s+", " ");
		System.out.println(String.format("Sentense without duplicated spaces: \"%s\".", sentence));
	}
	
	/**
	 * Implement a pattern for US currency: the first symbol "$", then any number of digits, dot and two digits after the dot. 
	 * Enter the text from the console that contains several occurrences of US currency. Display all occurrences on the screen.
	 */
	public static void task3() {		
		String line = "";
		
		do {
			System.out.print("Enter price in US dollars: ");
			line = s.nextLine().trim();
			if (!line.isBlank()) {
				if (line.matches("^\\$\\d+\\.\\d{2}")) {
					System.out.println(String.format("%s is a valid US currency.", line));					
				} else {
					System.out.println(String.format("%s is NOT a valid US currency.", line));					
				}
			}
		} while(!line.isBlank());	
	}
	
	public static void main(String[] args) {
		task1();
		task2();
		task3();
	}

}
