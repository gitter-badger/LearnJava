import java.io.*;

public final class Helper {

    // Юзер вводит номер ячейки, куда ходит
    public String getUserInput(String playerName){
        String inputLine = null;
        System.out.print("Ваш ход, " + playerName);
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0) return null;
        } catch (IOException e){
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }

    // Проверяем, достигнуто ли одно из условий победы
    public boolean checkWin(int[] board){
        return false;
    }
}
