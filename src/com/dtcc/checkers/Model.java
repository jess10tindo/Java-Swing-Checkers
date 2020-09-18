package com.dtcc.checkers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Model {

	//Default Black Starts
	String turn = "B";
	int black_count = 12;
	int red_count = 12;

	private String[][] board;
	private final static String File = "src\\com\\dtcc\\checkers\\Checkers_Save_File.txt";

	public Model() {
		String[][] board = new String[8][8];
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				board[i][j] = "EMPTY";
				if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
					if (i < 3) {
						board[i][j] = "R-P";
					}
					if (i > 4) {
						board[i][j] = "B-P";
					}
				}
			}
		}
		this.board = board;
	}

	public String[][] update(Move move) {
		normalMoveNoKing(move, isNormalMoveNoKingLegal(move));
		jumpMoveNoKing(move, isJumpMoveNoKingLegal(move));

		// Future methods I am working on:
		// normalMoveKing(move, isNormalMoveKingLegal(move));
		// jumpMoveKing(move, isJumpMoveKingLegal(move));

		makeKing();
		return board;
	}

	public String[][] getBoard() {
		return board;
	}

	//populate pieces on the board
	public String[][] populateNewBoard() {
		String board[][] = new String[8][8];
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				board[i][j] = "EMPTY";
				if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
					if (i < 3) {
						board[i][j] = "R-P";
					}
					if (i > 4) {
						board[i][j] = "B-P";
					}
				}
			}
		}
		return board;
	}

	public static void save(String[][] temp) {
		try {
			PrintWriter out = new PrintWriter(new File(File));
			String[][] temp_board = temp;
			System.out.println(temp_board.length);
			//Rows
			for (int y = 0; y < temp_board.length; y++) {
				//Columns
				for (int x = 0; x < temp_board.length; x++) {
					out.print(temp_board[y][x] + " ");
					System.out.print(temp_board[y][x] + " ");
				}
				out.println();
			}
			out.close();
		} catch (FileNotFoundException e) {
			//Do something
		}
	}

	public static void load() {
		try {
			String temp_board[][] = new String[8][8];
			Scanner input = new Scanner(new File(File));
			//Only runs while 
			while (input.hasNext()) {
				//Rows
				for (int y = 0; y < temp_board.length; y++) {
					//Columns
					for (int x = 0; x < temp_board.length; x++) {
						temp_board[y][x] = input.next();
					}
				}
			}
			input.close();
			//Do something with temp_board, not sure yet.
		} catch (FileNotFoundException e) {
			//Do Something
		}
	}

	public static void printBoard(String[][] temp) {
		String[][] temp_board = temp;

		for (int i = 0; i < temp_board.length; i++) {
			for (int j = 0; j < temp_board.length; j++) {

				System.out.print(temp_board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public String[][] makeKing() {
		for (int i = 0; i < 8; i++) {
			if (board[0][i].equals("B-P")) {
				board[0][i] = "B-K";
			}
		}
		for (int i = 0; i < 8; i++) {
			if (board[7][i].equals("R-P")) {
				board[7][i] = "R-K";
			}
		}
		return board;

	}

	public boolean isNormalMoveNoKingLegal(Move move) {
		boolean isNormalMoveNoKingLegal = false;
		if (turn.equals("R")) {
			if (board[move.startY][move.startX].equals("R-P") && (move.endY != move.startY + 2) && !(board[move.startY][move.startX].equals("R-K"))) {
				if (board[move.endY][move.endX].equals("EMPTY")) {
					if ((move.endY == move.startY + 1 && move.endX == move.startX + 1) || (move.endY == move.startY + 1 && move.endX == move.startX - 1)) {
						isNormalMoveNoKingLegal = true;
					}
				}
			}
		} else if (turn.equals("B")) {
			if (board[move.startY][move.startX].equals("B-P") && (move.endY != move.startY - 2) && !(board[move.startY][move.startX].equals("R-K"))) {
				if (board[move.endY][move.endX].equals("EMPTY")) {
					if ((move.endY == move.startY - 1 && move.endX == move.startX + 1) || (move.endY == move.startY - 1 && move.endX == move.startX - 1)) {
						isNormalMoveNoKingLegal = true;
					}
				}
			}

		}
		return isNormalMoveNoKingLegal;
	}

	public String[][] normalMoveNoKing(Move move, boolean isNormalMoveNoKingLegal) {
		String movingPiece = board[move.startY][move.startX];
		if (isNormalMoveNoKingLegal == true) {
			if (turn.equals("R")) {
				board[move.endY][move.endX] = movingPiece;
				board[move.startY][move.startX] = "EMPTY";
				turn = "B";
			} else {
				board[move.endY][move.endX] = movingPiece;
				board[move.startY][move.startX] = "EMPTY";
				turn = "R";
			}
		}
		return board;
	}

	public boolean isJumpMoveNoKingLegal(Move move) {
		boolean isJumpMoveNoKingLegal = false;
		if (turn.equals("R")) {
			if (board[move.startY][move.startX].equals("R-P") && (move.endY == move.startY + 2) && !(board[move.startY][move.startX].equals("R-K"))) {
				if (board[move.endY][move.endX].equals("EMPTY")) {
					if (((move.endY == move.startY + 2) && (move.endX == move.startX + 2) && (board[move.startY + 1][move.startX + 1].equals("B-P")))) {
						isJumpMoveNoKingLegal = true;
					} else if ((move.endY == move.startY + 2 && move.endX == move.startX - 2 && board[move.startY + 1][move.startX - 1].equals("B-P"))) {
						isJumpMoveNoKingLegal = true;
					}
				}
			}
		} else if (turn.equals("B")) {
			if (board[move.startY][move.startX].equals("B-P") && turn == "B" && (move.endY == move.startY - 2) && !(board[move.startY][move.startX].equals("B-K"))) {
				if (board[move.endY][move.endX].equals("EMPTY")) {
					if (((move.endY == move.startY - 2) && (move.endX == move.startX + 2) && (board[move.startY - 1][move.startX + 1].equals("R-P")))) {
						isJumpMoveNoKingLegal = true;
					} else if ((move.endY == move.startY - 2 && move.endX == move.startX - 2 && board[move.startY - 1][move.startX - 1].equals("R-P"))) {
						isJumpMoveNoKingLegal = true;
					}
				}
			}
		}
		return isJumpMoveNoKingLegal;
	}

	public String[][] jumpMoveNoKing(Move move, boolean isJumpMoveNoKingLegal) {
		String movingPiece = board[move.startY][move.startX];
		if (isJumpMoveNoKingLegal == true) {
			if (turn.equals("R")) {
				leftOrRightMovement(move, movingPiece);
			}
		}
		return board;
	}

	private void leftOrRightMovement(Move move, String movingPiece) {
		if (((move.endY == move.startY - 2) && (move.endX == move.startX + 2) && (board[move.startY - 1][move.startX + 1].equals("R-P")))) {
			board[move.endY][move.endX] = movingPiece;
			board[move.startY][move.startX] = "EMPTY";
			board[move.startY - 1][move.startX + 1] = "EMPTY";
			red_count -= 1;
			turn = "R";
		} else if ((move.endY == move.startY - 2 && move.endX == move.startX - 2 && board[move.startY - 1][move.startX - 1].equals("R-P"))) {
			board[move.endY][move.endX] = movingPiece;
			board[move.startY][move.startX] = "EMPTY";
			board[move.startY - 1][move.startX - 1] = "EMPTY";
			red_count -= 1;
			turn = "R";
		}
	}
}