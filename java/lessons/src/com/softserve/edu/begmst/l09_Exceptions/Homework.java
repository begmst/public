package com.softserve.edu.begmst.l09_Exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Homework {
	
	public static void main(String[] args) {
		Homework.task1();
		Homework.task2();
	}
	
	/**
	 * Create method div(), which calculates the dividing of two double numbers.
	 * In main method input 2 double numbers and call this method. Catch all exceptions.
	 */
	public static double div(double a, double b) {
		return a / b;
	}
	
	public static void task1() {
		Scanner s = new Scanner(System.in);
		double a, b; 
		while (true) {
			try {
				System.out.print("Enter double a: ");
				a = Double.parseDouble(s.nextLine());
				System.out.print("Enter double b: ");
				b = Double.parseDouble(s.nextLine());
				double result = Homework.div(a, b);
				System.out.println(String.format("%f / %f = %f", a, b, result));
				break;
			} catch (NumberFormatException e) {
				System.out.println(e.getClass() + ": " + e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getClass() + ": " + e.getMessage());
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getClass() + ": " + e.getMessage());
			} catch (ArithmeticException e) {
				System.out.println(e.getClass() + ": " + e.getMessage());
			}
		}
	}

	/**
	 * Write a method readNumber(int start, int end), that read from console integer number 
	 * and return it, if it is in the range [start...end].
	 * If an invalid number or non-number text is read, the method should throw an exception.
	 * Using this method write a method main(), that has to enter 10 numbers:
	 * -	a1, a2, ..., a10, such that 1 < a1 < ... < a10 < 100
	 * Refactor your previous homework (1-7) and try to handle all possible exceptions in your code.
	 * @throws InvalidRangeException 
	 */
	public static int readNumber(int start, int end) throws InvalidRangeException {
		Scanner s = new Scanner(System.in);
		int value = Integer.parseInt(s.nextLine());
		if ((value >= start) && (value <= end)) {
			return value;
		}
		throw new InvalidRangeException();
	}

	public static void task2() {
		int N = 10;
		int values[] = new int[N];
		int i = 0;
		int min = 1;
		int max = 100 - N;
		while (i < N) {
			try {
				System.out.print(String.format("Enter integer between %d and %d: ", min, max));
				values[i] = Homework.readNumber(min, max);
				min = values[i] + 1;
				max++;
				i++;				
			} catch (InvalidRangeException e) {
				System.out.println("Invalid value for this range.");
			}
		}
		System.out.print("Values: " + Arrays.stream(values).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
	}
}

class InvalidRangeException extends Exception {}
