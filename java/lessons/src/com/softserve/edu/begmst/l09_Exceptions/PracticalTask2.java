package com.softserve.edu.begmst.l09_Exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Create a class Plant, which includes fields int size, Color color and Type type, and constructor where these fields are initialized.
 * Color and type are Enum. Override the method toString( ).
 * Create classes ColorException and TypeException and describe there all possible colors and types of plants.
 * In the method main create an array of five plants. Check to work your exceptions.
 */
public class PracticalTask2 {

	public static void main(String[] args) {
		Color[] colors = Color.values();
		Type[] types = Type.values();
		Plant[] plants = new Plant[colors.length * types.length];
		int i = 0;
		for (Color color: colors) {
			for (Type type: types) {
				try {
					plants[i++] = new Plant(i, color, type);				
				} catch (ColorException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		System.out.println("All possible plants:");
		for (Plant plant: plants) {
			System.out.println(plant);
		}
		
		ArrayList<Plant> plantsAL = new ArrayList<Plant>(Arrays.asList(plants));
		plantsAL.removeIf(plant -> (plant == null));
		System.out.println("All created plants:");
		for (Plant plant: plantsAL) {
			System.out.println(plant);
		}
	}

}

class Plant {
	private int size;
	private Color color;
	private Type type;
	
	public Plant(int size, Color color, Type type) throws ColorException {
		if (!type.checkCombination(color)) {
			throw new ColorException(type.getCombination(), type);
		}
		this.setSize(size);
		this.setColor(color);
		this.setType(type);
	}
	
	public String toString() {
		return String.format("I'm a %s color %s with %d size", this.color, this.type, this.size);
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
}

enum Color {
	RED, 
	YELLOW, 
	GREEN, 
	BLUE;
}

enum Type {
	FLOWER(new Color[] {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE}), 
	WHEAT(new Color[] {Color.YELLOW}), 
	GRASS(new Color[] {Color.GREEN}), 
	FRUIT(new Color[] {Color.RED, Color.YELLOW, Color.GREEN});
	
	private HashSet<Color> colors;
	
	Type(Color[] colors) {
		this.colors = new HashSet<Color>();
		this.colors.addAll(Arrays.asList(colors));
		System.out.println(this.name() + " colors: " + this.colors);
	}
	
	public boolean checkCombination(Color color) {
		return this.colors.contains(color);
	}
	
	public HashSet<Color> getCombination() {
		return this.colors;
	}
}

@SuppressWarnings("serial")
class ColorException extends Exception {
	public ColorException(HashSet<Color> colors, Type type) {
		super(String.format("The only %s plant colors are allowed for %s", colors, type));
	}
}

@SuppressWarnings("serial")
class TypeException extends Exception {
//	public TypeException(HashSet<Type> types, Color color) {
//		super(String.format("The only %s plant types are allowed for %s", types, color));
//	}
}
