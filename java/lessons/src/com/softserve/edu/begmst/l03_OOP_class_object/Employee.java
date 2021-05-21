package com.softserve.edu.begmst.l03_OOP_class_object;

public class Employee {
	
	public static double totalSum;
	private static double bonusRate = 0.1;
		
	private String name;
	private int rate;
	private double hours;
	
	public Employee() {
		this.name = "Unknown";
		this.rate = 0; 
		this.hours = 0;
	}

	public Employee(String name, int rate) {
		this.name = name;
		this.rate = rate; 
		this.hours = 0;		
	}
	
	public Employee(String name, int rate, double hours) {
		this(name, rate);
		this.hours = hours;
	}
	
	public double getSalary() {
		return this.rate * this.hours;
	}
	
	public void changeRate(int rate) {
		this.rate = rate;
	}
	
	public double getBonuses() {
		return this.getSalary() * Employee.bonusRate;
	}
	
	@Override
	public String toString() {
		return String.format(
			"Employee name: %30s Rate: %-5d Hours: %5.2f Salary: %5.2f Bonus: %5.2f", 
			this.name, this.rate, this.hours, this.getSalary(), this.getBonuses()
		);
	}
	
	public static void main(String[] args) {
		Employee emplZ = new Employee();
		Employee emplA = new Employee("Jonh A.", 10);
		Employee emplB = new Employee("Jimmy B.", 15);
		Employee emplC = new Employee("Shawn C.", 25, 1.15);
		Employee emplD = new Employee("Arnold D.", 30, 2.5);
		System.out.println(emplZ);
		System.out.println(emplA);
		System.out.println(emplB);
		System.out.println(emplC);
		System.out.println(emplD);
		System.out.println("New rates:");
		emplZ.changeRate(1);
		emplA.changeRate(12);
		emplB.changeRate(20);
		emplC.changeRate(30);
		emplD.changeRate(35);
		System.out.println(emplZ);
		System.out.println(emplA);
		System.out.println(emplB);
		System.out.println(emplC);
		System.out.println(emplD);
	}
}
