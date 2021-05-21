package com.softserve.edu.begmst.l10_IO_Thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PracticalTask {
	
	/**
	 * Output text «I study Java» 10 times with the intervals of one second (Thread.sleep(1000);).
	 */
	public static void task1(String text) {
		Runnable r = new Task1Run(text);
		Thread t = new Thread(r);
		t.start();
	}
	
	/**
	 * Output two messages «Hello, world» and «Peace in the peace» 5 times each with the intervals of 2 seconds, 
	 * and the second - 3 seconds. After printing messages, print the text «My name is …»
	 */
	public static void task2() {
		Runnable r1 = new Task2Run("Hello, world", 2000);
		Runnable r2 = new Task2Run("Peace in the peace", 3000);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("My name is …");		
	}
	
	/**
	 * Prepare mytext.txt file with a lot of text inside.
	 * Read context from file into array of strings.
	 * Each array item contains one line from file.
	 * Complete next tasks:
	 * - 1) count and write the number of symbols in every line.
	 * - 2) find the longest and the shortest line.
	 * - 3) find and write only that lines, which consist of word «var»
	 */
	public static void task3(String fileName) {
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String s = null;
			int count = 0;
			List<String> strings = new ArrayList<String>();
			System.out.println("Read data from file: " + fileName);
			while ((s = br.readLine()) != null) {
				System.out.println(String.format("Line %d has %d symbols: %s", count, s.length(), s));
				strings.add(s);
				count++;
			}
			br.close();
			
			List<String> sortedStrings = strings
					.stream()
					.filter(v -> !v.isBlank())
					.sorted((a, b) -> b.length() - a.length())
					.collect(Collectors.toList());
			System.out.println(String.format("Longest string is: %s", sortedStrings.get(0)));
			System.out.println(String.format("Shortest string is: %s", sortedStrings.get(sortedStrings.size() - 1)));
			
			String longestStrings = strings
					.stream()
					.filter(v -> !v.isBlank())
					.map(v -> v)
					.max(Comparator.comparing(String::length))
					.get();
			String shortestStrings = strings
					.stream()
					.filter(v -> !v.isBlank())
					.map(v -> v)
					.min(Comparator.comparing(String::length))
					.get();
			System.out.println(String.format("Longest string is: %s", longestStrings));
			System.out.println(String.format("Shortest string is: %s", shortestStrings));
			
			String keyword = "var";
			strings
				.stream()
				.filter(v -> v.contains(keyword))
				.forEach(v -> System.out.println(String.format("String with %s: %s", keyword, v)));
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public static void main(String[] args) {
//		PracticalTask.task1("I study Java");
//		PracticalTask.task1("I study Java too");
//		PracticalTask.task2();
		PracticalTask.task3(args[0]);
	}
}

class Task1Run implements Runnable {
	private String text;
	
	public Task1Run(String text) {
		this.text = text;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.text);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception in Task1");				
			}
		}
	}
}

class Task2Run implements Runnable {
	private String text;
	private int timeout;
	
	public Task2Run(String text, int timeout) {
		this.text = text;
		this.timeout = timeout;		
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(String.format("%-20s %30s", this.text, java.time.LocalDateTime.now()));
			try {
				Thread.sleep(this.timeout);
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception in Task2");				
			}
		}
	}
}
