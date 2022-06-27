package com.paribas.tictactoe.model;

public enum CellValue {
	EMPTY (0) ,CROSS (1),CIRCLE (2);
	int value ; 
	
	CellValue(int i) {
		this.value = i ;
	} 
}	
