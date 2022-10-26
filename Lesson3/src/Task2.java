import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class Task2 {
// Пусть дан произвольный список целых чисел, удалить из него четные числа

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        ArrayList<Integer> testArray = new ArrayList<>();

        generateArray(testArray);
        logger.info("First Array -> " + testArray);

        deleteEvenElements(testArray);
        logger.info("Result array -> " + testArray);
    }

    public static void generateArray(ArrayList<Integer> array) {
        Random rd = new Random();
        for (int i = 0; i < 20; i++) {
            array.add(rd.nextInt(20));
        }
    }

    public static void deleteEvenElements(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                array.remove(i);
                i = i - 1;
            }
        }
        array.trimToSize();
    }
}