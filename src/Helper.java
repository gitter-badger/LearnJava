import java.util.Scanner;

public final class Helper {

    // Проверяем, достигнуто ли одно из условий победы
    public static boolean checkWin(int[] board){
        boolean weHaveAWinner = false;
        if(board[0] == board[1] && board[0]== board[2]){
            weHaveAWinner = true;
        }
        return weHaveAWinner;
    }
}
