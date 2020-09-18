package leetcode.S1291;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> sequentialDigits(int low, int high) {
        String lowStr = String.valueOf(low);
        int lowLen = lowStr.length();
        String highStr = String.valueOf(high);
        int highLen = highStr.length();
        List<Integer> res = new ArrayList<>();
        int lStart = Integer.parseInt(String.valueOf(lowStr.charAt(0)));
        int distance = highLen - lowLen;

        for (int k = 0; k <= distance; k++) {
            int len = lowLen + k;
            for (int i = (k == 0) ? lStart : 1; i <= 9; i++) {
                int l = 1;
                StringBuilder s = new StringBuilder().append(i);
                int tmp = i;
                while (l < len && tmp <= 9) {
                    s.append(++tmp);
                    l++;
                }
                Long value = Long.valueOf(s.toString());
                if (tmp > 9 || value < low) {
                    continue;
                }
                if (value < high) {
                    res.add(Integer.valueOf(s.toString()));
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.sequentialDigits(100,
                300);
        System.out.println(Arrays.toString(list.toArray()));

    }
}
