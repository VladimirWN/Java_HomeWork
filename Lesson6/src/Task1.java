import java.util.*;
import java.util.logging.Logger;

public class Task1 {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Scanner sc = new Scanner(System.in);

        NoteBook asus900 = new NoteBook("ASUS", "900", 15.6, "IPS",
                "Intel_i5", 8, 500, true);
        NoteBook acerM2 = new NoteBook("Acer", "M2", 14, "VA",
                "Ryzen_r3", 6, 256, true);
        NoteBook lenovoInspiration = new NoteBook("Lenovo", "Inspiration", 13, "TN",
                "Intel_i3", 4, 128, false);
        NoteBook asus123 = new NoteBook("ASUS", "123", 15.6, "IPS",
                "Intel_i3", 8, 256, false);
        NoteBook hpPh = new NoteBook("HP", "PH", 17, "IPS",
                "Intel_i7", 12, 500, true);
        Set<NoteBook> noteBookSet = new HashSet<>(Arrays.asList(asus900, acerM2, lenovoInspiration, asus123, hpPh));

        Map<Integer, String> filterList = new HashMap<>();
        filterList.put(1, "Screen size: 17\"/15.6\"/14\"/13\"");
        filterList.put(2, "Display matrix type: IPS/VA/TN");
        filterList.put(3, "Processor model: Intel_i7/Intel_i5/Intel_i5/Ryzen_r3");
        filterList.put(4, "RAM size: 12/8/6/4 GB");
        filterList.put(5, "HDD size: 500/256/128 GB");
        filterList.put(6, "Preinstalled OS: Yes/No");
        Map<Integer, String> userFilter = new HashMap<>();

        while (filterRequest(sc)) {
            setFilter(sc, filterList, userFilter);
        }

        logger.info(String.valueOf(getResult(userFilter, noteBookSet)));
    }

    public static void setFilter(Scanner sc, Map<Integer, String> list, Map<Integer, String> filter) {
        System.out.println("Введите критерий и его значение через пробел");
        for (Map.Entry<Integer, String> i :
                list.entrySet()) {
            System.out.println(i);
        }
        System.out.print("Ввод данных: ");
        String s = sc.nextLine();
        System.out.println();
        int number = Integer.parseInt(s.split(" ")[0]);
        String param = s.split(" ")[1];
        filter.put(number, param);
    }

    public static boolean filterRequest(Scanner sc) {
        System.out.print("Добавить критерий фильтра 1-да, 0-нет: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println();
        return n == 1;
    }

    public static List<NoteBook> getResult(Map<Integer, String> filter, Set<NoteBook> set) {
        List<NoteBook> resultList = new ArrayList<>();
        List<NoteBook> notMatchList = new ArrayList<>();
        for (Integer i :
                filter.keySet()) {
            if (i == 4 || i == 5) {
                for (NoteBook j :
                        set) {
                    if (Integer.parseInt(j.getNeedField(i)) >= Integer.parseInt(filter.get(i)) && !notMatchList.contains(j)) {
                        match(resultList, j);
                    } else {
                        notMatch(notMatchList, resultList, j);
                    }
                }
            } else {
                for (NoteBook j :
                        set) {
                    if (j.getNeedField(i).equals(filter.get(i)) && !notMatchList.contains(j)) {
                        match(resultList, j);
                    } else {
                        notMatch(notMatchList, resultList, j);
                    }
                }
            }
        }
        if (resultList.isEmpty()) return null;
        return resultList;
    }

    public static void match(List<NoteBook> list, NoteBook noteBook) {
        if (!list.contains(noteBook)) {
            list.add(noteBook);
        }
    }

    public static void notMatch(List<NoteBook> notMatchList, List<NoteBook> resultList, NoteBook noteBook) {
        notMatchList.add(noteBook);
        resultList.remove(noteBook);
    }
}
