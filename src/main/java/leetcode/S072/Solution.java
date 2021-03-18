package leetcode.S072;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。2
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        if (m * n == 0) {
            return m + n;
        }

        for (int i=0;i<m+1;i++){
            dp[i][0] = i;
        }

        for (int j=0;j<n+1;j++){
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int insert = dp[i][j - 1] + 1;
                int remove = dp[i - 1][j] + 1;
                int change = dp[i - 1][j - 1];

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    change++;
                }
                dp[i][j] = Math.min(insert, Math.min(change, remove));
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {

        int minDistance = new Solution().minDistance("horse", "ros");
        System.out.println(minDistance);

    }
}
