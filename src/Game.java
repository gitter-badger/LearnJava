import java.util.Scanner;

class Game {
    private int[] board = new int[9]; //Создаем доску 3х3, массив нумерует ячейки с верхней левой, 0-8.
    private int moves = 1; // Число ходов. Проверку победы имеет смысл делать с 5, ничья при 9.
    private static String playerOneName; //Имя первого игрока
    private static String playerTwoName; //Имя второго игрока
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
    }

    //Возвращает значение ячейки по ее индексу. Ну и нахрена это нужно?
    public int getBoard(int i) {
        return board[i];
    }

    //Пишем в указанную ячейку значение в соответствии с тем, какой игрок ходит. Если уже занято, ругаемся.
    private boolean setBoard(int i, int whoMoves) {
        return true;
    }

    // Игровой процесс
    void play(){
        String winner = "Draw!";
        int playerMove;
        String playerName;
        while(moves < 9){ // Пока не получим подтверждение победы или не кончатся ходы
            // Юзер вводит номер ячейки, куда ходит
            playerName = whoMoves == 1 ? playerOneName : playerTwoName;
            System.out.print("Ход " + moves);

            // Нарисуем текущее состояние доски
            for (int i : board){
                char content = 0;
                switch (i){
                    case 1:
                        content = 'x';
                        break;
                    case 2:
                        content = 'o';
                        break;
                    default:
                        content = (char)(i+1);
                        break;
                }
                if (i%3 == 0){
                    System.out.println(content);
                } else {
                    System.out.print(content);
                }
            }

            while (true) {
                System.out.print("Ваш ход, " + playerName + ": ");
                Scanner scan = new Scanner(System.in);
                playerMove = scan.nextInt() - 1; //Вычитаем единицу, чтобы для юзера поле было от 1 до 9
                // Тут надо сделать как-то проверку, что пришло число и обработать возможный облом

                // Запишем ход на доску, проверив сначала, что число в нужных пределах и такого хода еще не было.
                if (playerMove < 0 || playerMove > 8) {
                    System.out.println("Ошибочный номер ячейки!");
                } else {
                    if (board[playerMove] != 0) {
                        System.out.println("Ячейка занята");
                    } else {
                        board[playerMove] = whoMoves;
                        break;
                    }
                }
            }

            if(Helper.checkWin(board) && moves > 4){ // Проверим условия победы. Если true, выйдем из цикла к результатам.
                winner = "We have a winner! And it is ";
                winner += whoMoves == 1 ? playerOneName : playerTwoName;
                break;
            }
            whoMoves = whoMoves == 2 ? 1 : 2; // Поменяем текущего игрока.
            moves++;// Прибавим число ходов.
        }
        System.out.println(winner);
    }
}
