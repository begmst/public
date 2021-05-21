package com.softserve.edu.begmst.l04_Condition_statements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

//enum Breed {
//	DACHSHUND, CORGI, SAMOYED;
//}

public class Dog {
	enum Breed {
		DACHSHUND, CORGI, SAMOYED;
	}
	private String name;
	private Breed breed;
	private int age;
	
	public Dog(String name, Breed breed, int age) {
		this.setName(name);
		this.setBreed(breed);
		this.setAge(age);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return String.format("%s breed is %s. It is %d years old.", this.getName(), this.getBreed(), this.getAge());
	}

	public static void main(String[] args) {
		Dog diesel = new Dog("Diesel", Breed.DACHSHUND, 6);
		Dog crispi = new Dog("Crispi", Breed.CORGI, 1);
		Dog hazar = new Dog("Hazar", Breed.SAMOYED, 10);
		Dog crispi2 = new Dog("Crispi", Breed.CORGI, 12);
		
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(diesel);
		dogs.add(crispi);
		dogs.add(hazar);
		dogs.add(crispi2);
		
		HashSet<String> dogNames = new HashSet<String>();

		for (Dog dog: dogs) {
			System.out.println(dog);
			if (dogNames.contains(dog.getName())) {
				System.out.println("Duplicated dog name: " + dog.getName());				
			} else {
				dogNames.add(dog.getName());
			}
		}
		
		dogs.sort(new DogsComparator());
		
		System.out.println(String.format("The oldest dog is %s", dogs.get(dogs.size() - 1).getName()));
	}
}

class DogsComparator implements Comparator<Dog> {

	@Override
	public int compare(Dog dogA, Dog dogB) {
		return dogA.getAge() - dogB.getAge();
	}
	
}
