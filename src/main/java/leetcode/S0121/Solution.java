package leetcode.S0121;

/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max =0;
        for(int i=0;i<prices.length;i++){
            if(prices[i] < min ){
                min = prices[i];
            }
            max =Math.max(max,prices[i]-min);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] prices= {7,1,5,3,6,4};
        int maxProfit = new Solution().maxProfit(prices);
        System.out.println(maxProfit);
    }
}
