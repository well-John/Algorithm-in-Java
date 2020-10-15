package leetcode.S848;

public class Solution {

    public String shiftingLetters(String S, int[] shifts) {

        long[] res = new long[shifts.length];
        for (int i = 0; i < shifts.length; i++) {
            for (int j = 0; j <= i; j++) {
                res[j] += shifts[i];
            }
        }

        char[] c = S.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) ('a' + (long)(c[i] - 'a' + res[i]) % 26);
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] shift = {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
        String abc = solution.shiftingLetters("mkgfzkkuxownxvfvxasy", shift);
        System.out.println(abc);

        System.out.println((int) 'z');

    }

}
