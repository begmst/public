package tictactoe;

class Board {
	private int N = 3;
	private Field[][] fields;
	private FieldType winnerType = FieldType.Empty;
	
	public Board(int N) {
		this.fields = new Field[N][N];
	}
	
	public boolean isFinished() {
		return this.isWin() || this.isFull();
	}
	
	private boolean isFull() {
		int emptyFieldsCount = 0;
		for (int i = 0; i < this.N; i++) {
			for (int j = 0; j < this.N; j++) {
				emptyFieldsCount += this.fields[i][j].isFree() ? 1 : 0;
			}
		}
		return emptyFieldsCount == 0;
	}
	
	private boolean isWin() {
		boolean isWin = false;
		for (FieldType fieldType : FieldType.values()) {
			
		}
		return isWin;
	}
}
