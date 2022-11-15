import java.util.Random;
import java.util.logging.Logger;

public class Task4 {
    //    На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
    //    программа вычисляет одно случайное решение
    static int[] board = {0, 0, 0, 0, 0, 0, 0, 0};
    static int index = 1;

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Random rd = new Random();
        board[0] = rd.nextInt(0, 8);

        while (true) {
            if (check()) {
                if (index == 7) {
                    logger.info("A" + (board[0] + 1) + " B" + (board[1] + 1) + " C" + (board[2] + 1) +
                            " D" + (board[3] + 1) + " E" + (board[4] + 1) + " F" + (board[5] + 1) + " G"
                            + (board[6] + 1) + " H" + (board[7] + 1));
                    break;
                } else {
                    index++;
                }
            } else {
                board[index]++;
            }
        }
    }

    public static boolean check() {
        if (board[index] > 7) {
            board[index] = 0;
            index--;
            return false;
        }
        for (int i = 0; i < index; i++) {
            if ((board[index] == board[i]) | (Math.abs(board[index] - board[i]) == (index - i))) {
                return false;
            }
        }
        return true;
    }
}
