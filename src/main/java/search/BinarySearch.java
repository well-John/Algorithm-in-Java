package search;

import sort.HeapSort;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] arr, int desc) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (desc == arr[mid]) {
                return mid;
            } else if (desc < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }




    public static void main(String[] args) {
        int[] a = {1, 4, 5, 2, 3, 4, 7, 9, 0};
        HeapSort.sort(a);
        System.out.println(Arrays.toString(a));
        int search = binarySearch(a, 4);
        System.out.println("search = " + search);


    }
}
