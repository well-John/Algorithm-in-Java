package leetcode.S338;

import java.util.Arrays;

public class Solution {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution =new Solution();
        int[] countBits = solution.countBits(10);
        System.out.println(Arrays.toString(countBits));
    }
}
