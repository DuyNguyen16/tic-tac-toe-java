import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
    // set up the board
    String[][] board = {{"_", "_", "_"}, {"_","_", "_"}, {"_", "_", "_"}};

    // to read the user input
    Scanner readInput = new Scanner(System.in);

    // check if the current player is player 1
    boolean isPlayer1 = true;

    // clean the terminal
    System.out.print("\033[H\033[2J");
    System.out.flush();

    // display the board
    buildBoard(board);

    // run the game while there is no winner
    while (true) {
      // player input for row
      int row_read;

      // player input for column
      int column_read;

      // check who is the current player
      if (isPlayer1) {
        // while the input is invalid
        while (true) {
          // ask the player for the row
          System.out.print("Player 1 enter row number:");
          row_read =  readInput.nextInt();
          
          // ask the player for the column
          System.out.print("Player 1 enter column number:");
          column_read =  readInput.nextInt();

          // end the loop if the inputs are valid
          if (board[row_read - 1][column_read - 1] == "_") {
            break;
          }
        }
        
        board[row_read - 1][column_read - 1] = "X";
        
        isPlayer1 = !isPlayer1;
      } else {
        while (true) {
          System.out.print("Player 2 enter row number:");
          row_read =  readInput.nextInt();
        
          System.out.print("Player 2 enter column number:");
          column_read =  readInput.nextInt();

          if (board[row_read - 1][column_read - 1] == "_") {
            break;
          }
        }
        
        board[row_read - 1][column_read - 1] = "O";
  
        isPlayer1 = !isPlayer1;

      }
      System.out.print("\033[H\033[2J");
      System.out.flush();
      buildBoard(board);      

      if (winner(board)) {
        if (!isPlayer1) {
          System.out.println("Player 1 win!");
          break;
        } else {
          System.out.println("Player 2 win!");
          break;
        }
      };
    }

    readInput.close();
  }

  static void buildBoard(String[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int y = 0; y < board.length; y++) {
        if (y == 1 || y == 2) {
          System.out.print("|");
        }
        System.out.print(board[i][y]);
      }
      System.out.println();
    }
  }

  static boolean winner(String[][] board) {
    //  check horizontally
    if ((board[0][0] == board[0][1] && board[0][1] == board[0][2]) && board[0][0] != "_") {
      return true;
    } else if ((board[1][0] == board[1][1] && board[1][1] == board[1][2]) && board[1][0] != "_") {
      return true;
    } else if ((board[2][0] == board[2][1] && board[2][1] == board[2][2]) && board[2][0] != "_") {
      return true;
    }

    // check vertically
    if ((board[0][0] == board[1][0] && board[1][0] == board[2][0]) && board[0][0] != "_") {
      return true;
    } else if ((board[0][1] == board[1][1] && board[1][1] == board[2][1]) && board[0][1] != "_") {
      return true;
    } else if ((board[0][2] == board[1][2] && board[1][2] == board[2][2]) && board[0][2] != "_") {
      return true;
    }

    // check diagonally

    if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) && board[0][0] != "_") {
      return true;
    } else if ((board[0][2] == board[1][1] && board[1][1] == board[2][0]) && board[0][2] != "_") {
      return true;
    }

    return false;
  }
}


