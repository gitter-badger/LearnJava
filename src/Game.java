import java.util.Scanner;

public class Game {
    private int[] board = new int[9]; //СОздаем доску 3х3, массив нумерует ячейки с верхней левой, 0-8.
    public int moves = 1; // Число ходов. Проверка победы с 5, ничья при 9.
    public String playerOneName; //Имя первого игрока
    public String playerTwoName; //Имя второго игрока
    public int whoMoves = 1; // Номер игрока, который ходит. Если ходят крестики, 1, иначе 2.
    // Эти же значения пишутся в ячейки доски. При успешной проверке на победу, этой переменной определяем победителя.

    //Возвращает значение ячейки по ее индексу
    public int getBoard(int i) {
        return board[i];
    }

    //Пишем в указанную ячейку значение в соответствии с тем, какой игрок ходит. Если уже занято, ругаемся.
    public boolean setBoard(int i, int whoMoves) {
        if(board[i] != 0){
            System.out.println("Ячейка занята");
            return false;
        }
        board[i] = whoMoves;
        return true;
    }

    //Cпрашиваем имена игроков и записывает их.
    public void nameSetup() {
        Scanner scan = new Scanner(System.in);
        playerOneName = scan.next("Имя игрока за крестики:");
        if(playerOneName.length() == 0){playerOneName = "Крестики";}
        playerTwoName = scan.next("Имя игрока за нолики:");
        if(playerTwoName.length() == 0){playerTwoName = "Нолики";}
    }

    // Игровой процесс
    public void game(){
        while(moves < 10){ // Пока не получим подтверждение победы или не кончатся ходы
            setBoard((int)Helper.getUserInput(whoMoves), whoMoves); // Спросим ход и запишем его на доску
            if(Helper.checkWin == true){break;} // Проверим условия победы. Если true, выйдем из цикла к результатам.
            // Поменяем текущего игрока.
            // Прибавим число ходов.
        }
    }
}
