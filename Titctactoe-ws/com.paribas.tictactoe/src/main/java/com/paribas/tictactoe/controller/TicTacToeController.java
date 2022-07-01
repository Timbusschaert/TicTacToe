package com.paribas.tictactoe.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.paribas.tictactoe.model.TicTacToe;

/**
 * 
 * @author timbu
 *
 */
@Controller
public class TicTacToeController {
		
		private TicTacToe game;
		
		/**
		 * Start a new game and return to the player a new board 
		 * @param response
		 * @param params
		 * @return
		 * @throws IOException
		 */
		@RequestMapping(value="/start",method = RequestMethod.POST)
		@ResponseBody
		public ApiResponse startGame(HttpServletResponse response,@RequestBody ReadParam params) throws IOException{
			game = new TicTacToe(params.getPlayerOne(),params.getPlayerTwo());
			ApiResponse result = new ApiResponse();
			result.setMessage("Current player : " + game.getPlayers().getCurrentPlayer().getName());
			result.setBoard(game.getBoard());
			result.setOver(false);
			return result;
		}
		
		/**
		 * Check if a player can play , play if he can return the new board and return if the game isOver
		 * @param response
		 * @param params
		 * @return
		 * @throws IOException
		 */
		@RequestMapping(value="/play",method = RequestMethod.POST)
		@ResponseBody
		public ApiResponse playGame(HttpServletResponse response,@RequestBody RequestCell params) throws IOException{
			ApiResponse result = new ApiResponse();
			if(game == null ) {
				result.setMessage("Game has not been set");
				return result;
			}
			if(game.canCurrentPlayerPlay(params.getX(), params.getY())) {
				result.setBoard(game.getBoard());
				result.setMessage("Current player : " + game.getPlayers().getCurrentPlayer().getName());
				boolean isOver = game.play(params.getX(),params.getY()); 
				if(isOver) {
					if(game.hasCurrentPlayerWin()) {
						result.setMessage(game.getPlayers().getCurrentPlayer().getName() +" has won !");
					}else {
						result.setMessage("The game is a draw!" );
					}
				}else {
					result.setMessage("Current player : " + game.getPlayers().getCurrentPlayer().getName());
				}
				result.setOver(isOver);

			}else {
				result.setBoard(game.getBoard());
				result.setOver(game.isOver());
				result.setMessage("This cell is not empty");

			}		
			return result;
		}
		
	
}
