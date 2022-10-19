//Задание 2 - Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class task02 {

    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{5, 1, 8, 9, 2, 7, 0};
        int max;
        Logger lg = Logger.getAnonymousLogger();
        FileHandler fh = new FileHandler("./lesson2/task02.txt");
        lg.addHandler(fh);

        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        for (int i = 0; i < arr.length - 1; i++) {
            max = arr[0];
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] > max) max = arr[j + 1];
                else {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = max;
                }
            }
            lg.info(Arrays.toString(arr));
        }
        fh.close();
    }

}
