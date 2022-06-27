package com.paribas.tictactoe.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TitcTacToeTest {
	   
		TicTacToe game = new TicTacToe();
		@Test
		public void test01_isOver()  {
			assertEquals(game.game(),true);
		}
}
