package offer;

import java.util.Arrays;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int max[] = new int[length - k + 1];
        int max_index = 0;
        int left = 0, right = 0;
        int temp_max = Integer.MIN_VALUE;
        for (int i = 0; i < max.length; i++) {
            for (; ((right - left) <= (k-1)) && right < length; right++) {
                //达到窗口大小
                if ((right - left) == (k-1)) {
                    //上一个窗口最大值已经移除
                    if (left > max_index) {
                        temp_max = nums[left];
                        max_index = left;
                        int l = left + 1;
                        while (l <= right) {
                            if (nums[l] >= temp_max) {
                                max_index = l;
                                temp_max = nums[l];
                            }
                            l++;
                        }
                    } else {
                        if (nums[right] >= temp_max) {
                            max_index = right;
                            temp_max = nums[right];
                        }
                    }
                } else {
                    if (nums[right] >= temp_max) {
                        max_index = right;
                        temp_max = nums[right];
                    }
                }
            }
            max[i] = temp_max;
            left++;
        }

        return max;

    }

    public static void main(String[] args) {
        Question59 question59 = new Question59();
        int[] a= {1,3,-1,-3,5,3,6,7};
        int[] window = question59.maxSlidingWindow(a, 3);
        System.out.println(Arrays.toString(window));
       /* while (true){
            Thread thread = new Thread();
            thread.start();
        }*/
    }
}
