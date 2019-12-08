package search;

import sort.HeapSort;

import java.util.Arrays;

/**
 * 二分查找变体1:查找最后一个小于等于值的下标
 */
public class BinarySearch2 {

    /**
     * 找到最后一个小于等于给定值的位置
     *
     * @param arr
     * @param desc
     * @return
     */
    public static int search(int[] arr, int desc) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= desc) {
                if (mid == arr.length - 1 || arr[mid + 1] > desc) {
                    return mid;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
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
