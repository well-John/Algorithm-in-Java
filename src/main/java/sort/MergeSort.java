package sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {


    public static int[] sort(int[] a, int start, int end) {
        if (start == end) {
            return new int[]{a[start]};
        }
        int mid = start + (end - start) / 2;
        int[] leftArray = sort(a, start, mid);
        int[] rightArray = sort(a, mid + 1, end);
        int[] newNum = new int[leftArray.length + rightArray.length];
        int m = 0, i = 0, j = 0;
        while ((i < leftArray.length) && (j < rightArray.length)) {
            newNum[m++] = leftArray[i] < rightArray[j] ? leftArray[i++] : rightArray[j++];
        }
        while (i < leftArray.length) {
            newNum[m++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            newNum[m++] = rightArray[j++];
        }
        return newNum;
    }


    public static void main(String[] args) {
        int[] a = {1, 4, 5, 2, 3, 4, 7, 9, 0};
        int[] sort = MergeSort.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(sort));

    }

}
