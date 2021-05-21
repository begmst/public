package com.softserve.edu.begmst.l04_Condition_statements;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;
import org.junit.Test;

public class HomeworkNumbers {
	
	@Test
	public static void readFloats() {
		int min = -5, max = 5, N = 3;
		Scanner s = new Scanner(System.in);

		double[] numbers = new double[N];
		for (int i = 0; i < N; i++) {
			System.out.print(String.format("Enter a number [%d,%d]: ", min, max));
			numbers[i] = s.nextDouble();
			assertTrue(String.format("Number %f should be greater or equal %d", numbers[i], min), numbers[i] >= min);
			assertTrue(String.format("Number %f should be less or equal %d", numbers[i], max), numbers[i] <= max);
		}
	}
	
	public static void main(String[] args) {
		
	}
}
