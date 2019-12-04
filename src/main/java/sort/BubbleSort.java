package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {1, 4, 5, 2, 3, 4, 7, 9, 0};
        BubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
