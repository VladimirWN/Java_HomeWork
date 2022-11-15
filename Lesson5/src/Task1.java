import java.util.*;
import java.util.logging.Logger;

public class Task1 {
    //    Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Map<String, List<Long>> telephoneBook = new HashMap<>();
        addToTelephoneBook(telephoneBook, "Андрей Андреев", 89996543214L);
        addToTelephoneBook(telephoneBook, "Борис Борисов", 89879876532L);
        addToTelephoneBook(telephoneBook, "Виктор Викторов", 89784567812L);
        addToTelephoneBook(telephoneBook, "Борис Борисов", 89893219845L);
        addToTelephoneBook(telephoneBook, "Анна Анина", 89787894532L);
        logger.info(String.valueOf(telephoneBook));
    }


    public static void addToTelephoneBook(Map<String, List<Long>> book, String name, long number) {
        List<Long> temp;
        if (book.containsKey(name)) {
            temp = new ArrayList<>(book.get(name));
            temp.add(number);
        } else {
            temp = new ArrayList<>(List.of(number));
        }
        book.put(name, temp);
    }
}
