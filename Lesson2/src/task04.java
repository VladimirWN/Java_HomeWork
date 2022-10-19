import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task04 {
//    Задание 4 - К калькулятору из предыдущего дз добавить логирование.

    public static void main(String[] args) throws IOException {
        Logger lg = Logger.getAnonymousLogger();
        FileHandler fh = new FileHandler("./Lesson2/task04.txt", true);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        lg.addHandler(fh);

        Scanner sc = new Scanner(System.in);
        lg.info(calc(sc));
        fh.close();
    }

    public static String calc(Scanner sc) {
        System.out.print("Введите первое число: ");
        int x = Integer.parseInt(sc.nextLine());

        System.out.print("Введите операцию (+; -; *; /): ");
        char op = sc.nextLine().charAt(0);

        System.out.print("Введите второе число: ");
        int y = Integer.parseInt(sc.nextLine());

        int res;

        if (op == '+') {
            res = x + y;
            return "x + y = " + res;
        } else if (op == '-') {
            res = x - y;
            return "x - y = " + res;
        } else if (op == '*') {
            res = x * y;
            return "x * y = " + res;
        } else if (op == '/') {
            res = x / y;
            return "x / y = " + res;
        }
        return null;
    }

}

