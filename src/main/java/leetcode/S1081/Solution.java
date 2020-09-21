package leetcode.S1081;

import java.util.*;

public class Solution {

    public String smallestSubsequence(String text) {
        int[] count = new int[26];
        boolean[] used = new boolean[26];
        Deque<Character> stack = new LinkedList<>();
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        char[] chs = text.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            int idx = chs[i] - 'a';
            count[idx]--;
            if (used[idx]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > chs[i] && count[stack.peek() - 'a'] != 0) {
                used[stack.peek() - 'a'] = false;
                stack.pop();
            }
            used[idx] = true;
            stack.push(chs[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String subsequence = solution.smallestSubsequence("ecbacba");
        System.out.println(subsequence);

    }
}
