package com.paribas.tictactoe.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paribas.tictactoe.model.TicTacToe;

@Controller

public class TicTacToeController {
		
		private TicTacToe game;

		@RequestMapping(value="/start",method = RequestMethod.POST)
		@ResponseBody
		public ApiResponse startGame(HttpServletResponse response,@RequestBody ReadParam params) throws IOException{
			game = new TicTacToe(params.getPlayerOne(),params.getPlayerTwo());
			ApiResponse result = new ApiResponse();
			result.setMessage("Current player : " + game.getPlayers().getCurrentPlayer().getName());
			result.setBoard(game.getBoard());
			result.setOver(game.isOver());
			return result;
		}
		
		@RequestMapping(value="/play",method = RequestMethod.POST)
		@ResponseBody
		public String playGame(HttpServletResponse response) throws IOException{
			
			return "'";
		}
		
	
}
