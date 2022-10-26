import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class Task3 {
//    Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

//    найти "среднее", понял как найти число в массиве, которое является максимально равноудаленным от max и min
//    относительно остальных чисел массива

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        ArrayList<Integer> testArray = new ArrayList<>();

        generateArray(testArray);
        logger.info("Array -> " + testArray);

        logger.info(searchMinMaxAverage(testArray).toString());
    }

    public static void generateArray(ArrayList<Integer> array) {
        Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            array.add(rd.nextInt(-10, 11));
        }
    }

    public static StringBuilder searchMinMaxAverage(ArrayList<Integer> array) {
        int min = array.get(0);
        int max = array.get(0);
        for (Integer i :
                array) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }

        int average = (max + min) / 2;
        int realAverage = array.get(0);
        int position = Math.abs(max - average);
        for (Integer i :
                array) {
            int newPosition = Math.abs(average - i);
            if (newPosition < position) {
                realAverage = i;
                position = newPosition;
            }
        }

        return new StringBuilder("max = " + max + "; min = " + min + "; average = " + realAverage);
    }
}
