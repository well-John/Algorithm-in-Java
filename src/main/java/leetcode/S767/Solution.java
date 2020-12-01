package leetcode.S767;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    //babab
    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] count = new int[26];
        int maxCount = 0;
        for (int i = 0; i < S.length(); i++) {
            int idx = S.charAt(i) - 'a';
            count[idx]++;
            if (count[idx] > maxCount) {
                maxCount = count[idx];
            }
        }

        if (maxCount > (S.length() + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character letter1, Character letter2) {
                return count[letter2 - 'a'] - count[letter1 - 'a'];
            }
        });

        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] > 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (queue.size() > 1) {
            Character c1 = queue.poll();
            Character c2 = queue.poll();
            sb.append(c1);
            sb.append(c2);
            int idx1 = c1 - 'a';
            int idx2 = c2 - 'a';
            count[idx1]--;
            count[idx2]--;

            if (count[idx1] > 0) {
                queue.offer(c1);
            }

            if (count[idx2] > 0) {
                queue.offer(c2);
            }

        }

        if (queue.size() > 0) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String reorganizeString = solution.reorganizeString("aaab");
        System.out.println(reorganizeString);


    }
}
