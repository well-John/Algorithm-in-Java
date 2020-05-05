package leetcode.S207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        //存有向边
        List<List<Integer>> adjanency = new ArrayList<>();
        //存入度为0的元素
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            adjanency.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            //入度+1
            indegrees[cp[0]]++;
            //cp[1]->cp[0]
            adjanency.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i]==0){
                queue.offer(i);
            }

        }

        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            numCourses--;
            for (int cur : adjanency.get(pre)) {
                if (--indegrees[cur] == 0) {
                    queue.offer(cur);
                }
            }
        }

        return numCourses == 0;
    }

    public static void main(String[] args) {

        int[][] arr = {{0, 1}};
        boolean b = canFinish(2, arr);
        System.out.println(b);
    }


}
