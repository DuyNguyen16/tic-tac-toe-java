import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
    String[][] board = {{"_", "_", "_"}, {"_","_", "_"}, {"_", "_", "_"}};

    Scanner readInput = new Scanner(System.in);

    boolean isPlayer1 = true;

    System.out.print("\033[H\033[2J");
    System.out.flush();
    buildBoard(board);

    while (true) {
      int row_read;
      int column_read;
      if (isPlayer1) {
        while (true) {
          System.out.print("Player 1 enter row number:");
          row_read =  readInput.nextInt();
        
          System.out.print("Player 1 enter column number:");
          column_read =  readInput.nextInt();

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


}


