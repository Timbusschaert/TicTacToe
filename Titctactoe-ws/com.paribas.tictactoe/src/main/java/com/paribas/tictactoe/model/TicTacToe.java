package com.paribas.tictactoe.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Class that manages the gameplay of the model part 
 * @author timbu
 *
 */
public class TicTacToe {
	/**
	 * board of the game
	 */
	public Board board; 
	
	/**
	 * player queue management
	 */
	public Players players;
	
	/**
	 * Constructor 
	 * @param playerOne
	 * @param playerTwo
	 */
	public TicTacToe(String playerOne,String playerTwo) {
		this.board = new Board(3, 3);
		List<Player> players = new ArrayList<>();
		players.add(new Player(playerOne,CellValue.CROSS));
		players.add(new Player(playerTwo,CellValue.CIRCLE));		
		this.players = new Players(players);
	}
	
	public TicTacToe(String playerOne,String playerTwo, int row ,int column) {
		this.board = new Board(3, 3);
		List<Player> players = new ArrayList<>();
		players.add(new Player(playerOne,CellValue.CROSS));
		players.add(new Player(playerTwo,CellValue.CIRCLE));	
		this.board = new Board(row, column);
	}
	
	/**
	 * Make the current player play
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean play(int row , int column) {
		Player currentPlayer = players.getCurrentPlayer();
		board.setCellNewValue(row, column, currentPlayer.getType());
		if(isOver()) {
			return true ;
		}
		players.nextPlayer();
		return false;
	}
	
	/**
	 * Return true if a player has won or if the board is full
	 * @return
	 */
	public boolean isOver() {
		if(hasCurrentPlayerWin()) {
			return true;
		}
		for(int i = 0 ; i < board.getRow(); i++ ) {
			for(int j = 0 ; j <board.getColumn();j++ ) {
				if(board.getCellValue(i,j) == CellValue.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * return if the current player win
	 * @return
	 */
	public boolean hasCurrentPlayerWin() {
		for(int i = 0 ; i < board.getRow() ; i++) {
			if(hasWinColumn(i) || hasWinRow(i)) {
				return true ;
			}
		}
		return hasWinDiagonal() || hasWinOpositeDiagonal();
	}
	
	/**
	 * Return true if the current player has won with the given column 
	 * @param column
	 * @return
	 */
	private boolean hasWinColumn(int column) {
		for(int i = 0 ; i < board.getRow() ; i++) {
			CellValue cellValue = board.getCellValue(i, column);
			if( cellValue != players.getCurrentPlayer().getType()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Return true if the current player has won with the given row 
	 * @param row
	 * @return
	 */
	private boolean hasWinRow(int row) {
		for(int i = 0 ; i < board.getColumn() ; i++) {
			CellValue cellValue = board.getCellValue(row, i);
			if( cellValue != players.getCurrentPlayer().getType()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Return true if the current player has won with the diagonal
	 * @return
	 */
	private boolean hasWinDiagonal() {
		for(int i = 0 ; i < board.getRow() ; i++) {
			CellValue cellValue = board.getCellValue(i, i);
			if( cellValue != players.getCurrentPlayer().getType()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Return true if the current player has won with the opposite diagonal
	 * @return
	 */
	private boolean hasWinOpositeDiagonal() {
		for(int i = 0 ; i < board.getRow() ; i++) {
			CellValue cellValue = board.getCellValue((board.getColumn()-1)-i, i);
			if( cellValue != players.getCurrentPlayer().getType()) {
				return false;
			}
		}
		return true;
	}
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Players getPlayers() {
		return players;
	}
	public void setPlayers(Players players) {
		this.players = players;
	}
	/**
	 * Return true if the current player can play
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean canCurrentPlayerPlay(int i, int j) {
		return board.getCellValue(i, j) == CellValue.EMPTY ;
	}
	
}
