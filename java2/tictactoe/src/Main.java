import java.util.EnumSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Very beginning...");
		Player player1 = new HumanPlayer(FieldType.X);
		Player player2 = new HumanPlayer(FieldType.O);
		Game game = new Game(player1, player2);
		game.start();
	}

}

class Field {
	
	private FieldType fieldType = FieldType.Empty;
	
	public void setType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public FieldType getType() {
		return this.fieldType;
	}	
	
	public boolean isFree() {
		return this.fieldType == FieldType.Empty;
	}
	
}

enum FieldType {
	
	X('X'), O('O'), Empty(' ');
	
	private char symbol;
	
	FieldType(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
}

class Player {
	
	private FieldType playerType;
	
	public Player(FieldType playerType) {
		this.playerType = playerType;
	}
	
	public Move getMove(Board board) {
		return new Move('a', 0);
	}
	
	public FieldType getPlayerType() {
		return this.playerType;
	}
	
}

class HumanPlayer extends Player {
	
	public HumanPlayer(FieldType playerType) {
		super(playerType);
	}

	/**
	 * @Override
	 */
	public Move getMove(Board board) {
		Scanner s = new Scanner(System.in);
		System.out.print(String.format("Player %s, make a move: ", this.getPlayerType().getSymbol()));
        String line = s.nextLine();
        Move move = new Move(Character.toUpperCase(line.charAt(0)), Integer.parseInt(String.valueOf(line.charAt(1))));
		return move;
	}
	
}

class Game {
	
	private final int N = 3;
	
	private Board board;
	private Player player1, player2;
	
	public Game(Player player1, Player player2) {
		this.board = new Board(this.N);
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void start() {
		System.out.println("Game start!");
		while (!this.board.isFinished()) {
			this.board.show();

			Move move;
			do {
				move = this.player1.getMove(this.board);
			} while (!this.board.isValidMove(move));
			
			this.board.makeMove(player1, move);			
			this.board.show();
			
			if (board.isFinished()) {
				if (board.isWin()) {
					System.out.println(String.format("%s WINS!", player1.getPlayerType().getSymbol()));					
				}
				System.out.println(String.format("GAME OVER!"));
				break;
			}

			do {
				move = this.player2.getMove(this.board);
			} while (!this.board.isValidMove(move));
			
			this.board.makeMove(player2, move);
			this.board.show();
			
			if (board.isFinished()) {
				if (board.isWin()) {
					System.out.println(String.format("%s WINS!", player2.getPlayerType().getSymbol()));					
				}
				System.out.println(String.format("GAME OVER!"));
				break;
			}

			this.board.show();
		}
	}
	
}

class Board {
	
	private int N = 3;
	private Field[][] fields;
	private boolean isWin = false;
	private FieldType winnerType = FieldType.Empty;
	
	public Board(int N) {
		this.fields = new Field[N][N];
		for (int i = 0; i < this.N; i++) {
			for (int j = 0; j < this.N; j++) {
				this.fields[i][j] = new Field();
			}
		}
	}
	
	public boolean isFinished() {
		return this.checkIsWin() || this.checkIsFull();
	}
	
	private boolean checkIsFull() {
		int emptyFieldsCount = 0;
		for (int i = 0; i < this.N; i++) {
			for (int j = 0; j < this.N; j++) {
				emptyFieldsCount += this.fields[i][j].isFree() ? 1 : 0;
			}
		}
		return emptyFieldsCount == 0;
	}
	
	private boolean checkIsWin() {
		this.isWin = false;
		FieldType[] fieldTypes = FieldType.values();
		EnumSet<FieldType> fieldSet = EnumSet.allOf(FieldType.class);
		fieldSet.remove(FieldType.Empty);
		
		for (FieldType fieldType : fieldSet) {
			int rowCount;
			int colCount;
			int diaCount1 = 0;
			int diaCount2 = 0;
			for (int i = 0; i < this.N; i++) {
				rowCount = 0;
				colCount = 0;
				for (int j = 0; j < this.N; j++) {
					if (this.fields[i][j].getType() == fieldType) {
						rowCount++;
					}
					if (this.fields[j][i].getType() == fieldType) {
						colCount++;
					}
					if ((i == j) && (this.fields[i][j].getType() == fieldType)) {
						diaCount1++;
					}
				}
				int x = (N - i - 1);
				if (this.fields[(N - i - 1)][i].getType() == fieldType) {
					diaCount2++;
				}
				if ((rowCount == this.N) || (colCount == this.N) || (diaCount1 == this.N) || (diaCount2 == this.N)) {
					this.winnerType = fieldType;
					this.isWin = true;
					break;
				}
			}
		}
		return this.isWin;
	}
	
	public boolean isWin() {
		return this.isWin;
	}
	
	public FieldType getWinner() {
		return this.winnerType;
	}
	
	public boolean isValidMove(Move move) {
		boolean isValid = (move.getRow() < this.N)
			&& (move.getColumn() < this.N)
			&& this.fields[move.getRow()][move.getColumn()].isFree();
		return isValid;
	}
	
	public void show() {
		StringBuilder boardText = new StringBuilder("");
		String eol = System.getProperties().getProperty("line.separator");
		for (int i = 0; i <= this.N; i++) {
			for (int j = 0; j <= this.N; j++) {
				if ((i == 0) && (j == 0)) {
					boardText.append(" ");
				} else if (i == 0) {
					boardText.append(String.valueOf(j - 1));
				} else if (j == 0) {
					boardText.append((char)('A' + i - 1));					
				} else {
					boardText.append(this.fields[i-1][j-1].getType().getSymbol());
				}
			}
			boardText.append(eol);
		}
		System.out.println(boardText);
	}
	
	public void makeMove(Player player, Move move) {
		this.fields[move.getRow()][move.getColumn()].setType(player.getPlayerType());
	}
	
}

record Move(char row, int column) {
	
	public int getRow() {
		return (int)this.row - (int)'A';
	}
	
	public int getColumn() {
		return this.column;
	}
	
}

