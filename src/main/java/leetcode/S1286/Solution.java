package leetcode.S1286;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static class CombinationIterator {

        private List<String> res = new ArrayList<>();

        private boolean[] used =new boolean[26];

        private int index = 0;

        public CombinationIterator(String characters, int combinationLength) {
            StringBuilder sb = new StringBuilder();
            build(characters, combinationLength, 0, sb, ' ');
        }

        private void build(String characters, int combinationLength, int idx, StringBuilder sb, char lastChar) {
            if (idx == combinationLength) {
                res.add(sb.toString());
                return;
            }
            for (int i = 0; i < characters.length(); i++) {
                if (used[characters.charAt(i) - 'a'] || characters.charAt(i) <= lastChar) {
                    continue;
                }
                used[characters.charAt(i) - 'a'] = true;
                build(characters, combinationLength, idx + 1, sb.append(characters.charAt(i)), characters.charAt(i));
                used[characters.charAt(i) - 'a'] = false;
                sb.deleteCharAt(idx);
                if (idx - 1 >= 0) {
                    lastChar = sb.charAt(idx - 1);
                }
            }
        }

        public String next() {
            return res.get(index++);
        }

        public boolean hasNext() {
            return index < res.size();
        }
    }

    public static void main(String[] args) {
        CombinationIterator combinationIterator = new CombinationIterator("abcdfghl", 3);
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
    }


}
