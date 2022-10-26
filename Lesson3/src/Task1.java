import java.util.Arrays;
import java.util.logging.Logger;

public class Task1 {
//    Реализовать алгоритм сортировки слиянием

    public static void main(String[] args) {
        int[] startArray = {4, 2, 12, 8, 0, 15, 3, 1, 2, 1};
        Logger logger = Logger.getAnonymousLogger();
        logger.info(Arrays.toString(sortArray(startArray, startArray.length)));
    }

    public static int[] sortArray(int[] startArr, int n) {

        if (n < 2) return startArr;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(startArr, 0, left, 0, mid);
        System.arraycopy(startArr, mid, right, 0, n - mid);

        sortArray(left, mid);
        sortArray(right, n - mid);

        return merge(startArr, left, right, mid, n - mid);
    }

    public static int[] merge(int[] array, int[] left, int[] right, int leftLength, int rightLength) {
        int k = 0, i = 0, j = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            array[k++] = left[i++];
        }

        while (j < rightLength) {
            array[k++] = right[j++];
        }
        return array;
    }
}
