package com.paribas.tictactoe.model;

public class Player {
	private String name ;
	private CellValue type ;
	
	
	public Player(String name, CellValue type) {
		super();
		this.name = name;
		this.type = type;
	}
	public CellValue getType() {
		return type;
	}
	public void setType(CellValue type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
