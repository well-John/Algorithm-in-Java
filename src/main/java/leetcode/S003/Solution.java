package leetcode.S003;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * abcbacba
 */
public class Solution {


    public int longSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        String res = null;
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            if ((i - start + 1) > max) {
                max = Math.max(max, i - start + 1);
                res = s.substring(start, i + 1);
            }
        }

        System.out.println(res);
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int longSubstring = solution.longSubstring("abcda");
        System.out.println(longSubstring);

    }

}
