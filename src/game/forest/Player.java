package game.forest;

public class Player {
     
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
	    
	 public static char[][] movePlayer(char[][] forest, char direction) {
		  
		 
		 // identify the location coordinate of P in 2D array forest
		 int rows = forest.length;
		  int cols = forest[0].length;

		  int rowLoc=-1;
		  int colLoc=-1;
		  for (int i = 0; i < rows; i++) {
		    for (int j = 0; j < cols; j++) {
		      if (forest[i][j] == 'P') {
		          rowLoc = i;
		          colLoc=j;
		          break;
		      }
		      if(rowLoc != -1) {
		    	  break;
		      }
		    }
		  }
		  
		  
		  
		  
		  if(direction == 'W' ) {
			  rowLoc--;
			   if(isValidMove(forest, rowLoc, colLoc)) {
				      forest[rowLoc][colLoc]='P';
				      forest[rowLoc+1][colLoc]='.';
				      System.out.println(ANSI_GREEN+ "Person moved one stap upper side. "+ANSI_RESET);
			   }else {
				   System.out.println(" Upper Side " +ANSI_RESET);
			   }
		  }else if(direction == 'S') {
			  rowLoc++;
			  if(isValidMove(forest, rowLoc, colLoc)) {
				  forest[rowLoc][colLoc]='P';
			      forest[rowLoc-1][colLoc]='.';
			      System.out.println(ANSI_GREEN+ "Person moved one stap down side. "+ANSI_RESET);
			   }else {
				   System.out.println(" Down Side "+ANSI_RESET);
			   }
		  }else if(direction == 'A') {
			  colLoc--;
			  if(isValidMove(forest, rowLoc, colLoc)) {
				  forest[rowLoc][colLoc]='P';
			      forest[rowLoc][colLoc+1]='.';
			      System.out.println(ANSI_GREEN+ "Person moved one stap left side. "+ANSI_RESET);
			   }else {
				   System.out.println(" Left Side "+ANSI_RESET);
			   }
		  }else {
			  colLoc++;
			  if(isValidMove(forest, rowLoc, colLoc)) {
				  forest[rowLoc][colLoc]='P';
			      forest[rowLoc][colLoc-1]='.';
			      System.out.println(ANSI_GREEN+ "Person moved one stap right side. "+ANSI_RESET);
			   }else {
				   System.out.println(" Right Side "+ANSI_RESET);
			   }
		  }
		  
		
		  return forest;
		  
	 }
	 
	 
	  
     // move is valid or not
	 public static boolean isValidMove(char[][] forest, int row, int col) {
		 
		 // should not move out side of forest boundary
		  if(row>forest.length-1 || row< 0 || col > forest[0].length-1 || col < 0) {
			   System.out.print(ANSI_RED+ "!Oops, person cannot move Outside forset bountry at");
			   return false;
		  }else if(forest[row][col] == 'T') {
			  System.out.print(ANSI_RED + "!Oops, person cannot move, there is tree at");
			  return false;
		  }
		 
		 return true;
	 }
}
