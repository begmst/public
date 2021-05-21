package com.softserve.edu.begmst.l10_IO_Thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Homework {
	
	/**
	 * Run three threads and output there different messages for 5 times.
	 * The third thread supposed to start after finishing working of the two previous threads.
	 */
	public static void task1() {
		Thread t1 = new Thread(new Task1Run("A"));
		Thread t2 = new Thread(new Task1Run("BB"));
		List<Thread> threads = new ArrayList<Thread>();
		t1.start();
		t2.start();
		threads.add(t1);		
		threads.add(t2);		
		Thread t3 = new Thread(new Task1Run("CCC", threads));
		t3.start();
	}

	/**
	 * Cause a deadlock. Organize the expectations of ending a thread in main(),
	 * and make the end of the method main() in this thread.
	 */
	public static void task2() {
		
	}

	/**
	 * Create a thread «one», which would start the thread «two»,
	 * which has to output its number («Thread number two») 3 times and create thread «three»,
	 * which would to output message «Thread number three» 5 times.
	 */
	public static void task3() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread 1 start.");
				Thread t2 = new Thread(() -> {
					System.out.println("\tThread 2 start.");
					for (int i = 0; i < 3; i++) {
						System.out.println("\tThread # 2.");
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						}
					}

					Thread t3 = new Thread(() -> {
						System.out.println("\t\tThread 3 start.");
						for (int i = 0; i < 5; i++) {
							System.out.println("\t\tThread # 3.");
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							}
						}
						System.out.println("\t\tThread 3 finish.");
					});
					t3.start();
					
					System.out.println("\tThread 2 finish.");
				});
				t2.start();
				
				System.out.println("Thread 1 finish.");
			}
		});
		t1.start();
	}

	/**
	 * Create file1.txt file with a text about your career.
	 * Read context from file into array of strings. Each array item contains one line from file.
	 * Write in to the file2.txt
	 * 1) number of lines in file1.txt.
	 * 2) the longest line in file1.txt.
	 * 3) your name and birthday date. 
	 */
	public static void task4() {
		String srcFile = "file1.txt";
		String destFile = "file2.txt";
		FileReader srcReader = null;
		FileWriter destWriter = null;
		try {
			srcReader = new FileReader(srcFile);
			destWriter = new FileWriter(destFile);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {			
		}
		BufferedReader br = new BufferedReader(srcReader);
		BufferedWriter bw = new BufferedWriter(destWriter);
		
		String s = null;
		String out = "";
		int count = 0;
		int maxLength = 0;
		StringBuilder longestString = new StringBuilder("");
		List<String> strings = new ArrayList<String>();
		try {
			while ((s = br.readLine()) != null) {
				out = String.format("Line %d has %d symbols: %s", count, s.length(), s);
				System.out.println(out);
				bw.append(out);
				bw.newLine();
				strings.add(s);
				count++;
				if (s.length() > maxLength) {
					maxLength = s.length();
					longestString.setLength(0);
					longestString.append(s);
				}
			}
			br.close();
			
			out = String.format("File has %d total lines.", count);
			System.out.println(out);
			bw.append(out);
			bw.newLine();
			out = String.format("The longest line has %d symbols: %s", maxLength, longestString);
			System.out.println(out);
			bw.append(out);
			bw.newLine();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = "";
			try {
				dateString = dateFormat.format(dateFormat.parse("1954-11-30"));
			} catch (ParseException e) {
			} 
			out = String.format("My name is %s. I was born on %s", "James Bond", dateString);
			System.out.println(out);
			bw.append(out);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		task1();
		task2();
		task3();
		task4();
	}

}

class Task1Run implements Runnable {
	private String text;
	private List<Thread> joinThreads = new ArrayList<Thread>();
	
	public Task1Run(String text) {
		this.text = text;
	}
	public Task1Run(String text, List<Thread> threads) {
		this.text = text;
		this.joinThreads.addAll(threads);
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getId() + ": " + this.text);
		}
		this.joinThreads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		});
		System.out.println(Thread.currentThread().getId() + ": " + this.text + ": DONE");
	}
}

