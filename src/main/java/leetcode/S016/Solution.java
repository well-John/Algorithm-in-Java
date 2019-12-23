package leetcode.S016;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    result = sum;
                    return sum;
                } else if (sum < target) {
                    int temp = target - sum;
                    if (Math.abs(temp) < Math.abs(distance)) {
                        distance = Math.abs(temp);
                        result = sum;
                    }

                    left++;
                } else if (sum > target) {
                    int temp = target - sum;
                    if (Math.abs(temp) < Math.abs(distance)) {
                        distance = Math.abs(temp);
                        result = sum;
                    }
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        int threeSumClosest = new Solution().threeSumClosest(nums, -100);
        System.out.println("threeSumClosest = " + threeSumClosest);

    }
}
