package dp;

/**
 * 一元背包
 */
public class BagProblem {


    public static int bagProblemByOneArray(int[] weight, int[] value, int maxWeight) {
        int[] dp = new int[maxWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = maxWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[maxWeight];
    }

    public static int bagProblemByTwoArray(int[] weight, int[] value, int maxWeight) {
        int[][] dp = new int[weight.length][maxWeight + 1];


        for (int i = maxWeight; i >= weight[0]; i--) {
            dp[0][i] = dp[0][i - weight[0]] + value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = maxWeight; j >= weight[i]; j--) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[weight.length - 1][maxWeight];
    }


    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 4, 2};
        int[] value = {15, 20, 30, 35, 20};
        int maxValue = bagProblemByTwoArray(weight, value, 12);
        System.out.println(maxValue);
    }


}
