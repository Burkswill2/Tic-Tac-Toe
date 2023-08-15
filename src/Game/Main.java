package Game;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);

	      
	      //Declare object for Board.java and print
	      Board boardObject = new Board();
	      boardObject.print();
	      
	      //game begins with char x
	      char player = 'x';
	      int posX, posO;
	      
	      //Continue play while true
	      while (true) {
	         
	         //Prompt player for a position
	         System.out.print(player + " player: Enter position number (1 - 9): ");
	         posX = sc.nextInt();
	         
	         //Check position that it is in range and non occupied
	         while (posX < 1 || posX > 9) {
	            System.out.print("Out of range. Try again!\nEnter position number (1-9): ");
	            posX = sc.nextInt();
	         }
	         while(boardObject.checkRowCol(posX) == false) {
	            System.out.print("Incorrect cell. Try again!\nEnter position number (1-9): ");
	            posX = sc.nextInt();
	            while (posX < 1 || posX > 9) {
	               System.out.print("Out of range. Try again!\nEnter position number (1-9): ");
	               posX = sc.nextInt();
	            }
	         }
	         
	         //set player col and row via switch method
	         boardObject.switchCase(posX, player);
	         
	         
	       
	         //Display board
	         boardObject.print();
	         
	         //Check for a winner and if true declare winner and end game
	         if(boardObject.isWin()) {
	            System.out.println("x player wins!");
	            break;
	         }
	         
	         //Check for full and if true declare tie and end game
	         if(boardObject.isFull()) {
	            System.out.println("Tie...");
	            break;
	         }
	         
	         //Change player
	         boardObject.changePlayer();
	         player = 'o';

	         //Play for player o
	         System.out.print(player + " player: Enter position number (1 - 9): ");
	         posO = sc.nextInt();
	         
	         //Check position that it is in range and non occupied
	         while (posO < 1 || posO > 9) {
	            System.out.print("Out of range. Try again!\nEnter position number (1-9): ");
	            posO = sc.nextInt();
	         }
	         while(boardObject.checkRowCol(posO) == false || posO < 1 || posO > 9) {
	            System.out.print("Incorrect cell. Try again!\nEnter position number (1-9): ");
	            posO = sc.nextInt();
	            while (posO < 1 || posO > 9) {
	               System.out.print("Out of range. Try again!\nEnter position number (1-9): ");
	               posO = sc.nextInt();
	            }
	         }
	         
	         //set player col and row via switch method
	         boardObject.switchCase(posO, player);
	         

	         //Display board
	         boardObject.print();

	         //Check for a winner and if true declare winner and end game
	         if(boardObject.isWin()) {
	            System.out.println("o player wins!");
	            break;
	         }

	         //Check for full and if true declare tie and end game
	         if(boardObject.isFull()) {
	            System.out.println("Tie...");
	            break;
	         }
	         //Change player
	         boardObject.changePlayer();
	         player = 'x';

	      }
	      System.out.println("Goodbye!");
	      sc.close();
	      
	      
	   }

}
