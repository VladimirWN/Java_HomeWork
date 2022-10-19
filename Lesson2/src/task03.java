import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class task03 {
//Задание 3 - Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
//1 Расширение файла: txt
//2 Расширение файла: pdf
//3 Расширение файла:
//4 Расширение файла: jpg

    public static void main(String[] args) {
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        getExp(path);

    }

    public static void getExp(String s) {
        File dir = new File(s);
        String[] files = dir.list();
        StringBuilder out = new StringBuilder();
        int i = 1;
        for (String f : files) {
            out.append(i + " Расширение файла: ");
            if (f.contains(".")) {
                out.append(f.split("\\.")[1]);
            }
            System.out.println(out);
            out.delete(0, out.length());
            i++;
        }
    }
}