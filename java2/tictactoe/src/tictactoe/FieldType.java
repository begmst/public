package tictactoe;

public enum FieldType {
	X('X'), O('O'), Empty(' ');
	
	private char symbol;
	
	FieldType(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
}
