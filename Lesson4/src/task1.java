import java.util.*;
import java.util.logging.Logger;

//Пусть дан LinkedList c несколькими элементами. Реализуйте метод, который вернет "перевернутый" список.
public class task1 {
    public static void main(String[] args) {
        Logger lg = Logger.getAnonymousLogger();
        Random rd = new Random();

        LinkedList<Integer> someList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            someList.add(rd.nextInt(10));
        }
        lg.info("Start list -> " + someList);
        lg.info("Reverse list -> " + reverseList(someList));
    }

    private static LinkedList<Integer> reverseList(LinkedList<Integer> lst) {
        LinkedList<Integer> newList = new LinkedList<>(lst);
        Collections.reverse(newList);
        return newList;
    }
}
