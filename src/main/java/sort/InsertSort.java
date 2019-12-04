package sort;

import java.util.Arrays;

public class InsertSort {

    public static void sort(int[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {

            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 2, 3, 4, 7, 9, 0};
        InsertSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
