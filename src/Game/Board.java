package Game;

import java.util.ArrayList;

public class Board {
	
    private char[][] board; 
    private char currentPlayer;
    
    //ArrayList for tracking player choices
    static ArrayList<Integer> playerXPos = new ArrayList<Integer>();
	static ArrayList<Integer> playerOPos = new ArrayList<Integer>();
	
	   /**
     * This is the constructor for the class. It initializes the board so all cells in the board are equal to '-'. The currentPlayer 
     * is initialized to 'x'.
     *
     */
     public Board() {
        
        /*
        board will look as follows
        {{'-', ' ', '-', ' ', '-'},
		   {'-', ' ', '-', ' ', '-'},
		   {'-', ' ', '-', ' ', '-'}};
        */
        
        board = new char [3][5];
        for(int i=0; i<3; i++) {
           for(int j=0; j<5; j++) {
              if (j%2 != 0) 
              board[i][j] = ' ';
              else
              board[i][j] = '-';
            }
         }
         currentPlayer = 'x';


     }
	
	  /**
     * The method outputs the board in the following format. First the message "Current board" underligned is printed. 
     * Then the content of the board is printed as a 3 by 3 matrix.
     */
     public void print() {
        System.out.println("Current Board");
		  System.out.println("-------------");
		  
		  //for any character existing in board print that character out
		  for(char[] row : board) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
       
     }
	
	  /**
     * The method checks if all the positions on the board have been played.
     *
     * @return true if all the cells in the board are different than '-', false otherwise.
     */
     public boolean isFull() {
        for(int i=0; i<3; i++) {
           for(int j=0; j<5; j++) {
              if (j%2 == 0) {
              //Compare elements and if '-' exists in the board then return false
              if(board[i][j] == '-')
              return false;
              }
           }
        }
        return true;
     }
	
	  /**
     * The method checks if there is a winner.
     *
     * @return true if either a column, a row or a diagonal is filled by the same character and the character is different than '-',
     * false otherwise.
     */
     public boolean isWin() {
        
		if(checkRows()==true || checkColumns()==true || checkDiagonals()==true) {
		   return true;
		}
		else {
		   return false;
		}
	  }
    
	  /**
     * The method checks if at least one row is occupied by the same player.
     *
     * @return true if any row is filled by the same character and the character is different than '-',
     * false otherwise.
     */
     private boolean checkRows() {
        
        for(int i = 0; i < 3; i++) {
         int count = 0;
            for(int j = 0; j < 5; j++) {
               //Comparing elements and if currentPlayer occupies a position in row increment the count for that row. Once count is 3 return true
               if (j%2 == 0) {
               if(board[i][j] == currentPlayer)
                  count++;
             }
            }
               if(count == 3)
               return true;
            }
            return false;
           
      }
     
	 
	  /**
     * The method checks if at least one column is occupied by the same player.
     *
     * @return true if any column is filled by the same character and the character is different than '-',
     * false otherwise.
     */
     private boolean checkColumns() {
      
        for(int i=0; i<5; i++) {
           if (i%2 == 0) {
           int count =0;
           for(int j=0; j<3; j++) {
               //Comparing elements and if currentPlayer occupies a position in row increment the count for that row. Once count is 3 return true
              if(board[j][i] == currentPlayer)
              count++;
           }
           if(count == 3)
           return true;
           }
        }
        return false;
       
     }
	
	  /**
     * The method checks if at least one diagonal is occupied by the same player.
     *
     * @return true if any diagonal is filled by the same character and the character is different than '-',
     * false otherwise.
     */
     private boolean checkDiagonals() {
        
        //Check if currentPlayer occupies one of two specified sequences of diagnol positions. If so return true
        if ((board[0][0] == currentPlayer && board[1][2] == currentPlayer && board[2][4] == currentPlayer) ||
(board[0][4] == currentPlayer && board[1][2] == currentPlayer && board[2][0] == currentPlayer))
        return true;
        else
        return false;
}


     
     /**
     * The method changes the currentPlayer. If the currentPlayer is 'x', it changes to 'o'.  
     * If the currentPlayer is 'o', it changes to 'x'. 
     *
     */
     public void changePlayer() {
        //Check currentPlayer and swicth to the opposing player
        if(currentPlayer == 'x'){
           currentPlayer = 'o';
        }
        else {
           currentPlayer = 'x';
        }
     }

     
	  /**
     * The method attempts to set the cell on the position indicated by the row and column given to the currentPlayer value if
     * the cell is unoccupied (equal to '-') in which case returns true. If the position is occupied (not equal to '-') the cell
     * remains unchanged and the method returns false.
     * 
     * EDIT: 
     * The method attempts to set check the cell on the position chosen by the currentPlayer. If the position does not exist in
     * playerOPos or playerXPos ArrayList, then the cell is unoccupied (equal to '-') in which case returns true. If the position
     * is occupied (not equal to '-') then the position chosen by currentPlayer should not exist in either playerOPos or playerXPos 
     * ArrayList. In this case, the cell will remain unchanged, this method will return false, and currentPlayer will be prompted
     * for another choice in the main method
     * 
     *
     */
     public boolean checkRowCol(int pos) {
		   //Check if position already exists
         if(playerOPos.contains(pos) || playerXPos.contains(pos)) {
            
            return false;
         }
         else {
            return true;
         }
     }
     
     /**
     * The method changes the sets the row and col of currentPlayer by taking their chosen position and assigning it on the board 
     * via a switch. The position chosen should be added to the currentPlayer ArrayList and the currentPlayer symbol should be assigned
     * to the appropiate cell.
     * 
     * board positions are assigned as follows:
        {{'1', ' ', '2', ' ', '3'},
		   {'4', ' ', '5', ' ', '6'},
		   {'7', ' ', '8', ' ', '9'}};  
     *
     */
     
     public void switchCase (int position, char player){
         char symbol = ' ';
         if (player == 'x') {
         playerXPos.add(position);
			symbol = 'x';
			
			
		} else if (player == 'o') {
		   playerOPos.add(position);
			symbol = 'o';
			
		}
		switch(position) {
		case 1: board [0][0] = symbol;
		break;
		case 2: board [0][2] = symbol;
		break;
		case 3: board [0][4] = symbol;
		break;
		case 4: board [1][0] = symbol;
		break;
		case 5: board [1][2] = symbol;
		break;
		case 6: board [1][4] = symbol;
		break;
		case 7: board [2][0] = symbol;
		break;
		case 8: board [2][2] = symbol;
		break;
		case 9: board [2][4] = symbol;
		break;
		default: break;
		}
         
      }
}

