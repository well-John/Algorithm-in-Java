package leetcode.S0153;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2] 。
 * 5670124
 *
 * <p>
 * 请找出其中最小的元素
 */
public class Solution {

    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        if (nums[end] > nums[0]) {
            return nums[0];
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums ={4,5,6,7,0,1,2};

        int min = new Solution().findMin(nums);
        System.out.println(min);


    }

}
