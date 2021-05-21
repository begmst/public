package com.softserve.edu.begmst.Life;

import java.util.Scanner;

public class Life001 {
	
	private int N = 0;
	private boolean[] cells;
	private boolean[] prevCells;
	
	public Life001(int N, boolean[] initialState) {
		this.N = N;
		this.cells = initialState.clone();
		this.prevCells = initialState.clone();
	}
	
	public void run() {
		Scanner s = new Scanner(System.in);
		do {
			this.show();
			s.next();			
		} while (this.step());
	}

	public void show() {
		this.show(this.cells);
	}
	
	public void show(boolean[] cells) {
		String cellString = "";
		for (boolean i: cells) {
			cellString = cellString.concat(i ? "1" : "0");
		}
		String output = "\r".concat(cellString);
		System.out.println(output);
	}
	
	public boolean step() {
		this.cells = this.generateCells();
		boolean result = !this.prevCells.equals(this.cells);
		if (result) {
			this.prevCells = this.cells.clone();
		}
		return result; 
	}
	
	protected boolean generateCell(boolean left, boolean cell, boolean right) {
		System.out.println(left,);
		if (left && cell && right) {
			cell = false;
		} else if (!cell && (left ^ right)) {
			cell = true;
		}
		return cell;
	}
	
	protected boolean[] generateCells() {
		boolean[] newCells = this.cells.clone();
		this.show(newCells);
		System.exit(0);
		
		boolean left, cell, right;
		for (int i = 0; i < this.N; i++) {
			cell = this.cells[i];
			if (i == 0) {
				left = false;
				right = this.cells[i + 1];
			} else if (i == (N - 1)) {
				left = this.cells[i - 1];
				right = false;
			} else {
				left = this.cells[i - 1];
				right = this.cells[i + 1];
			}
			newCells[i] = this.generateCell(left, cell, right);
		}
		return newCells;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("Enter number of cells: ");
		int N = Integer.parseInt(s.nextLine());
		boolean[] initialState = new boolean[N];
		
		System.out.print("Enter initial state (01100): ");
		String initialLine = s.nextLine();
		
		initialLine = initialLine.substring(0, N);
		for (int i = 0; i < N; i++) {
			initialState[i] = initialLine.substring(i, i + 1).equals("1") ? true: false;
		}
		Life001 life = new Life001(N, initialState);
		life.show();
		for (int i = 0; i < 1; i++) {
			life.step();
			life.show();
		}
	}

}
