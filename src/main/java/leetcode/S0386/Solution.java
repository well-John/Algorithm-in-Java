package leetcode.S0386;

import java.util.*;

public class Solution {

    public List<Integer> lexicalOrder(int n) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return String.valueOf(o1).compareTo(String.valueOf(o2));
            }
        });

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> lexicalOrder = solution.lexicalOrder(20);
        System.out.println(Arrays.toString(lexicalOrder.toArray()));
    }
}
