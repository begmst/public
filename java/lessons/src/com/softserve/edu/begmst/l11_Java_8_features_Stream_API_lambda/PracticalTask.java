package com.softserve.edu.begmst.l11_Java_8_features_Stream_API_lambda;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class PracticalTask {

	/**
	 * Print n random numbers on console using Java 8
	 */
	public static void task1(int N) {
		Random random = new Random();
		random.ints().limit(N).forEach(System.out::println);
	}
	
	/**
	 * Print n random numbers on console using Java 8 in a sorted order
	 */
	public static void task2(int N) {		
		Random random = new Random();
		random.ints().limit(N).sorted().forEach(System.out::println);
	}
	
	/**
	 * Using Java 8 show the biggest number from n random numbers
	 */
	public static void task3(int N) {		
		Random random = new Random();
		int max = random.ints().limit(N).max().getAsInt();
		System.out.println(String.format("Max number: %d", max));
	}
	
	/**
	 * Show witch today is a day of a week
	 */
	public static void task4() {
		Date currentDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("EEEE");
		Calendar cal = Calendar.getInstance();
		System.out.println(String.format("Today is %s, #%d day of week", dateFormat.format(currentDate), cal.get(Calendar.DAY_OF_WEEK)));
	}
	
	/**
	 * Show a date of first Monday for current month
	 */
	public static void task5() {		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
	    System.out.println("Month: " + month);
	    System.out.println("Year: " + year);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	    calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
	    calendar.set(Calendar.MONTH, month);
	    calendar.set(Calendar.YEAR, year);
	    int day = (calendar.get(Calendar.DATE));
		System.out.println(String.format("First Monday is %s", dateFormat.format(calendar.getTime())));
	}
	
	/**
	 * Write a method for sorting list of Strings using Java 8
	 */
	public static void task6() {		
		String[] strings = {"AB", "BB", "AAA", "C"};
		List<String> list = Arrays.asList(strings);
		list.stream().sorted().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		task1(5);
		System.out.println();
		task2(4);
		System.out.println();
		task3(3);
		System.out.println();
		task4();
		System.out.println();
		task5();
		System.out.println();
		task6();
	}

}
