import java.util.*;
import java.util.logging.Logger;

public class Task2 {
    //    Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов,
//    Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов
//    Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        List<String> someList = new ArrayList<>(List.of("Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
                "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"));
        logger.info(String.valueOf(calcRepeats(someList)));
    }

    public static List<Object> calcRepeats(List<String> list) {
        Map<String, Integer> repeatsMap = new HashMap<>();
        for (String item :
                list) {
            String name = item.split(" ")[0];
            if (!repeatsMap.containsKey(name)) {
                repeatsMap.put(name, 1);
            } else {
                repeatsMap.put(name, repeatsMap.get(name) + 1);
            }
        }
        List<Object> result = new ArrayList<>();
        repeatsMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                forEach(result::add);
        return result;
    }
}
