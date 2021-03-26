package leetcode.S0621;

import java.util.*;

public class Solution {

    public int leastInterval(char[] tasks, int n) {

        if (n ==0 ) return tasks.length;
        Map<Character,Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i =0;i< tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
            queue.add(tasks[i]);
        }

        int category = map.size();

        Set<Character> window = new HashSet<>();
        int res =0;

        while (!queue.isEmpty()){
            Character c =  queue.peek();
            if(window.contains(c)){
                if(window.size() >= category){
                    int distance = n+1-window.size();
                    res= res+distance;
                    window = new HashSet<>();
                    queue.poll();
                }else {
                    queue.offer(queue.poll());
                }
            }else {
                queue.poll();
                window.add(c);
                res++;
                if(window.size() == n+1){
                    window = new HashSet<>();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[] c= {'A','A','A','B','B','B'};
        Solution solution = new Solution();
        int i = solution.leastInterval(c, 2);
        System.out.println(i);
    }
}
