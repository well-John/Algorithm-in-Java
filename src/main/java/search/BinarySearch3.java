package search;

import sort.HeapSort;

import java.util.Arrays;

/**
 * 查询最后一个值等于给定值的下标
 */
public class BinarySearch3 {

    public static int search(int[] arr, int desc) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (desc == arr[mid]) {
                if (mid == arr.length - 1 || arr[mid + 1] != desc) {
                    return mid;
                }
                start = mid + 1;
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
        int search = search(a, 4);
        System.out.println("search = " + search);


    }
}
