import static org.junit.Assert.*;

import org.junit.Test;

/** A series of tests to check the methods implemented in the Sudoku class.
 * Namely the toString method and the isFilled method.
 * @author Dhanish Ashraf
 *
 */
public class SudokuTest {
	
	//Here we initialise the arrays to use with the tests
	
	int[][] a1 = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
			{4, 5, 6, 7, 8, 9, 1, 2, 3},
			{7, 8, 9, 1, 2, 3, 4, 5 ,6},
			{2, 3, 4, 5, 6, 7, 8, 9, 1},
			{5, 6, 7, 8, 9, 1, 2, 3, 4},
			{8, 9, 1, 2, 3, 4, 5, 6, 7},
			{3, 4, 5, 6, 7, 8, 9, 1, 2},
			{6, 7, 8, 9, 1, 2, 3, 4, 5},
			{9, 1, 2, 3, 4, 5, 6, 7, 8}};
	
	int[][] a2 = {{0, 2, 3, 4, 5, 6, 7, 8, 0},
			{0, 5, 6, 7, 8, 9, 1, 2, 0},
			{0, 8, 9, 1, 2, 3, 4, 5 ,0},
			{0, 3, 4, 5, 6, 7, 8, 9, 0},
			{0, 6, 7, 8, 9, 1, 2, 3, 0},
			{0, 9, 1, 2, 3, 4, 5, 6, 0},
			{0, 4, 5, 6, 7, 8, 9, 1, 0},
			{0, 7, 8, 9, 1, 2, 3, 4, 0},
			{0, 1, 2, 3, 4, 5, 6, 7, 0}};

	Sudoku array1 = new Sudoku(a1);
	Sudoku array2 = new Sudoku(a2);

	/**
	 * Checking the toString prints correctly.
	 */
	@Test
	public void testToString1() {
		
		
		String actual = array1.toString();
		
		String expected = "++===+===+===++===+===+===++===+===+===++" + "\n" +
				"|| 1 | 2 | 3 || 4 | 5 | 6 || 7 | 8 | 9 ||" + "\n" +
				"++---+---+---++---+---+---++---+---+---++" + "\n" +
				"|| 4 | 5 | 6 || 7 | 8 | 9 || 1 | 2 | 3 ||" + "\n" +
				"++---+---+---++---+---+---++---+---+---++" + "\n" +
				"|| 7 | 8 | 9 || 1 | 2 | 3 || 4 | 5 | 6 ||" + "\n" +
				"++===+===+===++===+===+===++===+===+===++" + "\n" +
				"|| 2 | 3 | 4 || 5 | 6 | 7 || 8 | 9 | 1 ||" + "\n" +
				"++---+---+---++---+---+---++---+---+---++" + "\n" + 
				"|| 5 | 6 | 7 || 8 | 9 | 1 || 2 | 3 | 4 ||" + "\n" + 
				"++---+---+---++---+---+---++---+---+---++" + "\n" + 
				"|| 8 | 9 | 1 || 2 | 3 | 4 || 5 | 6 | 7 ||" + "\n" + 
				"++===+===+===++===+===+===++===+===+===++" + "\n" + 
				"|| 3 | 4 | 5 || 6 | 7 | 8 || 9 | 1 | 2 ||" + "\n" + 
				"++---+---+---++---+---+---++---+---+---++" + "\n" + 
				"|| 6 | 7 | 8 || 9 | 1 | 2 || 3 | 4 | 5 ||" + "\n" + 
				"++---+---+---++---+---+---++---+---+---++" + "\n" + 
				"|| 9 | 1 | 2 || 3 | 4 | 5 || 6 | 7 | 8 ||" + "\n" + 
				"++===+===+===++===+===+===++===+===+===++";  
		
		assertEquals("Incorrect toString returned", expected, actual);
		
	}
	
	/**
	 * Checking the toString prints correctly when the sudoku is partially filled.
	 */
	@Test
	public void testToString2(){
		
		
	String actual = array2.toString();
	
	String expected = "++===+===+===++===+===+===++===+===+===++" + "\n" +
			"||   | 2 | 3 || 4 | 5 | 6 || 7 | 8 |   ||" + "\n" +
			"++---+---+---++---+---+---++---+---+---++" + "\n" +
			"||   | 5 | 6 || 7 | 8 | 9 || 1 | 2 |   ||" + "\n" +
			"++---+---+---++---+---+---++---+---+---++" + "\n" +
			"||   | 8 | 9 || 1 | 2 | 3 || 4 | 5 |   ||" + "\n" +
			"++===+===+===++===+===+===++===+===+===++" + "\n" +
			"||   | 3 | 4 || 5 | 6 | 7 || 8 | 9 |   ||" + "\n" +
			"++---+---+---++---+---+---++---+---+---++" + "\n" + 
			"||   | 6 | 7 || 8 | 9 | 1 || 2 | 3 |   ||" + "\n" + 
			"++---+---+---++---+---+---++---+---+---++" + "\n" + 
			"||   | 9 | 1 || 2 | 3 | 4 || 5 | 6 |   ||" + "\n" + 
			"++===+===+===++===+===+===++===+===+===++" + "\n" + 
			"||   | 4 | 5 || 6 | 7 | 8 || 9 | 1 |   ||" + "\n" + 
			"++---+---+---++---+---+---++---+---+---++" + "\n" + 
			"||   | 7 | 8 || 9 | 1 | 2 || 3 | 4 |   ||" + "\n" + 
			"++---+---+---++---+---+---++---+---+---++" + "\n" + 
			"||   | 1 | 2 || 3 | 4 | 5 || 6 | 7 |   ||" + "\n" + 
			"++===+===+===++===+===+===++===+===+===++";  
	assertEquals("Incorrect toString returned", expected, actual);
		
	}
	
	/**
	 * Checking the isFilled method works correctly with a fully filled Sudoku
	 */
	@Test
	public void testIsFilled1(){ 
		
		boolean actual = array1.isFilled();
		boolean expected = true;
		assertEquals("The sudoku is completely filled in", expected, actual);
	}
	
	/**
	 * Checking the isFilled method works correctly with a partially filled sudoku
	 */
	@Test
	public void testIsFilled2(){ 
		
		boolean actual = array2.isFilled();
		boolean expected = false;
		assertEquals("The sudoku is not completely filled in", expected, actual);
	}

}
