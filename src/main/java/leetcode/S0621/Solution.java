package leetcode.S0621;

import java.util.*;

public class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] bucket = new int[26];
        for (int i=0;i<tasks.length;i++){
            bucket[tasks[i]-'A']++;
        }
        Arrays.sort(bucket);

        int maxTime = bucket[25];
        int maxSameCount = 1;
        for (int i= bucket.length-1;i>0;i--){
            if(bucket[i]==bucket[i-1]){
                maxSameCount++;
            }else {
                break;
            }
        }

        int res = (n+1)* (maxTime-1) + maxSameCount;
        return Math.max(res,tasks.length);
    }

    public static void main(String[] args) {
        char[] c= {'A','A','A','A','A','A','B','C','D','E','F','G'};
        Solution solution = new Solution();
        int i = solution.leastInterval(c, 2);
        System.out.println(i);
    }
}
