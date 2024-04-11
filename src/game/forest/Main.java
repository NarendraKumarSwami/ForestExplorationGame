package game.forest;

import java.util.Scanner;

public class Main {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
	public static char[][] forestArr;
	
	
	public static void main(String[] args) {
		
		
		// generate the forest 
		       
		         boolean flag = true;
		         
		         
		         Scanner sc = new Scanner(System.in); 
		         
		         int length=0;
		         
		         int width=0;
		         
		         while(flag) {
		        	 System.out.println("Enter the length of forest in integer");
				       
				       length = sc.nextInt();
				       
				       System.out.println("Enter the width of forest in integer");
				       
				       width = sc.nextInt();
				       
//				       minimum height and with should be >=2
				       if(width >= 1 && length>= 1) {
				    	     flag = false;
				    	     System.out.println("Generating the Forest Map...");
				       }else {
				    	   System.out.println("Please enter the correct dimension of forest in integer"
				    	   		+ " (length and width of Map should be greater equal to 1)"
				    	   		+ "\nStart Again");
				    	  
				       } 
		         }
		       
		         
		       
		      
		       
		        forestArr =   Forest.generateForest(length, width);
		       
		       
		       
		        Forest.displayForest(forestArr);
		       
		        
		        // Move the Player in Forest
		        System.out.println("Rules for moving player in Forest by typing\n"
		        		+ "'W' for moving up\n"
		        		+ "or 'S' for moving down\n"
		        		+ "or 'A' for moving left\n"
		        		+ "or 'D' for moving right\n"
		        		+ "and press enter");
		        
		        flag = true;
		        
		        while(flag) {
		        	 System.out.println("Enter the move");
		        	 char direction = sc.next().toCharArray()[0];
		        	 switch (direction) {
					case 'W': {
						Player.movePlayer(forestArr, 'W');
						break;
					}
					case 'S': {
						Player.movePlayer(forestArr, 'S');
						break;
					}
					case 'A': {
						Player.movePlayer(forestArr, 'A');
						break;
					}
					case 'D': {
						Player.movePlayer(forestArr, 'D');
						break;
					}
					default:
						System.out.println(ANSI_RED+"Unexpected value: " + direction +ANSI_RESET);
						
					}
		        	 
		        	 Forest.displayForest(forestArr);
		        	
		           System.out.println("Want to move next enter true or if you want to exit enter false");
		           
		           
		           flag = sc.nextBoolean();
		        	 
		        	 
		        	 
		        }
		       
		       
		       
		       System.out.println(ANSI_RED+"Game is Ended !"+ANSI_RESET);
		       
		       
		       
	}
}
