package leetcode.S0494;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> layer = new HashMap<>();
        layer.put(0, 1);
        for (int i : nums) {
            Map<Integer, Integer> next_layer = new HashMap<>();
            for (int j : layer.keySet()) {
                int val = layer.get(j);
                next_layer.put(j + i, next_layer.getOrDefault(j + i, 0) + val);
                next_layer.put(j - i, next_layer.getOrDefault(j - i, 0) + val);
            }
            layer = next_layer;
        }
        return layer.getOrDefault(S, 0);
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        Solution solution = new Solution();
        int targetSumWays = solution.findTargetSumWays(nums, 3);
        System.out.println(targetSumWays);


    }
}
