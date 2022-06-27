package com.paribas.tictactoe.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TitcTacToeTest {
	private TicTacToe game = new TicTacToe("Player one","player two");

	@Test
	public void test01_isOver()  {
		game.play(0, 0);
		game.play(0, 1);
		game.play(1, 0);
		game.play(0, 2);
		game.play(2, 0);
		assertEquals(game.isOver(),true);
	}
	
	@Test
	public void test02_isOver() {
		game.play(0, 0);
		game.play(1, 0);
		game.play(0, 1);
		game.play(1, 0);
		game.play(0, 2);
		assertEquals(game.isOver(),true);
	}
	
	@Test
	public void test03_isOver() {
		game.play(0, 0);
		game.play(0, 0);
		assertEquals(game.isOver(),false);
	}
	@Test
	public void test04_isOver() {
		game.play(0, 0);
		game.play(0, 1);
		game.play(0, 2);
		game.play(1, 0);
		game.play(1, 1);
		game.play(1, 2);
		game.play(2, 0);
		game.play(2, 1);
		game.play(2, 2);
		assertEquals(game.isOver(),true);
	}
	
	@Test
	public void test05_isOver() {
		game.play(0, 0);
		game.play(1, 0);
		game.play(1, 1);
		game.play(1, 0);
		game.play(2, 2);
		assertEquals(game.isOver(),true);
	}
	
	@Test
	public void test06_isOver() {
		game.play(0, 2);
		game.play(1, 0);
		game.play(1, 1);
		game.play(1, 0);
		game.play(2, 0);
		assertEquals(game.isOver(),true);
	}
	
	@Test
	public void test07_isOver() {
		game.play(0, 2);
		assertEquals(game.isOver(),false);
	}
	
	@Test
	public void test08_canCurrentPlayerPlay() {
		
		game.canCurrentPlayerPlay(0 , 0);
		assertEquals(game.isOver(),true);
	}
	
}
