package com.paribas.tictactoe.controller;

/**
 * DTO Class for the play() method
 * @author timbu
 *
 */
public class RequestCell {
	private int x ;
	private int y ;
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
}
