package com.dtcc.checkers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Model {
	
	private String[][] board;
	private final static String File = "src\\com\\dtcc\\checkers\\Checkers_Save_File.txt";
	
	public Model(){
		String[][] board = new String[8][8];
		for(int i = 0; i <= 7; i++) {
			for(int j = 0; j <= 7; j++) {
				board[i][j] = "EMPTY";
				if((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
					if(i<3) {
						board[i][j] = "R-P";
					}
					if(i>4) {
						board[i][j] = "B-P";
					}
				}
			}
		}
		this.board = board;
	}
	
	public String[][] update(Move move){
    	String movingPiece = board[move.startY][move.startX];
    	
    	if(board[move.startY][move.startX].equals("R-P")){
    		if(board[move.endY][move.endX].equals("EMPTY")) {
    			if((move.endY == move.startY + 1 && move.endX == move.startX+1) || (move.endY == move.startY + 1 && move.endX == move.startX-1)) {
    	    		board[move.endY][move.endX] = movingPiece;
    	    		board[move.startY][move.startX] = "EMPTY";
    	    	}
    		}
    	}
        
    	else if(board[move.startY][move.startX].equals("B-P")){
    		if(board[move.endY][move.endX].equals("EMPTY")) {
	    		if((move.endY == move.startY - 1 && move.endX == move.startX+1) || (move.endY == move.startY - 1 && move.endX == move.startX-1)) {
		    		board[move.endY][move.endX] = movingPiece;
		    		board[move.startY][move.startX] = "EMPTY";
	    		}
    		}
    	}
		return board;
    }
	
    public String[][] getBoard() {
    	return board;
    }

    
    public static void save(String board[][]){
    //populate pieces on the board
    public String[][] populateNewBoard() {
    	String board[][] = new String[8][8];
		for(int i = 0; i <= 7; i++) {
			for(int j = 0; j <= 7; j++) {
				board[i][j] = "EMPTY";
				if((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
					if(i<3) {
						board[i][j] = "R-P";
					}
					if(i>4) {
						board[i][j] = "B-P";
					}
				}
			}
		}
		return board;
    }
    
    
    public void save(){
		try {
			PrintWriter out = new PrintWriter(new File(File));
			String temp_board[][] = board;
			System.out.println(temp_board.length);
			//Rows
			for(int y = 0; y < temp_board.length; y++) {
				//Columns
				for(int x = 0; x < temp_board.length; x++) {
					out.print(temp_board[y][x] + " ");
					System.out.print(temp_board[y][x] + " ");
				}
				out.println();
			}
			out.close();
			}
		catch(FileNotFoundException e) {
			//Do something
		}
    }
    
    public static void load(){
    	try {
    		String temp_board[][] = new String[8][8];
			Scanner input = new Scanner(new File(File));
			//Only runs while 
			while(input.hasNext()) {
				//Rows
				for(int y = 0; y < temp_board.length; y++) {
					//Columns
					for(int x = 0; x < temp_board.length; x++) {
						temp_board[y][x] = input.next();
					}
				}
			}
			input.close();
			//Do something with temp_board, not sure yet.
		}
		catch(FileNotFoundException e) {
			//Do Something
		}
    }

    
}
