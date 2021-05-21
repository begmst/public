package com.softserve.edu.begmst.l08_String_Regular_expression;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class PracticalTask {
	
	private static Scanner s;
	
	static {
		s = new Scanner(System.in);		
	}
	
	/**
	 * Enter the two variables of type String. 
	 * Determine whether the first variable substring second. 
	 * For example, if you typed «IT» and «IT Academy» you must receive true.
	 */
	public static void task1() {
		Scanner s = PracticalTask.s;
		System.out.print("Enter string 1: ");
		String s1 = s.nextLine();
		System.out.print("Enter string 2: ");
		String s2 = s.nextLine();
		if (s2.contains(s1)) {
			System.out.println(String.format("\"%s\" is a part of \"%s\".", s1, s2));
		}
	}

	/**
	 * Enter surname, name and patronymic on the console as a variable of type String. 
	 * Output on the console: 
	 * - surnames and initials
	 * - name
	 * - name, middle name and last name
	 */
	public static void task2() {
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> surnames = new ArrayList<String>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> fullNames = new ArrayList<String>();
		Scanner s = PracticalTask.s;
		String line;
		
		do {
			System.out.print("Enter surname, name and patronymic name: ");
			line = s.nextLine();
			if (!line.isBlank()) {
				strings.add(line.trim());

				Pattern p = Pattern.compile("(\\w+)\\s+(\\w+)\\s+(\\w+)");
				Matcher m = p.matcher(line);
				if (m.find()) {
					String lastName = m.group(1);
					String firstName = m.group(2);
					String middleName = m.group(3);
					surnames.add(String.format("%s %s. %s.", lastName, firstName.substring(0,  1), middleName.substring(0, 1)));
					names.add(firstName);
					fullNames.add(String.format("%s %s %s", firstName, middleName, lastName));
				}
			}
		} while(!line.isBlank());	
		
		System.out.println(String.format("Surnames: %s", surnames));
		System.out.println(String.format("Names: %s", names));
		System.out.println(String.format("Full names: %s", fullNames));
	}

	/**
	 * The user name can be 3 to 15 characters of the Latin alphabet, numbers, and underscores. 
	 * Using regular expressions implement checking the user name for validity. 
	 * Input five names in the main method. 
	 * Output a message to the console of the validation of each of the entered names.
	 */
	public static void task3() {
		String[] usernames = { "No" , "Valid0_password", "Too0000Lo000ng_Valid_password", "Invalid123_Пароль", "123_" };
		Pattern p = Pattern.compile("[A-Za-z\\d_]{3,15}");
		for (String username: usernames) {
			Matcher m = p.matcher(username);
			if (m.matches()) {
				System.out.println(String.format("Username \"%s\" is valid.", username));
			} else {
				System.out.println(String.format("Username \"%s\" is invalid.", username));				
			}
		}
	}

	public static void main(String[] args) {
		task1();
		task2();
		task3();
	}

}
