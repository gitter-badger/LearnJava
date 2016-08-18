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
        if(i < 0 || i > 8) {
            System.out.println("Ошибочный номер ячейки!");
            return false;
        }
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
        int playerMove = -1;
        String playerName;
        while(moves < 10){ // Пока не получим подтверждение победы или не кончатся ходы
            // Юзер вводит номер ячейки, куда ходит
            playerName = whoMoves == 1 ? playerOneName : playerTwoName;
            System.out.println("Ваш ход, " + playerName);
            Scanner scan = new Scanner(System.in);
            if(scan.hasNextInt()){
                playerMove = scan.nextInt();
            }
            // Тут надо сделать как-то проверку, что пришло число и обработать возможный облом
            scan.close();
            if(setBoard(playerMove, whoMoves)){ // Запишем ход на доску
                setBoard(playerMove, whoMoves);
            } else {
                System.out.println("Что-то пошло не так"); // А что, если не смогли?
            }
            if(Helper.checkWin(board)){ // Проверим условия победы. Если true, выйдем из цикла к результатам.
                winner = "We have a winner! And it is ";
                winner += whoMoves == 2 ? playerOneName : playerTwoName;
                break;
            }
            whoMoves = whoMoves == 2 ? 1 : 2; // Поменяем текущего игрока.
            moves++;// Прибавим число ходов.
        }
        System.out.println(winner);
    }
}
