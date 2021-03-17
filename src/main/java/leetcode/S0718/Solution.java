package leetcode.S0718;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class Solution {
    public int findLength(int[] A, int[] B) {

        int[][] dp = new int[A.length + 1][B.length + 1];

        int max =0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                if(dp[i][j] > max){
                    max =dp[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {


    }
}
