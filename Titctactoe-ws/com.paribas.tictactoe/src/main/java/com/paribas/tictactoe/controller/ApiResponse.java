package com.paribas.tictactoe.controller;

import com.paribas.tictactoe.model.Board;

public class ApiResponse {
	private String message;
	private Board board ;
	private boolean isOver ;
	public boolean isOver() {
		return isOver;
	}
	
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
