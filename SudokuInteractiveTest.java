import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class SudokuInteractiveTest {

	@Test
	public void test1() {
		
		int[][] expected = {{0, 2, 3, 4, 5, 6, 7, 0, 9}, 
                {4, 5, 6, 7, 8, 9, 1, 2, 0}, 
                {7, 8, 9, 1, 2, 3, 4, 5, 0}, 
                {2, 3, 4, 0, 6, 7, 8, 9, 1}, 
                {5, 6, 7, 8, 9, 1, 0, 3, 4}, 
                {8, 9, 1, 2, 0, 4, 5, 6, 7}, 
                {3, 4, 0, 6, 7, 8, 9, 1, 2}, 
                {6, 0, 8, 9, 1, 2, 0, 4, 5}, 
                {0, 1, 2, 3, 4, 5, 6, 7, 8}};

		Sudoku expect = new Sudoku(expected);
		
		SudokuInteractive actual = new SudokuInteractive() 
	}

}
