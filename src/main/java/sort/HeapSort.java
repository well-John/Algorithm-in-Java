package sort;

import java.util.Arrays;

public class HeapSort {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapify(int[] arr, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int max = i;
        if (left < length && arr[left] > arr[max]) {
            max = left;
        }

        if (right < length && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            swap(arr, i, max);
            heapify(arr, max, length);
        }
    }

    public  static void buildMaxHeap(int[] arr, int length) {
        for (int i = (int) Math.floor(length / 2); i >= 0; i--) {
            heapify(arr, i, length);
        }
    }

    public static void sort(int[] arr) {
        int length = arr.length;

        buildMaxHeap(arr, length);

        for (int i = length - 1; i > 0; i--) {
            swap(arr, 0, i);
            length--;
            heapify(arr, 0, length);
        }
    }

    public static void main(String[] args) {

        int[] a ={1, 5, 6, 7, 0, 4, 2, 8};
        HeapSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

}



