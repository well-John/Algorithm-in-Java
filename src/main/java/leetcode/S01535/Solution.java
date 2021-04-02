package leetcode.S01535;

public class Solution {
    public int getWinner(int[] arr, int k) {
        int cur = Math.max(arr[0],arr[1]);;
        int max = cur;
        if(k == 1){
            return max;
        }
        int winCount =1;
        for (int i= 2;i<arr.length;i++){
            if(cur > arr[i]){
                winCount++;
            }else {
                winCount=1;
                cur =arr[i];
            }
            if(winCount == k){
                return cur;
            }
            max = Math.max(max,arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {2,1,3,5,4,6,7};
        int winner = new Solution().getWinner(array, 2);
        System.out.println(winner);

    }
}
