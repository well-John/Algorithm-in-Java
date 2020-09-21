package leetcode.S318;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int maxProduct(String[] words) {
        List<String> list = Arrays.asList(words);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (isNotContainEqualChar(list.get(i), list.get(j))) {
                    int length = list.get(i).length() * list.get(j).length();
                    if (length > max) {
                        max = length;
                    }
                }
            }
        }
        return max;
    }

    private boolean isNotContainEqualChar(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index]++;
        }

        for (char b : t.toCharArray()) {
            int index = b - 'a';
            if (count[index] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"a","ab","abc","d","cd","bcd","abcd"};
        Solution solution = new Solution();
        int maxProduct = solution.maxProduct(words);
        System.out.println(maxProduct);


    }
}
