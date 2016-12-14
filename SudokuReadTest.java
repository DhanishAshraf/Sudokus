import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/** 4 tests to check that class SudokuRead operates correctly.
 * @author Dhanish Ashraf
 *
 */
public class SudokuReadTest { 

	/** 
	 * In test1 we check that SudokuRead interprets any empty spaces as 0's.
	 */
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
		
		Sudoku actual = null;
		
		try {
			actual = SudokuRead.readSudoku("testFile");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertArrayEquals("The file was not read correctly", expect.getArray(), actual.getArray());
		
	}
	/** 
	 * Here we check that SudokuRead ignores any extra trailing input
	 */
	@Test
	public void test2() { 
		
		int[][] expected = {{1, 2, 3, 4, 5, 6, 7, 8, 9}, 
		                    {4, 5, 6, 7, 8, 9, 1, 2, 3}, 
		                    {7, 8, 9, 1, 2, 3, 4, 5, 6}, 
		                    {2, 3, 4, 5, 6, 7, 8, 9, 1}, 
		                    {5, 6, 7, 8, 9, 1, 2, 3, 4}, 
		                    {8, 9, 1, 2, 3, 4, 5, 6, 7}, 
		                    {3, 4, 5, 6, 7, 8, 9, 1, 2}, 
		                    {6, 7, 8, 9, 1, 2, 3, 4, 5}, 
		                    {9, 1, 2, 3, 4, 5, 6, 7, 8}};
		
		Sudoku expect = new Sudoku(expected);
		
		Sudoku actual = null;
		
		try {
			actual = SudokuRead.readSudoku("sudoku-extra.txt");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertArrayEquals("The file was not read correctly", expect.getArray(), actual.getArray());
		
	}
	
	@Rule 
	public ExpectedException exception = ExpectedException.none();
	
	/** Here we test that SudokuRead throws an illegal argument exception when it encounters an illegal argument.
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	@Test
	public void test3() throws IllegalArgumentException, IOException { 
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Values must be between 1 and 9 inclusively");
		
		SudokuRead.readSudoku("sudokuIllegal1.txt");

	}
	
	/** Here we test that SudokuRead throws an IOException when the file is not found.
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	@Test
	public void test4() throws IllegalArgumentException, IOException { 
		
		exception.expect(IOException.class);
		exception.expectMessage("(No such file or directory)");
		
		SudokuRead.readSudoku("sudokuIllegal11.txt");

	}
	

}
