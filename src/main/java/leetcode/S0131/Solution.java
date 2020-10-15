package leetcode.S0131;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(right) == s.charAt(left) && ((right - left <= 2) || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, s.length(), dp, stack, res);
        return res;
    }

    private void backtracking(String s, int start, int end, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (start == end) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < end; i++) {

            if (!dp[start][i]) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, end, dp, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> partition = solution.partition("aabba");
        System.out.println(partition);
    }

}
