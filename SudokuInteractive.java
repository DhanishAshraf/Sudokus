import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/** This class is a subclass of the Sudoku class. 
 * It allows the user to play the sudoku.
 * @author Dhanish Ashraf
 *
 */
public class SudokuInteractive extends Sudoku { 
	
	private static int[][] checkArray;
	
	/** The constructor for the array
	 * @param array
	 */
	public SudokuInteractive(int[][] array) { 
		super(array);
	}

		
	
	/** This method will allow the user to play the sudoku through the use of a scanner.
	 * The user can only edit fields that were not filled in as part of the original sudoku. This is 
	 * achieved by the user of a 2d boolean array which will have true in all the fields that were originally
	 * filled in.
	 * @param file
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	public static void play(String file) throws IllegalArgumentException, IOException { 
	
		Sudoku readArray = SudokuRead.readSudoku(file); 
		Sudoku readArray2 = SudokuRead.readSudoku(file); 
		SudokuInteractive board = new SudokuInteractive(readArray.getArray());
		checkArray = readArray2.getArray();
		
		int[][] arr = readArray.getArray();
		int[][] originalArr = readArray2.getArray(); //Used to reset the sudoku, should the user wish
		boolean[][] isFilled = new boolean[9][9];
		
		//Filling in the boolean array
      	for(int i = 0; i < readArray.getArray().length; i++){
      		for(int j = 0; j < readArray.getArray().length; j++){
      			if(readArray.getArray()[i][j] >= 1 &&  readArray.getArray()[i][j] <= 9)
      				isFilled[i][j] = true;
      			else
      				isFilled[i][j] = false;
        		 }	 
        	 }
        
        String str;
        Scanner s = new Scanner(System.in);
        
        System.out.println(board.toString());
        
       //Prompting the user for an input
        System.out.println("Fill in the Sudoku in the format \"d4:5\" which indicates that in field d3 should go a 5.");
        
        str = s.next(); //assigning the next input from the user to the variable str
       
        while(!str.contentEquals("exit")){
             	
        	if(str.contentEquals("reset")){
        		for(int i = 0; i < readArray.getArray().length; i++)
        			for(int j = 0; j < readArray.getArray().length; j++)
        				board.getArray()[i][j] = readArray2.getArray()[i][j];
        	}   
        	
        	if(str.contains(":")){
        	int i = str.charAt(0) - 'a';
        	int j = str.charAt(1) - (int) '0';
        	int input = str.charAt(3) - (int) '0';
        	
        	if(isFilled[i][j] == false)
        		board.getArray()[i][j] = input;
        	}
        	System.out.println(board.toString());
        	
        	//System.out.println(Arrays.deepToString(arr));
                	
        	str = s.next(); 
        }
        s.close();
        
        }
	
	/** This method take the row number that is required to be printed and prints it in the correct format
	 * using a for loop and an if else statement.
	 * @param a is the number of the row that we would like to print
	 * @return row which is the row we have just printed
	 */
	public String rowNumber(int a){ 
		
		String row = ""; //Initialising the row to be an empty sting
		
		// for each column in the row do the do the following:
		for(int column = 0; column < 9; column++){ 
			if(column % 3 == 0) //if the column number is divisible by 3 do the following:
				// add to the String row "|| " followed by the element of the array at [a][column] followed by a space
				if(getArray()[a][column] == 0)
					row += "|| " +"  ";
				else
					if(checkArray[a][column] != 0)
					row += "||*" + getArray()[a][column] + "*";
					else
						row += "|| " + getArray()[a][column] + " ";
				 
			else //otherwise do the following:
				// add to the String row "| " followed by the element of the array at [a][column] followed by a space
				if(getArray()[a][column] == 0)
					row += "| " + "  ";
				else
					if(checkArray[a][column] != 0)
					row += "|*" + getArray()[a][column] + "*";
					else
						row += "| " + getArray()[a][column] + " ";
				 
		}
		
		row += "||"; //At the end of each row, add a "||"
		
		return row; //return the resulting String
	}
	
	/** This method pieces together the three methods; outBorders (from Sudoku), inBorders (from Sudoku) and rowNumber
	 * to print the Sudoku in the correct format.
	 * @return sudoku as a String
	 */
	public String allTogether(){ 
		
		String sudoku = ""; //Initialising an empty String, sudoku.
		
		for(int i = 0; i < getArray().length; i++){ // For each row of the array, do the following: 
			
			if(i % 3 == 0) // if the row number i divisible by 3, do the following:
				// add to the String sudoku the outBorders method followed by a new line followed 
				// by the rowNumber method (for row i) followed by a new line.
				sudoku += Sudoku.outBorders() + "\n" + rowNumber(i) + "\n"; 
			else // otherwise do the following:
				// add to the String sudoku the inBorders method followed by a new line followed 
				// by the rowNumber method (for row i) followed by a new line.
				sudoku += Sudoku.inBorders() + "\n" + rowNumber(i) + "\n";
		}
		sudoku = sudoku + Sudoku.outBorders(); //add an outside border to the last line of the sudoku
		return sudoku; //return the resulting String.	
	}
		
	// This toString method will return the allTogether method which will print the Sudoku in the required format
	public String toString(){
		return allTogether(); 
	
	
    }
	
	public static void main(String[] args) {
		try {
			play("testFile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
