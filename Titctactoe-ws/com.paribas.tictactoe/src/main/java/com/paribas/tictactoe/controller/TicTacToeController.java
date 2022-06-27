package com.paribas.tictactoe.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


public class TicTacToeController {
	@Controller
	public class HomeController {

		@RequestMapping(value="/start",method = RequestMethod.POST)
		@ResponseBody
		public String startGame(HttpServletResponse response) throws IOException{
			
			return "'";
		}
		
		@RequestMapping(value="/play",method = RequestMethod.POST)
		@ResponseBody
		public String playGame(HttpServletResponse response) throws IOException{
			
			return "'";
		}
		
	}
}
