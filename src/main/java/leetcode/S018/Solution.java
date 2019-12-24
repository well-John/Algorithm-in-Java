package leetcode.S018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[3];
            if (min > target) {
                continue;
            }
            int max = nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
            if (max < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int m = nums.length - 1;
                while (k < m) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        k++;
                        while (k < m && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        m--;
                        while (k < m && nums[m] == nums[m + 1]) {
                            m--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        m--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,4,-5,2,-2,4,2,-1,4};
        List<List<Integer>> fourSum = new Solution().fourSum(nums, 12);
        System.out.println("fourSum = " + fourSum);


    }

}
