package leetcode.S0942;

import java.util.Arrays;

public class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int left = 0, right = N;
        int[] res = new int[N + 1];

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                res[i] = left++;
            } else {
                res[i] = right--;
            }
        }
        res[N] = left;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] match = solution.diStringMatch("IDDIDIIDD");
        System.out.println(Arrays.toString(match));
    }

}
