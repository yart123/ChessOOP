package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Cell;
import chess.Main;
import pieces.Piece;

public class MainTest
{
	@Test
	public void normalKingTest() 
	{
		Main main = new Main();
		main.main(null);
		main.checkbox960.setSelected(false);
		Cell[][] cells = main.setupBoard();
		
		int kingX = main.getKing(0).gety();
		if (kingX != 3)		
			fail("King in wrong spot");
	}
	
	@Test
	public void nineSixtyPieceKingMatchTest() 
	{
		Main main = new Main();
		main.main(null);
		main.checkbox960.setSelected(true);
		Cell[][] cells = main.setupBoard();
		
		int whiteKingX = main.getKing(0).gety();
		int blackKingX = main.getKing(1).gety();
		if (whiteKingX != blackKingX)		
			fail("King in wrong spot");
	}
	
	@Test
	public void nineSixtyPieceBishopTest() 
	{
		Main main = new Main();
		main.main(null);
		main.checkbox960.setSelected(true);
		Cell[][] cells = main.setupBoard();
		
		int bishop1X = -1;
		int bishop2X = -1;
		for (int i = 0; i < 8; i++)
		{
			Piece piece = cells[7][i].getpiece();
			
			if (piece instanceof pieces.Bishop)
			{
				if (bishop1X == -1)
					bishop1X = i;
				else
					bishop2X = i;
			}
		}
		
		if (bishop1X % 2 == bishop2X % 2)		
			fail("King in wrong spot");
	}
	
	@Test
	public void nineSixtyKingBetweenRooksTest() 
	{
		Main main = new Main();
		main.main(null);
		main.checkbox960.setSelected(true);
		Cell[][] cells = main.setupBoard();
		
		int rook1X = -1, rook2X = -1, kingX = -1;
		
		for (int i = 0; i < 8; i++)
		{
			Piece piece = cells[7][i].getpiece();
			
			if (piece instanceof pieces.Rook)
			{
				if (rook1X == -1)
					rook1X = i;
				else
					rook2X = i;
			}
			else if (piece instanceof pieces.King)
			{
				kingX = i;
			}
		}
		
		if (kingX < rook1X || kingX > rook2X)		
			fail("King in wrong spot");
	}
	
	@Test
	public void normalRookTest() 
	{
		Main main = new Main();
		main.main(null);
		main.checkbox960.setSelected(false);
		Cell[][] cells = main.setupBoard();
		
		Piece piece = cells[7][0].getpiece();
		if (!(piece instanceof pieces.Rook))		
			fail("Rook in not in the corner");
	}

}
