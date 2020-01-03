package leetcode.S076;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.get(c) == null ? 1 : (needs.get(c) + 1));
        }
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        String res = "";

        int match = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1, window.get(c1) == null ? 1 : (window.get(c1) + 1));
                if (window.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    res = s.substring(left,right);
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }


        return res;
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String l = "ABC";
        String window = minWindow(s, l);
        System.out.println(window);

    }
}
