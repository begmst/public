package tictactoe;

public class Game {
	private final int N = 3;
	
	private Board board;
	private Player player1, player2;
	
	public Game(Player player1, Player player2) {
		this.board = new Board(this.N);
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void start() {
//		while (this.board)
		System.out.println("Game start");
	}
}
