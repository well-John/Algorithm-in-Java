package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question57 {

    public static int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        for (int left = 1, right = 2; left < right; ) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] temp = new int[right - left + 1];
                int j = left;
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = j++;
                }
                left++;
                result.add(temp);
            } else if (sum < target) {
                right++;
            } else {
                left++;
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {

        int[][] continuousSequence = findContinuousSequence(15);
        for (int i = 0; i < continuousSequence.length; i++) {
            for (int j = 0; j < continuousSequence[i].length; j++) {
                System.out.print(continuousSequence[i][j]);
            }
            System.out.println();
        }

    }

}
