package com.softserve.edu.begmst.l04_Condition_statements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HomeworkMinMaxNumbers {
	public static void main(String[] args) {
		int N = 3;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < N; i++) {
			System.out.print("Enter value: ");
			int value = s.nextInt();
			numbers.add(value);
		}
		System.out.println("Min value: " + Collections.min(numbers));		
		System.out.println("Max value: " + Collections.max(numbers));		
	}
}
