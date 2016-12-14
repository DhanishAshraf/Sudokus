/**
 * @author Dhanish Ashraf
 * This class will print sudokus in a specific format.
 * The sudoku will be read in from a private field variable array of type int.
 * The class will also incorporate a method that will check if all the elements are filled in the array.
 * @param array is the 2-dimensional array containing the values of the Sudoku
 */

public class Sudoku {
	
	private int[][] array;

	/** This constructor initialises the array
	 * @param array is the 2-dimensional array containing the values of the Sudoku
	 */
	public Sudoku(int[][] array) { 
		this.array = array;
	}

	/** This setter sets the array
	 * @param array
	 */
	public void setArray(int[][] array) {
		this.array = array;
	}



	/** This getter returns the array
	 * @return array
	 */
	public int[][] getArray() { 
		return array;
	}
	
	//We will now create methods in order to create a toString which will print the Sudoku in a specific format.
	
	/** This method prints the top and bottom borders of the 3x3 squares
	 * @return the top and bottom borders
	 */
	public static String outBorders(){
		return "++===+===+===++===+===+===++===+===+===++";
	}
	
	/**This method prints the horizontal inside borders of the 3x3 squares
	 * @return he horizontal inside borders
	 */
	public static String inBorders(){ 
		return "++---+---+---++---+---+---++---+---+---++";
	}
	
	/** This method take the row number that is required to be printed and prints it in the correct format
	 * using a for loop and an if else statement
	 * @param a is the number of the row that we would like to print
	 * @return row which is the row we have just printed
	 */
	public String rowNumber(int a){ 
		String row = ""; //Initialising the row to be an empty sting
		
		// for each column in the row do the do the following:
		for(int column = 0; column < 9; column++){ 
			if(column % 3 == 0) //if the column number is divisible by 3 do the following:
				// add to the String row "|| " followed by the element of the array at [a][column] followed by a space
				if(array[a][column] == 0)
					row += "|| " +"  ";
				else
					row += "|| " + array[a][column] + " ";
				 
			else //otherwise do the following:
				// add to the String row "| " followed by the element of the array at [a][column] followed by a space
				if(array[a][column] == 0)
					row += "| " + "  ";
				else
					row += "| " + array[a][column] + " ";
				 
		}
		
		row += "||"; //At the end of each row, add a "||"
		
		return row; //return the resulting String
	}
	
	/** This method pieces together the three methods; outBorders, inBorders and rowNumber
	 * to print the Sudoku in the correct format.
	 * @return sudoku as a String
	 */
	public String allTogether(){ 
		
		String sudoku = ""; //Initialising an empty String, sudoku.
		
		for(int i = 0; i < array.length; i++){ // For each row of the array, do the following: 
			
			if(i % 3 == 0) // if the row number i divisible by 3, do the following:
				// add to the String sudoku the outBorders method followed by a new line followed 
				// by the rowNumber method (for row i) followed by a new line.
				sudoku += outBorders() + "\n" + rowNumber(i) + "\n"; 
			else // otherwise do the following:
				// add to the String sudoku the inBorders method followed by a new line followed 
				// by the rowNumber method (for row i) followed by a new line.
				sudoku += inBorders() + "\n" + rowNumber(i) + "\n";
		}
		sudoku = sudoku + outBorders(); //add an outside border to the last line of the sudoku
		return sudoku; //return the resulting String.	
	}
	
	// This toString method will return the allTogether method which will print the Sudoku in the required format
	public String toString(){ 
		return allTogether();
	}
	
	/** This method will check whether all the elements in the array have been filled
	 * @return true or false depending on if the array has been filled or not
	 */
	public boolean isFilled(){ 
		for(int i = 0; i < array.length; i++) //for each row of the array
			for(int j = 0; j < array.length; j++) //for each column of the array, do the following:
				if(array[i][j] == 0) //if the element at position (i,j) of the array is 0, do the following:
					return false; //return false (because 0 represents unfilled fields)

	
		return true; //if no 0's are encountered, return true
	}

}
