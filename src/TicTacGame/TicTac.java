package TicTacGame;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class TicTac {
    static String[] board;
    static  String turn;
    private static String checkWinner()
    {

        for(int i=0;i<8;i++)
        {
            String line="";
            switch (i)
            {
                case 0:
                    line=board[0]+board[1]+board[2];
                    break;
                case 1:
                    line=board[3]+board[4]+board[5];
                    break;
                case 2:
                    line=board[6]+board[7]+board[8];
                    break;
                case 3:
                    line=board[0]+board[3]+board[6];
                    break;
                case 4:
                    line=board[1]+board[4]+board[7];
                    break;
                case 5:
                    line=board[2]+board[5]+board[8];
                    break;
                case 6:
                    line=board[0]+board[4]+board[8];
                    break;
                case 7:
                    line=board[2]+board[4]+board[6];
                    break;
            }
            if (line.equals("XXX"))
                return "X";
            else if (line.equals("OOO"))
                return "O";
        }
        for (int i=0;i<9;i++)
        {
            if(Arrays.asList(board).contains(String.valueOf(i+1)))
                break;
            else if (i==8)
                return "draw";
        }
        System.out.println(turn+"'s turn:"+"enter position");
        return null;
    }
    private  static void printBoard()
    {

        System.out.println(board[0]+"   "+board[1]+"    " +board[2]);

        System.out.println(board[3]+"   "+board[4]+"    " +board[5]);

        System.out.println(board[6]+"   "+board[7]+"    " +board[8]);


    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("welcome to tic tac toe game....");
        board=new String[9];
        for (int i=0;i<9;i++)
        {
            board[i]=String.valueOf(i+1);
        }
        printBoard();
        turn="X";
        System.out.println("X's turn enter your set position");
        String winner=null;
        while (winner==null)
        {
            int position;
            try {
                position = scanner.nextInt();
                if (!(position>0&&position<=9)) {
                    System.out.println("invalid position..please enter position");
                    continue;
                }
             }
            catch (InputMismatchException e)
            {
                System.out.println("enter valid input...");
                continue;
            }
            if (board[position-1].equals(String.valueOf(position)))
            {
                board[position-1]=turn;
                if (turn.equals("X"))
                    turn="O";
                else
                    turn="X";

                printBoard();
                winner=checkWinner();
            }
            else{
                System.out.println("enter position is already taken....so enter your position again");
            }

        }

        if(winner.equalsIgnoreCase("draw"))
        {
            System.out.println("Thanks for playing...it's draw");
            return;
        }
            System.out.println("congratulation!" + winner+"'s winning...");

    }
}
