package com.softserve.edu.begmst.l09_Exceptions;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		B b = (B)new B();
		Test.f(2);
	}
	
	public static void f(int a) {
		System.out.println("int");
	}

	public static void f(Integer a) {
		System.out.println("Integer");
	}

}

class A {
	public void f() {
		System.out.println("A");
	}
}

class B extends A {
	public void f() {
		System.out.println("A");
	}
}

class C {
	public A f() {
		return new B();
	}
}

class D extends C {
	public A f() {
		return new B();
	}
}
