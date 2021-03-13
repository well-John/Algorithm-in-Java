package sort;

import utils.CommonUtils;

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
    
    
    
    
    public void quickSort_v2(int[] nums,int left,int right){
        if(left<right) {
            int partion = partion(nums, left, right);
            quickSort_v2(nums,left,partion-1);
            quickSort_v2(nums,partion+1,right);
        }
    }

    private int partion(int[] nums, int left, int right) {
        int pivot =nums[left];
        while (left<right){
            while (left<right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }


    public static void main(String[] args) {
        int[] a = {1, 4, 5, 2, 3, 4, 7, 9, 0};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort_v2(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }
}
