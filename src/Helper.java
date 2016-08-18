import java.util.Scanner;

public final class Helper {

    // Юзер вводит номер ячейки, куда ходит
    public static int getUserInput(int playerNumber){
        int inputLine; // Должны получить номер ячейки
        String playerName = playerNumber == 1 ? Game.playerOneName : Game.playerTwoName;
        System.out.print("Ваш ход, " + playerName);
        Scanner scan = new Scanner(System.in);
        inputLine = scan.nextInt();
        // Тут надо сделать как-то проверку, что пришло ожидаемое
        scan.close();
        return inputLine;
    }

    // Проверяем, достигнуто ли одно из условий победы
    public static boolean checkWin(int[] board){
        boolean weHaveAWinner = false;
        if(board[0] == board[1] && board[0]== board[2]){
            weHaveAWinner = true;
        }
        return weHaveAWinner;
    }
}
