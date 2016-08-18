final class Helper {
    // Проверяем, достигнуто ли одно из условий победы
    static boolean checkWin(int[] board){
        boolean weHaveAWinner = false;
        if((board[0] == board[1] && board[0]== board[2]) || (board[3] == board[4] && board[3]== board[5]) || (board[6] == board[7] && board[6]== board[8]) || (board[0] == board[3] && board[0]== board[6]) || (board[1] == board[4] && board[1]== board[7]) || (board[2] == board[5] && board[2]== board[8]) || (board[0] == board[4] && board[0]== board[8]) || (board[2] == board[4] && board[2]== board[6])){
            weHaveAWinner = true;
        }
        return weHaveAWinner;
    }
}
