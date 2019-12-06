package sort;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] a) {
        int length = a.length;
        for (int i = 0; i < a.length; i++) {
            int min = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 2, 3, 4, 7, 9, 0};
        SelectionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
