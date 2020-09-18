package leetcode.S1576;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String modifyString(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (array[i] == '?') {
                List<Character> list = new ArrayList<>();
                if (i - 1 >= 0) {
                    list.add(array[i - 1]);
                }
                if (i + 1 < s.length() && array[i + 1] != '?') {
                    list.add(array[i + 1]);
                }
                array[i] = choose(list);
            }
        }

        return String.valueOf(array);
    }

    private static char choose(List<Character> list) {
        int random;
        while (true) {
            random = 97 + (int) (Math.random() * 25);
            if (!list.contains((char) random)) {
                break;
            }
        }
        return (char) random;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String modifyString = solution.modifyString("a????a");
        System.out.println(modifyString);

    }
}
