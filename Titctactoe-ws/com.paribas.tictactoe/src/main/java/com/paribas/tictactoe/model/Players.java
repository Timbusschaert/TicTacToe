package com.paribas.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Management of the players queue
 * @author timbu
 *
 */
public class Players {
	//List of players
	List<Player> players ;
	
	private int queue ;
	
	/**
	 * Constructor
	 * @param players
	 */
	public Players(List<Player> players) {
		this.players = players;
		this.queue = 0;
	}
	
	public List<Player> getPlayers() {
		ArrayList<Player> tmp = new ArrayList<Player>(players);
		return tmp;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public int getQueue() {
		return queue;
	}
	
	public void setQueue(int queue) {
		this.queue = queue;
	}
	
	public Player getCurrentPlayer() {
		return players.get(queue);
	}
	
	/**
	 * Move forward in the queue
	 */
	public void nextPlayer() {
		queue = (queue + 1) % players.size() ;
	}
}
