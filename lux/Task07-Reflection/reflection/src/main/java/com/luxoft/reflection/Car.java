package com.luxoft.reflection;

import java.util.List;

public class Car {
    private String name;
    private int power;
    private double length;
    private List wheels;

    public Car() {
        setName("Default name");
    }

    public Car(String name, int power) {
        setName(name);
        setPower(power);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + getName() + '\'' +
                ", power=" + power +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    private void privateMethod() {
        System.out.println("Private method without params");
    }

    final protected void protectedMethod() {
        System.out.println("Protected method without params");
    }

    public void publicMethod() {
        System.out.println("Public method without params");
    }

    private void privateMethod(String value) {
        System.out.println("Private method with param " + value);
    }

    protected void protectedMethod(String value) {
        System.out.println("Protected method with param" + value);
    }

    final public void publicMethod(String value) {
        System.out.println("Private method with param" + value);
    }
}
