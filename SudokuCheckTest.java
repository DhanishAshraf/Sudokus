import static org.junit.Assert.*;
import org.junit.Test;

/** 4 tests to check that the SudokuCheck class works correctly.
 * @author Dhanish Ashraf
 *
 */
public class SudokuCheckTest {

	/**
	 * Here we check SudokuCheck works correctly when the Sudoku is correct and complete.
	 */
	@Test
	public void testAll() { 
		
		int[][] a1 = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{4, 5, 6, 7, 8, 9, 1, 2, 3},
				{7, 8, 9, 1, 2, 3, 4, 5 ,6},
				{2, 3, 4, 5, 6, 7, 8, 9, 1},
				{5, 6, 7, 8, 9, 1, 2, 3, 4},
				{8, 9, 1, 2, 3, 4, 5, 6, 7},
				{3, 4, 5, 6, 7, 8, 9, 1, 2},
				{6, 7, 8, 9, 1, 2, 3, 4, 5},
				{9, 1, 2, 3, 4, 5, 6, 7, 8}}; 
		
		Sudoku array1 = new Sudoku(a1);
		boolean[][] actual = SudokuCheck.check(array1);
		
		boolean[][] expected = {{true, true, true, true, true, true, true, true, true},
								{true, true, true, true, true, true, true, true, true},
								{true, true, true, true, true, true, true, true, true}};
		
		assertArrayEquals(expected, actual);
							
		}
	
	/**
	 * Here we check SudokuCheck works some rows and columns are false.
	 */
	@Test
	public void test2() { 
		
		int[][] a2 = {{1, 1, 3, 4, 5, 6, 7, 8, 9},
				{4, 5, 6, 7, 8, 9, 1, 2, 3},
				{7, 8, 9, 1, 2, 3, 4, 5 ,6},
				{2, 3, 4, 5, 6, 7, 8, 9, 1},
				{5, 6, 7, 8, 9, 1, 2, 3, 4},
				{8, 9, 1, 2, 3, 4, 5, 6, 7},
				{3, 4, 5, 6, 7, 8, 9, 1, 2},
				{6, 7, 8, 9, 1, 2, 3, 4, 5},
				{9, 1, 2, 3, 4, 5, 6, 7, 3}}; 
		
		Sudoku array1 = new Sudoku(a2);
		boolean[][] actual = SudokuCheck.check(array1);
		
		boolean[][] expected = {{false, true, true, true, true, true, true, true, false},
								{true, false, true, true, true, true, true, true, false},
								{false, true, true, true, true, true, true, true, false}};
		
		//System.out.println(Arrays.deepToString(actual));
		assertArrayEquals(expected, actual);
							
		}
	
	/**
	 * Here we check SudokuCheck works all the rows and columns are false.
	 */
	@Test
	public void test3() {
		
		int[][] a3 = {{1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1},}; 
		
		Sudoku array1 = new Sudoku(a3);
		boolean[][] actual = SudokuCheck.check(array1);
		
		boolean[][] expected = {{false, false, false, false, false, false, false, false, false},
								{false, false, false, false, false, false, false, false, false},
								{false, false, false, false, false, false, false, false, false}};
		
		//System.out.println(Arrays.deepToString(actual));
		assertArrayEquals(expected, actual);
							
		}
	
	/**
	 * Here we check SudokuCheck works some rows and columns are false.
	 */
	@Test
	public void test4() { 
		
		int[][] a4 = {{1, 2, 3, 4, 5, 7, 7, 8, 9},
					  {4, 5, 6, 7, 8, 9, 1, 2, 3},
				 	  {7, 8, 9, 1, 2, 3, 4, 5 ,6},
					  {2, 3, 4, 5, 6, 7, 8, 9, 1},
					  {5, 6, 7, 8, 9, 1, 2, 3, 4},
					  {8, 9, 1, 2, 3, 4, 5, 6, 7},
					  {3, 4, 5, 6, 7, 8, 9, 1, 2},
					  {6, 7, 8, 9, 1, 2, 3, 4, 5},
					  {9, 1, 2, 3, 4, 5, 6, 7, 8}}; 
		
		Sudoku array1 = new Sudoku(a4);
		boolean[][] actual = SudokuCheck.check(array1);
		
		boolean[][] expected = {{false, true, true, true, true, true, true, true, true},
								{true, true, true, true, true, false, true, true, true},
								{true, false, true, true, true, true, true, true, true}};
		
		assertArrayEquals(expected, actual);
							
		}

}
