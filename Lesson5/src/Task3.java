import java.util.Arrays;
import java.util.logging.Logger;

public class Task3 {
    //    Реализовать алгоритм пирамидальной сортировки (HeapSort)
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        int[] someArr = {5, 15, 1, 6, 8, 10, 20, 0};
        heapSort(someArr);
        logger.info(Arrays.toString(someArr));
    }


    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}
