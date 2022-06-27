package com.paribas.tictactoe.model;

public class Board {
	private CellValue[][] board;
	private int row ; 
	private int column ;
	
	public Board (int row , int column ) {
		
		this.row = row ;
		this.column = column ;
		board = new CellValue[this.row][this.column];
		
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < column;j++) {
				board[i][j]=CellValue.EMPTY;
			}
		}
	}

	public CellValue[][] getBoard() {
		CellValue[][] tmp = board.clone();
		return tmp;
	}

	public void setBoard(CellValue[][] board) {
		this.board = board;
	}
	
	public void setCellNewValue(int x , int y , CellValue newValue){
			board[x][y] = newValue;
	}
	public CellValue getCellValue(int x , int y ){
		return getBoard()[x][y];
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
}
