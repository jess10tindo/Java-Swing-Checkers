package com.dtcc.checkers;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;


class ModelTest extends Model{
	
	
	@Test
	void isNormalMoveNoKingLegalTest() {
		
		String turn = getTurn();
		String board[][] =  {{"EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY"},
							 {"EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY"},
							 {"EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY"},
							 {"EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY"},
							 {"EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY"},
							 {"EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY"},
							 {"EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY"},
							 {"EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY"}};
		
		Move move = new Move();
		board[6][5] = "R-P";
		
		move.startX = 5;
		move.startY = 6;
		
		move.endX = 6;
		move.endY = 5;
		
		assertEquals(true, isNormalMoveNoKingLegal(move));
		
	}
	
	@Test
	void isNormalKingLegalTest() {
		fail("Not yet implemented");
	}
	
	@Test
	void isJumpMoveNoKingLegalTest() {
		fail("Not yet implemented");
	}
	
	
	
	@Test
	void isJumpMoveKingLegal() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void normalMoveNoKingTest() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void jumpMoveNoKingTest() {
		fail("Not yet implemented");
	}
	
	
	
	@Test
	void normalMoveKingTest() {
		fail("Not yet implemented");
	}
	
	@Test
	void jumpMoveKingTest() {
		fail("Not yet implemented");
	}
	
	
	
	@Test
	void removeJumpedPieceTest() {
		fail("Not yet implemented");
	}
	
	
}
