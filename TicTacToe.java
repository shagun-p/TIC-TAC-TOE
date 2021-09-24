package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicToeToe {
	
	static ArrayList<Integer> playerpositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpupositions = new ArrayList<Integer>();

	public static void main(String[] args) {
				
		        char [][] gameBoard = {{' ' , '|' , ' ' , '|' , ' '} ,
		        		{'-' , '+' , '-' , '+' , '-'},
		        		{' ' , '|' , ' ' , '|' , ' '},
		        		{'-' , '+' , '-' , '+' , '-'},
		        		{' ' , '|' , ' ' , '|' , ' '}};
		    printGameBoard(gameBoard);   
		    
		    Scanner scan = new Scanner (System.in);
		    while(true) {
		    	
		    	System.out.println("Enter Your Placements (1-9):");
			    int playerPosition = scan.nextInt();
			    while(playerpositions.contains(playerPosition) || cpupositions.contains(playerPosition ))
			    {
			    System.out.println("position taken!! Enter a correct placement");
			    playerPosition=scan.nextInt();
			    }		
			    
			    placepiece(gameBoard , playerPosition , "player");
			    
			    String result = checkWinner();
			    if(result.length() > 0) {
			    	System.out.println(result);
			    	break;
			    }

			    Random rand = new Random();
			    int cpuPosition = rand.nextInt(9) + 1;
			    
			    while(playerpositions.contains(cpuPosition) || cpupositions.contains(cpuPosition ))
			    {		   
			            cpuPosition = rand.nextInt(9) + 1;
			    }
			    placepiece(gameBoard , cpuPosition , "cpu");
			    
			    printGameBoard(gameBoard);
			    
			    result = checkWinner();
			    if(result.length() > 0) {
			    	System.out.println(result);
			    	break;
			    }
			     
		    }
	}    
		    
		   	public static void printGameBoard(char[][] gameBoard) {
				 for(char[] row : gameBoard) {
			        	for(char c : row) {
			        		System.out.print(c);
			        	}
			        	System.out.println();
			        }
			}
			public static void placepiece(char [][] gameBoard , int playerPosition , String user) {
				
				char symbol = ' ';				
				if(user.equals("player")) {
					symbol='X';
					playerpositions.add(playerPosition);
				} else if(user.equals("cpu")) {
					symbol = '0';
					cpupositions.add(playerPosition);
				}
				
				switch(playerPosition) {
			    case 1: 
			    	gameBoard[0][0] = symbol;
			    	break;
			    case 2:
			    	gameBoard[0][2] = symbol;
			    	break;
			    case 3:
			    	gameBoard[0][4] = symbol;
			    	break;
			    case 4:
			    	gameBoard[2][0] = symbol;
			    	break;
			    case 5:
			    	gameBoard[2][2] = symbol;
			    	break;
			    case 6:
			    	gameBoard[2][4] = symbol;
			    	break;
			    case 7:
			    	gameBoard[4][0] = symbol;
			    	break;
			    case 8:
			    	gameBoard[4][2] = symbol;
			    	break;
			    case 9:
			    	gameBoard[4][4] = symbol;
			    	break;
			    default:
			    	break;
			    }
			}
		public static String checkWinner() {
			
			List toprow=Arrays.asList(1 , 2 , 3);
			List midrow=Arrays.asList(4 , 5 ,6);
			List botrow=Arrays.asList(7 , 8 , 9);
			List leftcol=Arrays.asList(1 , 4 , 7);
			List midcol=Arrays.asList(2 , 5 ,8);
			List rightcol=Arrays.asList(3 , 6 , 9);
			List cross1=Arrays.asList(1 , 5 ,9);
			List cross2=Arrays.asList(7 , 5 , 3);
			
			List<List> winning = new ArrayList<List>();
			winning.add(toprow);
			winning.add(midrow);
			winning.add(botrow);
			winning.add(leftcol);
			winning.add(midcol);
			winning.add(rightcol);
			winning.add(cross1);
			winning.add(cross2);
			
			for(List l : winning) {
				if(playerpositions.containsAll(l)) {
					return "Congratulations you won!!";
				}else if(cpupositions.contains(l)) {
					return " cpu wins!! sorry!:)";
				}else if(playerpositions.size() + cpupositions.size()== 9) {
					return "Cat!";
				}
			}
			
			return "";
		}
}
