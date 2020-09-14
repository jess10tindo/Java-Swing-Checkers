//testing
package com.dtcc.checkers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Model {
	
	private final static String File = "src\\com\\dtcc\\checkers\\Checkers_Save_File.txt";
	
    public String[][] update(Move move){
        return  null;
    }

    public String[][] getBoard() {
        return null;
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
	
	public static void save(String board[][]){
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
}
