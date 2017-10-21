package model;

public class Model {
	private int playerId;
	private int movesCount;
	private char[][] board;
	private String message;
	
	// default constructor
	public Model() {
		this.board = new char[3][3];
		this.movesCount = 9;
	}
    
	//setters and getters
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getMovesCount() {
		return movesCount;
	}

	public void setMovesCount(int movesCount) {
		this.movesCount = movesCount;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// function to update the board
	public void PlayMove(int x, int y, int playerId) {
		if(getMovesCount() > 0){
			
			if(playerId%2 != 0)
				board[x][y] = 'X';
			else
				board[x][y] = 'O';
			
			setMovesCount(--movesCount);
			
			if(isWinner(x, y, playerId))
				setMessage("Player" + playerId + "is Winner!");
			if(getMovesCount()==0)
				setMessage("No Winner! Game ended in a Tie");
		}
		
	}
	
	// function to check if there is a winner
	public boolean isWinner(int x, int y, int playerId) {
		int countRow = 0;
		int countCol = 0;
		int countLDiag = 0;
		int countRDiag = 0;
		char symbol;
		if(playerId %2 !=0)
			symbol = 'X';
		else
			symbol = 'O';
		
		for(int i=0; i<board.length;i++) {
			if(board[x][i] == symbol)
				countRow++;
			if(board[i][y] == symbol)
				countCol++;
			if(board[i][i] == symbol)
				countRDiag++;
			if(board[board.length-1-i][i] == symbol)
				countLDiag++;	
		}
		
		if(countCol==board.length || countRow==board.length 
		   || countLDiag == board.length || countRDiag == board.length)
			return true;
		
		return false;
	}
		
}
