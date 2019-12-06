package sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] a, int start, int end) {
        int pivot = a[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (a[j] > pivot)) {
                j--;
            }

            while ((i < j) && (a[i] < pivot)) {
                i++;
            }

            if (a[i] == a[j] && i < j) {
                i++;
            } else {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        if (start < i - 1)
            quickSort(a, start, i - 1);
        if (end > j + 1)
            quickSort(a, j + 1, end);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 2, 3, 4, 7, 9, 0};
        QuickSort.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }
}
