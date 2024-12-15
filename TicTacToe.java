import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        char[][] board=new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
        char player='X';
        boolean gameOver=false;
        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+player+" enter: ");
            int row=in.nextInt();
            int col=in.nextInt();
            if(board[row][col]==' '){
                //place the element
                board[row][col]=player;
                gameOver=haveWon(board,player);
                if(gameOver)
                    System.out.println("Player "+player+" has won");
                else{
                    if(player=='X'){
                        player='O';
                    }else player='X';
                }
            }else System.out.println("Invalid move try again");
        }
        printBoard(board);
    }

    private static boolean haveWon(char[][] board, char player) {
        for (char[] chars : board) {
            if (chars[0] == player && chars[1] == player && chars[2] == player)
                return true;
        }
        for(int col=0;col<board[0].length;col++){
            if(board[0][col]==player&&board[1][col]==player&&board[2][col]==player)
                return true;
        }
       if(board[0][0]==player&&board[1][1]==player&&board[2][2]==player)
           return true;
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    private static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " | ");
            }
            System.out.println();
        }
    }
}
