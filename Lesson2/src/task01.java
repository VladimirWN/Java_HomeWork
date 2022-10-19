import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class task01 {
    //Задание 1 - Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя
//    StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//        (Не sql запрос, я оговорился на вебинаре!)
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.
    public static void main(String[] args) {
        String inp = "[{'фамилия':'Иванов','оценка':'5','предмет':'Математика'}" +
                "{'фамилия':'Петрова'','оценка':'4','предмет':'Информатика'}" +
                "{'фамилия':'Краснов'','оценка':'5','предмет':'Физика'}]";
        getItem(inp);
    }

    public static void getItem(String s) {
        s = s.replace("'", "")
                .replace("[", "")
                .replace("]", "")
                .replace("{", "");
        String[] str = s.split("}");
        for (String c :
                str) {
            StringBuilder out = new StringBuilder("Студент ");
            String[] student = c.split(",");
            out.append(student[0].split(":")[1]).append(" получил ")
                    .append(student[1].split(":")[1]).append(" по предмету ")
                    .append(student[2].split(":")[1]).append(".");
            System.out.println(out);
        }
    }
}
