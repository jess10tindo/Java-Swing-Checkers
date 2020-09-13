package com.dtcc.checkers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Model {
	
	private final static String File = "src\\com\\dtcc\\checkers\\Checkers_Save_File.tx";
	
    public String[][] update(Move move){
        return  null;
    }

    public String[][] getBoard() {
        return null;
    }

    public void save(){
		try {
			
			PrintWriter out = new PrintWriter(new File(File));
			
			String board[][] = getBoard();
			
			//Rows
			for(int y = 0; y < board.length; y++) {
				//Columns
				for(int x = 0; x < board[x].length; x++) {
					out.print(board[y][x] + " ");
				}
				out.println();
			}
			}
		catch(FileNotFoundException e) {
			
		}

    }

    public static void load(){
    	try {
    		int temp_board[][] = new int[8][8];
			Scanner input = new Scanner(new File(File));
			//Only runs while 
			while(input.hasNextInt()) {
				//Rows
				for(int y = 0; y < temp_board.length; y++) {
					//Columns
					for(int x = 0; x < temp_board.length; x++) {
						temp_board[y][x] = input.nextInt();
					}
				}
			}
			
			//Do something with temp_board, not sure yet.
			
		}
		catch(FileNotFoundException e) {
			
		}
    }
}
