package com.softserve.edu.begmst.l03_OOP_class_object;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {

	private String firstName, lastName;
	private int birthYear;
	
	public Person() {
		this.setFirstName("");
		this.setLastName("");
		this.setBirthYear(0);
	}
	
	public Person(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthYear(0);
	}
	
	public int getAge() {
		return Year.now().getValue() - this.birthYear;
	}
	
	protected void changeName(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public void input() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter first name: ");
		String firstName = s.nextLine();
		System.out.print("Enter last name: ");
		String lastName = s.nextLine();
		System.out.print("Enter year of birth: ");
		int birthYear = s.nextInt();
		this.changeName(firstName, lastName);
		this.setBirthYear(birthYear);
	}
	
	public void output() {
		String output = String.format(
			"Person name is %s %s. Person is %d years old.", 
			this.firstName, this.lastName, this.getAge()
		);
		System.out.println(output);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public static void main(String[] args) {
		ArrayList<Person> persons = new ArrayList<Person>();
		int N = 3;
		for (int i = 0; i < N; i++) {
			Person person = new Person();
			person.input();
			persons.add(person);
		}
		for (Person person: persons) {
			person.output();
		}
	}
}
