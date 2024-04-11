package game.forest;

import java.util.Random;

public class Forest {
	
	
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	

    public  static char[][] generateRandomArray(int rows, int cols, double probabilityF) {
        char[][] array = new char[rows][cols];
        Random random = new Random();
        
       
        // total tree in forest
        // IF 30% is some decimal number the rounding according to reminder
        int numT =  ((rows* cols *30)%100 > 70)? (rows* cols *30/100)+1  :  rows* cols *30/100;
        
        
        // total empty space in forest
        int numDot = rows* cols - numT;
        
        // is person placed in forest
        boolean putP = true;
        
        // calculate the placed range of person for different dimension of forest
        double[] placedRange = calculatedPlacedPersonRange(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            	    double rnum = random.nextDouble();
                if ( rnum < probabilityF &&  numDot>0) {
                	
                	// put person when it is in between 0.4 to 0.6
                	if(putP  && (( rnum >= placedRange[0] && rnum <= placedRange[1] ) || numDot == 1) ){
                		array[i][j] = 'P';
                        numDot--;
                        putP = false;
                	}else {
                		array[i][j] = '.';
                        numDot--;
                	}
                    
                } else if(numT> 0){
                    array[i][j] = 'T';
                    numT--;
                }else {
                	if(putP  && (( rnum >= placedRange[0] && rnum <= placedRange[1] ) || numDot == 1) ){
                		array[i][j] = 'P';
                        numDot--;
                        putP = false;
                	}else {
                		array[i][j] = '.';
                        numDot--;
                	}
                }
            }
        }

        return array;
    }
    
    public static double[] calculatedPlacedPersonRange(int row, int col) {
    	    // reduce the placed range of placing person, form median of probability
    	
    	double  coeffi=0.7;
    	   if(col >= 10 && col<= 100) {
    		     // reducing the range with a variable coefficient of range 
    		   coeffi = 0.7;
    	   }
    	   if(col >= 1000) {
    		    coeffi = 0.7;
    	   }
    	 double  lowerRange = 0.35-coeffi/(col*row); 
    	 double uperRange = 0.35+coeffi/(col*row);
    	   
    	   return new double[]{lowerRange, uperRange};
    }

    public static char[][] generateForest(int rows, int cols) {
        
        double probabilityF = 0.7;

        return generateRandomArray(rows, cols, probabilityF);

       
    }
    
    public static void displayForest(char[][] forestArr) {
    	
    	   int rows = forestArr.length;
    	   int cols = forestArr[0].length;
    			   
    	 System.out.println("Person in Forest Map:");
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < cols; j++) {
            	 if(forestArr[i][j] == 'P') {
            		 System.out.print(ANSI_RED + forestArr[i][j]+ " " +ANSI_RESET);
            	 }else if(forestArr[i][j] == 'T') {
            		 System.out.print(ANSI_GREEN + forestArr[i][j]+ " " +ANSI_RESET);
            	 }else{
                 System.out.print( forestArr[i][j]+ " ");
            	 }
             }
             System.out.println();
         }
    }
}

