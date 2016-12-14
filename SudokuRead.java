import java.io.*;
import java.util.Arrays;

/** This class will read in a potentially only partially filled Sudoku from a file
 * and throw exceptions if there are illegal arguments or if the file is not found
 * @author Dhanish Ashraf
 *
 */
public class SudokuRead { 
	
	/** This method will read in the file "fileName" and check the inputs
	 * @param fileName is the name of the file to be read
	 * @return array
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	public static Sudoku readSudoku(String fileName) throws IllegalArgumentException, IOException { 
		
		
            String readString; // Initialising a String readString
            int [][] arr = new int[9][9]; //Creating a new 9x9 array
            Sudoku array = new Sudoku(arr);
             

            //Creating a buffered to read the file "fileName"
            BufferedReader in = 
                new BufferedReader(new FileReader(fileName));
            
            int counter = 0;
            while (counter < 9) { //Whilst the counter is less than 9, do the following:
            	
            	readString = in.readLine(); 
            	            	
            		 for(int j = 0; j < 9; j++){
            		
            			 int intElement = readString.charAt(j) - (int) '0'; //Converting the chars to integers
            			 if(intElement == -16) 
            				 intElement = 0;	
            			 
            		 // for each line of readString, if the character at i is greater than 9 or less than 9
            		 if( intElement > 9 || intElement < 0) { //throw an IllegalArgument exception
            			 throw new IllegalArgumentException("Values must be between 1 and 9 inclusively");
            		 }
            			 
            		arr[counter][j] = intElement; 
            		           	
            		 }
         
            		 counter++;	   
            }
            
            in.close(); //close the buffered reader
                     
          return array; //return the resulting array
         
        }

}
