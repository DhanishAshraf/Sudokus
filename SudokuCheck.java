import java.util.Arrays;

/** This class checks whether a given Sudoku satisfies the conditions of a sudoku.
 * @author Dhanish Ashraf
 *
 */
public class SudokuCheck { 
	
	/** This method will return a 2d array of type boolean indicating which columns, rows
	 * and 3x3 squares are correct and which are not.
	 * @param sudoku is the sudoku that needs to be checked
	 * @return result which is a 2d array of type boolean
	 */
	public static boolean[][] check(Sudoku sudoku){ 
		
		int[][] checkArray = sudoku.getArray(); //the array of the sudoku that needs to be checked
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9}; //the expected result
		boolean[][] result = new boolean[3][9]; // The array that will contain the results (i.e. if the conditions are satisfied)
		
	/** Checking each row of checkArray by copying each row to a temporary 1d array called tempRow
	 *  and sorting it and checking that it is equal to the expected result defined above. If so, we return true
	 *  otherwise we return false*/
		for(int row = 0; row < checkArray.length; row++){
			int[] tempRow = new int[9];
			
			for(int column = 0; column < checkArray[0].length; column++){
					tempRow[column] = checkArray[row][column];
				}
			
			Arrays.sort(tempRow);
			
			if(Arrays.equals(tempRow, expected))
				result[0][row] = true; //the 0 indicates that we are referring to the rows
			else
				result[0][row] = false;
			}
		
		/** Checking each column of checkArray by copying each row to a temporary 1d array called tempCol
		 *  and sorting it and checking that it is equal to the expected result defined above. If so, we return true
		 *  otherwise we return false*/
		for(int column = 0; column < checkArray[0].length; column++){
			int[] tempCol = new int[9];
			
			for(int row = 0; row < checkArray.length; row++){
					tempCol[row] = checkArray[row][column];
				}
			
			Arrays.sort(tempCol);
			if(Arrays.equals(tempCol, expected))
				result[1][column] = true; ////the 1 indicates that we are referring to the columns
			else
				result[1][column] = false;
		}
	
		/** Checking each 3x3 square of checkArray by copying each square to a temporary 1d array called tempCol
		 *  and sorting it and checking that it is equal to the expected result defined above. If so, we return true
		 *  otherwise we return false*/
		
		int count = -1;	
			
		for(int i = 0; i < 9; i = i + 3){						
			for(int k = 0; k < 9; k = k + 3){
				
				int[] tempSq = new int[9];
				int m = 0;
				count += 1;
				
					for(int j = i; j < i + 3; j++){									
						for(int l = k; l < k + 3; l++){
							
								tempSq[m] = checkArray[j][l];	
								m += 1;
						}						
				}
					
				Arrays.sort(tempSq);
				if(Arrays.equals(tempSq, expected))
					result[2][count] = true; //The 2 indicates we are referring to the 3x3 squares
				else
					result[2][count] = false;
					
				}
			}
	
		return result;
		}
}
