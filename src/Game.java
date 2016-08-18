import java.util.Scanner;

class Game {
    private int[] board = new int[9]; //Создаем доску 3х3, массив нумерует ячейки с верхней левой, 0-8.
    private int moves = 1; // Число ходов. Проверку победы имеет смысл делать с 5, ничья при 9.
    static String playerOneName; //Имя первого игрока
    static String playerTwoName; //Имя второго игрока
    private int whoMoves = 1; // Номер игрока, который ходит. Если ходят крестики, 1, иначе 2.
    // Эти же значения пишутся в ячейки доски. При успешной проверке на победу, этой переменной определяем победителя.

    // Спрашивает имена игроков и записывает их.
   Game() {
       Scanner scan = new Scanner(System.in);
       System.out.println("Имя игрока за крестики:");
       playerOneName = scan.nextLine();
       if(playerOneName.length() == 0){playerOneName = "Крестики";}
       System.out.println("Имя игрока за нолики:");
       playerTwoName = scan.nextLine();
       if(playerTwoName.length() == 0){playerTwoName = "Нолики";}
       scan.close();
    }

    //Возвращает значение ячейки по ее индексу
    public int getBoard(int i) {
        return board[i];
    }

    //Пишем в указанную ячейку значение в соответствии с тем, какой игрок ходит. Если уже занято, ругаемся.
    private boolean setBoard(int i, int whoMoves) {
        if(board[i] != 0){
            System.out.println("Ячейка занята");
            return false;
        }
        board[i] = whoMoves;
        return true;
    }

    // Игровой процесс
    public void play(){
        String winner = "Draw!";
        while(moves < 10){ // Пока не получим подтверждение победы или не кончатся ходы
            setBoard(Helper.getUserInput(whoMoves), whoMoves); // Спросим ход и запишем его на доску
            if(Helper.checkWin(board)){ // Нет ли победителя?
                winner = "We have a winner! And it is ";
                winner += whoMoves == 2 ? playerOneName : playerTwoName;
                break;
            } // Проверим условия победы. Если true, выйдем из цикла к результатам.
            whoMoves = whoMoves == 2 ? 1 : 2; // Поменяем текущего игрока.
            moves++;// Прибавим число ходов.
        }
        System.out.println(winner);
    }
}
